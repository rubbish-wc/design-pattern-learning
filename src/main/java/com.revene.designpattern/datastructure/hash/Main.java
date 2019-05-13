package com.revene.designpattern.datastructure.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //hashcode只是算出hashcode,而hashcode转索引是哈希表这个类中的工作,因为此时并不知道hash表的大小是多少,替换成索引所取的模也就不知道是多少

        //Integer 类型的hashCode就是自己的本事
        int a = 42 ;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        //Double的hashcode是一个整型
        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        //String 的 hashcode也是一个整型
        String d = "wangbaoliang王保良";
        System.out.println(d.hashCode());

        Student student = new Student(3,2,"王","保良");
        System.out.println(student.hashCode());

        NoOverrideHashCodeStudent noOverrideHashCodeStudent = new NoOverrideHashCodeStudent("王保良",24,1);
        System.out.println(noOverrideHashCodeStudent.hashCode());

        //java 中两个跟hash相关的数据结构
        //HashSet
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet.add(student);

        //hashMap
        HashMap<Student,Integer> scores = new HashMap();
        scores.put(student,100);
    }
}
