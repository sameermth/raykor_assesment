/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raykor_internship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author sameer
 */
class Node{
    String _value;
    String left;
    String right;
    static char current = 'B';
    int level;
    
    Node(char val){
        this._value = Character.toString(val);
        this.left   = Character.toString(current++);
        this.right  = Character.toString(current++);
    }   
}
public class PrintTree {
    public static void main(String[] args) {
        
        char init = 'A';
        char max  = 'H';
        List<Node> nodeList = new ArrayList();
        while(init<max){
            nodeList.add(new Node(init));
            init++;
        }
        
        int len = 0;
        
        //while(len<nodeList.size()){
            
        for(Node s: nodeList){
            System.out.println(s._value);
            System.out.print(s.left);
            System.out.print(" ");
            System.out.println(s.right);
        }
    }
}
