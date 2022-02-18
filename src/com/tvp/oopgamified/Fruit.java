package com.tvp.oopgamified;

public class Fruit {
    int quality;
    boolean gold;

    public static Fruit getFruit(boolean goldenTree){
        Fruit fruit = new Fruit();
        fruit.quality = GameMath.random(1,3);
        fruit.gold = goldenTree;
        return fruit;
    }
}
