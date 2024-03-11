package com.hhj.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame {
    public RegisterJFrame(){
        initJFrame();

        //显示界面
        this.setVisible(true);
    }

    private void initJFrame() {
        this.setSize(488, 500);
        //设置标题
        this.setTitle("拼图注册");
        //设置窗口置顶
        this.setAlwaysOnTop(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置程序关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
