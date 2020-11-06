package com.example.demo.arraySeries;

/**
 * 最长公共前缀
 * 说明：
 *  1. 所有输入只包含小写字母 a-z
 *  2. 如果不存在公共前缀，则返回""
 */
public class MaxLengthStr {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static String demo(String[] strs){

        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        String outStr = "";
        for (int i =0; i<strs.length; i++){
            String str = strs[i];
            int lengt = Math.min(prefix.length(),strs[i].length());
            int index = lengt-1;
            while (index < lengt && prefix.charAt(index) ==  str.charAt(index)){
                index++;
            }
            prefix = prefix.substring(0,index);
        }
        return prefix;
    }
    public static void main(String[] args) {

        String [] str = {"ddog","dracecar","dcar"};
        String outStr = demo(str);
//        String outStr = "ddog";
        System.out.println("commonPrefix = [" + outStr + "]");

    }

}
