package raykor_internship;


import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sameer
 */
public class XmlFormatting {
    public static void main(String[] args)throws Exception {
        int space= 0;
        
        File file = new File("C:\\Users\\sameer\\Documents\\NetBeansProjects\\Raykor_internship\\input.xml");
        
        Scanner in = new Scanner(file);
        
        Stack<String> stack_open = new Stack<String>();
        Pattern pattern_close = Pattern.compile("(<)(/)([a-z]+|[A-Z]+)(.*)(>)");
        Pattern pattern_open = Pattern.compile("(<)([a-z]+|[A-Z]+)(.*)(>)");
        
        
        while(in.hasNextLine()){
            
            String line = in.nextLine();
            Matcher matcher_open = pattern_open.matcher(line);
            Matcher matcher_close = pattern_close.matcher(line);
            
            if(matcher_open.find()){
                
                if(matcher_close.find())
                {
                    space = stack_open.size();
                    while(space>0){
                        System.out.print("\t");
                        space--;
                    }
                    System.out.println(line);
                }
                else if(!matcher_close.find())
                {
                    space= stack_open.size();
                    stack_open.push(matcher_open.group());
                    while(space>0){
                        System.out.print("\t");
                        space--;
                    }
                    System.out.println(line);
                }
            }
            else if(matcher_close.find()){
                
                space = stack_open.size()-1;
                stack_open.pop();
                while(space>0){
                    System.out.print("\t");
                    space--;
                }
                System.out.println(line);
            }
            else
              System.out.println(line);
        }
        in.close();
    }
}
