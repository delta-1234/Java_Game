package com.game.fighting;

import com.game.things.Character;
import com.game.util.Constant;
import com.game.util.GameUtil;

public class NormalAttack {
    public NormalAttack(Character characterA, Character characterB) {
        isAttack(characterA, characterB);
        isAttack(characterB, characterA);
    }

    //A是否攻击到了B
    public void isAttack(Character attacker, Character victim) {
        boolean attack = attacker.getAttack();
        int state = attacker.getState();
        int attackerX = attacker.getX();
        int attackerY = attacker.getY();
        int victimX = victim.getX();
        int victimY = victim.getY();
        int victimHP = victim.getHP();
        if (attack && attacker.getTime() >= 29) {
            if (Math.abs(attackerY - victimY) < Constant.crashHeight) {
                //向右攻击
                if ((state == Constant.rightStop || state == Constant.rightRun) && attackerX <= victimX && attackerX + 2 * Constant.crashWidth > victimX) {
                    victim.changeX(victimX + GameUtil.widthChange(20));
                    victim.changeHP(victimHP - 1);
                    victim.changeMP(victim.getMP() + 1);
                    attacker.changeMP(attacker.getMP() + 1);
                }
                //向左攻击
                else if ((state == Constant.leftStop || state == Constant.leftRun) && victimX <= attackerX && attackerX < victimX + 2 * Constant.crashWidth) {
                    victim.changeX(victimX - GameUtil.widthChange(20));
                    victim.changeHP(victimHP - 1);
                    victim.changeMP(victim.getMP() + 1);
                    attacker.changeMP(attacker.getMP() + 1);
                }
            }
        }
    }
}
