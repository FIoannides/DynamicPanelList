/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import controller.ExaminationController;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import model.examination.Examination;
import model.examination.Section;
import model.question.MCQ;
import model.question.Question;

public class TeacherUI extends javax.swing.JFrame {

    private static int count = 0;
    private JPanel listContainer;
    private ArrayList<Question> questions;
    private JFrame frame = new JFrame("Test");
    private Examination examination;
    private ExaminationController controller;
    private JPanel mainList;



    /*public static void main(String[] args) {
        new TeacherUI().setVisible(true);
    }*/
    
    
    public TeacherUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    public TeacherUI(Examination examination) {
        this.examination = examination;
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                     
                }
                 
                frame.add(new TestPane());
                frame.setSize(500, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    
    public void updateView(Examination examination){
        this.examination = examination;
        Component[] comp = frame.getContentPane().getComponents();
        for (int i = 0; i < comp.length; i++) {
            if (comp[i] instanceof JPanel) {
                frame.remove(comp[i]);
            }
        }
        TestPane tp = new TestPane();
        //this.mainList = tp;
        frame.add(tp);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        validate();
        repaint();
    }

    public class TestPane extends JPanel {

        
        
        public TestPane() {
            setLayout(new BorderLayout(10, 10));
            /*String labels[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
            JList jl = new JList<String>(labels);*/
            
            
            JLabel lblTitle = new JLabel("English test");
            lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
            lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            //lblTitle.setForeground(Color.RED);
            add(lblTitle, BorderLayout.NORTH);
            mainList = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.RELATIVE;
            gbc.weightx = 1;
            gbc.weighty = 1;
            mainList.add(new JPanel(), gbc);

            int count2=0;
            for(int i=0; i<examination.getSections().size(); i++)
            {
                final JPanel sectionPanel = new JPanel();
                sectionPanel.setLayout(new BoxLayout(sectionPanel, BoxLayout.Y_AXIS));
                GridBagConstraints c = new GridBagConstraints();

                //c.weightx = 0.5;
                //c.fill = GridBagConstraints.HORIZONTAL;
                //c.gridx = 0;
                //c.gridy = 0;
                Section s = getController().getExamination().getSections().get(i);


                //int size = getController().getExamination().getSections().size()-1;

                JPanel mcqPanel = new JPanel();
                mcqPanel.setLayout(new GridBagLayout());

                // Question text panel
                final JPanel questionHeaderPanel = new JPanel();
                questionHeaderPanel.setLayout(new GridBagLayout());

                // GridBagConstraints
                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 1;
                c.gridx = 0;
                questionHeaderPanel.add(new JLabel(s.toString()), c);

                c.weightx = 0.2;
                c.gridx = 1;
                JButton editButton = new JButton("edit");
                questionHeaderPanel.add(editButton, c);

                c.weightx = 0.2;
                c.gridx = 2;
                JButton deleteButton = new JButton("delete");
                deleteButton.setActionCommand(Integer.toString(i));
                questionHeaderPanel.add(deleteButton, c);
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        //
                        examination.getSections().remove(Integer.parseInt(ae.getActionCommand()));
                        updateView(examination);
                    }
                });
                c.gridx = 0;
                c.gridwidth = GridBagConstraints.REMAINDER;
                mcqPanel.add(questionHeaderPanel, c);
                sectionPanel.add(mcqPanel);
                sectionPanel.revalidate();
                mainList.add(sectionPanel, c, count2);
                count2++;

//                c.weightx = 0.2;
//                c.gridx = 1;
//                JButton addSubsectionButton = new JButton("add subsection");
//                addSubsectionButton.setActionCommand(Integer.toString(i));
//                addSubsectionButton.addActionListener(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent ae) {
//                        controller.addSubsection(Integer.parseInt(ae.getActionCommand()), "Test");
////                        updateView(examination);
//                    }
//                });
//                sectionPanel.add(addSubsectionButton, c);
//                
//                c.weightx = 0.2;
//                c.gridx = 2;
//                JButton deleteButton = new JButton("delete");
//                deleteButton.setActionCommand(Integer.toString(s.getId()));
//                sectionPanel.add(deleteButton, c);

                
                
                 
                // Add subsection
//                for(int j=0; j<s.getSubsections().size(); j++){
//                    final JPanel subsectionPanel = new JPanel();
//                    subsectionPanel.setLayout(new GridBagLayout());
//                    c.fill = GridBagConstraints.HORIZONTAL;
//                    c.weightx = 1;
//                    c.gridx = 0;
//                    c.gridy = count;
//                    Subsection ss = s.getSubsections().get(j);
//                    sectionPanel.add(new JLabel(ss.toString()), c);
//
//                    c.weightx = 0.2;
//                    c.gridx = 1;
//                    JButton addQuestionButton = new JButton("add question");
//                    sectionPanel.add(addQuestionButton, c);
 
//                    c.weightx = 0.2;
//                    c.gridx = 2;
//                    JButton addQuestionButton = new JButton("add question");
//                    addQuestionButton.setActionCommand(Integer.toString(s.getId()));
//                    sectionPanel.add(addQuestionButton, c);
//
//                    c.weightx = 0.2;
//                    c.gridx = 2;
//                    JButton deleteSubsectionButton = new JButton("delete");
//                    deleteSubsectionButton.setActionCommand(Integer.toString(s.getId()));
//                    sectionPanel.add(deleteSubsectionButton, c);
//
//                    mainList.add(sectionPanel, c);
//                    count++;
//                    //add to section list
//                    validate();
//                    repaint();
//              }
            }
            
            
            
            
            
            add(new JScrollPane(mainList), BorderLayout.CENTER);

            JButton btnSection = new JButton("Add section");
            btnSection.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SectionDialog dialog = new SectionDialog(frame, true);
                    dialog.setSize(200, 200);
                    dialog.setVisible(true);
                    count++;
                    controller.addSection(dialog.getValidatedText());
                    updateView(examination);
                }
            });

            JButton btnSubsection = new JButton("Add subsection");
            btnSubsection.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MCQDialog dialog = new MCQDialog(frame, true);
                    dialog.setSize(200, 200);
                    dialog.setVisible(true);
                }
            });

            JButton btnMCQ = new JButton("Add MCQ");
            btnMCQ.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MCQDialog dialog = new MCQDialog(frame, true);
                    dialog.setSize(450, 450);
                    dialog.setVisible(true);
                    MCQ q = dialog.getQuestion();
                    
                    
                    // Container
                    listContainer = new JPanel();
                    listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

                    // Test data
                    ArrayList<model.answer.Choice> choices = q.getChoices();

                    // Multiple choice question
                    if (q instanceof MCQ) {
                        // Question panel
                        final JPanel mcqPanel = new JPanel();
                        mcqPanel.setLayout(new GridBagLayout());

                        // Question text panel
                        final JPanel questionHeaderPanel = new JPanel();
                        questionHeaderPanel.setLayout(new GridBagLayout());

                        // GridBagConstraints
                        GridBagConstraints c = new GridBagConstraints();
                        c.fill = GridBagConstraints.HORIZONTAL;
                        c.weightx = 1;
                        c.gridx = 0;
                        questionHeaderPanel.add(new JLabel(q.getQuestionText()), c);

                        c.weightx = 0.2;
                        c.gridx = 1;
                        JButton editButton = new JButton("edit");
                        questionHeaderPanel.add(editButton, c);

                        c.weightx = 0.2;
                        c.gridx = 2;
                        JButton deleteButton = new JButton("delete");
                        deleteButton.setActionCommand("1");
                        questionHeaderPanel.add(deleteButton, c);
                        deleteButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                //
                                
                            }
                        });

                        c.gridx = 0;
                        mcqPanel.add(questionHeaderPanel, c);

                        // TODO: Proof if there are more than one correct option
                        // Multiple choice question with one correct option
                        ButtonGroup group = new ButtonGroup();

                        int j = 0;
                        for (model.answer.Choice choice : ((MCQ) q).getChoices()) {
                            //Create the radio buttons.
                            JRadioButton choiceButton = new JRadioButton(choice.getText());
                            choiceButton.setMnemonic(KeyEvent.VK_B);

                            //Group the radio buttons.
                            group.add(choiceButton);

                            //Register a listener for the radio buttons.
                            //choiceButton.addActionListener(this);

                            c.weightx = 1;
                            c.gridx = 0;
                            c.gridy = j + 1;
                            j++;
                            mcqPanel.add(choiceButton, c);
                        }
                        listContainer.add(mcqPanel);
                        listContainer.revalidate();
                    }
                   
                    
                    
                    
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.weightx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    mainList.add(listContainer, gbc, count);
                    count++;

                    //add to questions list
                    validate();
                    repaint();
                }  
            });

            JButton btnFIB = new JButton("Add FIB");
            btnFIB.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                    
                    
                    // Container
                    listContainer = new JPanel();
                    listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

                    // Test data
                    model.answer.Choice c1 = new model.answer.Choice("true", true);
                    model.answer.Choice c2 = new model.answer.Choice("false", false);
                    ArrayList<model.answer.Choice> choices = new ArrayList<model.answer.Choice>();
                    choices.add(c1);
                    choices.add(c2);
                    MCQ mcq1 = new MCQ("Question 1", choices);
                    MCQ mcq2 = new MCQ("Question 2", choices);

                    questions = new ArrayList<Question>();
                    //examination.getSections().get(0).getSubsections().get(0).getQuestions()
                    questions.add(mcq1);
                    questions.add(mcq2);

                    for (int i = 0; i < questions.size(); i++) {
                        Question q = questions.get(i);
                        // Multiple choice question
                        if (q instanceof MCQ) {
                            // Question panel
                            final JPanel mcqPanel = new JPanel();
                            mcqPanel.setLayout(new GridBagLayout());

                            // Question text panel
                            final JPanel questionHeaderPanel = new JPanel();
                            questionHeaderPanel.setLayout(new GridBagLayout());

                            // GridBagConstraints
                            GridBagConstraints c = new GridBagConstraints();
                            c.fill = GridBagConstraints.HORIZONTAL;
                            c.weightx = 1;
                            c.gridx = 0;
                            questionHeaderPanel.add(new JLabel(q.getQuestionText()), c);

                            c.weightx = 0.2;
                            c.gridx = 1;
                            JButton editButton = new JButton("edit");
                            questionHeaderPanel.add(editButton, c);

                            c.weightx = 0.2;
                            c.gridx = 2;
                            JButton deleteButton = new JButton("delete");
                            deleteButton.setActionCommand(Integer.toString(i));
                            questionHeaderPanel.add(deleteButton, c);
                            deleteButton.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent ae) {
                                    //
                                    questions.remove(Integer.parseInt(ae.getActionCommand()));
                                }
                            });

                            c.gridx = 0;
                            mcqPanel.add(questionHeaderPanel, c);

                            // TODO: Proof if there are more than one correct option
                            // Multiple choice question with one correct option
                            ButtonGroup group = new ButtonGroup();

                            int j = 0;
                            for (model.answer.Choice choice : ((MCQ) q).getChoices()) {
                                //Create the radio buttons.
                                JRadioButton choiceButton = new JRadioButton(choice.getText());
                                choiceButton.setMnemonic(KeyEvent.VK_B);

                                //Group the radio buttons.
                                group.add(choiceButton);

                                //Register a listener for the radio buttons.
                                //choiceButton.addActionListener(this);

                                c.weightx = 1;
                                c.gridx = 0;
                                c.gridy = j + 1;
                                j++;
                                mcqPanel.add(choiceButton, c);
                            }
                            listContainer.add(mcqPanel);
                            listContainer.revalidate();
                        }
                    }
                    
                    
                    
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.weightx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    mainList.add(listContainer, gbc, count);
                    count++;

                    //add to questions list
                    validate();
                    repaint();
                }
            });

            JButton btnPreview = new JButton("Preview");
            btnPreview.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Hello"));
                    panel.add(new Button("Edit2"));
                    panel.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.weightx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    mainList.add(panel, gbc, count);
                    count++;

                    validate();
                    repaint();
                }
            });


            JPanel jpBottom = new JPanel();
            GridLayout gl = new GridLayout(1, 5);
            jpBottom.setLayout(gl);
            jpBottom.add(btnSection);
            jpBottom.add(btnSubsection);
            jpBottom.add(btnMCQ);
            jpBottom.add(btnFIB);
            jpBottom.add(btnPreview);
            gl.setHgap(10);
            add(jpBottom, BorderLayout.SOUTH);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
    
    /**
     * @return the controller
     */
    public ExaminationController getController() {
        return controller;
    }
 
    /**
     * @param controller the controller to set
     */
    public void setController(ExaminationController controller) {
        this.controller = controller;
    }
}