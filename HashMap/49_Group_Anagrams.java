/*
-------------------------------------------------------
Problem : 49. Group Anagrams
Platform: LeetCode
Topic   : HashMap, Sorting, Strings
Difficulty : Medium

Approach:
1. Sort each string.
2. Use the sorted string as the HashMap key.
3. Store original strings having the same key.
4. Return all grouped lists.

Time Complexity : O(n × k log k)
Space Complexity: O(n × k)

n = number of strings
k = average length of each string
-------------------------------------------------------
*/

import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}