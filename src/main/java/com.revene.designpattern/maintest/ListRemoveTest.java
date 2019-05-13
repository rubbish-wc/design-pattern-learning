package com.revene.designpattern.maintest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListRemoveTest {

    /**
     * List删除测试
     * @param args
     */
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i < 10000000; i++){
            list.add(new Random(1000000).nextInt());
        }
        //1 使用遍历的方式删除
        long currentTimeMillis1 = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if (next != 4){
                iterator.remove();
            }
        }
        long current2 = System.currentTimeMillis();
        System.out.println(current2 - currentTimeMillis1);


        //2 使用stream流删除
        long cu3 = System.currentTimeMillis();
        list.stream().filter(ListRemoveTest::compareTo4)
                .collect(Collectors.toList());
        long cu4 = System.currentTimeMillis();
        System.out.println("=========" + (cu4 - cu3));
    }

    /**
     * 比较函数
     * @param integer
     * @return
     */
    public static boolean compareTo4(Integer integer){
        if (integer != 4){
            return false;
        }else {
            return true;
        }
    }

    //将任意长度的输入转换成压缩后的任意长度的输出,hash值对应的地址是该对象在hash表中的位置,而物理位置指的是对象在内存中的地址

    //关于重写equals 和 hashcode 方法
}
