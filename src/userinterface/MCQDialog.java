/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import model.answer.Choice;
import model.question.MCQ;

/**
 *
 * @author Fidias
 */
public class MCQDialog extends javax.swing.JDialog {

    private ArrayList<Choice> questions = new ArrayList<Choice>();
    private MCQ question;

    public MCQ getQuestion() {
        return question;
    }
    private JPanel mainList = new JPanel(new GridBagLayout());
    private char nextChar = 'A';
    private ArrayList<Character> availChars = new ArrayList<Character>();
    private int i;
    /**
     * Creates new form MCQDialog
     */
    public MCQDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLayout(new BorderLayout(20, 20));
        JLabel lblTitle = new JLabel("Add MCQ");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        //lblTitle.setForeground(Color.RED);
        add(lblTitle, BorderLayout.NORTH);

        JPanel jpComplete = new JPanel();
        jpComplete.setLayout(new GridLayout(3,0));
        
        JPanel jpCenter = new JPanel();
        GridBagLayout gla = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        jpCenter.setLayout(gla);
        Border empty = new MatteBorder(0, 20, 0, 20,new Color(240,240,240));
        JLabel lblNumber = new JLabel("Number");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        jpCenter.add(lblNumber,c);
        JLabel lblText = new JLabel("Question Text: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 1;
        jpCenter.add(lblText,c);
        final JTextArea txtName = new JTextArea(5,12);
        txtName.setFont(new Font("Arial", 0, 14));
        JScrollPane scrollPane = new JScrollPane(txtName);
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        jpCenter.add(scrollPane,c);
        jpCenter.setBorder(empty);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainList.add(new JPanel(), gbc);
        
        for(i=0;i<2;i++){
            JPanel option = new JPanel();
            option.setName("Option " + nextChar);
            GridLayout gl = new GridLayout();
            option.setLayout(gl);
            JLabel lblOption = new JLabel("Option "+nextChar);
            //c.weightx = 0.5;
            //c.fill = GridBagConstraints.HORIZONTAL;
            //c.gridx = 0;
            //c.gridy = 0;
            option.add(lblOption);
            JTextField txtOption = new JTextField(); 
            //c.weightx = 0.5;
            //c.fill = GridBagConstraints.HORIZONTAL;
            //c.gridx = 1;
            //c.gridy = 0;
            option.add(txtOption);
            JCheckBox cbOption = new JCheckBox();
            //c.weightx = 0.5;
            //c.fill = GridBagConstraints.HORIZONTAL;
            //c.gridx = 2;
            //c.gridy = 0;
            option.add(cbOption);
            JButton btnDelete = new JButton("Delete");
            btnDelete.setActionCommand("Option "+nextChar);
            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    Component[] comp = mainList.getComponents();
                    for (int i = 0; i < comp.length; i++) {
                        if (comp[i].getName().equals(ae.getActionCommand().toString())) {
                            mainList.remove(comp[i]);
                            nextChar = ae.getActionCommand().toString().replaceAll("Option ", "").toCharArray()[0];
                            break;
                        }
                    }
                    i--;
                    validate();
                    repaint();
                }
            });
            //c.weightx = 0.5;
            //c.fill = GridBagConstraints.HORIZONTAL;
            //c.gridx = 3;
            //c.gridy = 0;
            option.add(btnDelete);
            gbc.weightx = 0.5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = 0;
            //gbc.gridy = i;
            mainList.add(option, gbc, nextChar % 65);
            nextChar++;
        }
        
        mainList.setBorder(empty);          
        
        JPanel jpCenter2 = new JPanel();
        jpCenter2.setLayout(gla);
        JButton btnAdd = new JButton("Add");
        btnAdd.setActionCommand(Integer.toString(i));
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel option = new JPanel();
                option.setName("Option " + nextChar);
                GridLayout gl = new GridLayout();
                option.setLayout(gl);
                JLabel lblOption = new JLabel("Option " + nextChar);
                //c.weightx = 0.5;
                //c.fill = GridBagConstraints.HORIZONTAL;
                //c.gridx = 0;
                //c.gridy = 0;
                option.add(lblOption);
                JTextField txtOption = new JTextField();
                //c.weightx = 0.5;
                //c.fill = GridBagConstraints.HORIZONTAL;
                //c.gridx = 1;
                //c.gridy = 0;
                option.add(txtOption);
                JCheckBox cbOption = new JCheckBox();
                //c.weightx = 0.5;
                //c.fill = GridBagConstraints.HORIZONTAL;
                //c.gridx = 2;
                //c.gridy = 0;
                option.add(cbOption);
                JButton btnDelete = new JButton("Delete");
                btnDelete.setActionCommand("Option "+nextChar);
                btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Component[] comp = mainList.getComponents();
                        for (int i = 0; i < comp.length; i++) {
                            if (comp[i].getName().equals(ae.getActionCommand().toString())) {
                                mainList.remove(comp[i]);
                                nextChar = ae.getActionCommand().toString().replaceAll("Option ", "").toCharArray()[0];
                                break;
                            }
                        }
                        i--;
                        validate();
                        repaint();
                    }
                });
                //c.weightx = 0.5;
                //c.fill = GridBagConstraints.HORIZONTAL;
                //c.gridx = 3;
                //c.gridy = 0;
                option.add(btnDelete);
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.weightx = 0.5;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridx = 0;
                //gbc.gridy = Integer.parseInt(e.getActionCommand());
                mainList.add(option, gbc, nextChar % 65);
                validate();
                repaint();
                nextChar++;
                i++;
            }
        });
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        jpCenter2.add(btnAdd,gbc);
        
        JLabel lblMarks = new JLabel("Marks: ");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        jpCenter2.add(lblMarks,c);
        JTextField txtMarks = new JTextField("");
        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        jpCenter2.add(txtMarks,c);
        jpCenter2.setBorder(empty);
       
                
        jpComplete.add(jpCenter);
        jpComplete.add(new JScrollPane(mainList));
        jpComplete.add(jpCenter2);
        add(jpComplete, BorderLayout.CENTER);
        
        JPanel jpBottom = new JPanel();
        GridLayout gl = new GridLayout(1, 2);
        jpBottom.setLayout(gl);
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //typedText = txtName.getText();
                //question = new MCQ();
                boolean[] correct = new boolean[i];
                Component[] comp = mainList.getComponents();
                for (int i = 0; i < comp.length; i++) {
                    JPanel jp = (JPanel) comp[i];
                    Component[] comp2 = jp.getComponents();
                    for (int j=0; j<comp2.length; j++){
                        if(comp2[j] instanceof JCheckBox){
                            JCheckBox jcb = (JCheckBox) comp2[j];
                            if(jcb.isSelected()){
                                correct[i] = true;
                            }
                        }
                    }
                }
                for (int i = 0; i < comp.length; i++) {
                    JPanel jp = (JPanel) comp[i];
                    Component[] comp2 = jp.getComponents();
                    for (int j=0; j<comp2.length; j++){
                        if(comp2[j] instanceof JTextField){
                            JTextField jtf = (JTextField) comp2[j];
                            questions.add(new Choice(jtf.getText(),correct[i]));
                        }
                    }
                }
                question = new MCQ(txtName.getText(),questions);
                clearAndHide();
            }
        });
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAndHide();
            }
        });
        jpBottom.add(btnSubmit);
        jpBottom.add(btnCancel);
        gl.setHgap(10);
        add(jpBottom, BorderLayout.SOUTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MCQDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MCQDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MCQDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MCQDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MCQDialog dialog = new MCQDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    /** This method clears the dialog and hides it. */
    public void clearAndHide() {
        setVisible(false);
        dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
