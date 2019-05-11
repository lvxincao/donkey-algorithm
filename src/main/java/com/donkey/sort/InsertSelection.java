package com.donkey.sort;

/**
 * @author: lxc
 * @Date: 2019/5/11 10:29
 * @Description:
 */
public class InsertSelection {

    public static void main(String[] args) {
        int[] arra = {23, 21, 25, 27, 29, 13, 11, 9, 3, 5, 7};

        for (int i = 1; i < arra.length; i++) {
            //方法1
//            for (int j = 0; j <i; j++) {
//                if (arra[i] < arra[j]) {
//                    SelectionSort.swap(arra, j, i);
//                }
//            }
            for (int j = i; j > 0; j--) {
                if(arra[j-1] > arra[j]){
                    SelectionSort.swap(arra, j, j-1);
                }
            }
            System.out.print("第"+i+"次交换：");
            SelectionSort.print(arra);
        }
    }

}