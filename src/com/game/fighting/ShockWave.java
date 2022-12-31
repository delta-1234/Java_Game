package com.game.fighting;

import com.game.things.Character;
import com.game.util.Constant;
import com.game.util.GameUtil;

public class ShockWave {
    public ShockWave(Character characterA,Character characterB) {
        attack(characterA,characterB);
        attack(characterB,characterA);
    }
    public void attack(Character attacker,Character victim) {
        boolean waveOnScreen = attacker.isWaveOnScreen();
        int waveX = attacker.getWaveX();
        int waveY = attacker.getWaveY();
        int victimX = victim.getX();
        int victimY = victim.getY();
        int victimHP = victim.getHP();
        boolean hurt = victim.isWaveHurt();
        if(waveOnScreen && !hurt) {
            if(Math.abs(waveY - victimY) < Constant.crashHeight) {
                if(waveX >= victimX && waveX <= victimX + Constant.crashWidth) {
                    if(attacker.getWaveFace() == Constant.shockWaveRight)
                        victim.changeX(victimX + GameUtil.widthChange(20));
                    else
                        victim.changeX(victimX - GameUtil.widthChange(20));
                    victim.changeHP(victimHP - 2);
                    victim.changeWaveHurt(true);
                }
            }
        }
        else
            victim.changeWaveHurt(false);
    }
}
