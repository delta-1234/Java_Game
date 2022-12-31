package com.game.ui;

import com.game.fighting.*;
import com.game.things.*;
import com.game.things.Character;
import com.game.util.Constant;
import com.game.util.GameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PVPPlayingInterface extends GameWindows {
    private final Character characterA;
    private final Character characterB;
    private final Block smallBlock;
    private final Block bigBlock;
    private final HPBar hpBar;
    private final MPBar mpBar;
    private final ReHPBall reHPBall;
    private final ReMPBall reMPBall;
    private BufferedImage bufferImage = new BufferedImage(Constant.deviceWidth, Constant.deviceHeight, BufferedImage.TYPE_4BYTE_ABGR);
    private JButton exitButton;
    private boolean gameOver = false;

    public PVPPlayingInterface() {
        Constant.background = GameUtil.heightChange(720);
        //创建A、B角色
        characterA = new Character(Constant.characterAImagePath, GameUtil.widthChange(200), 0);
        characterB = new Character(Constant.characterBImagePath, GameUtil.widthChange(600), 1);
        //创建障碍物
        smallBlock = new Block(Constant.smallBlock, GameUtil.widthChange(8), GameUtil.widthChange(200), GameUtil.heightChange(500), Constant.smallBlockWidth, Constant.smallBlockHeight);
        bigBlock = new Block(Constant.bigBlock, GameUtil.widthChange(5), GameUtil.widthChange(500), GameUtil.heightChange(175), Constant.bigBlockWidth, Constant.bigBlockHeight);
        //创建血条
        hpBar = new HPBar(characterA, characterB);
        //创建MP球
        mpBar = new MPBar(characterA, characterB);
        //随机生成恢复球
        reHPBall = new ReHPBall();
        reMPBall = new ReMPBall();
        //添加按键监听
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                move(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                stop(e);
            }
        });
        //建立线程运行角色动作
        new Run().start();
    }

    class Run extends Thread {
        @Override
        public void run() {
            while (!gameOver) {
                repaint();
                new CharacterCrash(characterA, characterB);
                new BlockCrash(characterA, smallBlock);
                new BlockCrash(characterA, bigBlock);
                new BlockCrash(characterB, smallBlock);
                new BlockCrash(characterB, bigBlock);
                new NormalAttack(characterA, characterB);
                new ShockWave(characterA, characterB);
                new CatchReBall(characterA, reHPBall);
                new CatchReBall(characterB, reHPBall);
                new CatchReBall(characterA, reMPBall);
                new CatchReBall(characterB, reMPBall);
                new Roar(characterA, characterB);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //游戏背景
    class ExitClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            gameOver = true;
        }
    }

    @Override
    public void paint(Graphics g) {
        //得到图片的画笔
        Graphics graphics = bufferImage.getGraphics();
        graphics.drawImage(GameUtil.getImage(Constant.backgroundImagePath), 0, 0, Constant.deviceWidth, Constant.deviceHeight, null);
        if (characterA.getHP() > 0 && characterB.getHP() > 0) {
            characterA.paint(graphics);
            characterB.paint(graphics);
        } else {
            if (characterA.getHP() == 0)
                characterB.paint(graphics);
            else
                characterA.paint(graphics);
            graphics.drawImage(GameUtil.getImage(Constant.gameOver), 0, 0, Constant.deviceWidth, Constant.deviceHeight, null);
            graphics.drawImage(GameUtil.getImage(Constant.exit), (int) (Constant.deviceWidth / 2.5), (int) (Constant.deviceHeight / 1.7), GameUtil.widthChange(250), GameUtil.heightChange(100), null);
            //游戏结束的退出按钮
            exitButton = new JButton("");
            exitButton.setBounds(0, 0, Constant.deviceWidth, Constant.deviceHeight);
            add(exitButton);
            exitButton.addActionListener(new ExitClick());
//            exitButton.setBounds((int)(Constant.deviceWidth / 2.5),(int)(Constant.deviceHeight / 1.7),GameUtil.widthChange(250),GameUtil.heightChange(100));
//            exitButton.setBackground(Color.GRAY);
//            exitButton.setForeground(Color.orange);
//            exitButton.setOpaque(false);
//            exitButton.setContentAreaFilled(false);
//            exitButton.setBorderPainted(false);
        }
        bigBlock.paint(graphics);
        smallBlock.paint(graphics);
        hpBar.paint(graphics);
        mpBar.paint(graphics);
        reHPBall.paint(graphics);
        reMPBall.paint(graphics);
        //一次性将图片绘制在屏幕中
        g.drawImage(bufferImage, 0, 0, null);
    }

    //按键
    public void move(KeyEvent e) {
        if (e.getKeyCode() == Constant.rightA)
            characterA.xMove(1);
        else if (e.getKeyCode() == Constant.leftA)
            characterA.xMove(2);
        else if (e.getKeyCode() == Constant.jumpA)
            characterA.yMove(true);
        else if (e.getKeyCode() == Constant.attackA)
            characterA.setAttack(true);
        else if (e.getKeyCode() == Constant.shockWaveA)
            characterA.setShock(true);
        else if (e.getKeyCode() == Constant.roarA)
            characterA.setRoar(true);
        else if (e.getKeyCode() == Constant.rightB)
            characterB.xMove(1);
        else if (e.getKeyCode() == Constant.leftB)
            characterB.xMove(2);
        else if (e.getKeyCode() == Constant.jumpB)
            characterB.yMove(true);
        else if (e.getKeyCode() == Constant.attackB)
            characterB.setAttack(true);
        else if (e.getKeyCode() == Constant.shockWaveB)
            characterB.setShock(true);
        else if (e.getKeyCode() == Constant.roarB)
            characterB.setRoar(true);
    }

    //松开按键
    public void stop(KeyEvent e) {
        if (e.getKeyCode() == Constant.rightA)
            characterA.xMove(3);
        else if (e.getKeyCode() == Constant.leftA)
            characterA.xMove(4);
        else if (e.getKeyCode() == Constant.jumpA)
            characterA.yMove(false);
        else if (e.getKeyCode() == Constant.attackA)
            characterA.setAttack(false);
        else if (e.getKeyCode() == Constant.shockWaveA)
            characterA.setShock(false);
        else if (e.getKeyCode() == Constant.roarA)
            characterA.setRoar(false);
        else if (e.getKeyCode() == Constant.rightB)
            characterB.xMove(3);
        else if (e.getKeyCode() == Constant.leftB)
            characterB.xMove(4);
        else if (e.getKeyCode() == Constant.jumpB)
            characterB.yMove(false);
        else if (e.getKeyCode() == Constant.attackB)
            characterB.setAttack(false);
        else if (e.getKeyCode() == Constant.shockWaveB)
            characterB.setShock(false);
        else if (e.getKeyCode() == Constant.roarB)
            characterB.setRoar(false);
    }
}
