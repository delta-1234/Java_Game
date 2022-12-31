package com.game.ui;

import com.game.util.Constant;

import javax.swing.*;

import java.awt.event.*;

/*窗口创建*/
public class GameWindows extends JFrame {

    public GameWindows() {
        //设置窗口可见
        setVisible(true);
        //创建窗口
        setSize(Constant.deviceWidth, Constant.deviceHeight);
        //设置窗口标题
        setTitle("myGame");
        //窗口大小不可改变
        setResizable(false);
        //窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);//结束程序
            }
        });

    }

}

