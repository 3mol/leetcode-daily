package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Leetcode049 {
  /**
   * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
   * <p>
   * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
   * <p>
   * 示例 1:
   * <p>
   * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
   * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
   * 示例 2:
   * 输入: strs = [""]
   * 输出: [[""]]
   * 示例 3:
   * 输入: strs = ["a"]
   * 输出: [["a"]]
   * 提示：
   * <p>
   * 1 <= strs.length <= 104
   * 0 <= strs[i].length <= 100
   * strs[i] 仅包含小写字母
   *
   * @param strs ~
   * @return ~
   */
  public List<List<String>> groupAnagrams(String[] strs) {
    // 对每一个单词进行排序，排序后映射到map<sort_value, List<value>>中，如果后续存在就加入到列表
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      map.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    final var lists = new Leetcode049().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    System.out.println(lists);
  }
}