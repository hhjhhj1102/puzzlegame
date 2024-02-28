package com.study.ui;

import javax.swing.*;
import java.awt.*;

public class RegisterJfram extends JFrame {
    public RegisterJfram(){
        this.setSize(488,500);
//        设置标题
        this.setTitle("拼图注册");
//        设置窗口置顶
        this.setAlwaysOnTop(true);
//        设置窗口居中
        this.setLocationRelativeTo(null);
//        设置程序关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


//        显示界面
        this.setVisible(true);
    }
}
