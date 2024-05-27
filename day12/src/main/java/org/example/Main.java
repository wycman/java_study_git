package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //创建一个(600 * 600)的窗体
        JFrame jFrame = new JFrame();
        jFrame.setSize(600, 600);
        //设置窗体标题
        jFrame.setTitle("小游戏");
        //修改窗体关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消窗体默认布局
        jFrame.setLayout(null);

        //1.创建按钮对象
        JButton jButton1 = new JButton("button1");
        //设置按钮的摆放位置及大小
        jButton1.setBounds(150, 100, 80, 50);
        //在窗体的面板对象中添加按钮
        jFrame.getContentPane().add(jButton1);

        //2.创建Jlabel对象
        //Jlabel展示文本
        JLabel jLabel1 = new JLabel("爱你!");
        jLabel1.setBounds(150, 60, 50, 50);
        jFrame.getContentPane().add(jLabel1);
        JLabel jLabel2 = new JLabel("爱你!!");
        jLabel2.setBounds(250, 60, 50, 50);
        jFrame.getContentPane().add(jLabel2);
        //Jlabel展示图片
        JLabel jLabel3 = new JLabel(new ImageIcon("C:\\Users\\20776\\Desktop\\小说\\logo_ruiji.png"));
        jLabel3.setBounds(150, 220, 250, 300);
        jFrame.getContentPane().add(jLabel3);
        //设置窗体可见
        jFrame.setVisible(true);
    }
}