package com.tvp.oopgamified;

import java.util.Random;

public class GameMath {
    public static int random(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return  result;
    }
    public static int getPercent(){
        Random r = new Random();
        return r.nextInt(100-0) + 0;
    }

    public static double roundMoney(double money){
        return Math.round(money * 100.0) / 100.0;
    }
}
