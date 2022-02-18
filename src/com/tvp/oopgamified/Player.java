package com.tvp.oopgamified;

public class Player {
    String name;
    double money = 0;
    int level = 0;
    int babyTreeChan = 45;
    Object[] items = new Object[0];

    private void newItem(Object item){
        int newItemCount = items.length + 1;
        Object[] tempItems = new Object[newItemCount];

        int i = 0;
        for(Object oldItem : World.player.items){
                tempItems[i] = oldItem;
            i++;
        }

        tempItems[newItemCount - 1] = item;
        World.player.items = tempItems;
    }

    private void removeItem(int index){
        int newItemCount = items.length - 1;
        Object[] tempItems = new Object[newItemCount];


        for( int i = 0; i < newItemCount; i++){
            int tempIndex = i == 0 ? 0 : i - 1;
            if(i != index){
                tempItems[tempIndex] = World.player.items[i];
            }
        }
        World.player.items = tempItems;
    }

    public void harvest(){
        Boolean harvested = false;
        for (Tree tree : World.trees) {
            if(tree.age >= 3){
                for (Fruit fruit : tree.fruits){
                    newItem(fruit);
                }

                if(GameMath.getPercent() <= babyTreeChan){
                    newItem(Tree.getSapling());
                }

                tree.age = 1;
                tree.fruits = null;
                harvested = true;
            }
        }

        if(!harvested){
            System.out.println("there was no trees to harvest.");
        } else {
            System.out.println("You had a good harvest.");
        }
    }

    public void showTrees(){
        if(World.trees != null){
            int goldTrees = 0;
            int avgAge;
            int totalAge = 0;
            int avgGoldAge;
            int totalGoldAge = 0;

            for( Tree tree : World.trees){
                if(tree.gold){
                    goldTrees++;
                    totalGoldAge += tree.age;
                } else {
                    totalAge += tree.age;
                }
            }

            avgAge = totalAge / (World.trees.length - goldTrees);
            showTree(avgAge, World.trees.length - goldTrees , false);

            if(goldTrees >= 1){
                avgGoldAge = totalGoldAge / goldTrees;
                showTree(avgAge, totalGoldAge , true);

            }


        } else{
            System.out.println(GameSystem.errorTree);
        }
    }

    private static void showTree(int avg, int totalTrees, boolean gold){
        if(avg >= 3){
            System.out.println(GameSystem.fruitTree);
            System.out.println("Tree avg age: " + avg);
            System.out.println("Total trees : " + totalTrees);
            if(gold){
                System.out.println("Tree type: Golden Fruit Tree");
            } else {
                System.out.println("Tree type: Fruit Tree");
            }
        } else {
            System.out.println(GameSystem.emptyTree);
            System.out.println("Tree avg age: " + avg);
            System.out.println("Total trees : " + totalTrees);
            if(gold){
                System.out.println("Tree type: Golden Fruit Tree");
            } else {
                System.out.println("Tree type: Fruit Tree");
            }
        }

    }

    public void sell(){
        int i = 0;
        int fruits = 0;
        for(Object item : World.player.items){
            if(item instanceof Fruit){
                World.player.money += sellQualityPrice(((Fruit) item).quality, ((Fruit) item).gold);
                removeItem(i);
                fruits++;
            }
            i++;
        }

        System.out.println("You sold x" + fruits + " fruits.");
    }

    private double sellQualityPrice(int quality, boolean gold){
        double price = 0;
        double multi = gold == true ? Prices.goldMulti : 1;
        switch (quality){
            case 1:
                price = Prices.low * multi;
                break;
            case 2:
                price = Prices.mid * multi;
                break;
            case 3:
                price = Prices.high * multi;
                break;
        }
        return GameMath.roundMoney(price);
    }

    public void inventory(){
        if(World.player.items.length >= 1){
            for(Object item : World.player.items){
                System.out.println(item);
            }
        } else {
            System.out.println("You don't have any items to show.");
        }

    }

    private void showItem(Object item){

    }

    public void plant(){
        boolean sapling = false;
        int i = 0;
        int saplingsCount = 0;

        for(Object item : World.player.items){
            if( item instanceof Tree){
                removeItem(i);
                World.newTree((Tree) item);
                saplingsCount++;
                sapling = true;
            }
            i++;
        }

        if (!sapling){
            System.out.println("You do not have any saplings.");
        } else{
            System.out.println("Planted " + saplingsCount + " tree(s).");
        }
    }

    public void levelUp(){

    }

    public void sleep(){
        World.nextDay();
        System.out.println("You Slept well.");
    }

}