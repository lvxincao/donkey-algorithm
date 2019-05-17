package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/11 7:33
 * @Description: 冒泡排序 平均时间复杂度O（n2）最好时间复杂度O（n）
 * 为什么这个排序要叫冒泡呢？为什么不叫其他名词呢？其实这个取名是根据排序算法的基本思路命名的，
 * 见名知意，冒泡排序，就是想泡泡在水里一样，在水里大的泡泡先浮出水面，
 * 就是大的先排出来，最小的最慢排出。
 * 并且冒泡和选择排序一样，也是一种交换排序，只不过这个是每次都两两交换
 */
public class BubbleSelection {

    public static void main(String[] args) {
        int[] arra = {1, 2, 4, 6, 2, 5, 6, 7, 8};
        sort(arra);
        System.out.print("最后得到的数组：");
        SelectionSort.print(arra);
    }

    static void sort(int[] arra) {
        for (int i = arra.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                if (arra[j] > arra[j + 1]) {
                    SelectionSort.swap(arra, j, j + 1);
                    flag = true;
                }
            }
            System.out.print("第" + (arra.length - i) + "次交换的结果：");
            SelectionSort.print(arra);
            if (!flag) {
                break;
            }
        }
    }

}