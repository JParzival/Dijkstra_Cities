/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jparzival.dijkstra_con_parseador.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class Parseador_File
{
    public String readFile() throws FileNotFoundException
    {
        String allText = null;
        BufferedReader br = new BufferedReader(new FileReader("distancias.json"));
        
        try
        {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try 
            {
                line = br.readLine();
            } 
            catch (IOException ex)
            {
                Logger.getLogger(Parseador_File.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (line != null)
            {
                try
                {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                catch (IOException ex)
                {
                    Logger.getLogger(Parseador_File.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            allText = sb.toString();
        }
        finally 
        {
            try 
            {
                br.close();    
            } 
            catch (IOException ex)
            {
                Logger.getLogger(Parseador_File.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allText;
        
    }
    
    
}
