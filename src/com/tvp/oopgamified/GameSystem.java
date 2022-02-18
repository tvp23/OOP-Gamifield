package com.tvp.oopgamified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class GameSystem {
    //ascii art
    static String startMessage = " _______  _______  _______    _______  _______  _______ _________ _______ _________ _______  _        ______  \n" + "(  ___  )(  ___  )(  ____ )  (  ____ \\(  ___  )(       )\\__   __/(  ____ \\\\__   __/(  ____ \\( \\      (  __  \\ \n" + "| (   ) || (   ) || (    )|  | (    \\/| (   ) || () () |   ) (   | (    \\/   ) (   | (    \\/| (      | (  \\  )\n" + "| |   | || |   | || (____)|  | |      | (___) || || || |   | |   | (__       | |   | (__    | |      | |   ) |\n" + "| |   | || |   | ||  _____)  | | ____ |  ___  || |(_)| |   | |   |  __)      | |   |  __)   | |      | |   | |\n" + "| |   | || |   | || (        | | \\_  )| (   ) || |   | |   | |   | (         | |   | (      | |      | |   ) |\n" + "| (___) || (___) || )        | (___) || )   ( || )   ( |___) (___| )      ___) (___| (____/\\| (____/\\| (__/  )\n" + "(_______)(_______)|/         (_______)|/     \\||/     \\|\\_______/|/       \\_______/(_______/(_______/(______/ \n" + "                                                                                                              ";
    static String errorAction = "That is not a legal action.";
    static String emptyTree = "                            '.,\n" + "                              'b      *\n" + "                               '$    #.\n" + "                                $:   #:\n" + "                                *#  @):\n" + "                                :@,@):   ,.**:'\n" + "                      ,         :@@*: ..**'\n" + "                       '#o.    .:(@'.@*\"'\n" + "                          'bq,..:,@@*'   ,*\n" + "                          ,p$q8,:@)'  .p*'\n" + "                         '    '@@Pp@@*'\n" + "                               Y7'.'\n" + "                              :@):.\n" + "                             .:@:'.\n" + "                           .::(@:.      -Empty-";
    static String fruitTree = "                     ; ; ;\n" + "                   ;        ;  ;     ;;    ;\n" + "                ;                 ;         ;  ;\n" + "                                ;\n" + "                               ;                ;;\n" + "               ;          ;            ;              ;\n" + "               ;            ';,        ;               ;\n" + "               ;              'b      *\n" + "                ;              '$    ;;                ;;\n" + "               ;    ;           $:   ;:               ;\n" + "             ;;      ;  ;;      *;  @):        ;   ; ;\n" + "                          ;     :@,@):   ,;**:'   ;\n" + "              ;      ;,         :@@*: ;;**'      ;   ;\n" + "                       ';o;    ;:(@';@*\"'  ;\n" + "               ;  ;       'bq,;;:,@@*'   ,*      ;  ;\n" + "                          ,p$q8,:@)'  ;p*'      ;\n" + "                   ;     '  ; '@@Pp@@*'    ;  ;\n" + "                    ;  ; ;;    Y7'.'     ;  ;\n" + "                              :@):.\n" + "                             .:@:'.\n" + "                           .::(@:.      -Harvestable-";
    static String sapling = "   |\n" + " .'|'.\n" + "/.'|\\ \\\n" + "| /|'.|\n" + " \\ |\\/\n" + "  \\|/\n" + "   `";

    //game messages
    static String errorTree = "there are no trees.";

    public static void start(){
        System.out.println(GameSystem.startMessage);
        World.start();
    }

    private static void clear(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void playerAction(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String action = null;
        System.out.print("Enter your action: ");

        try {
            action = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        processPlayerAction(action);
    }

    public static boolean confirm(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        System.out.print("Are you sure you want to stop? Y/N: ");

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input.toLowerCase(Locale.ROOT).equals("y");
    }

    private static void processPlayerAction(String action){
        switch(action) {
            case "clear":
                clear();
                playerAction();
                break;
            case "stop":
                if(confirm()){
                    System.out.println("Stopping...");
                }
                else{
                    playerAction();
                }
                break;
            case "harvest":
                clear();
                World.player.harvest();
                playerAction();
                break;
            case "trees":
                clear();
                World.player.showTrees();
                playerAction();
                break;
            case "sleep":
                clear();
                World.player.sleep();
                World.player.showTrees();
                playerAction();
            case "inv":
                clear();
                World.player.inventory();
                playerAction();
                break;
            case "plant":
            World.player.plant();
            playerAction();
                break;
            case "sell":
                World.player.sell();
                playerAction();
                break;
            default:
                System.out.println(errorAction);
                playerAction();
        }
        System.out.println("\n");
    }
}

class Prices{
    static int low = 1;
    static int mid = 5;
    static int high = 10;
    static double goldMulti = 1.5;
}