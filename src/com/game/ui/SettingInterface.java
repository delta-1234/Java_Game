package com.game.ui;

import com.game.util.Constant;
import com.game.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SettingInterface extends GameWindows {
    static int key;
    static JLabel jumpAKey, rightAKey, leftAKey, attackAKey, shockWaveAKey, roarAKey;
    static JLabel jumpBKey, rightBKey, leftBKey, attackBKey, shockWaveBKey, roarBKey;

    public SettingInterface() {
        //页面布局
        setLayout(null);
        //标题
        JLabel playerA = new JLabel();
        playerA.setText("PlayerA");
        playerA.setBounds((int) (Constant.deviceWidth / 4.0), Constant.deviceHeight / 30, GameUtil.widthChange(500), GameUtil.heightChange(200));
        playerA.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        playerA.setForeground(Color.blue);
        add(playerA);
        //设置按键监听
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                key = e.getKeyCode();
            }
        });
        /*修改角色A按键的按钮*/
        //修改jump
        JButton jumpA = new JButton("Jump");
        jumpA.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 4, GameUtil.widthChange(150), GameUtil.heightChange(50));
        jumpA.setForeground(Color.orange);
        jumpA.setBackground(Color.GRAY);
        add(jumpA);
        jumpA.addActionListener(new JumpAClick());
        jumpA.setRequestFocusEnabled(false);
        jumpAKey = new JLabel();
        jumpAKey.setText(GameUtil.keyName(Constant.jumpA));
        jumpAKey.setBounds((int) (Constant.deviceWidth / 2.7), Constant.deviceHeight / 4, GameUtil.widthChange(150), GameUtil.heightChange(50));
        jumpAKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        jumpAKey.setForeground(Color.RED);
        add(jumpAKey);
        //修改右移
        JButton rightA = new JButton("Right");
        rightA.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 4 + GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        rightA.setForeground(Color.orange);
        rightA.setBackground(Color.GRAY);
        add(rightA);
        rightA.addActionListener(new RightAClick());
        rightA.setRequestFocusEnabled(false);
        rightAKey = new JLabel();
        rightAKey.setText(GameUtil.keyName(Constant.rightA));
        rightAKey.setBounds((int) (Constant.deviceWidth / 2.7), Constant.deviceHeight / 4 + GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        rightAKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        rightAKey.setForeground(Color.RED);
        add(rightAKey);
        //修改左移
        JButton leftA = new JButton("Left");
        leftA.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 4 + 2 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        leftA.setForeground(Color.orange);
        leftA.setBackground(Color.GRAY);
        add(leftA);
        leftA.addActionListener(new LeftAClick());
        leftA.setRequestFocusEnabled(false);
        leftAKey = new JLabel();
        leftAKey.setText(GameUtil.keyName(Constant.leftA));
        leftAKey.setBounds((int) (Constant.deviceWidth / 2.7), Constant.deviceHeight / 4 + 2 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        leftAKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        leftAKey.setForeground(Color.RED);
        add(leftAKey);
        //攻击
        JButton attackA = new JButton("Attack");
        attackA.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 4 + 3 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        attackA.setForeground(Color.orange);
        attackA.setBackground(Color.GRAY);
        add(attackA);
        attackA.addActionListener(new AttackAClick());
        attackA.setRequestFocusEnabled(false);
        attackAKey = new JLabel();
        attackAKey.setText(GameUtil.keyName(Constant.attackA));
        attackAKey.setBounds((int) (Constant.deviceWidth / 2.7), Constant.deviceHeight / 4 + 3 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        attackAKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        attackAKey.setForeground(Color.RED);
        add(attackAKey);
        //shockWave
        JButton shockWaveA = new JButton("ShockWave");
        shockWaveA.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 4 + 4 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        shockWaveA.setForeground(Color.orange);
        shockWaveA.setBackground(Color.GRAY);
        add(shockWaveA);
        shockWaveA.addActionListener(new ShockWaveAClick());
        shockWaveA.setRequestFocusEnabled(false);
        shockWaveAKey = new JLabel();
        shockWaveAKey.setText(GameUtil.keyName(Constant.shockWaveA));
        shockWaveAKey.setBounds((int) (Constant.deviceWidth / 2.7), Constant.deviceHeight / 4 + 4 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        shockWaveAKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        shockWaveAKey.setForeground(Color.RED);
        add(shockWaveAKey);
        //roar
        JButton roarA = new JButton("Roar");
        roarA.setBounds((int) (Constant.deviceWidth / 8.0), Constant.deviceHeight / 4 + 5 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        roarA.setForeground(Color.orange);
        roarA.setBackground(Color.GRAY);
        add(roarA);
        roarA.addActionListener(new RoarAClick());
        roarA.setRequestFocusEnabled(false);
        roarAKey = new JLabel();
        roarAKey.setText(GameUtil.keyName(Constant.roarA));
        roarAKey.setBounds((int) (Constant.deviceWidth / 2.7), Constant.deviceHeight / 4 + 5 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        roarAKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        roarAKey.setForeground(Color.RED);
        add(roarAKey);
        /*玩家B*/
        JLabel playerB = new JLabel();
        playerB.setText("PlayerB");
        playerB.setBounds((int) (Constant.deviceWidth / 1.5), Constant.deviceHeight / 30, GameUtil.widthChange(500), GameUtil.heightChange(200));
        playerB.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        playerB.setForeground(Color.blue);
        add(playerB);
        //跳跃
        JButton jumpB = new JButton("Jump");
        jumpB.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 4, GameUtil.widthChange(150), GameUtil.heightChange(50));
        jumpB.setForeground(Color.orange);
        jumpB.setBackground(Color.GRAY);
        add(jumpB);
        jumpB.addActionListener(new JumpBClick());
        jumpB.setRequestFocusEnabled(false);
        jumpBKey = new JLabel();
        jumpBKey.setText(GameUtil.keyName(Constant.jumpB));
        jumpBKey.setBounds((int) (Constant.deviceWidth / 1.2), Constant.deviceHeight / 4, GameUtil.widthChange(150), GameUtil.heightChange(50));
        jumpBKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        jumpBKey.setForeground(Color.RED);
        add(jumpBKey);
        //右移
        JButton rightB = new JButton("Right");
        rightB.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 4 + GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        rightB.setForeground(Color.orange);
        rightB.setBackground(Color.GRAY);
        add(rightB);
        rightB.addActionListener(new RightBClick());
        rightB.setRequestFocusEnabled(false);
        rightBKey = new JLabel();
        rightBKey.setText(GameUtil.keyName(Constant.rightB));
        rightBKey.setBounds((int) (Constant.deviceWidth / 1.2), Constant.deviceHeight / 4 + GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        rightBKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        rightBKey.setForeground(Color.RED);
        add(rightBKey);
        //左移
        JButton leftB = new JButton("Left");
        leftB.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 4 + 2 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        leftB.setForeground(Color.orange);
        leftB.setBackground(Color.GRAY);
        add(leftB);
        leftB.addActionListener(new LeftBClick());
        leftB.setRequestFocusEnabled(false);
        leftBKey = new JLabel();
        leftBKey.setText(GameUtil.keyName(Constant.leftB));
        leftBKey.setBounds((int) (Constant.deviceWidth / 1.2), Constant.deviceHeight / 4 + 2 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        leftBKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        leftBKey.setForeground(Color.RED);
        add(leftBKey);
        //攻击
        JButton attackB = new JButton("Attack");
        attackB.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 4 + 3 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        attackB.setForeground(Color.orange);
        attackB.setBackground(Color.GRAY);
        add(attackB);
        attackB.addActionListener(new AttackBClick());
        attackB.setRequestFocusEnabled(false);
        attackBKey = new JLabel();
        attackBKey.setText(GameUtil.keyName(Constant.attackB));
        attackBKey.setBounds((int) (Constant.deviceWidth / 1.2), Constant.deviceHeight / 4 + 3 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        attackBKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        attackBKey.setForeground(Color.RED);
        add(attackBKey);
        //shockWave
        JButton shockWaveB = new JButton("ShockWave");
        shockWaveB.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 4 + 4 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        shockWaveB.setForeground(Color.orange);
        shockWaveB.setBackground(Color.GRAY);
        add(shockWaveB);
        shockWaveB.addActionListener(new ShockWaveBClick());
        shockWaveB.setRequestFocusEnabled(false);
        shockWaveBKey = new JLabel();
        shockWaveBKey.setText(GameUtil.keyName(Constant.shockWaveB));
        shockWaveBKey.setBounds((int) (Constant.deviceWidth / 1.2), Constant.deviceHeight / 4 + 4 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        shockWaveBKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        shockWaveBKey.setForeground(Color.RED);
        add(shockWaveBKey);
        //roar
        JButton roarB = new JButton("Roar");
        roarB.setBounds((int) (Constant.deviceWidth / 1.7), Constant.deviceHeight / 4 + 5 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        roarB.setForeground(Color.orange);
        roarB.setBackground(Color.GRAY);
        add(roarB);
        roarB.addActionListener(new RoarBClick());
        roarB.setRequestFocusEnabled(false);
        roarBKey = new JLabel();
        roarBKey.setText(GameUtil.keyName(Constant.roarB));
        roarBKey.setBounds((int) (Constant.deviceWidth / 1.2), Constant.deviceHeight / 4 + 5 * GameUtil.heightChange(50), GameUtil.widthChange(150), GameUtil.heightChange(50));
        roarBKey.setFont(new Font("", Font.BOLD, GameUtil.widthChange(30)));
        roarBKey.setForeground(Color.RED);
        add(roarBKey);
        //返回主界面
        JButton exitButton = new JButton("Back Main Menu");
        exitButton.setBounds((int) (Constant.deviceWidth / 2.7), (int) (Constant.deviceHeight / 1.3), GameUtil.widthChange(250), GameUtil.heightChange(100));
        exitButton.setForeground(Color.orange);
        exitButton.setBackground(Color.GRAY);
        add(exitButton);
        exitButton.addActionListener(new ExitClick());
    }

    class JumpAClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.jumpA = SettingInterface.key;
                jumpAKey.setText(GameUtil.keyName(Constant.jumpA));
            }
        }
    }

    class LeftAClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.leftA = SettingInterface.key;
                leftAKey.setText(GameUtil.keyName(Constant.leftA));
            }
        }
    }

    class RightAClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.rightA = SettingInterface.key;
                rightAKey.setText(GameUtil.keyName(Constant.rightA));
            }
        }
    }

    class AttackAClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.attackA = SettingInterface.key;
                attackAKey.setText(GameUtil.keyName(Constant.attackA));
            }
        }
    }

    class ShockWaveAClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.shockWaveA = SettingInterface.key;
                shockWaveAKey.setText(GameUtil.keyName(Constant.shockWaveA));
            }
        }
    }

    class RoarAClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.roarA = SettingInterface.key;
                roarAKey.setText(GameUtil.keyName(Constant.roarA));
            }
        }
    }

    class JumpBClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.jumpB = SettingInterface.key;
                jumpBKey.setText(GameUtil.keyName(Constant.jumpB));
            }
        }
    }

    class RightBClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.rightB = SettingInterface.key;
                rightBKey.setText(GameUtil.keyName(Constant.rightB));
            }
        }
    }

    class LeftBClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.leftB = SettingInterface.key;
                leftBKey.setText(GameUtil.keyName(Constant.leftB));
            }
        }
    }

    class AttackBClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.attackB = SettingInterface.key;
                attackBKey.setText(GameUtil.keyName(Constant.attackB));
            }
        }
    }

    class ShockWaveBClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.shockWaveB = SettingInterface.key;
                shockWaveBKey.setText(GameUtil.keyName(Constant.shockWaveB));
            }
        }
    }

    class RoarBClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (GameUtil.keyChange(SettingInterface.key)) {
                Constant.roarB = SettingInterface.key;
                roarBKey.setText(GameUtil.keyName(Constant.roarB));
            }
        }
    }

    class ExitClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}


