package com.game.util;

import java.awt.*;

public class GameUtil {
    public static Image getImage(String imagePath) {
        try {
            return Toolkit.getDefaultToolkit().getImage(imagePath);
        } catch (Exception e) {
            System.out.println("Can't open" + imagePath);
            System.out.println("WrongImageName!");
            return null;
        }
    }

    public static int widthChange(int size) {
        double x = Constant.deviceWidth / 1536.0;
        return (int) (x * size);
    }

    public static int heightChange(int size) {
        double x = Constant.deviceHeight / 864.0;
        return (int) (x * size);
    }

    public static boolean keyChange(int key) {
        if (key != Constant.jumpA && key != Constant.leftA && key != Constant.rightA && key != Constant.attackA && key != Constant.shockWaveA) {
            return key != Constant.jumpB && key != Constant.leftB && key != Constant.rightB && key != Constant.attackB && key !=Constant.shockWaveB;
        }
        return false;
    }
    public static String keyName(int key) {
        if(key >= 65 && key <= 90 || key >=48 && key <= 57)
            return Character.toString((char)key);
        else if(key >=96 && key <= 105)
            return Character.toString((char)(key-48));
        else if(key == 8) return "BackSpace";
        else if(key == 9) return "Tab";
        else if(key == 13) return "Enter";
        else if(key == 16) return "Shift";
        else if(key == 17) return "Control";
        else if(key == 18) return "Alt";
        else if(key == 20) return "Cape Lock";
        else if(key == 27) return "Esc";
        else if(key == 32) return "Space";
        else if(key == 37) return "Left";
        else if(key == 38) return "Up";
        else if(key == 39) return "Right";
        else if(key == 40) return "Down";
        else return null;
    }
}
