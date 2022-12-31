package com.game.fighting;

import com.game.things.Block;
import com.game.things.Character;
import com.game.util.Constant;

public class Falling {
    public Falling(Character character, Block block) {
        int blockX,blockY,blockWidth;
        blockX = block.getX();
        blockY = block.getY();
        blockWidth = block.getWidth();
        if(character.getY() >= Constant.deviceHeight - Constant.crashHeight) {
            character.changeHP(character.getHP() - 1);
            character.changeX(blockX + blockWidth / 2);
            character.changeY(blockY - 2 * Constant.characterHeight);
        }
    }
}
