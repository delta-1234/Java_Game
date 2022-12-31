package com.game.fighting;

import com.game.things.Character;
import com.game.things.ReHPBall;
import com.game.things.ReMPBall;
import com.game.util.Constant;

public class CatchReBall {
    private Character character;
    private ReHPBall reHPBall;
    private ReMPBall reMPBall;
    private int characterX,characterY;
    public CatchReBall(Character character, ReHPBall reHPBall) {
        this.character = character;
        this.reHPBall = reHPBall;
        characterX = character.getX();
        characterY = character.getY();
        eatReHPBall();
    }
    public CatchReBall(Character character, ReMPBall reMPBall) {
        this.character = character;
        this.reMPBall = reMPBall;
        characterX = character.getX();
        characterY = character.getY();
        eatMPBall();
    }
    public void eatReHPBall() {
        int ballX,ballY;
        ballX = reHPBall.getX();
        ballY = reHPBall.getY();
        if(reHPBall.isBallOnScreen()) {
            if (Math.abs(ballY - characterY) < Constant.crashHeight + Constant.ballHeight) {
                if (Math.abs(ballX - characterX) < Constant.crashWidth + Constant.ballWidth) {
                    reHPBall.changeBallOnScreen(false);
                    character.changeHP(character.getHP() + 1);
                }
            }
        }
    }
    public void eatMPBall() {
        int [] ballX,ballY;
        ballX = reMPBall.getXList();
        ballY = reMPBall.getYList();
        for (int i = 0; i < reMPBall.getCount(); i++) {
            if(reMPBall.getIsOnScreen(i)) {
                if (Math.abs(ballY[i] - characterY) < Constant.crashHeight + Constant.ballHeight) {
                    if (Math.abs(ballX[i] - characterX) < Constant.crashWidth + Constant.ballWidth) {
                        reMPBall.changeIsOnScreen(false,i);
                        character.changeMP(character.getMP() + 1);
                    }
                }
            }
        }
        reMPBall.isNoBall();
    }
}
