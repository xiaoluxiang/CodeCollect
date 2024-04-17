package com.lushixiang.TestSimple;

import java.util.HashMap;
import java.util.Scanner;

public class Temp_KeDa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(Temp_KeDa.getFinalString(s2,s1));
    }
    public static String getFinalString(String s1, String s2){
        HashMap<Character, Boolean> checkMap = new HashMap<>();
        for(int i = 0; i<s1.length(); i++){
            checkMap.put(s1.charAt(i), Boolean.TRUE);
//            checkMap.put(s1.)
        }
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i<s2.length(); i++){
            if(checkMap.get(s2.charAt(i))==null){
                finalString.append(s2.charAt(i));
            }
        }
        return finalString.toString();
    }
}
