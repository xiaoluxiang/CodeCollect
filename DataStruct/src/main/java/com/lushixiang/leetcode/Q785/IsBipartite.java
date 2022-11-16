package com.lushixiang.leetcode.Q785;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class IsBipartite {
    public static void main(String[] args) {
        int[][] graph = {{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},{10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},{},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},{47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
        System.out.println(new Solution().isBipartite(graph));
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        for(int i=0; i<graph.length; i++){
            if(!checkBipartite(graph,i)){
                System.out.println("exist wrong child_tree");
                return false;
            }
        }
        return true;
    }


    public boolean checkBipartite(int[][] graph, int index){
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        // 节点初始化
        HashSet<Integer> targetSet = new HashSet<>();
        for(int k=index; k<graph.length; k++){
            if(graph[k].length!=0){
                setA.add(k);
                for(int i=0; i<graph[k].length; i++){
                    setB.add(graph[k][i]);
                    targetSet.add(graph[k][i]);
                }
                break;
            }

        }

        boolean convert = false;
        while(!targetSet.isEmpty()){
            System.out.println("Main cycle: "+targetSet);
            HashSet<Integer> nextTargetSet = new HashSet<>();
            for (Integer i : targetSet) {
                System.out.println("current execute number : "+i);
                for(int j=0; j<graph[i].length; j++){
                    if(convert){
                        // add to B
                        if(setA.contains(graph[i][j])){
                            System.out.println("add to B wrong");
                            System.out.println(graph[i][j]);
                            return false;
                        }
                        if(!setB.contains(graph[i][j])){
                            nextTargetSet.add(graph[i][j]);
                            setB.add(graph[i][j]);
                        }

                    }else{
                        // add to A
                        if(setB.contains(graph[i][j])){
                            System.out.println("add to A wrong");
                            System.out.println(graph[i][j]);
                            return false;
                        }
                        if(!setA.contains(graph[i][j])){
                            nextTargetSet.add(graph[i][j]);
                            setA.add(graph[i][j]);
                        }
                    }
                }
            }
            convert = !convert;
            targetSet = nextTargetSet;
        }


        if(setA.size()+ setB.size()!=graph.length){
            System.out.println("calculate total number wrong");
            return true;
        }
        return true;
    }

}