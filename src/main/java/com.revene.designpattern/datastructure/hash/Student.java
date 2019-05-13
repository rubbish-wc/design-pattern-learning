package com.revene.designpattern.datastructure.hash;

public class Student {

    private int grade;

    private int cla;

    private String firstName;

    private String lastName;

    public Student(int grade, int cla, String firstName, String lastName) {
        this.grade = grade;
        this.cla = cla;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    想要让student类成为hash表中的key来进行存储,student就要重写hashcode提供哈希函数
    //如果不重写hashCode,则Object中默认的hashcode生产方法是使用内存地址去换算的hashcode,所以即使是两个一模一样的对象,得到的hashcode的结果也不相同
    //todo 这里为什么要用B = 31 去乘
    @Override
    public int hashCode(){
        int B = 31;

        int hash = 0 ;

        hash = hash * B + grade;
        hash = hash * B + cla;
        hash = hash * B + firstName.hashCode();
        hash = hash * B + lastName.hashCode();

        return hash;
    }

    //覆盖equals方法
    @Override
    public boolean equals(Object o){
        //前置的判断校验
        //判断是不是同一个引用
        if (this == o){
            return true;
        }
        //判断传入的是不是一个null
        if (o == null) {
            return false;
        }
        //判断类类型是否相同
        if (getClass() != o.getClass()){
            return false;
        }

        //equals的语义校验
        Student another = (Student)o;
        return this.grade == another.grade && this.cla == another.cla && this.firstName.equalsIgnoreCase(another.firstName) && this.lastName.equalsIgnoreCase(another.lastName);

    }
}
