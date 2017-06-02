package com.xxo.algorithm;

/**
 *
 * 最大字段和
 *
 *
 * 给定长度为n的整数序列， a[1...n], 求[1,n]某个子区间[i , j] 使得a[i]+…+a[j]和最大.或者求出最大的这个和.
 *
 * 例如(-2,11,-4,13,-5,2)的最大子段和为20,所求子区间为[2,4].
 *
 * Created by xiaoxiaomo on 2017/6/2.
 */
public class MaxSegmentSum {

    public static void main(String[] args) {
        maxSegmentSum3();
        maxSegmentSum2();
    }


    /**
     * 穷举
     */
    public static void maxSegmentSum1(){

        int max = 0;
        int start = 0;
        int end = 0;
        int[] a = { -2,11,-4,13,-5,2,9,5,3,-9,7 } ;
        for (int i = 0; i < a.length; ++i) {

            for (int j = i; j < a.length; ++j) {

                int sum = 0 ;
                for (int k = i; k <= j; ++k) {
                    sum += a[k] ;
                }
                if( sum > max  ){
                    start = i ;
                    end = j ;
                    max = sum ;
                }

            }
        }

        System.out.println(max);
        System.out.println(start);
        System.out.println(end);

    }


    /**
     * 穷举
     * 并不需要每次都重新从起始位置求和加到终点位置.可以充分利用之前的计算结果
     */
    public static void maxSegmentSum2(){

        int max = 0;
        int start = 0;
        int end = 0;
        int[] a = { -2,11,-4,13,-5,2,9,5,3,-9,7 } ;
        for(int i = 0; i < a.length; ++i)
        {
            int sum = 0;
            for(int j = i; j < a.length ;++j)
            {
                sum += a[j];
                if(sum > max)
                {
                    start = i;
                    end = j;
                    max = sum;
                }
            }
        }

        System.out.println(max);
        System.out.println(start);
        System.out.println(end);

    }


    /**
     * 动态划分
     *
     * 令b[j]  表示以位置 j 为终点的所有子区间中和最大的一个
     * 子问题: 如j为终点的最大子区间包含了位置j-1,则以j-1为终点的最大子区间必然包括在其中
     * 如果b[j-1] >0, 那么显然b[j] = b[j-1] + a[j]，用之前最大的一个加上a[j]即可，因为a[j]必须包含
     * 如果b[j-1]<=0, 那么b[j] = a[j] ,因为既然最大，前面的负数必然不能使你更大
     */
    public static void maxSegmentSum3(){

        int[] a = { -2,11,-4,13,-5,2,9,5,3,-9,7 } ;
        int max = 0;
        int[] b = a;
        for(int i = 1; i < a.length; ++i)
        {
            if(b[i-1]>0)
            {
                b[i] = b[i-1]+a[i];
            }else{
                b[i] = a[i];
            }
            if(b[i]>max)
                max = b[i];
        }

        System.out.println(max);

    }

}
