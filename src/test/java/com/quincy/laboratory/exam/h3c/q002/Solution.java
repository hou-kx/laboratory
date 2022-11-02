package com.quincy.laboratory.exam.h3c.q002;

public class Solution {
    public static void main(String[] args) {
        Father father = new Child();
        father.doSomething();
//        father.cannotDo();
    }
}

class Father{
    void doSomething(){
        System.out.println("father do!");
    }
}

class Child extends Father{
    @Override
    void doSomething() {
        System.out.println("child do!");
    }

    void cannotDo(){
        System.out.println("child cannot do！");
    }
}
