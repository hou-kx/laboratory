package com.quincy.laboratory;

public class ClassTest002 extends X{
    Y y = new Y();
    public ClassTest002(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        new ClassTest002();
    }
}
class X{
    Y y = new Y();
    public X(){
        System.out.println("X");
    }
}

class Y {
    public Y(){
        System.out.println("Y");
    }
}