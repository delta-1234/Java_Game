package com.game.things;

import com.game.util.Constant;
import com.game.util.GameUtil;

import java.awt.*;
import java.util.Random;

public class ReMPBall {
    private int time = 100;//生成恢复球间隔
    private int [] x,y;//生成恢复球位置
    private int count;//生成恢复球数量
    private final Image reMPBall;
    private boolean [] isOnScreen ;
    private boolean noBall = true;
    private Random rx,ry,rc;
    public ReMPBall() {
        rx = new Random();
        ry = new Random();
        rc = new Random();
        x = new int[4];
        y = new int[4];
        isOnScreen = new boolean[4];
        for (int i = 0; i < 4; i++) {
            isOnScreen[i] = false;
        }
        reMPBall = GameUtil.getImage(Constant.reMPBallImagePath);
    }
    public void paint(Graphics g) {
        if(noBall && time <=0 ) {
            count = rc.nextInt(3);
            for (int i = 0; i < count; i++) {
                isOnScreen[i] = true;
                x[i] = rx.nextInt(Constant.deviceWidth - Constant.ballWidth);
                y[i] = 2*Constant.characterHeight + ry.nextInt(Constant.background - Constant.ballHeight - 2*Constant.characterHeight);
            }
            noBall = false;
            time = 100;
        }
        if(!noBall) {
            for (int i = 0; i < count; i++) {
                if(isOnScreen[i])
                    g.drawImage(reMPBall,x[i],y[i],Constant.ballWidth,Constant.ballHeight,null);
            }
        }
        else
            time--;
    }
    public boolean getIsOnScreen(int i) {
        return isOnScreen[i];
    }
    public int [] getXList() {
        return x;
    }
    public int [] getYList() {
        return y;
    }
    public int getCount() {
        return count;
    }
    public void changeIsOnScreen(boolean isOnScreen,int i) {
        this.isOnScreen[i] = isOnScreen;
    }
    public void isNoBall() {
        int i;
        for (i = 0; i < count; i++) {
            if(isOnScreen[i])
                break;
        }
        noBall = i == count;
    }
}
