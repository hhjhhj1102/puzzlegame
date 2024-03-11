package com.hhj.test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3(){
//        设置宽高，标题，置顶，居中，关闭模式，取消默认的居中放置，只有取消了才会按照xy轴的形式添加组件
        this.setSize(603,680);
        this.setTitle("拼图登录 V1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);


//      给整个窗体添加键盘监听
        this.addKeyListener(this);

//        显示界面
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下了"+e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开了"+e.getKeyChar());
    }
}
