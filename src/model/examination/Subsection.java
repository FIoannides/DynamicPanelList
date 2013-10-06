/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.examination;

import java.io.Serializable;
import java.util.ArrayList;
import model.question.Question;

/**
 *
 * @author sirithana
 */
public class Subsection implements Serializable{
    
    private String topic;
    private ArrayList<Question> questions;
    
    public Subsection(String topic){
        this.topic = topic;
    }

    /**
     * @return the topic
     */
    public String getTopic() {
        return topic;
    }

    /**
     * @param topic the topic to set
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @return the questions
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
    
    public String toString(){
        return "Subsection : "+topic;
    }
}
