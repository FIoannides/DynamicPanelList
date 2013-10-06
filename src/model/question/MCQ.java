/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.question;

import java.util.ArrayList;
import model.answer.Choice;

/**
 *
 * @author sirithana
 */
public class MCQ extends Question{
    
    private ArrayList<Choice> choices;
    
    public MCQ(String questionText, ArrayList<Choice> choices){
        super(questionText);
        try {
            if(choices.size() < 2){
                throw new Exception();
            }
            else{
                this.choices = choices;
            }
        } catch (Exception e) {
            System.out.println("Two options or more required");
        }
    }

    /**
     * @return the choices
     */
    public ArrayList<Choice> getChoices() {
        return choices;
    }

    /**
     * @param choices the choices to set
     */
    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }
    
}
