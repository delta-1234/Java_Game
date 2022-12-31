package com.game.fighting;

import com.game.things.Character;
import com.game.util.Constant;

public class CharacterCrash {
    private int characterAX, characterAY, characterBX, characterBY;
    private int characterAXSpeed, characterAYSpeed, characterBXSpeed, characterBYSpeed;
    private int characterAGround, characterBGround;
    private int characterAState, characterBState;

    public CharacterCrash(Character characterA, Character characterB) {
        characterAX = characterA.getX();
        characterAY = characterA.getY();
        characterAXSpeed = characterA.getXSpeed();
        characterAYSpeed = characterA.getYSpeed();
        characterAGround = characterA.getGround();
        characterAState = characterA.getState();
        characterBX = characterB.getX();
        characterBY = characterB.getY();
        characterBXSpeed = characterB.getXSpeed();
        characterBYSpeed = characterB.getYSpeed();
        characterBGround = characterB.getGround();
        characterBState = characterB.getState();
        crash();
        characterA.changeXSpeed(characterAXSpeed);
        characterA.changeYSpeed(characterAYSpeed);
        characterA.changeGround(characterAGround);
        characterA.changeState(characterAState);
        characterB.changeXSpeed(characterBXSpeed);
        characterB.changeYSpeed(characterBYSpeed);
        characterB.changeGround(characterBGround);
        characterB.changeState(characterBState);
    }

    public void crash() {
        //A和B不能进入对方碰撞体积内
        int nextAX, nextAY, nextBX, nextBY;
        nextAX = characterAX + characterAXSpeed;
        nextAY = characterAY + characterAYSpeed;
        nextBX = characterBX + characterBXSpeed;
        nextBY = characterBY + characterBYSpeed;
        //A和B发生x方向碰撞，y需要满足一定条件
        if (!(characterAY >= characterBY + Constant.crashHeight) && !(characterBY >= characterAY + Constant.crashHeight)) {
            //如果A从左边撞上了B
            if (characterAXSpeed > 0 && nextBX < nextAX + Constant.crashWidth && nextAX < nextBX) {
                characterAXSpeed = 0;
                characterAState = Constant.rightStop;//姿态转变为rightStop
            }
            //如果A从右边撞上了B
            else if (characterAXSpeed < 0 && nextBX < nextAX && nextAX < nextBX + Constant.crashWidth) {
                characterAXSpeed = 0;
                characterAState = Constant.leftStop;//姿态转变为leftStop
            }
            //B从左边撞上了A
            if (characterBXSpeed > 0 && nextAX < nextBX + Constant.crashWidth && nextBX < nextAX) {
                characterBXSpeed = 0;
                characterBState = Constant.rightStop;
            }
            //B从右边撞上了A
            else if (characterBXSpeed < 0 && nextAX < nextBX && nextBX < nextAX + Constant.crashWidth) {
                characterBXSpeed = 0;
                characterBState = Constant.leftStop;
            }
        }
        //A和B发生y轴碰撞，x必须满足一定条件
        if (!(characterAX + Constant.crashWidth <= characterBX) && !(characterBX + Constant.crashWidth <= characterAX)) {
            //A从上方碰撞到B
            if (characterAYSpeed >= 0 && nextAY <= nextBY && nextBY <= nextAY + Constant.crashHeight) {
                characterAGround = characterBY;
            } else {
                    characterAGround = Constant.background;
            }
            //B从上方碰撞到A
            if (characterBYSpeed >= 0 && nextBY <= nextAY && nextAY <= nextBY + Constant.crashHeight) {
                characterBGround = characterAY;
            } else {
                    characterBGround = Constant.background;
            }
        } else {
                characterAGround = Constant.background;
                characterBGround = Constant.background;
        }
    }
}
