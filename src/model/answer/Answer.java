/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

import java.io.Serializable;

/**
 *
 * @author sirithana
 */
public class Answer implements Serializable{
    
    private int id;
    private String text;
    
    public Answer(String text) {
        this.text = text;
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
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
}
