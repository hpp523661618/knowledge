package leetcode.btyedance.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution1 {

    /**
     * 暴力解法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] arr = s.toCharArray();
        List<Character> tmpList = new ArrayList<>();

        int size = arr.length;

        int maxsize = 1;
        for (int i = 0; i < size - 1; i++) {
            int longsize = 1;
            tmpList.clear();
            tmpList.add(arr[i]);
            for (int j = i + 1; j < size; j++) {
                if (!tmpList.contains(arr[j])) {
                    tmpList.add(arr[j]);
                    longsize++;
                    if (longsize > maxsize) {
                        maxsize = longsize;
                    }
                } else {
                    break;
                }

            }
        }
        return maxsize;
    }


    /**
     * 滑动窗口
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) {
            return 0;
        }

//        char[] arr = s.toCharArray();
        int size = s.length();

        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < size && j < size) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;

    }


    public static void main(String[] args) {
//        System.out.println("");
//        System.out.println(lengthOfLongestSubstring2("bbb"));
//        System.out.println(lengthOfLongestSubstring2("abc"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

}
