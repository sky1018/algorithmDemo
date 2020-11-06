package com.example.demo.arraySeries;


import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 两个数组的交集
 * 说明：
 *  1. 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *  2. 我们可以不考虑输出结果的顺序。
 */
public class TheIntersectionOfTwoNumbers {


    public static int [] demo1(int [] nums1, int [] nums2) {

        List<Integer> list = new ArrayList<>();
        for (int i=0,num1Count=nums1.length;i < num1Count;i++) {
            for (int j=0,num2Count=nums2.length;j < num2Count;j++) {
                if (nums1[i] == nums2[j]){
                    list.add(nums1[i]);
                    break;
                }
            }
        }

        if (list != null && list.size() > 0){
            Object [] obj = list.toArray();
            int [] num = new int[2];
            for (int j=0,num2Count=obj.length;j < num2Count;j++) {
                num[j] = Integer.parseInt(String.valueOf(obj[j]));
            }
            return num;
        }
        return null;
    }

    /**
     * int [] nums1 = {1,2,2,1};
     * int [] nums2 = {2,2};
     * 满足了不了有重复值类型的数组，获取交集
     * @param nums1
     * @param nums2
     * @return
     */
    public static int [] demo2(int [] nums1, int [] nums2){

        if(nums1.length > nums2.length){
            demo2(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<>(16);
        for (int num : nums1){
            map.put(num,1);
        }

        int [] outNum = new int[nums1.length];
        int i = 0;
        for(int num : nums2){
            if(map.containsKey(num)){
                outNum[i] = num;
                map.remove(num);
                i++;
            }
        }

        return Arrays.copyOfRange(outNum,0, i);
    }

    public static int [] demo3(int [] nums1, int [] nums2){

        if(nums1.length > nums2.length){
            demo2(nums2,nums1);
        }

        Map<Integer,Integer> map = new HashMap<>(16);
        for (int num : nums1){
            int cont = map.getOrDefault(num,0)+1;
            map.put(num,cont);
        }

        int [] outNum = new int[nums1.length];
        int i = 0;
        for(int num : nums2){
            int count = map.getOrDefault(num,0);
            if (count > 0){
                outNum[i++] = num;
                count--;

                if (count > 0){
                    map.put(num, count);
                } else {
                    map.remove(num);
                }

            }
        }

        return Arrays.copyOfRange(outNum,0, i);
    }


    public static int [] demo4(int [] nums1, int [] nums2){

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int nums1Leng = nums1.length, nums2Leng = nums2.length;
        int index = 0,index1 = 0,index2=0;

        int [] outNum = new int[Math.min(nums1Leng,nums2Leng)];
        int j = 1;
        while (true){
            System.out.println("第"+ (j++) +"次循环，nums1 = [" + nums1[index1] + "], nums2 = [" + nums2[index2] + "]");
            if(nums1[index1] > nums2[index2]){
                index1++;
            } else if(nums1[index1] < nums2[index2]) {
                index2++;
            } else {
                outNum[index] = nums1[index1];
                index++;
                index1++;
                index2++;

            }
            if(index2 >= (nums2Leng-1)){
                index2 = Math.min(index1,index2);
            }
            if(index2 == nums1Leng || index2 == nums2Leng){
                break;
            }
        }

        return Arrays.copyOfRange(outNum,0, index);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        int k = 1;
        while (index1 < length1 && index2 < length2) {
            System.out.println("第"+ (k++) +"次循环，nums1 = [" + nums1[index1] + "], nums2 = [" + nums2[index2] + "]");
            if (nums1[index1] > nums2[index2]) {
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[]args){
        /*int [] nums1 = {4,9,5};
        int [] nums2 = {9,4,9,8,4};*/
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2,2};

//        int [] nums1 = {1,2,3,4,4,13};
//        int [] nums2 = {1,2,3,9,10};


//        demo(nums1,nums2);
//        int [] outArray = intersect(nums1,nums2);
        int [] outArray = demo4(nums1,nums2);
//        int [] outArray = intersect2(nums1,nums2);
        System.out.println(Arrays.toString(outArray));
    }


}

