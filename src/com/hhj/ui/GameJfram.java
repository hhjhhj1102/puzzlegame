package com.hhj.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJfram extends JFrame implements KeyListener, ActionListener {

//    存储图片的数据
    int[][] data = new int[4][4];
    int[][] winData = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

//    创建项目下的条目对象
    JMenu replaceItem = new JMenu("更换图片");
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLogItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭");

    JMenuItem accountItem = new JMenuItem("公众号");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem beautyItem = new JMenuItem("美女");

//    空白块的位置
    int x = 0, y = 0;

//  当前图片路径
    String path = "image/animal/animal1/";

//    构造方法
    public GameJfram(){
//        设置界面宽高以及让界面显示
        initJfram();

//        初始化菜单
        initMenu();

//        初始化数据
        initData();

//        初始化图像
        initImage();


//        显示界面
        this.setVisible(true);
    }

    private void initData() {
        int[] arr = new int[16];
        for (int i = 0; i < 16; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < 16; i++) {
            Random r = new Random();
            int idx = r.nextInt(16);
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
        for (int i = 0; i < 16; i++) {
            if(arr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = arr[i];
        }
    }


    //    初始化图像
    private void initImage() {
//        清空界面
        this.getContentPane().removeAll();

        if(isWin()) {
            JLabel winJlabel = new JLabel(new ImageIcon("image/win.png"));
            winJlabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winJlabel);

        }
//        添加图片
        for (int i = 0; i < data.length; i++) {
            for (int i1 = 0; i1 < data[i].length; i1++) {
                JLabel jLabel = new JLabel(new ImageIcon(path + data[i][i1] + ".jpg"));
                jLabel.setBounds(i1*105 + 83,i*105 + 134,105,105);
//                给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }

        //        添加背景图
        ImageIcon bg = new ImageIcon("image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

//        刷新界面
        this.getContentPane().repaint();
    }


    private void initMenu() {
        //        初始化菜刀
//        创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
//        创建菜单上的两个选项对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");



//        将每个选项下面的条目加到对应选项
        functionMenu.add(replaceItem);
        functionMenu.add(replayItem);
        functionMenu.add(reLogItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

//        更换图片
        replaceItem.add(animalItem);
        replaceItem.add(beautyItem);


//        给条目绑定事件
        replayItem.addActionListener(this);
        reLogItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
//        replaceItem.addActionListener(this);

        animalItem.addActionListener(this);
        beautyItem.addActionListener(this);


//        将选项添加到菜刀中
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);


//        给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJfram() {


        this.setSize(603,680);
//        设置标题
        this.setTitle("拼图 v1.0");
//        设置窗口置顶
        this.setAlwaysOnTop(true);
//        设置窗口居中
        this.setLocationRelativeTo(null);
//        设置程序关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        取消默认居中
        this.setLayout(null);

//        给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

//    判断是否胜利游戏
    private boolean isWin(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] != winData[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        判断游戏是否胜利。如果胜利则不再进行下面的操作
        if (isWin()) {
            return;
        }

        int code = e.getKeyCode();
//        按下A则删除界面所有图片并添加完整图片
        if(code == 65){
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

//            添加背景图
            ImageIcon bg = new ImageIcon("image/background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
//            刷新界面
            this.getContentPane().repaint();
        }
    }

//    作弊直接赢游戏
    private void win() {
        for (int i = 0; i < 15; i++) {
            data[i / 4][i % 4] = i + 1;
        }
        data[3][3] = 0;
        initImage();
    }


    @Override
    public void keyReleased(KeyEvent e) {
//        判断游戏是否胜利。如果胜利则不再进行下面的操作
        if(isWin()){
            return;
        }

        int code = e.getKeyCode();
//        对上下左右判断
//        左：37  上：38  右：39  下：40
//        System.out.println(code);
        switch (code) {
            case 37:
//                System.out.println("左");
                if(y == 3){
                    return;
                }
                data[x][y] = data[x][y + 1];
                data[x][y + 1] = 0;
                y++;
                initImage();
                break;
            case 38:
//                System.out.println("上");
                if(x == 3){
                    return;
                }
                data[x][y] = data[x + 1][y];
                data[x + 1][y] = 0;
                x++;
                initImage();
                break;
            case 39:
//                System.out.println("右");
                if(y == 0){
                    return;
                }
                data[x][y] = data[x][y - 1];
                data[x][y - 1] = 0;
                y--;
                initImage();
                break;
            case 40:
//                System.out.println("下");
                if(x == 0){
                    return;
                }
                data[x][y] = data[x - 1][y];
                data[x - 1][y] = 0;
                x--;
                initImage();
                break;
            case 65:
                initImage();
                break;
            case 87:
                win();
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == replayItem) {
            System.out.println("重新游戏");
            initData();
            initImage();
        }
        else if (source == reLogItem) {
            System.out.println("重新登录");
        }
        else if (source == closeItem) {
            System.out.println("关闭");
            System.exit(0);
        }
        else if (source == accountItem) {
            System.out.println("公众号");
        }
        else if (source == animalItem) {
            System.out.println("更换图片");
            path = "image/animal/animal" + (new Random().nextInt(8) + 1) + "/";
            initData();
            initImage();
        }
        else if (source == beautyItem) {
            System.out.println("更换图片");
            path = "image/girl/girl" + (new Random().nextInt(13) + 1) + "/";
            initData();
            initImage();
        }
    }
}
