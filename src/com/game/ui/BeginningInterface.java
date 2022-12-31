package com.game.ui;

import com.game.util.Constant;
import com.game.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeginningInterface extends GameWindows {
    public BeginningInterface() {
        //页面布局
        setLayout(null);
        //标题
        JLabel gameName = new JLabel();
        gameName.setText("MY GAME");
        gameName.setBounds((int) (Constant.deviceWidth / 2.6), Constant.deviceHeight / 10, GameUtil.widthChange(500), GameUtil.heightChange(100));
        gameName.setFont(new Font("", Font.BOLD, GameUtil.widthChange(60)));//设置标题字体和宽度
        gameName.setForeground(Color.RED);
        add(gameName);
        //启动按钮
        JButton lunchButton = new JButton("BEGIN");
        lunchButton.setBounds((int) (Constant.deviceWidth / 2.5), Constant.deviceHeight / 4, GameUtil.widthChange(250), GameUtil.heightChange(100));
        lunchButton.setForeground(Color.orange);//字体颜色
        lunchButton.setBackground(Color.GRAY);//按键背景色
        lunchButton.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        add(lunchButton);
        lunchButton.addActionListener(new LunchClick());//点击效果，启动游戏
        //设置
        JButton settingButton = new JButton("SETTINGS");
        settingButton.setBounds((int) (Constant.deviceWidth / 2.5), Constant.deviceHeight / 4 + GameUtil.heightChange(100), GameUtil.widthChange(250), GameUtil.heightChange(100));
        settingButton.setForeground(Color.orange);
        settingButton.setBackground(Color.GRAY);
        settingButton.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        add(settingButton);
        settingButton.addActionListener(new SetClick());
        //模式选择按钮
        JButton modelButton = new JButton("MODEL");
        modelButton.setBounds((int) (Constant.deviceWidth / 2.5), Constant.deviceHeight / 4 + GameUtil.heightChange(200), GameUtil.widthChange(250), GameUtil.heightChange(100));
        modelButton.setForeground(Color.orange);
        modelButton.setBackground(Color.GRAY);
        modelButton.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        add(modelButton);
        modelButton.addActionListener(new ModelClick());
        //退出按钮
        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds((int) (Constant.deviceWidth / 2.5), Constant.deviceHeight / 4 + GameUtil.heightChange(300), GameUtil.widthChange(250), GameUtil.heightChange(100));
        exitButton.setForeground(Color.orange);
        exitButton.setBackground(Color.GRAY);
        exitButton.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        add(exitButton);
        exitButton.addActionListener(new ExitClick());//点击效果，退出游戏
    }
}

class ExitClick implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}

class LunchClick implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Constant.gameModel == 0)
            new PVPPlayingInterface();
        else if (Constant.gameModel == 1)
            new PVEPlayingInterface();
    }
}

class SetClick implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new SettingInterface();
    }
}

class ModelClick implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new ModelInterface();
    }
}