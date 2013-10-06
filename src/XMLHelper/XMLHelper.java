/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package XMLHelper;

/**
 *
 * @author sirithana
 */
import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.*;
import model.examination.Examination;

public class XMLHelper {
    
    public static void write(Examination examination, String filename) throws Exception{
        XMLEncoder encoder =
           new XMLEncoder(
              new BufferedOutputStream(
                new FileOutputStream(filename)));
        encoder.writeObject(examination);
        encoder.close();
    }

    public static Examination read(String filename) throws Exception {
        XMLDecoder decoder =
            new XMLDecoder(new BufferedInputStream(
                new FileInputStream(filename)));
        Examination examination = (Examination)decoder.readObject();
        decoder.close();
        return examination;
    }
}