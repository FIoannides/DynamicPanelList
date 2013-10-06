/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MELT;

import userinterface.TeacherUI;
import controller.ExaminationController;

/**
 *
 * @author sirithana
 */
public class MELTDemo {
    
    public static void main(String[] args){
        //Create a view : to write student details on console
      ExaminationController controller = new ExaminationController();
      TeacherUI view = new TeacherUI(controller.getExamination());
      view.setController(controller);
      controller.setView(view);
      controller.updateView();
    }
    
}
