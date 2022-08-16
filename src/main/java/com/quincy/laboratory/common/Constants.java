package com.quincy.laboratory.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * import static package.ClassName.*;
 * 上面语法中的星号只能代表静态成员变量或方法名。
 */
public class Constants {

    public static final String RELATIVE_PATH_DOC = "bak/doc/";

    public static final int DEFAULT_PAGE_SIZE = 100000;



    private Constants(){}

    /**
     * 如果定义的常量过多，可能得到所有常量的数组比较麻烦，可通过Java的反射机制得到这个类的所有常量数组
     */
    public static String[] values() {
        Field[] fields = Constants.class.getFields();
        String[] s = new String[fields.length];
        for(int i=0,n=fields.length; i<n; i++) {
            try {
                Field f = fields[i];
                s[i] = (String) f.get(null);
            } catch (Exception ex) {
//                Logger.getLogger(Constants.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return s;
    }

    public static Set<String> asSet() {
        return new HashSet<String>(Arrays.asList(values()));
    }

    public static void main(String[] args) {
        System.out.println("values=" + Arrays.asList(values()));
        System.out.println("set=" + asSet());
    }

}
