package com.sunjinwei;

/**
 * @program: com.sunjinwei
 * @author: Sun jinwei
 * @create: 2019-08-13 10:42
 * @description: 冒泡排序算法
 **/
public class MaoPao {
    public static void main(String[] args) {

        int[] arr=new int[]{2,5,3,1,6,2};

        for (int i = 0; i < arr.length; i++) {

            boolean isChange=false;

            for (int j = 0; j < arr.length - 1-i; j++) {

                if (arr[j]>arr[j+1]){
                    //定义一个变量
                    int temp = arr[j+1];

                    arr[j+1] = arr[j];

                    arr[j] = temp;

                    isChange = true;
                }
            }
            if (!isChange){
                break;
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}