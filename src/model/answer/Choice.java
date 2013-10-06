/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.answer;

/**
 *
 * @author sirithana
 */
public class Choice extends Answer{
    
    private boolean correct;
    
    public Choice(String text, boolean correct){
        super(text);
        this.correct = correct;
    }

    /**
     * @return the correct
     */
    public boolean isCorrect() {
        return correct;
    }

    /**
     * @param correct the correct to set
     */
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    
}
