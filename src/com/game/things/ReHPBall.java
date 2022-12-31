package com.game.things;

import com.game.util.Constant;
import com.game.util.GameUtil;

import java.awt.*;
import java.util.Random;

public class ReHPBall {
    private int time = 300;//生成恢复球间隔
    private int x,y;//生成恢复球位置
    private final Image reHPBall;
    private boolean isOnScreen = false;
    private Random rx,ry;
    public ReHPBall() {
        rx = new Random();
        ry = new Random();
        reHPBall = GameUtil.getImage(Constant.reHPBallImagePath);
    }
    public void paint(Graphics g) {
        if(!isOnScreen && time <= 0) {
            x = rx.nextInt(Constant.deviceWidth - Constant.ballWidth);
            y = 2*Constant.characterHeight + ry.nextInt(Constant.background - Constant.ballHeight - 2*Constant.characterHeight);
            isOnScreen = true;
            time = 300;
        }
        if(isOnScreen) {
            g.drawImage(reHPBall, x, y, Constant.ballWidth, Constant.ballHeight, null);
        }
        else
            time--;
    }
    public boolean isBallOnScreen() {
        return isOnScreen;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void changeBallOnScreen(boolean isOnScreen) {
        this.isOnScreen = isOnScreen;
    }
}
