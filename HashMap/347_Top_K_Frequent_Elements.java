/*
-------------------------------------------------------
Problem : 347. Top K Frequent Elements
Platform : LeetCode
Topic : HashMap, Bucket Sort
Difficulty : Medium

Approach:
1. Count frequency using HashMap.
2. Store numbers in buckets based on frequency.
3. Traverse buckets from highest frequency to lowest.
4. Collect the first k elements.

Time Complexity : O(n)
Space Complexity : O(n)
-------------------------------------------------------
*/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {

            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // Step 3: Traverse buckets from highest frequency
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    result[index++] = num;

                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return result;
    }
}