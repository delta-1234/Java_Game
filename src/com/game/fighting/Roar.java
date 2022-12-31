package com.game.fighting;

import com.game.things.Character;
import com.game.util.Constant;

public class Roar {
    public Roar(Character characterA,Character characterB) {
        attack(characterA,characterB);
        attack(characterB,characterA);
    }
    public void attack(Character attacker,Character victim) {
        boolean isRoarOnScreen = attacker.isRoarOnScreen();
        int roarX = attacker.getRoarX();
        int roarY = attacker.getRoarY();
        int victimX = victim.getX();
        int victimY = victim.getY();
        int victimHP = victim.getHP();
        boolean hurt = victim.isRoarHurt();
        if(isRoarOnScreen && !hurt) {
            if(Math.abs(roarX - victimX) < Constant.crashWidth + Constant.roarWidth) {
                if(Math.abs(roarY - victimY) < Constant.crashHeight + Constant.roarHeight) {
                    victim.changeHP(victimHP - 3);
                    victim.changeRoarHurt(true);
                    victim.changeY(victimY - 20);
                }
            }
        }
        else if(!isRoarOnScreen)
            victim.changeRoarHurt(false);
    }
}
