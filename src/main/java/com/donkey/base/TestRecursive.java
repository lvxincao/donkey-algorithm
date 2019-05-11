package com.donkey.base;

/**
 * @author: lxc
 * @Date: 2019/5/11 20:12
 * @Description: 递归的基础知识
 * 递归就是一个方法调用它本身
 * 下面以Fibonacci数列为例
 * 1,1,2,3,5,8,...第50个数的值。
 * 满足公司 F(1) = F(2) =1; F(n) =F(n-1) +F(n-2)
 */
public class TestRecursive {

    public static void main(String[] args) {
        System.out.println(f(40));
    }

    static long f(long i) {
        long result =0;
        if (i == 1 || i == 2) {
            result = 1;
        } else {
//            return f(i - 1) + f(i - 2);
            long last_1=1;
            long last_2=1;
            for (int j = 3; j <= i; j++) {
                result = last_1 +last_2;
                last_1 = last_2;
                last_2 = result;
            }
        }
        return result;
    }
}
