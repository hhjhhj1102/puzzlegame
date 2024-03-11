package com.hhj.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
    //    创建两个按钮对象
    JButton jButton1 = new JButton("点我");

    public MyJFrame2(){
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
//        给俺就绑定鼠标事件
        jButton1.addMouseListener(this);
//        jButton1.addActionListener(this);
        this.getContentPane().add(jButton1);

//        显示界面
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("点击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("进入");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("离开");
    }
}
