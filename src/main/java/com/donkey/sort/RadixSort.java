package com.donkey.sort;


/**
 * @author: lxc
 * @Date: 2019/5/16 19:05
 * @Description: 基数排序 平均时间复杂度O（d*(n+r)）,最好0(d*(n+r)),空间复杂度O(n+r)  d 为位数，r 为基数，n 为原数组个数。
 * 基数排序是个稳定排序 适用于范围较小的排序，以为随着位数的增大时间复杂度是乘数增大的
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arra = {12, 12, 766, 1083, 6374, 99, 34, 11, 123, 99, 156, 107, 44, 355, 3, 5, 1};
        sort(arra);
        SelectionSort.print(arra);
    }

    static void sort(int[] arra) {
        int max = calcMax(arra);
        int bigDigits = calcMaxDigits(max);
        int base = 10;
        System.out.println(bigDigits);
        int[][] bucket = new int[10][arra.length];
        for (int n = 0; n < bigDigits; n++) {
            //定义一个数组，来存储放入每个桶里边元素的数量，例如第0个桶放了9个，那么
            //这个数组就是{9,0,0,0,0,0,0,0,0}
            int[] bucketLine = new int[10];
            for (int i = 0; i < arra.length; i++) {
                int digitsNum = calaDigitsNum(arra[i], base);
                System.out.print(digitsNum);
                bucket[digitsNum][bucketLine[digitsNum]++] = arra[i];
            }
            System.out.println();
            //从每个桶的底部开始，依次拿出数据，替换到原来数组
            //所有桶内元素的个数，就是原有数组的个数。所以下面就是从桶里边拿出元素的方法
            //所以要对二维数组足够熟悉
            int m = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int k = 0; k < bucketLine[i]; k++) {
                    arra[m++] = bucket[i][k];
                }
            }
            base *= 10;
        }
    }

    /**
     * 获取一个数字某个位上的数字
     */

    static int calaDigitsNum(int num, int base) {
        return (num % base) / (base / 10);
    }

    /**
     * 计算一个数的最大的位数
     */
    static int calcMaxDigits(int num) {
        int digits = 1;
        while (num / 10 > 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }

    /**
     * 计算一个数组的中的最大值
     *
     * @param arra
     * @return
     */
    static int calcMax(int[] arra) {
        int max = 0;
        for (int i = 0; i < arra.length; i++) {
            if (max < arra[i]) {
                max = arra[i];
            }
        }
        return max;
    }


}