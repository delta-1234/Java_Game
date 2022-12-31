package com.game.things;

import com.game.util.Constant;
import com.game.util.GameUtil;

import java.awt.*;

public class HPBar {
    private final Image HPBar1,HPBar2;
    private final Image blood;
    private Character characterA,characterB;
    public HPBar(Character characterA,Character characterB) {
        HPBar1 = GameUtil.getImage(Constant.HPBar1);
        HPBar2 = GameUtil.getImage(Constant.HPBar2);
        blood = GameUtil.getImage(Constant.blood);
        this.characterA = characterA;
        this.characterB = characterB;
    }
    public HPBar(Character characterA) {
        HPBar1 = GameUtil.getImage(Constant.HPBar1);
        HPBar2 = null;
        blood = GameUtil.getImage(Constant.blood);
        this.characterA = characterA;
    }
    public void paint(Graphics g) {
        g.drawImage(HPBar1,GameUtil.widthChange(10),GameUtil.heightChange(25),GameUtil.widthChange(250),GameUtil.heightChange(100),null);
        if(HPBar2 != null)
            g.drawImage(HPBar2,GameUtil.widthChange(1275),GameUtil.heightChange(25),GameUtil.widthChange(250),GameUtil.heightChange(100),null);
        for (int i = 0; i < characterA.getHP(); i++) {
            g.drawImage(blood,GameUtil.widthChange(140 + i*50),GameUtil.heightChange(60),GameUtil.widthChange(40),GameUtil.heightChange(40),null);
        }
        if(HPBar2 != null) {
            for (int i = 0; i < characterB.getHP(); i++) {
                g.drawImage(blood, GameUtil.widthChange(1375 - i * 50), GameUtil.heightChange(60), GameUtil.widthChange(40), GameUtil.heightChange(40), null);
            }
        }
    }
}
