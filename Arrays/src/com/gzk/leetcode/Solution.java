package com.gzk.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Solution {
    public <T> int getNum(List<T> a){

    }

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int[] result = new int[nums.length];

        //Set<Integer> set = new HashSet<Integer>(Arrays.asList(nums));

        //Set<Integer> set = Stream.of(Arrays.stream(nums).parallel().boxed().toArray(Integer[]::new)).collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }


        //Collections.addAll(set, nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //Iterator iterator = set.iterator();
        //while(iterator.hasNext()){
        //    int num = iterator.next();
        //}
        //int[] arr = new int[set.size()];
        Integer[] arr = set.toArray(new Integer[set.size()]);
        int temp = 0;
        int leftIndex = 0;
        for(int j = 0; j < arr.length; ++j){
            temp = 0;
            for(int k = 0; k < arr.length; ++k){
                int num = map.get(nums[k]);
                temp += num * Math.abs(arr[j] - arr[k]);
            }
            int iterval = map.get(nums[j]);
            Arrays.fill(result, leftIndex, leftIndex + iterval, temp);
            leftIndex += iterval;
        }
        return result;
    }
}