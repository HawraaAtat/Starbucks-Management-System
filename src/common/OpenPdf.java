/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class OpenPdf {
    
    public static void openById(String id)
    {
        try
        {
            if((new File("C:\\Users\\Administrator\\OneDrive\\Desktop\\"+id+".pdf")).exists())
            {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\Administrator\\OneDrive\\Desktop\\"+id+".pdf");
                        
            }
            else
                //System.out.println("File is not Exists");
                 JOptionPane.showMessageDialog(null,"File is not Exists");
            
        }
        catch(Exception e)
        {   
//            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
