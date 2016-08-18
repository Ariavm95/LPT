/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPT;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


/**
 *
 * @author Aria
 */
public class LPT {
 
 
    static Map<Integer,Integer> unsortedArray=new HashMap<Integer, Integer>();
    //static Map<Integer,Integer> m=new Map<Integer, Integer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Test Data
        // int [] a={15,5,15,30,10};
        //int [] a={4,4,4,4,4,4,4};
        //int [] a= {70,60,40,40,30,15,6, 2,1};
        //int [] a= {15,2,14,14,14,258,90,7};
        int a[]=new int[2000000];
        Random t= new Random();
        for(int b=0;b<2000000;b++){
            a[b]= 100+(t.nextInt(99000));
        }

        LPT test=new LPT();
        test.lptFunc(a,3);
        
    }
    
    public void lptFunc(int []a,int machineSize){
        for(int i=0; i< a.length;i++ )
        {
             unsortedArray.put(i, a[i]);
             
        }
        
        List<Entry<Integer, Integer>> sortedArray = entriesSortedByValues(unsortedArray);
        List <Integer> sum= new ArrayList<Integer>();
        // gol is the output
        ArrayList<List<Entry<Integer, Integer>>> gol=new ArrayList<List<Entry<Integer, Integer>>>();
        for(int m=0; m<machineSize;m++)
        {
            List<Entry<Integer, Integer>> m1=new ArrayList<Entry<Integer,Integer>>();
            gol.add(m1);
            sum.add(0);
        }
        int mdefault=1;
     
        for(int i=0; i< sortedArray.size();i++)
        {
            
            int v=sortedArray.get(i).getValue();
            int min=Collections.min(sum);
            mdefault=(sum.indexOf(min));
            sum.set(mdefault, (v+min));
            gol.get(mdefault).add(sortedArray.get(i));
           
        }
        //print(gol);
    }
    
    private static void print(ArrayList<List<Entry<Integer, Integer>>> g){
        int size=g.size();
        for(int i=0;i<size;i++){
            List<Entry<Integer,Integer>> l=g.get(i);
            for(int j=0;j<l.size();j++){
               System.out.println("m"+(i+1)+": "+l.get(j).getKey()+" , "+l.get(j).getValue());
               
            }
        }
    }
   
    
   static <K,V extends Comparable<? super V>> 
            List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());

        Collections.sort(sortedEntries, 
            new Comparator<Entry<K,V>>() {
                @Override
                public int compare(Entry<K,V> e1, Entry<K,V> e2) {
                    return e2.getValue().compareTo(e1.getValue());
                }
            }
        );

        return sortedEntries;
    }

    
}
