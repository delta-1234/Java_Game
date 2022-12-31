package com.game.things;

import com.game.util.Constant;
import com.game.util.GameUtil;

import java.awt.*;

public class Character {

    //存放角色图片
    protected final Image[] image;
    //角色状态
    protected int state;
    protected int tempState;
    //攻击
    public static int time = 30;//攻击持续时间
    protected boolean attack = false;//是否攻击
    protected boolean shock = false;//是否释放冲击波
    protected boolean waveOnScreen = false;//冲击波是否在屏幕上
    protected int waveX = 0, waveY = 0;//冲击波位置
    protected int waveSpeed = 0;//冲击波速度
    protected int waveFace = 0;//冲击波朝向
    protected boolean waveHurt = false;//是否受到冲击波伤害
    protected int roarX, roarY;//roar的位置
    protected boolean roar = false;//是否释放roar
    protected boolean roarOnScreen = false;//屏幕上是否存在roar
    protected int roarTime = 7;//roar持续时间
    protected boolean roarHurt = false;//是否受到roar伤害
    //角色的位置
    protected int ground = Constant.background;
    protected int x, y = ground - Constant.crashHeight;
    //角色的移动
    protected boolean right = false, left = false;
    protected boolean jump = false;
    protected int count = 0;//二段跳计数用
    protected boolean isInAir = false;//判断角色是否在空中
    //角色的移动速度
    protected int xSpeed = 10;//向右为正
    protected int ySpeed = -30;//向下为正
    //角色血条
    protected int HP = Constant.maxHP;
    protected int MP = 0;


    //对图像初始化
    public Character(String[] characterImagePath, int beginX, int beginState) {
        x = beginX;
        state = beginState;
        image = new Image[Constant.characterIMGCount];
        for (int i = 0; i < Constant.characterIMGCount; i++) {
            image[i] = GameUtil.getImage(characterImagePath[i]);
        }
    }
    public Character(String[] characterImagePath, int beginX,int beginY,int beginState) {
        x = beginX;
        y = beginY;
        state = beginState;
        image = new Image[Constant.characterIMGCount];
        for (int i = 0; i < Constant.characterIMGCount; i++) {
            image[i] = GameUtil.getImage(characterImagePath[i]);
        }
    }

    //控制角色移动方向
    //水平移动
    public void xMoveLogic() {
        if (y == ground - Constant.characterHeight) {
            if (xSpeed > 10) {
                xSpeed = 10;
            } else if (xSpeed < -10) {
                xSpeed = -10;
            }
        }
        if (right) {
            if (x <= GameUtil.widthChange(1450))
                x += xSpeed;
        } else if (left) {
            if (x >= 0)
                x += xSpeed;
        }
    }

    public void xMove(int move) {
        switch (move) {
            case 1 -> {
                state = Constant.rightRun;
                right = true;
                left = false;
                xSpeed = 10;
            }
            case 2 -> {
                state = Constant.leftRun;
                left = true;
                right = false;
                xSpeed = -10;
            }
            case 3 -> {
                state = Constant.rightStop;
                left = true;
                right = true;
                xSpeed = 0;
            }
            case 4 -> {
                state = Constant.leftStop;
                left = true;
                right = true;
                xSpeed = 0;
            }
        }
    }

    //跳跃
    public void yMoveLogic() {

        if (jump && y == ground - Constant.crashHeight) {
            ySpeed = -30;
            count++;
        } else if (!jump && y == ground - Constant.crashHeight) {
            ySpeed = 0;
            count = 0;
            isInAir = false;
        } else if (jump && count <= 1 && isInAir) {
            count++;
            ySpeed = -30;
        } else if (!jump && y != ground - Constant.crashHeight) {
            isInAir = true;
            ySpeed += 2;
        } else
            ySpeed += 2;
        if (y <= ground - Constant.crashHeight) {
            y += ySpeed;
            if (y > ground - Constant.crashHeight)
                y = ground - Constant.crashHeight;
            else if (y < 0) {
                ySpeed = 0;
            }
        }
    }

    public void yMove(boolean jump) {
        this.jump = jump;
    }

    //普通攻击
    public void attackPaint(Graphics g) {
        time--;
        if (attack) {
            if ((state == Constant.rightStop || state == Constant.rightRun) && time >= 10) {
                g.drawImage(image[Constant.attackRight], x + Constant.characterWidth, y, Constant.characterWidth, Constant.characterHeight, null);
            } else if ((state == Constant.leftStop || state == Constant.leftRun) && time >= 10) {
                g.drawImage(image[Constant.attackLeft], x - Constant.characterWidth, y, Constant.characterWidth, Constant.characterHeight, null);
            }
        }
        if (attack && time <= 0)
            time = 30;
    }

    public void setAttack(boolean attack) {
        if (time <= 0)
            this.attack = attack;
        else
            this.attack = false;
    }

    //冲击波
    public void shockWavePaint(Graphics g) {
        if (shock && MP >= 2 && !waveOnScreen) {
            if (state == Constant.rightStop || state == Constant.rightRun) {
                waveSpeed = 40;
                waveX = x + Constant.characterWidth;
                waveY = y;
                waveOnScreen = true;
                waveFace = Constant.shockWaveRight;
                x -= GameUtil.widthChange(10);
                MP -= 2;
            } else if (state == Constant.leftStop || state == Constant.leftRun) {
                waveSpeed = -40;
                waveX = x - Constant.waveWidth;
                waveY = y;
                waveOnScreen = true;
                waveFace = Constant.shockWaveLeft;
                x += GameUtil.widthChange(10);
                MP -= 2;
            }
        }
        if (waveOnScreen)
            g.drawImage(image[waveFace], waveX, waveY, Constant.waveWidth, Constant.characterHeight, null);
    }

    public void waveMoveLogic() {
        waveX += waveSpeed;
        if (waveX <= 0 || waveX >= Constant.deviceWidth)
            waveOnScreen = false;
    }

    public void setShock(boolean shock) {
        this.shock = shock;
    }

    //roar技能
    public void roarPaint(Graphics g) {
        roarTime--;
        if (roar && MP >= 3 && !roarOnScreen) {
            MP -= 3;
            roarTime = 7;
            roarOnScreen = true;
            tempState = state;
        }
        if (roarOnScreen) {
            roarX = x - Constant.roarWidth / 2 + Constant.characterWidth / 2;
            roarY = y - Constant.roarHeight;
            state = Constant.roarAction;
            ySpeed = 0;
            g.drawImage(image[Constant.roar], roarX, roarY, Constant.roarWidth, Constant.roarHeight, null);
        }
        if (roarTime <= 0 && roarOnScreen) {
            roarOnScreen = false;
            state = tempState;
        }
    }

    public void setRoar(boolean roar) {
        this.roar = roar;
    }

    //绘制角色
    public void paint(Graphics g) {
        xMoveLogic();
        yMoveLogic();
        waveMoveLogic();
        attackPaint(g);
        shockWavePaint(g);
        roarPaint(g);
        g.drawImage(image[state], x, y, Constant.characterWidth, Constant.characterHeight, null);
    }

    //反馈角色位置、是否攻击、状态、速度、血条
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getAttack() {
        return attack;
    }

    public int getState() {
        return state;
    }

    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    public int getHP() {
        return HP;
    }

    public int getMP() {
        return MP;
    }

    public int getGround() {
        return ground;
    }

    public int getTime() {
        return time;
    }

    public int getWaveX() {
        return waveX;
    }

    public int getWaveY() {
        return waveY;
    }

    public int getWaveFace() {
        return waveFace;
    }

    public boolean isWaveOnScreen() {
        return waveOnScreen;
    }

    public boolean isWaveHurt() {
        return waveHurt;
    }

    public boolean isRoarOnScreen() {
        return roarOnScreen;
    }

    public boolean isRoarHurt() {
        return roarHurt;
    }

    public int getRoarX() {
        return roarX;
    }

    public int getRoarY() {
        return roarY;
    }

    //改变角色位置、速度、血条
    public void changeX(int x) {
        if (x >= 0 && x <= GameUtil.widthChange(1450))
            this.x = x;
    }

    public void changeY(int y) {
        if (y >= 0 && y <= ground - Constant.crashHeight)
            this.y = y;
    }

    public void changeXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void changeYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void changeHP(int HP) {
        if (HP >= 0 && HP <= Constant.maxHP)
            this.HP = HP;
        else if (HP < 0)
            this.HP = 0;
    }

    public void changeMP(int MP) {
        if (MP >= 0 && MP <= Constant.maxMP)
            this.MP = MP;
    }

    public void changeGround(int ground) {
        if (ground > 0 && ground <= Constant.deviceHeight)
            this.ground = ground;
    }

    public void changeState(int state) {
        if (state >= 0 && state <= 3)
            this.state = state;
    }

    public void changeWaveHurt(boolean hurt) {
        this.waveHurt = hurt;
    }

    public void changeRoarHurt(boolean hurt) {
        this.roarHurt = hurt;
    }
}
