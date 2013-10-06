/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.question;

import java.io.Serializable;
import model.answer.Answer;
import java.util.List;

/**
 *
 * @author sirithana
 */
public class Question implements Serializable{
    
    private int id;
    private String questionText;
    
    public Question(String questionText) {
        this.questionText = questionText;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * @param questionText the questionText to set
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
}
