package com.game.ui;

import com.game.util.Constant;
import com.game.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModelInterface extends GameWindows{
    public ModelInterface() {
        setLayout(null);
        JLabel model = new JLabel();
        model.setText("Select Model");
        model.setBounds((int) (Constant.deviceWidth / 2.5), Constant.deviceHeight / 30, GameUtil.widthChange(500), GameUtil.heightChange(200));
        model.setFont(new Font("", Font.BOLD, GameUtil.widthChange(60)));
        model.setForeground(Color.blue);
        add(model);
        //PVP模式按钮
        JButton PVP = new JButton("PVP");
        PVP.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 3, GameUtil.widthChange(450), GameUtil.heightChange(150));
        PVP.setForeground(Color.orange);
        PVP.setBackground(Color.GRAY);
        PVP.setFont(new Font("", Font.BOLD, GameUtil.widthChange(60)));
        add(PVP);
        PVP.addActionListener(new PVPClick());
        //PVE模式按钮
        JButton PVE = new JButton("PVE");
        PVE.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 3, GameUtil.widthChange(450), GameUtil.heightChange(150));
        PVE.setForeground(Color.orange);
        PVE.setBackground(Color.GRAY);
        PVE.setFont(new Font("", Font.BOLD, GameUtil.widthChange(60)));
        add(PVE);
        PVE.addActionListener(new PVEClick());
        //退出
        JButton exitButton = new JButton("Back Main Menu");
        exitButton.setBounds((int) (Constant.deviceWidth / 2.8), (int) (Constant.deviceHeight / 1.5), GameUtil.widthChange(450), GameUtil.heightChange(150));
        exitButton.setForeground(Color.orange);
        exitButton.setBackground(Color.GRAY);
        exitButton.setFont(new Font("", Font.BOLD, GameUtil.widthChange(40)));
        add(exitButton);
        exitButton.addActionListener(new ExitClick());
    }
    class PVPClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Constant.gameModel = 0;
            dispose();
        }
    }
    class PVEClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Constant.gameModel = 1;
            dispose();
        }
    }
    class ExitClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
