package com.game.things;


import com.game.util.Constant;
import com.game.util.GameUtil;

import java.awt.*;
import java.util.Random;

public class Enemy extends Character {
    private Random rx, ry;
    private Character character;
    private int attackMode;

    public Enemy(String[] characterImagePath, int beginX, int beginY, int beginState, Character character, int attackMode) {
        super(characterImagePath, beginX, beginY, beginState);
        rx = new Random();
        ry = new Random();
        this.character = character;
        this.attackMode = attackMode;
        HP = 5;
    }

    public void MoveLogic() {
        if (close()) {
            if (attackMode == 0) {
                if (rx.nextInt(300) >= 295) {
                    super.changeMP(4);
                    super.setShock(true);
                } else {
                    super.setShock(false);
                }
            } else {
                if (rx.nextInt(30) >= 27) {
                    super.setAttack(true);
                } else {
                    super.setAttack(false);
                }
            }
            if (character.x - x > Constant.crashWidth) {
                state = 0;
                if (x + 10 > 50 && x + 10 < Constant.deviceWidth - 100)
                    x += 5;
            } else if (x - character.x > Constant.crashWidth) {
                state = 1;
                if (x - 10 > 50 && x - 10 < Constant.deviceWidth - 100)
                    x -= 5;
            }
            if (character.y - y > Constant.crashHeight) {
                if (y + 10 > 50 && y + 10 < Constant.deviceHeight - 100)
                    y += 5;
            } else if (y - character.y > Constant.crashHeight) {
                if (y - 10 > 50 && y - 10 < Constant.deviceHeight - 100)
                    y -= 5;
            }
        } else {
            int temp1 = 2, temp2 = 1;
            if (rx.nextInt(30) >= 28) {
                temp1 = rx.nextInt(6);
                temp2 = ry.nextInt(6);
            }
            if (temp1 >= 2) {
                state = 0;
                if (x + temp1 - 2 > 50 && x + temp1 - 2 < Constant.deviceWidth - 100)
                    x = x + temp1 - 2;
                if (y + temp2 - 2 > 150 && y + temp2 - 2 < Constant.deviceHeight - 100)
                    y = y + temp2 - 1;
            } else {
                state = 1;
                if (x - temp1 > 50 && x - temp1 < Constant.deviceWidth - 100)
                    x = x - temp1;
                if (y + temp2 - 5 > 150 && y + temp2 - 5 < Constant.deviceHeight - 100)
                    y = y + temp2 - 1;
            }
        }
    }

    private boolean close() {
        double length = (x - character.x) * (x - character.x) + (y - character.y) * (y - character.y);
        length = Math.sqrt(length);
        if (length > 300)
            return false;
        else
            return true;
    }

    @Override
    public void paint(Graphics g) {
        MoveLogic();
        waveMoveLogic();
        if (HP > 0) {
            g.drawImage(image[state], x, y, Constant.characterWidth, Constant.characterHeight, null);
            shockWavePaint(g);
            attackPaint(g);
        }
    }
}
