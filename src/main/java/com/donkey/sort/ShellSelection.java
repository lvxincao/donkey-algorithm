package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/11 18:59
 * @Description: 希尔排序
 * 希尔排序就是以间隔进行的插入排序
 */
public class ShellSelection {
    private static final int AVERAGE = 2;

    public static void main(String[] args) {
        int[] arra = {20, 18, 13, 21, 19, 43, 25, 89, 83, 74};
//        sort1(arra);
        sort2(arra);
        SelectionSort.print(arra);
    }

    /**
     * 第一种方法，以二不断均分的间隔算法
     *
     * @param arra
     */
    static void sort1(int[] arra) {
        for (int h = arra.length / AVERAGE; h > 0; h /= AVERAGE) {
            for (int i = h; i < arra.length; i++) {
                for (int j = i; j > h - 1; j = j - h) {
                    if (arra[j] < arra[j - h]) {
                        SelectionSort.swap(arra, j, j - h);
                    }
                }
            }
        }
    }

    /**
     * 以Knuth序列
     * h = 1
     * h = 3*h +1     1, 4, 13.....
     *
     * @param arra
     */
    static void sort2(int[] arra) {
        int gap = 1;
        while (gap <= arra.length / 3) {
            gap = 3 * gap + 1;
        }
        for (int h = gap; h > 0; h = (h - 1) / 3) {
            for (int i = h; i < arra.length; i++) {
                for (int j = i; j > h - 1; j = j - h) {
                    if (arra[j] < arra[j - h]) {
                        SelectionSort.swap(arra, j, j - h);
                    }
                }
            }
        }
    }

}