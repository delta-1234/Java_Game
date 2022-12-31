package com.game.util;

import java.awt.*;
public class Constant {
    //窗口大小
    private static final Toolkit tk = Toolkit.getDefaultToolkit();
    private static final Dimension screen = tk.getScreenSize();
    public static final int deviceWidth = (int)screen.getWidth();//屏幕宽度
    public static final int deviceHeight = (int)screen.getHeight();//屏幕高度
    public static final String backgroundImagePath = "img/background.png";
    public static final String gameOver = "img/gameOver.png";
    public static final String exit = "img/exit.png";
    public static int background = GameUtil.heightChange(720);
    public static final int characterIMGCount = 11;
    public static final String [] characterAImagePath =
            {"img/characterRightStop.png","img/characterLeftStop.png","img/characterRightRun.png","img/characterLeftRun.png",
                    "img/attackRight.png","img/attackLeft.png","img/shockWaveRight.png","img/shockWaveLeft.png","img/roar.png",
                    "img/roarActionA.png","img/AHurt.png"};
    public static final String [] characterBImagePath =
            {"img/characterBRightStop.png","img/characterBLeftStop.png","img/characterBRightRun.png","img/characterBLeftRun.png",
                    "img/attackRight.png","img/attackLeft.png","img/shockWaveRight.png","img/shockWaveLeft.png","img/roar.png",
                    "img/roarActionB.png","img/BHurt.png"};
    public static final String [] bigEnemyImagePath =
            {"img/bigEnemyRight.png","img/bigEnemyLeft.png","img/bigEnemyRight.png","img/bigEnemyLeft.png",
                    "img/attackRight.png","img/attackLeft.png","img/enemyWave.png","img/enemyWave.png","img/roar.png",
                    "img/roarActionB.png","img/BHurt.png"};
    public static final String [] smallEnemyImagePath =
            {"img/smallEnemyRight.png","img/smallEnemyLeft.png","img/smallEnemyRight.png","img/smallEnemyLeft.png",
                    "img/attackRight.png","img/attackLeft.png","img/enemyWave.png","img/enemyWave.png","img/roar.png",
                    "img/roarActionB.png","img/BHurt.png"};
    public static final int characterWidth = GameUtil.widthChange(90);
    public static final int characterHeight = GameUtil.heightChange(70);
    public static final int crashWidth = GameUtil.widthChange(70);
    public static final int crashHeight = GameUtil.heightChange(60);
    public static final int waveWidth = GameUtil.widthChange(180);
    public static final int roarWidth = GameUtil.widthChange(160);
    public static final int roarHeight = GameUtil.heightChange(140);
    public static final String smallBlock = "img/smallBlock.png";
    public static final String bigBlock = "img/bigBlock.png";
    public static final String HPBar1 = "img/HPBar1.png";
    public static final String HPBar2 = "img/HPBar2.png";
    public static final String blood = "img/blood.png";
    public static final int smallBlockWidth = GameUtil.widthChange(196);
    public static final int smallBlockHeight = GameUtil.heightChange(99);
    public static final int bigBlockWidth = GameUtil.widthChange(392);
    public static final int bigBlockHeight = GameUtil.heightChange(99);
    public static final int maxHP = 8;
    public static final int maxMP = 6;
    public static final String [] MPAImagePath =
            {"img/MPA1.png","img/MPA2.png","img/MPA3.png","img/MPA4.png","img/MPA5.png","img/MPA6.png"};
    public static final String [] MPBImagePath =
            {"img/MPB1.png","img/MPB2.png","img/MPB3.png","img/MPB4.png","img/MPB5.png","img/MPB6.png"};

    public static int jumpA = 87,rightA = 68,leftA = 65,attackA = 70,shockWaveA = 69,roarA = 81;
    public static int jumpB = 73,rightB = 76,leftB = 74,attackB = 72,shockWaveB = 85,roarB = 79;
    public static final String reHPBallImagePath = "img/reHPBall.png";
    public static final String reMPBallImagePath = "img/reMPBall.png";
    public static final int ballWidth = GameUtil.widthChange(60);
    public static final int ballHeight = GameUtil.heightChange(60);
    public static final int rightStop = 0;
    public static final int leftStop = 1;
    public static final int rightRun = 2;
    public static final int leftRun = 3;
    public static final int attackRight = 4;
    public static final int attackLeft = 5;
    public static final int shockWaveRight = 6;
    public static final int shockWaveLeft = 7;
    public static final int roar = 8;
    public static final int roarAction = 9;
    public static final int beHurt = 10;
    public static int gameModel = 0;
    public static String PVEBackground = "img/PVEBackground.png";
}
