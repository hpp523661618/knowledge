package leetcode.btyedance.string;

import java.util.*;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class Solution2 {

    public static String reverseWords(String s) {


        String[] str = s.split(" ");
        List<String> list = new ArrayList<>();
        String result = "";
        for (String s1 : str) {
            if (!s1.equals("")) {
                list.add(s1);
            }
        }
        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            result += list.get(i);
            if (i!=0) {
                result+=" ";
            }
        }

        return result;

    }

    public static void main(String[] args) {

        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords("a good   example"));
    }


}
