package org.example;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * 设计一个简单的框架用于保存指定对象到txt文件中去
 */
public class ObjectSaveFrame {
    public static void SaveObject(Object o) throws FileNotFoundException, IllegalAccessException {
        PrintStream printStream = new PrintStream(new FileOutputStream("reflection_java\\src\\main\\resources\\f.txt", true), true);
        //获取该对象的类
        Class<?> aClass = o.getClass();
        //写出该对象的简化类名
        printStream.println("-----" + aClass.getSimpleName());
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            printStream.println(declaredField.getName() + "---" + declaredField.get(o));
        }
    }
}