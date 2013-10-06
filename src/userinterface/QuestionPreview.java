/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.answer.Choice;
import model.question.MCQ;
import model.question.Question;

/**
 *
 * @author sirithana
 */
public class QuestionPreview {
    private int i;
    private JPanel listContainer;
    private ArrayList<Question> questions;

    private void initUI() {
        // Frame initialise
        final JFrame frame = new JFrame(QuestionPreview.class.getSimpleName());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Container
        listContainer = new JPanel();
        listContainer.setLayout(new BoxLayout(listContainer, BoxLayout.Y_AXIS));

        frame.add(new JScrollPane(listContainer), BorderLayout.CENTER);

        // Test data
        Choice c1 = new Choice("true", true);
        Choice c2 = new Choice("false", false);
        ArrayList<Choice> choices = new ArrayList<Choice>();
        choices.add(c1);
        choices.add(c2);
        MCQ mcq1 = new MCQ("Question 1", choices);
        MCQ mcq2 = new MCQ("Question 2", choices);
        
        questions = new ArrayList<Question>();
        questions.add(mcq1);
        questions.add(mcq2);
        
        for(int i=0; i<questions.size(); i++){
            Question q = questions.get(i);
            // Multiple choice question
            if(q instanceof MCQ){
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
                
                int j=0;
                for(Choice choice : ((MCQ)q).getChoices()){
                    //Create the radio buttons.
                    JRadioButton choiceButton = new JRadioButton(choice.getText());
                    choiceButton.setMnemonic(KeyEvent.VK_B);
                    
                    //Group the radio buttons.
                    group.add(choiceButton);

                    //Register a listener for the radio buttons.
                    //choiceButton.addActionListener(this);
                    
                    c.weightx = 1;
                    c.gridx = 0;
                    c.gridy = j+1;
                    j++;
                    mcqPanel.add(choiceButton, c);
                }
                listContainer.add(mcqPanel);
                listContainer.revalidate();
            }
        }
        
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new QuestionPreview().initUI();
            }
        });
    }
}