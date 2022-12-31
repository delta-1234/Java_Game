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
import java.util.Random;

public class PVEPlayingInterface extends GameWindows {
    private Character character;
    private Block smallBlock1,smallBlock2;
    private Block bigBlock;
    private HPBar hpbar;
    private MPBar mpBar;
    private boolean gameOver = false;
    private ReHPBall reHPBall;
    public ReMPBall reMPBall;
    private BufferedImage bufferImage = new BufferedImage(Constant.deviceWidth, Constant.deviceHeight, BufferedImage.TYPE_4BYTE_ABGR);
    private Enemy [] enemy;
    private int enemyNum;
    private JButton exitButton;
    public PVEPlayingInterface() {
        Constant.background = Constant.deviceHeight;
        character = new Character(Constant.characterAImagePath, GameUtil.widthChange(200),GameUtil.heightChange(621), 0);
        character.changeGround(GameUtil.heightChange(720));
        Random r = new Random();
        enemyNum = 3 + r.nextInt(5);
        enemy = new Enemy[8];
        enemy[0] = new Enemy(Constant.bigEnemyImagePath,GameUtil.widthChange(200),GameUtil.heightChange(300), 0, character, 0);
        enemy[1] = new Enemy(Constant.bigEnemyImagePath,GameUtil.widthChange(900),GameUtil.heightChange(400), 1, character, 0);
        for (int i = 2; i < enemyNum; i++) {
            enemy[i] = new Enemy(Constant.smallEnemyImagePath,GameUtil.widthChange(r.nextInt(1000)),GameUtil.heightChange(r.nextInt(600) + 150),
                    r.nextInt(1),character,1);
            enemy[i].changeHP(3);
        }
        Constant.background = Constant.deviceHeight;
        smallBlock1 = new Block(Constant.smallBlock,GameUtil.widthChange(4), GameUtil.widthChange(200),
                GameUtil.heightChange(500), Constant.smallBlockWidth, Constant.smallBlockHeight);
        smallBlock2 = new Block(Constant.smallBlock,GameUtil.widthChange(-4),GameUtil.widthChange(400),
                GameUtil.heightChange(200), Constant.smallBlockWidth, Constant.smallBlockHeight);
        bigBlock = new Block(Constant.bigBlock,GameUtil.widthChange(2),GameUtil.widthChange(150),
                GameUtil.heightChange(720),Constant.bigBlockWidth,Constant.bigBlockHeight);
        hpbar = new HPBar(character);
        mpBar = new MPBar(character);
        reHPBall = new ReHPBall();
        reMPBall = new ReMPBall();
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
        new Run().start();
    }
    class Run extends Thread {
        @Override
        public void run() {
            while (true) {
                repaint();
                gameOver = true;
                for (int i = 0; i < enemyNum; i++) {
                    if(enemy[i].getHP() > 0) {
                        new CharacterCrash(character, enemy[i]);
                        new NormalAttack(character, enemy[i]);
                        new ShockWave(character, enemy[i]);
                        new Roar(character, enemy[i]);
                        gameOver = false;
                    }
                }
                if(character.getHP() == 0)
                    gameOver = true;
                new BlockCrash(character,smallBlock1);
                new BlockCrash(character,smallBlock2);
                new BlockCrash(character,bigBlock);
                new CatchReBall(character,reHPBall);
                new CatchReBall(character,reMPBall);
                new Falling(character, bigBlock);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        Graphics graphics = bufferImage.getGraphics();
        graphics.drawImage(GameUtil.getImage(Constant.PVEBackground),
                0, 0, Constant.deviceWidth, Constant.deviceHeight, null);
        if(character.getHP() > 0)
            character.paint(graphics);
        for (int i = 0; i < enemyNum; i++) {
            enemy[i].paint(graphics);
        }
        hpbar.paint(graphics);
        smallBlock1.paint(graphics);
        smallBlock2.paint(graphics);
        bigBlock.paint(graphics);
        mpBar.paint(graphics);
        reHPBall.paint(graphics);
        reMPBall.paint(graphics);
        if(gameOver) {
            graphics.drawImage(GameUtil.getImage(Constant.gameOver), 0, 0, Constant.deviceWidth, Constant.deviceHeight, null);
            graphics.drawImage(GameUtil.getImage(Constant.exit), (int) (Constant.deviceWidth / 2.5), (int) (Constant.deviceHeight / 1.7), GameUtil.widthChange(250), GameUtil.heightChange(100), null);
            //游戏结束的退出按钮
            exitButton = new JButton("");
            exitButton.setBounds(0, 0, Constant.deviceWidth, Constant.deviceHeight);
            add(exitButton);
            exitButton.addActionListener(new ExitClick());
        }
        g.drawImage(bufferImage, 0, 0, null);
    }
    public void move(KeyEvent e) {
        if (e.getKeyCode() == Constant.rightA)
            character.xMove(1);
        else if (e.getKeyCode() == Constant.leftA)
            character.xMove(2);
        else if (e.getKeyCode() == Constant.jumpA)
            character.yMove(true);
        else if (e.getKeyCode() == Constant.attackA)
            character.setAttack(true);
        else if (e.getKeyCode() == Constant.shockWaveA)
            character.setShock(true);
        else if (e.getKeyCode() == Constant.roarA)
            character.setRoar(true);
    }

    //松开按键
    public void stop(KeyEvent e) {
        if (e.getKeyCode() == Constant.rightA)
            character.xMove(3);
        else if (e.getKeyCode() == Constant.leftA)
            character.xMove(4);
        else if (e.getKeyCode() == Constant.jumpA)
            character.yMove(false);
        else if (e.getKeyCode() == Constant.attackA)
            character.setAttack(false);
        else if (e.getKeyCode() == Constant.shockWaveA)
            character.setShock(false);
        else if (e.getKeyCode() == Constant.roarA)
            character.setRoar(false);
    }
    class ExitClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            gameOver = true;
        }
    }
}

