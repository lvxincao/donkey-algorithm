package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/11 10:29
 * @Description: 插入排序，算林称最亲民的排序算法，插入排序采用最简单的插入方式对一个整数数组进行排序。它循环数组中从第二个开始的所有元素，
 * 并且将每一个循环到的元素插入到相应的位置，从而实现排序的目的。
 * 时间复杂度O(n2) 最好时间复杂度O(n)
 */
public class InsertSelection {

    public static void main(String[] args) {
        int[] arra = {23, 21, 25, 27, 29, 13, 11, 9, 3, 5, 7};
        for (int i = 1; i < arra.length; i++) {
            int temp = arra[i];
            int p = i;
            int j = i;
            while (j > 0 && arra[j - 1] > temp) {
                arra[j] = arra[j - 1];
                p = j - 1;
                j--;
            }
            arra[p] = temp;
            System.out.print("第" + i + "次交换：");
            SelectionSort.print(arra);
        }
    }

}