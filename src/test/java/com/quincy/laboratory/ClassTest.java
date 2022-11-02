package com.quincy.laboratory;

import org.apache.poi.ss.formula.functions.T;
import org.assertj.core.util.DateUtil;
import org.thymeleaf.util.DateUtils;

import java.text.SimpleDateFormat;
import java.util.*;

public class ClassTest {


    private static int a;

    public static void main(String[] args) {
        modify(a);
        System.out.println(a);
    }

    private static void modify(int a) {
        a++;
    }
}

class b extends a {
//    public short getNumber(){
//        return 2;
//    }

    public static void main(String[] args) {
        b b = new b();
        System.out.println(b.getNumber());
    }
}

class a {
    public byte getNumber() {
        return 1;
    }
}

class C {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(3);
        Collections.sort(a);
        a.add(2);
        Collections.reverse(a);
        System.out.println(a);
    }
}

class ThreadTest implements Runnable {
    public static void main(String[] args) {
        ThreadTest tt = new ThreadTest();
        Thread thread = new Thread(tt);
        thread.start();
        System.out.println("\nend\n");
    }

    @Override
    public void run() {
        String[] arr = {"1-", "2-", "3-"};
        runClass rc = new runClass(arr);
        int count = 0;
        while (true) {
            try {
                Thread.sleep(1000);
                rc.printArr();
                if (count ++ == 2) {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class runClass {
    String[] arr;
    int count;

    runClass(String[] arr) {
        this.arr = arr;
        this.count = 0;
        System.out.println("=================="+ " before alter " +"====================");
        for (String s : arr) {
            System.out.println(s);
        }
    }

    void updateArr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        arr[count] = count + "-" + format.format(new Date());
        count = (count + 1) % arr.length;
    }

    void printArr() {
        updateArr();
        System.out.println("=================="+ "    altered   " +"====================");
        for (String s : arr) {
            System.out.println(s);
        }
    }

}
