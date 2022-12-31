package com.game.fighting;

import com.game.things.Block;
import com.game.things.Character;
import com.game.util.Constant;

public class BlockCrash {
    boolean flag = false;
    public BlockCrash(Character character, Block block) {
        int characterX = character.getX();
        int characterXSpeed = character.getXSpeed();
        int characterY = character.getY();
        int characterYSpeed = character.getYSpeed();
        int blockX = block.getX();
        int blockY = block.getY();
        int blockSpeed = block.getSpeed();
        int blockWidth = block.getWidth();
        int blockHeight = block.getHeight();

        int nextCX = characterX + characterXSpeed;
        int nextCY = characterY + characterYSpeed;
        int nextBX = blockX + blockSpeed;
        //x方向发生碰撞
        if (!(characterY >= blockY + blockHeight) && !(blockY >= characterY + Constant.crashHeight)) {
            if (nextBX < nextCX + Constant.crashWidth && nextCX + Constant.crashWidth < nextBX + blockWidth) {
                character.changeXSpeed(blockSpeed);
            } else if (nextCX > nextBX && nextCX < nextBX + blockWidth) {
                character.changeXSpeed(blockSpeed);
            }
        }
        //y方向发生碰撞
        if (!(characterX + Constant.crashWidth <= blockX) && !(blockX + blockWidth <= characterX)) {
            if (nextCY <= blockY && blockY <= nextCY + Constant.crashHeight) {
                if (characterYSpeed >= 0) {
                    character.changeYSpeed(0);
                    character.changeGround(blockY);
                    flag = true;
                    if (character.getState() == 2 || character.getState() == 3) {
                        if (characterXSpeed == 10 || characterXSpeed == -10 || characterXSpeed == 0)
                            character.changeXSpeed(blockSpeed + characterXSpeed);
                    } else if (character.getState() == 0 || character.getState() == 1) {
                        character.changeXSpeed(blockSpeed);
                    }
                } else
                    character.changeYSpeed(0);
            } else if (nextCY >= blockY && nextCY <= blockY + blockHeight) {
                character.changeYSpeed(0);
            }
        }
        if(characterX - blockX > blockWidth || blockX - characterX > Constant.crashWidth) {
            if(flag) {
                character.changeGround(Constant.background);
                flag = false;
            }
        }
    }
}
