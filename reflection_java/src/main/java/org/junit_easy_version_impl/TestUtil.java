package org.junit_easy_version_impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUtil {

    @AnoTest
    public void test1(){
        System.out.println("加了Test注解的test1方法成功执行了...");
    }

    public void test2(){
        System.out.println("test2方法成功执行了...");
    }

    public void test3(){
        System.out.println("test3方法成功执行了...");
    }

    @AnoTest
    public void test4(){
        System.out.println("加了Test注解的test4方法成功执行了...");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestUtil testUtil = new TestUtil();
        //获得testUtil类对象的class对象
        Class<? extends TestUtil> aClass = testUtil.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            if(declaredMethod.isAnnotationPresent(AnoTest.class)){
                declaredMethod.invoke(testUtil);
            }
        }
    }
}
