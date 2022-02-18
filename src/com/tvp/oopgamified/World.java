package com.tvp.oopgamified;

public class World {
    static int day;
    static Tree[] trees;
    static Player player;

    public static void start(){
        player = new Player();

        setUpTree();
    }

    private static void setUpTree(){
        trees = new Tree[1];
        trees[0] = new Tree();
        trees[0].age = 2;
        trees[0].gold = false;
        trees[0].name = "Fruit tree";
        trees[0].sapling = false;
    }

    public static void newTree(Tree tree){
        System.out.println(tree);

        int newTreeCount = World.trees.length + 1;
        Tree[] tempTrees = new Tree[newTreeCount];

        int i = 0;
        for(Tree oldTree : World.trees){
            tempTrees[i] = oldTree;
            i++;
        }

        tempTrees[newTreeCount - 1] = tree;
        tempTrees[newTreeCount - 1 ].sapling = false;
        if(tempTrees[newTreeCount - 1].gold){
            tempTrees[newTreeCount - 1 ].name = "Golden Fruit Tree";
        } else {
            tempTrees[newTreeCount - 1 ].name = "Fruit Tree";
        }
        tempTrees[newTreeCount - 1].age = 1;

        World.trees = tempTrees;
    }

    public static void nextDay(){
        World.day++;
        Tree.grow();
    }
}
