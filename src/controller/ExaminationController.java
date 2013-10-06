/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
 
import java.io.BufferedInputStream;
import userinterface.TeacherUI;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.examination.Examination;
import model.examination.Section;
import model.examination.Subsection;
import model.question.Question;
 
/**
 *
 * @author sirithana
 */
public class ExaminationController {
     
    private Examination examination;
    private TeacherUI view;
     
    public ExaminationController(TeacherUI view){
        this.examination = new Examination();
        this.view = view;
        this.readFromFile();
    }
     
    public ExaminationController(){
        this.examination = new Examination();
        this.readFromFile();
    }
     
     /**
     * @return the examination
     */
    public Examination getExamination() {
        return examination;
    }
 
    /**
     * @param examination the examination to set
     */
    public void setExamination(Examination examination) {
        this.examination = examination;
    }
     
    public void createExamination(){
        this.setExamination(new Examination());
    }
     
    public void addSection(){
        Section newSection = new Section();
        // assign an ID for new section
        int id = 0;
        for(Section s : this.getExamination().getSections()){
            if(s.getId() > id){
                id = s.getId();
            }
        }
        newSection.setId(id+1);
        this.getExamination().getSections().add(newSection);
    }
     
    public void addSection(String name){
        // assign an ID for new section
        int id = 0;
        for(Section s : this.getExamination().getSections()){
            if(s.getId() > id){
                id = s.getId();
            }
        }
        Section newSection = new Section(id+1, name);
        this.getExamination().getSections().add(newSection);
    }
     
    public void deleteSection(int sectionIndex){
       this.getExamination().getSections().remove(sectionIndex);
    }
     
    public void addSubsection(int sectionIndex, String topic){
        Section selectedSection = (Section)this.getExamination().getSections().get(sectionIndex);
        Subsection newSubsection = new Subsection(topic);
        selectedSection.getSubsections().add(newSubsection);
    }
     
    public void addQuestion(int sectionIndex, int subsectionIndex, Question question){
        Section selectedSection = (Section)this.getExamination().getSections().get(sectionIndex);
        Subsection selectedSubsection = (Subsection)selectedSection.getSubsections().get(subsectionIndex);
        selectedSubsection.getQuestions().add(question);
    }
     
    public void deleteQuestion(int sectionIndex, int subsectionIndex, Question question){
 
    }
     
    public void readFromFile(){
//        try {
//            this.examination = XMLHelper.read("src/XMLHelper/examination.xml");
//        }catch (NoSuchElementException ex) {
//            this.examination = new Examination();
//            this.saveToFile();
//        }
//        catch (Exception ex) {
//            Logger.getLogger(ExaminationController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try{
        //use buffering
            InputStream file = new FileInputStream("src/datastorage/examination.ser");
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            try{
            //deserialize the List
            examination = (Examination)input.readObject();
            //display its data
            for(Section s: examination.getSections()){
                System.out.println("Recovered Section: " + s.toString());
            }
        }
        finally{
            input.close();
        }
    }
    catch(ClassNotFoundException ex){
        //fLogger.log(Level.SEVERE, "Cannot perform input. Class not found.", ex);
    }
    catch(IOException ex){
      //fLogger.log(Level.SEVERE, "Cannot perform input.", ex);
    }
    }
     
    public void saveToFile(){
        try {
            OutputStream file = new FileOutputStream("src/datastorage/examination.ser");
            //OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(file);
            output.writeObject(this.examination);
            output.close();
            System.out.println("done");
        }  
        catch(IOException ex){
            Logger.getLogger(ExaminationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void updateView(){
        view.updateView(this.examination);
    }
     
    /**
     * @return the view
     */
    public TeacherUI getView() {
        return view;
    }
 
    /**
     * @param view the view to set
     */
    public void setView(TeacherUI view) {
        this.view = view;
    }
     
}