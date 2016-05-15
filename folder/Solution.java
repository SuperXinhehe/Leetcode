/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;
/**
 *
 * @author xinhe
 */
public class Solution {

    public void consecusiveseq(Integer[] integers){
        int len = integers.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer> (Arrays.asList(integers));
        Collections.sort(arrayList);
        System.out.println(arrayList);
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        ArrayList<Integer> inner = new ArrayList<Integer>();

        for(int i=0; i<arrayList.size();i++){
            int j = i+1;
            newlist.add(arrayList.get(i));
            if(arrayList.get(j)==arrayList.get(i)+1){
                newlist.add(arrayList.get(j));
            }
            else{
                if(newlist.size()==1){
                    arrayList.remove(0);
                    arrayList.add(j);
                }
                else{
                    if(inner.isEmpty()){
                        for(Integer i2: newlist){
                            inner.add(i2);      
                        }
                        newlist.removeAll(newlist);
                    }
                    else{
                        if(newlist.size()>inner.size()){
                            inner.removeAll(inner);
                            for(Integer i2: newlist){
                            inner.add(i2);      
                        }
                        newlist.removeAll(newlist);
                        }
                        else{
                            newlist.removeAll(newlist);
                        }
                    }
                }
            }

        }
        System.out.println(newlist);

//        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//        for(int i:arrayList){
//            map.put(i, i+1);
//        }
//        
        
    }
    //max set of activities  greedy
    public List<Integer> maxSet(int[] start, int[] end) {
        List<Integer> out = new ArrayList<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        // wont deal with the duplicates...
        for (int i=0;i<start.length;i++) {
            map.put(end[i],i);
        }
        Integer[] indices = map.values().toArray(new Integer[map.values().size()]);
        int[] newstart = new int[start.length];
        for (int i=0;i<indices.length;i++) {
            newstart[i] = start[indices[i]];
        }
        // for (int ele:indices) {
        //     System.out.print(ele+ " ");
        // }
        // adding the first element 
        out.add(0);
        // for (int ele:newstart) {
        //     System.out.print(ele+ " ");
        // }
        System.out.println();
        int j = 0;
        for (int i=1;i<end.length;i++) {
            if(newstart[i] >= end[j]) {
                j = i;
                out.add(i);
            }
        }
        return out;
    }

    // set cover greedy algorithm
    // approach is to pick the set with minimum ratio:
    // cost(si) / |si - I|
    public Set<Integer> setCover() 

    // find minimum time to finish all jobs with given constraints..
    // k : number of assignees avaliable
    // t: time taken by an assignee to finish one unit of job
    // an assignee can be assigned only contigous jobs.. cannot be assigned jobs 1and3 but not 2
    // c++
    public static void main(String[] args) {
        // Integer[] ints = new Integer[] {100,25,2,44,45,46};
        
        // Solution solu = new Solution();
        // solu.consecusiveseq(ints);
        // maxset testing..
        Solution s = new Solution();
        int[] start = {1,3,0,5,8};
        int[] end = {2,4,6,7,9};
        List<Integer> out = s.maxSet(start,end);
        out.forEach(ele->System.out.println(ele));
    }
    
}
