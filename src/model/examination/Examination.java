/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.examination;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sirithana
 */
public class Examination implements Serializable{
    
    private int id;
    private String instruction;
    private ArrayList<Section> sections;
    
    public Examination(){
        sections = new ArrayList<Section>();
    }

    public Examination(String instruction){
        this.instruction = instruction;
        sections = new ArrayList<Section>();
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
     * @return the instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @param instruction the instruction to set
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    
    /**
     * @return the sections
     */
    public ArrayList<Section> getSections() {
        return sections;
    }

    /**
     * @param sections the sections to set
     */
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }
    
}
