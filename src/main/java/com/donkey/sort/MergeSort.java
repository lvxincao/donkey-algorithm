package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/11 21:15
 * @Description: 归并排序 merge sort
 * java对象的排序用的是改进的归并排序
 * 平均时间复杂度O(nlogn) 空间复杂度O(n)
 * 归并排序需要理解两个问题 递归和 给定一个数组，如果数组的前后两个部分是有序的，那就要merge一个有序的数组
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arra = {1, 3, 5, 39, 12, 34, 21, 3, 7, 2, 4, 6, 8, 10};
        sort(arra, 0, arra.length - 1);
        SelectionSort.print(arra);
    }

    /**
     * 排序
     * 一直从中间进行切割，直到无法继续切割分离结束
     *
     * @param arra
     * @param left
     * @param right
     */
    static void sort(int[] arra, int left, int right) {
        //左右边界指的是index 数组的下标，即指针
        if (left == right) {
            return;
        }
        //生成数组的分割位置，以所以的形式，这样就能从0开始
        int dividerIndex = left + (right - left) / 2;
        //左边排序 进行递归
        sort(arra, left, dividerIndex);
        //右边排序 进行递归
        sort(arra, dividerIndex + 1, right);
        merge(arra, left, dividerIndex, right);
    }

    /**
     * 对数组进行归并
     *
     * @param arra
     * @param leftPointer
     * @param dividerIndex
     * @param rightBound
     */
    static void merge(int[] arra, int leftPointer, int dividerIndex, int rightBound) {
        int mid = dividerIndex;
        int[] temp = new int[rightBound - leftPointer + 1];
        int i = leftPointer;
        int j = dividerIndex + 1;
        int k = 0;
        while (i <= mid && j <= rightBound) {
            //为了保证稳定性，要判断等号在前面
            temp[k++] = arra[i] <= arra[j] ? arra[i++] : arra[j++];
        }
        while (i <= mid) {
            temp[k++] = arra[i++];
        }
        while (j <= rightBound) {
            temp[k++] = arra[j++];
        }
        //拷贝临时数组到原数组
        for (int m = 0; m < temp.length; m++) {
            arra[leftPointer + m] = temp[m];
        }
    }

}