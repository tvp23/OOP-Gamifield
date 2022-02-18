package com.tvp.oopgamified;

public class Tree {
    String name;
    boolean gold;
    boolean sapling;
    int age = 1;
    static int goldRate = 1;
    Fruit[] fruits;

    public static void grow(){
        if(World.trees != null){
            for(Tree tree : World.trees){
                tree.age++;
                if(tree.age >= 3){
                    int fruitCount = GameMath.random(1, 6);
                    tree.fruits = new Fruit[fruitCount];
                    for (int i = 0; i < fruitCount; i++){
                        tree.fruits[i] = Fruit.getFruit(tree.gold);
                    }
                }
            }
        }

    }

    public static Tree getSapling(){
        Tree sapling = new Tree();
        sapling.sapling = true;

        if(GameMath.getPercent() < goldRate){
            sapling.gold = true;
        }

        if(sapling.gold == true){
            sapling.name = "Golden Fruit Sapling";
        } else{
            sapling.name = "Fruit Sapling";
        }

        return sapling;
    }
}