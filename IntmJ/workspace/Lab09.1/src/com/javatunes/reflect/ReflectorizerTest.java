package com.javatunes.reflect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonat on 3/29/2017.
 */
public class ReflectorizerTest {
    public void voidMethod() {}
    public boolean booleanMethod() {return false;}
    public int intMethod(){return 0;}
    public static void main(String[] args) {
        int seeMee = -1;
        Map map = new HashMap();
        map.put("hello","there");
        System.out.println("----------------------Reflectorizer.dumpAll ---------------------------------------------");
        System.out.println("----------------------Reflectorizer.dumpAll ---------------------------------------------");
        Reflectorizer.dumpAll(ReflectorizerTest.class, true);
        Reflectorizer.dumpClassInfo(ReflectorizerTest.class, true);
    }
}
