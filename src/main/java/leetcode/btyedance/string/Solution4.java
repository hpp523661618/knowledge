package leetcode.btyedance.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 */
public class Solution4 {

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int i = 0, j = s1.length();

        char[] arr1 = s1.toCharArray();

        while (j <= s2.length()) {
            String s = s2.substring(i++, j++);
            char[] arr2 = s.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

//        System.out.println(checkInclusion("ab", "ab"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));

    }
}
