package com.quincy.gc.gcTest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

public class GCTest {

    @Test
    public void newObjectTest01() {
        for (int i = 0; i < 1000; i++) {
            byte[] bytes = new byte[1024 * 1024];//1MB
        }
    }

    @Test
    public void newObjectTest02() {
        ArrayList<Object> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            byte[] bytes = new byte[1024 * 1024];//1MB
            list.add(bytes);
        }
        list.clear();
    }

    @Test
    public void whileNewObjectTest03() {

        for (; ; ) {
            byte[] bytes = new byte[1024 * 1];//1MB
        }
    }

}
