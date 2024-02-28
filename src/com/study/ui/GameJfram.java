package com.study.ui;

import javax.swing.*;

public class GameJfram extends JFrame {
    public GameJfram(){
//        设置界面宽高以及让界面显示
        initJfram();

//        初始化菜单
        initMenu();

//        初始化图像
        initImage();

//        显示界面
        this.setVisible(true);
    }


//    初始化图像
    private void initImage() {
//        创建一个ImageIcon对象

//        创建一个JLable对象

//        把管理容器添加到菜单中
    }


    private void initMenu() {
        //        初始化菜刀
//        创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
//        创建菜单上的两个选项对象
        JMenu functionMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

//        创建项目下的条目对象
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLogItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭");

        JMenuItem accountItem = new JMenuItem("公众号");


//        将每个选项下面的条目加到对应选项
        functionMenu.add(replayItem);
        functionMenu.add(reLogItem);
        functionMenu.add(closeItem);

        aboutMenu.add(accountItem);

//        将选项添加到菜刀中
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);


//        给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJfram() {
        this.setSize(630,680);
//        设置标题
        this.setTitle("拼图 v1.0");
//        设置窗口置顶
        this.setAlwaysOnTop(true);
//        设置窗口居中
        this.setLocationRelativeTo(null);
//        设置程序关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
