package org.example;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * MainFrame既继承JFrame，又实现键盘监听类
 */
public class MainFrame extends JFrame implements KeyListener {
    private String image_dir = "C:\\Users\\20776\\Desktop\\new_project\\Java_Study\\资料\\java_se_入门教程资料\\day04\\资料\\image";
    private int game_state = 0; //为0表示进行中，1为表示游戏结束
    private int[][] pos_image_idx = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}};
    //统计走过的步数
    private int num_steps = 0;
    private int[][] win_array = new int[][]{
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {8, 9, 10, 11},
            {12, 13, 14, 15}
    };
    private int zero_row; //记录零元素位置的行
    private int zero_col; //记录零元素位置的列
    public MainFrame(){
        this.addKeyListener(this);

        shuffle_stone_array();
        init_frame();
    }
    /**
     * 初始化窗体
     */
    public void init_frame(){
        this.setTitle("小游戏");
        this.setSize(514, 595);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消窗体默认布局
        this.setLayout(null);
        //设置游戏窗体始终处于最上层
        this.setAlwaysOnTop(true);
        //设置游戏窗体居中
        this.setLocationRelativeTo(null);
        //绘制游戏界面
        paint_game_frame();
        //设置窗口可见
        this.setVisible(true);
    }

    /**
     * 绘制游戏界面
     */
    public void paint_game_frame(){
        //清除所有添加的组件
        super.getContentPane().removeAll();
        /**
        * 显示游戏背景图
        */

        //定义一个一维数组存储16张图片对应的jabel对象
        JLabel[] jLabels = new JLabel[16];
        for (int i = 0; i < jLabels.length; i++) {
            jLabels[i] = new JLabel(new ImageIcon(image_dir + "\\" + i + ".png"));
        }
        //定义背景图像对应的jlabel对象
        JLabel jLabel_bg = new JLabel(new ImageIcon(image_dir + "\\background.png"));
        //循环为4 * 4的二维空间添加石块图片
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                JLabel jLabel = jLabels[pos_image_idx[i][j]];
                jLabel.setBounds(50 + j * 100, 90 + i * 100, 100, 100);
                this.getContentPane().add(jLabel);
            }
        }
        jLabel_bg.setBounds(26, 30, 450, 484);
        this.getContentPane().add(jLabel_bg);
        //显示走过的步数
        JLabel jLabel_steps = new JLabel("走过的步数为: " + num_steps);
        jLabel_steps.setBounds(26, 15, 150, 15);
        getContentPane().add(jLabel_steps);
        //添加重新开始按钮
        JButton jButton_restart = new JButton("重新开始");
        jButton_restart.setBounds(320, 15, 100, 15);
        //取消按钮焦点
        jButton_restart.setFocusable(false);
        //添加监听类实现
        jButton_restart.addActionListener(e -> {
                num_steps = 0;
                game_state = 0;
                shuffle_stone_array();
                paint_game_frame();});
        getContentPane().add(jButton_restart);
        //刷新操作
        super.getContentPane().repaint();
    }

    /**
     * 打乱石头方块矩阵array
     */
    public void shuffle_stone_array(){
        Random random = new Random();
        //基本思路是遍历pos_image_idx数组中的每一个元素并与一个随机元素进行交换
        //打乱数组
        for (int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++){
                //获取随机元素的行、列索引
                int random_i = random.nextInt(4);
                int random_j = random.nextInt(4);
                //交换当前遍历的数组元素与随机元素
                int temp = pos_image_idx[i][j];
                pos_image_idx[i][j] = pos_image_idx[random_i][random_j];
                pos_image_idx[random_i][random_j] = temp;
            }
        }

        //获取打乱后零号元素的位置坐标
        for(int i = 0;i < 4; i++){
            for(int j = 0;j < 4; j++)
            {
                if (pos_image_idx[i][j] == 0)
                {
                    zero_row = i;
                    zero_col = j;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game_state == 1)
            return;
    int keycode = e.getKeyCode();
    if(keycode == 37){
        move_left();
    } else if (keycode == 38) {
        move_up();
    } else if (keycode == 39) {
        move_right();
    } else if (keycode == 40) {
        move_down();
    } else if (keycode == 90){
        cheat();
    }
    num_steps++;
    if (game_state == 1){
        win();
    }else
    paint_game_frame();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    /**
     * 移动业务代码的功能函数封装
     */

    /**
     * 左移
     */
    public void move_left(){
        if(zero_col == 3){
            return;
        }
        int new_zero_col = zero_col + 1;
        int temp = pos_image_idx[zero_row][zero_col];
        pos_image_idx[zero_row][zero_col] = pos_image_idx[zero_row][new_zero_col];
        pos_image_idx[zero_row][new_zero_col] = temp;
        zero_col = new_zero_col;
        if(is_win() == true)
            game_state = 1;
    }

    /**
     * 上移
     */
    public void move_up(){
        if(zero_row == 3){
            return;
        }
        int new_zero_row = zero_row + 1;
        int temp = pos_image_idx[zero_row][zero_col];
        pos_image_idx[zero_row][zero_col] = pos_image_idx[new_zero_row][zero_col];
        pos_image_idx[new_zero_row][zero_col] = temp;
        zero_row = new_zero_row;
        if(is_win() == true)
            game_state = 1;
    }

    /**
     * 右移
     */
    public void move_right(){
        if(zero_col == 0){
            return;
        }
        int new_zero_col = zero_col - 1;
        int temp = pos_image_idx[zero_row][zero_col];
        pos_image_idx[zero_row][zero_col] = pos_image_idx[zero_row][new_zero_col];
        pos_image_idx[zero_row][new_zero_col] = temp;
        zero_col = new_zero_col;
        if(is_win() == true)
            game_state = 1;
    }

    /**
     * 下移
     */
    public void move_down(){
        if(zero_row == 0){
            return;
        }
        int new_zero_row = zero_row - 1;
        int temp = pos_image_idx[zero_row][zero_col];
        pos_image_idx[zero_row][zero_col] = pos_image_idx[new_zero_row][zero_col];
        pos_image_idx[new_zero_row][zero_col] = temp;
        zero_row = new_zero_row;
        if(is_win() == true)
            game_state = 1;
    }

    /**
     * 作弊器，按z进行使用
     */
    public void cheat(){
        pos_image_idx = new int[][]{
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        //重新为zero_row、zero_col赋值
        for(int i = 0;i < 4; i++){
            for(int j = 0;j < 4; j++)
            {
                if (pos_image_idx[i][j] == 0)
                {
                    zero_row = i;
                    zero_col = j;
                }
            }
        }
        game_state = 1;
    }
    /**
     * 判断游戏是否胜利
     */
    public boolean is_win(){

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(pos_image_idx[i][j] != win_array[i][j])
                    return false;
            }
        }
        return true;
    }
    /**
     * 游戏胜利
     */
    public void win(){
        getContentPane().removeAll();
        JLabel jLabel = new JLabel(new ImageIcon(image_dir + "\\win.png"));
        jLabel.setBounds(124, 230, 266, 88);
        getContentPane().add(jLabel);
        getContentPane().repaint();
        //显示走过的步数
        JLabel jLabel_steps = new JLabel("走过的步数为: " + num_steps);
        jLabel_steps.setBounds(26, 15, 150, 15);
        getContentPane().add(jLabel_steps);
        //添加重新开始按钮
        JButton jButton_restart = new JButton("重新开始");
        jButton_restart.setBounds(320, 15, 100, 15);
        //取消按钮焦点
        jButton_restart.setFocusable(false);
        //添加监听类实现
        jButton_restart.addActionListener(e -> {
            num_steps = 0;
            game_state = 0;
            shuffle_stone_array();
            paint_game_frame();});
        getContentPane().add(jButton_restart);
    }


}
