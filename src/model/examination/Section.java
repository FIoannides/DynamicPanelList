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
public class Section implements Serializable{
    
    private int id;
    private String name;
    
    private ArrayList<Subsection> subsections;
    
    public Section(){
        this.subsections = new ArrayList<Subsection>();
    }
    
    public Section(int id, String name){
        this.id = id;
        this.name = name;
        this.subsections = new ArrayList<Subsection>();
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subsections
     */
    public ArrayList<Subsection> getSubsections() {
        return subsections;
    }

    /**
     * @param subsections the subsections to set
     */
    public void setSubsections(ArrayList<Subsection> subsections) {
        this.subsections = subsections;
    }
    
    public String toString(){
        return "Section "+id+" "+(name == null ? "" : name);
    }
}
