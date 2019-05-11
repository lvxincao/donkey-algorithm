package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/11 21:15
 * @Description: 归并排序 merge sort
 * java对象的排序用的是改进的归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arra = {1, 8, 12, 11, 39, 56, 43, 22, 99, 4, 7, 8, 3, 6, 9};
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
        //分成两半
        int mid = left + (right - left) / 2;
        //左边排序 进行递归
        sort(arra, left, mid);
        //右边排序 进行递归
        sort(arra, mid + 1, right);
        merge(arra, left, mid + 1, right);
    }

    /**
     * 对数组进行归并
     *
     * @param arra
     * @param leftPointer
     * @param rightPointer
     * @param rightBound
     */
    static void merge(int[] arra, int leftPointer, int rightPointer, int rightBound) {
        int mid = rightPointer - 1;
        int[] temp = new int[rightBound - leftPointer + 1];
        int i = leftPointer;
        int j = rightPointer;
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