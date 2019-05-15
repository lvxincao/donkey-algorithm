package com.donkey.sort;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Arrays;

/**
 * @author: lxc
 * @Date: 2019/5/15 17:25
 * @Description: 计数排序 平均时间复杂度O(n+k) 空间复杂度是O（n+k）
 * 适用于数量比较大，元素的范围比较小，如果公司人员的年龄，高考成绩（没小数）等
 * 它是一种非比较排序，但是要注意它的使用范围
 * 以数组的元素作为count计数数组的下标，要做稳定排序，就要加入一个累加计数数组，这个数组的意义就是前后大小的两个数之间的间隔
 */
public class CountSort {
    public static void main(String[] args) {
        int[] arra = {11, 13, 12, 15, 13, 14, 13, 16, 11, 12, 19, 11, 18, 15, 15, 14, 14, 12, 11, 13, 18, 18, 19,
                17, 17, 17, 14, 100};
        int min = findMin(arra);
        int max = findMax(arra);
        int[] result = sort(arra, min, max);
        SelectionSort.print(result);

    }

    static int[] sort(int[] arra, int min, int max) {
        //结果数组
        int[] result = new int[arra.length];
        //范围数组
        int k = max - min + 1;
        int[] count = new int[k];
        for (int i = 0; i < arra.length; i++) {
            count[arra[i] - min]++;
        }

        //count数组的累计数组
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        System.out.println(Arrays.toString(count));
        //倒序遍历，给定位置
        for (int i = arra.length - 1; i >= 0; i--) {
            result[--count[arra[i] - min]] = arra[i];
        }
        return result;
    }

    static int findMin(int[] arra) {
        int min = arra[0];
        for (int i = 0; i < arra.length; i++) {
            if (arra[i] < min) {
                min = arra[i];
            }
        }
        return min;
    }

    static int findMax(int[] arra) {
        int max = arra[0];
        for (int i = 0; i < arra.length; i++) {
            if (arra[i] > max) {
                max = arra[i];
            }
        }
        return max;
    }
}