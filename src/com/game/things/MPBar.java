package com.game.things;

import com.game.util.Constant;
import com.game.util.GameUtil;

import java.awt.*;

public class MPBar {
    private final Image[] MPBarA;
    private final Image[] MPBarB;
    private final Character characterA, characterB;

    public MPBar(Character characterA, Character characterB) {
        MPBarA = new Image[Constant.maxMP];
        MPBarB = new Image[Constant.maxMP];
        for (int i = 0; i < Constant.maxMP; i++) {
            MPBarA[i] = GameUtil.getImage(Constant.MPAImagePath[i]);
            MPBarB[i] = GameUtil.getImage(Constant.MPBImagePath[i]);
        }
        this.characterA = characterA;
        this.characterB = characterB;
    }
    public MPBar(Character characterA) {
        MPBarA = new Image[Constant.maxMP];
        MPBarB = null;
        for (int i = 0; i < Constant.maxMP; i++) {
            MPBarA[i] = GameUtil.getImage(Constant.MPAImagePath[i]);
        }
        this.characterA = characterA;
        this.characterB = null;
    }
    public void paint(Graphics g) {
        if (characterA.getMP() >= 1)
            g.drawImage(MPBarA[characterA.getMP() - 1], GameUtil.widthChange(10), GameUtil.heightChange(25), GameUtil.widthChange(250), GameUtil.heightChange(100), null);
        if (characterB != null && characterB.getMP() >= 1 )
            g.drawImage(MPBarB[characterB.getMP() - 1], GameUtil.widthChange(1275), GameUtil.heightChange(25), GameUtil.widthChange(250), GameUtil.heightChange(100), null);
    }
}
