package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/9 19:17
 * @Description: 选择排序 时间复杂度O（n2） 不稳
 * 选择排序基本就是每次找出最小的数字，然后将下标进行交换
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arra = {5, 8, 4, 6, 7, 3, 7};
        for (int i = 0; i < arra.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arra.length; j++) {
                minPos = arra[j] < arra[minPos] ? j : minPos;
            }
            System.out.println("minPos:" + minPos);
            swap(arra, i, minPos);
            System.out.print("第" + i + "次循环结果：");
            print(arra);
        }
    }

    static void swap(int[] arra, int currentPos, int minPos) {
        int temp = arra[currentPos];
        arra[currentPos] = arra[minPos];
        arra[minPos] = temp;
    }

    static void print(int[] arra) {
        for (int i = 0; i < arra.length; i++) {
            System.out.print(arra[i] + " ");
        }
        System.out.println();
    }

}