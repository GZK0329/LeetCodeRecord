package com.gzk.leetcode242;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*242. 有效的字母异位词
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

        示例 1:

        输入: s = "anagram", t = "nagaram"
        输出: true
        示例 2:

        输入: s = "rat", t = "car"
        输出: false
        说明:
        你可以假设字符串只包含小写字母。

        进阶:
        如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            int k = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), k);
        }
        for(int i = 0; i < t.length(); ++i){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
            else{
                return false;
            }
        }

        //遍历hashmap 方法1 迭代器
        /*Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){

            //Map.Entry<k,v> 表示一个映射项
            //iterator接口的方法 next
            //
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue() != 0){
                return false;
            }

        }*/
        //方法2 键值对 for each 循环
        /*for (Map.Entry<Character, Integer> entry:
                map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }*/

        map.forEach( (k,v) -> System.out.println("k ="+ k + ",v =" + v));
        return true;
    }
}
