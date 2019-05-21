package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/20 20:05
 * @Description: 堆排序 平均时间复杂度 O(NlogN)
 * 利用完全二叉树，构建堆进行排序，
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arra = {6, 2, 1, 3, 5, 4, 9, 53, 76, 12, 23, 43, 12, 3908, 273, 1229, 44590};
        sort(arra);
        SelectionSort.print(arra);
    }

    static void sort(int[] arra) {
        //初始构建大顶堆
        buildMaxHeap(arra);
        for (int i = arra.length - 1; i > 0; i--) {
            SelectionSort.swap(arra, 0, i);
            adjustDownToUp(arra, 0, i);
        }
    }

    /**
     * 将元素自下往上逐步调整属性结构
     * @param arra
     * @param index
     * @param size
     */
    static void adjustDownToUp(int[] arra, int index, int size) {
        //当前双亲节点
        int maxIndex = index;
        //当前节点的值
        int temp = arra[maxIndex];
        //左节点
        int leftIndex = 2 * index + 1;
        //i为初始化节点k的做孩子，沿节点较大的子节点向下调整
        for (int i = leftIndex; i < size-1; i = 2 * i + 1) {
            //找出左右节点最大的一个
            if (i < size && arra[i] < arra[i + 1]) {
                i++;
            }
            if (temp >= arra[i]) {
                //如果当前最大，那就不进行交换，那么后边的子节点也就不需要进行交换
                break;
            } else {
                //如果当前元素的值小，那就要进行交换
                arra[maxIndex] = arra[i];
                //同时下面的子节点也要进行判断，进行更换，知道最后一个元素
                maxIndex = i;
            }
        }
        arra[maxIndex] = temp;
    }

    /**
     * 构建初始化的大顶堆，即将array看成完全二叉树的顺序存储结构爱
     *
     * @param arra
     */
    static void buildMaxHeap(int[] arra) {
        //开始位置为最后一个非叶子节点
        int start = (arra.length - 2) / 2;
        for (int i = start; i >= 0; i--) {
            adjustDownToUp(arra, i, arra.length);
        }
    }
}