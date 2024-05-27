package org.example.q3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * **具体要实现的功能点如下所示**
 *
 * 1、请从**系统菜单.txt**中读取这些菜单信息，将这些菜单信息在控制台展示成图1的样子（必须确保展示的顺序是正确的）
 *
 * 2、将正确的菜单顺序，写出到一个新文件**"系统菜单2.txt"**中保存起来，详细格式如下
 */
public class Test3 {
    public static void main(String[] args) throws IOException {
    //读取菜单信息
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Final_Test\\src\\main\\resources\\系统菜单.txt"));
        List<String> menu = new ArrayList<>();
        char[] char_arr = new char[1024];
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            menu.add(line);
        }
        bufferedReader.close();
        List<String> final_menu = menu.stream().sorted(
                (s1, s2) -> {
                    int index_string = s1.charAt(3) - s2.charAt(3);
                    int flag = (index_string == 0 ? s1.length() - s2.length() : index_string);
                    return flag;
                }
        ).collect(Collectors.toList());
        final_menu.forEach(s -> System.out.println(s.split("-")[0].length() == 4 ? s.split("-")[1] : "\t" + s.split("-")[1]));
        PrintStream printStream = new PrintStream(new FileOutputStream("Final_Test\\src\\main\\resources\\系统菜单2.txt"), true);

        for (String s : final_menu) {
            printStream.println(s);
        }
        printStream.close();
    }
}
