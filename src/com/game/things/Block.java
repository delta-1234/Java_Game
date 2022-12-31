package com.game.things;

import com.game.util.GameUtil;

import java.awt.*;

public class Block {
    //障碍物图片
    private final Image blockImage;
    //障碍物速度
    private int speed;
    //障碍物位置
    private int x, y;
    //障碍物大小
    private final int width;
    private final int height;
    //构造方法
    public Block(String blockPath, int speed, int x, int y, int width,int height) {
        this.blockImage = GameUtil.getImage(blockPath);
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void xMoveLogic() {
        x += speed;
        if (x <= 0 || x >= GameUtil.widthChange(1200))
            speed = -speed;
    }
    public void paint(Graphics g) {
        xMoveLogic();
        g.drawImage(blockImage, x, y, width, height, null);
    }
    //获取block位置。大小
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getSpeed() {
        return speed;
    }
}
