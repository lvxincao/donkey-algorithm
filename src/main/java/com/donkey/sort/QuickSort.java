package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/13 19:25
 * @Description: 快速排序 平均时间复杂度O（NlogN）最好时间复杂度 O（NlogN）不稳定
 * 并且要避免最坏复杂度O（N2） 所以取轴的时候可以随机取，然后和最后一位交换，或者判断用一下数组是不是已经是顺序的了，如果是顺序的了，就
 * 不使用快速排序了
 * 进行分区，分区中找到轴
 * 取轴进行左右两边进行两两交换，然后利用递归进行交换
 * 例子是经典的双轴排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arra = {6, 4, 4, 2, 6, 19, 43, 56, 67, 98};
        sort(arra, 0, arra.length - 1);
        SelectionSort.print(arra);
    }

    static void sort(int[] arra, int leftBound, int rightBound) {
        if (leftBound >= rightBound) {
            return;
        }
        int mid = partition(arra, leftBound, rightBound);
        //左边递归排序
        sort(arra, leftBound, mid - 1);
        // 右边递归排序
        sort(arra, mid + 1, rightBound);
    }

    static int partition(int[] arra, int leftBound, int rightBound) {
        int pivot = arra[rightBound];
        int left = leftBound;
        int right = rightBound - 1;
        while (left <= right) {
            while (left <= right && arra[left] <= pivot) {
                left++;
            }
            while (left <= right && arra[right] > pivot) {
                right--;
            }
            if (left < right) {
                SelectionSort.swap(arra, left, right);
            }
        }
        SelectionSort.swap(arra, left, rightBound);
        return left;

    }


}