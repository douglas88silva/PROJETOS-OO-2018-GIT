/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ice
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<Pokemon> a = new ArrayList();
        Set <Pokemon> b = new HashSet<Pokemon>();
        Map <Integer ,Pokemon> c = new HashMap();
        
        Pokemon a1 = new Pokemon(10,"Pokemon10");
        Pokemon a2 = new Pokemon(0,"Pokemon0");
        Pokemon a3 = new Pokemon(5,"Pokemon5");
        Pokemon a4 = new Pokemon(20,"Pokemon20");
        Pokemon a5 = new Pokemon(20,"Pokemon20");
        
        a.add(a1);
        a.add(a2);
        a.add(a3);
        a.add(a4);
        
        b.add(a1);
        b.add(a2);
        b.add(a3);
        b.add(a4);
        b.add(a5);
        
        c.put(a1.getId(), a1);
        c.put(a2.getId(), a2);
        c.put(a3.getId(), a3);
        c.put(a4.getId(), a4);
//        
//        
//        for(Pokemon j: a )
//        {
//            System.out.println(j.getNome());
//        }
//        
//        Collections.sort(a, new Comparator<Pokemon>() {
//            @Override
//            public int compare(Pokemon o1, Pokemon o2) {
//              return o1.getNome().compareTo(o2.getNome());
//            }
//        });
//        
//        
//        System.out.println("");
//        for(Pokemon j: a )
//        {
//            System.out.println(j.getNome());
//            
//        }
//        
        
        
//        System.out.println("");
//        for(Pokemon s: b )
//        {
//            System.out.println(s.getNome());
//            
//        }
        Iterator i = c.entrySet().iterator();
        System.out.println("");
        
        for(i.hasNext())
        {
            
            
        }
        
        
    }
    
}
