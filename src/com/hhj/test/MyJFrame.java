package com.hhj.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyJFrame extends JFrame implements ActionListener {
//    创建两个按钮对象
    JButton jButton1 = new JButton("登录");
    JButton jButton2 = new JButton("注册");

    public MyJFrame(){
//        设置宽高，标题，置顶，居中，关闭模式，取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setSize(603,680);
        this.setTitle("拼图登录 V1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        initButton();

    }

//    给按钮设置位置和宽高,以及事件监听
    private void initButton() {
        jButton1.setBounds(0,0,100,50);
        jButton1.addActionListener(this);
        jButton2.setBounds(400,500,100,50);
        jButton2.addActionListener(this);
        this.getContentPane().add(jButton1);
        this.getContentPane().add(jButton2);

//        显示界面
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        对当前按钮判断
//        获取当前被操作按钮对象
        Object source = e.getSource();
        if (source == jButton1) {
            System.out.println("点击了登录按钮");
        }
        else if (source == jButton2) {
            System.out.println("点击了注册按钮");
        }
    }
}
