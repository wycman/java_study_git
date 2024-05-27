package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        File src = new File("C:\\迅雷下载\\wx_webgis-master");
        File target = new File("C:\\Users\\20776\\Desktop\\小说\\");
        copyDir(src, target);

    }

    /**
     * io流案例
     */
    public static void test01() {
        byte[] bytes = new byte[1024];
        int len = 0;
        try (FileInputStream fileInputStream = new FileInputStream("C:\\Users\\20776\\Desktop\\小说\\logo_ruiji.png");) {
            try(FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\20776\\Desktop\\小说\\target.png");){
                while((len = fileInputStream.read(bytes)) != -1){
                    fileOutputStream.write(bytes, 0, len);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 图片加密解密案例
     */
    public static void test02 () throws IOException{
        encoder();
        decoder();


    }

    /**
     * 图片加密
     */
    public static void encoder() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\20776\\Desktop\\小说\\logo_ruiji.png");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\20776\\Desktop\\小说\\encoder.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        int i;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while((i = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(i ^ 2);
            arrayList.add(i);
        }
        System.out.println(arrayList.size());
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    /**
     * 图片解密
     */
    public static void decoder() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\20776\\Desktop\\小说\\encoder.png");
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\20776\\Desktop\\小说\\decoder.png");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = bufferedInputStream.read(bytes)) != -1){
            for(int i = 0; i < len; i++){
                bytes[i] = (byte) (bytes[i] ^ 2);
            }
            bufferedOutputStream.write(bytes, 0, len);
        }
        bufferedOutputStream.close();
        bufferedInputStream.close();
    }

    /**
     * 统计字符个数案例函数
     */
    public static void test03() throws IOException {
        FileReader fileReader = new FileReader("C:\\Users\\20776\\Desktop\\小说\\test03.txt");
        int i;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while((i = fileReader.read()) != -1){
            if(hashMap.containsKey((char) i))
                hashMap.put((char) i, hashMap.get((char) i) + 1);
            else
                hashMap.put((char) i, 1);
        }
        fileReader.close();
        hashMap.forEach((c, num) -> System.out.print(c + "(" + num + ")"));
        System.out.println();
    }

    /**
     * 多级文件夹拷贝案例
     */
    public static void copyDir(File src, File target){
        File tar_dir = new File(target, src.getName());
        tar_dir.mkdirs();
        File[] files = src.listFiles();
        if(files != null){
        for (File file : files) {
            if(file.isFile())
                copyfile(new File(src, file.getName()), new File(tar_dir, file.getName()));
            else
                copyDir(new File(src, file.getName()), tar_dir);
        }
        }
    }

    public static void copyfile(File src, File target){
        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            int i;
            while ((i = fileInputStream.read()) != -1){
                fileOutputStream.write(i);
            }
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}