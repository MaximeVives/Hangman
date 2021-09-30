package com.maxime.hangman.Mot;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mot {
    private static final int MAX_COUP = 10;
    private String[] list_word;
    private String[] random_word;
    private String[] mot_cache;
    private Boolean stillPlaying;
    private int numberCoupsRestant;


    public Mot(){
        this.list_word = new String[]{"abruptly",
                "absurd",
                "abyss",
                "affix",
                "askew",
                "avenue",
                "awkward",
                "axiom",
                "azure",
                "bagpipes",
                "bandwagon",
                "banjo",
                "bayou",
                "beekeeper",
                "bikini",
                "blitz",
                "blizzard",
                "boggle",
                "bookworm",
                "boxcar",
                "boxful",
                "buckaroo",
                "buffalo",
                "buffoon",
                "buxom",
                "buzzard",
                "buzzing",
                "buzzwords",
                "caliph",
                "cobweb",
                "cockiness",
                "croquet",
                "crypt",
                "curacao",
                "cycle",
                "daiquiri",
                "dirndl",
                "disavow",
                "dizzying",
                "duplex",
                "dwarves",
                "embezzle",
                "equip",
                "espionage",
                "euouae",
                "exodus",
                "faking",
                "fishhook",
                "fixable",
                "fjord",
                "flapjack",
                "flopping",
                "fluffiness",
                "flyby",
                "foxglove",
                "frazzled",
                "frizzled",
                "fuchsia",
                "funny",
                "gabby",
                "galaxy",
                "galvanize",
                "gazebo",
                "giaour",
                "gizmo",
                "glowworm",
                "glyph",
                "gnarly",
                "gnostic",
                "gossip",
                "grogginess",
                "haiku",
                "haphazard",
                "hyphen",
                "iatrogenic",
                "icebox",
                "injury",
                "ivory",
                "ivy",
                "jackpot",
                "jaundice",
                "jawbreaker",
                "jaywalk",
                "jazziest",
                "jazzy",
                "jelly",
                "jigsaw",
                "jinx",
                "jiujitsu",
                "jockey",
                "jogging",
                "joking",
                "jovial",
                "joyful",
                "juicy",
                "jukebox",
                "jumbo",
                "kayak",
                "kazoo",
                "keyhole",
                "khaki",
                "kilobyte",
                "kiosk",
                "kitsch",
                "kiwifruit",
                "klutz",
                "knapsack",
                "larynx",
                "lengths",
                "lucky",
                "luxury",
                "lymph",
                "marquis",
                "matrix",
                "megahertz",
                "microwave",
                "mnemonic",
                "mystify",
                "naphtha",
                "nightclub",
                "nowadays",
                "numbskull",
                "nymph",
                "onyx",
                "ovary",
                "oxidize",
                "oxygen",
                "pajama",
                "peekaboo",
                "phlegm",
                "pixel",
                "pizazz",
                "pneumonia",
                "polka",
                "pshaw",
                "psyche",
                "puppy",
                "puzzling",
                "quartz",
                "queue",
                "quips",
                "quixotic",
                "quiz",
                "quizzes",
                "quorum",
                "razzmatazz",
                "rhubarb",
                "rhythm",
                "rickshaw",
                "schnapps",
                "scratch",
                "shiv",
                "snazzy",
                "sphinx",
                "spritz",
                "squawk",
                "staff",
                "strength",
                "strengths",
                "stretch",
                "stronghold",
                "stymied",
                "subway",
                "swivel",
                "syndrome",
                "thriftless",
                "thumbscrew",
                "topaz",
                "transcript",
                "transgress",
                "transplant",
                "triphthong",
                "twelfth",
                "twelfths",
                "unknown",
                "unworthy",
                "unzip",
                "uptown",
                "vaporize",
                "vixen",
                "vodka",
                "voodoo",
                "vortex",
                "voyeurism",
                "walkway",
                "waltz",
                "wave",
                "wavy",
                "waxy",
                "wellspring",
                "wheezy",
                "whiskey",
                "whizzing",
                "whomever",
                "wimpy",
                "witchcraft",
                "wizard",
                "woozy",
                "wristwatch",
                "wyvern",
                "xylophone",
                "yachtsman",
                "yippee",
                "yoked",
                "youthful",
                "yummy",
                "zephyr",
                "zigzag",
                "zigzagging",
                "zilch",
                "zipper",
                "zodiac",
                "zombie"};
    }


    public void Game(){
        this.stillPlaying = true;

        while (stillPlaying){
            // Initialisation
            this.setRandom_word();
            this.setMot_cache();
            this.numberCoupsRestant = MAX_COUP;

            while (Arrays.asList(this.mot_cache).contains("_") && this.numberCoupsRestant > 0){
                System.out.println(Arrays.toString(this.mot_cache));
                System.out.println(this.printNumberCoupsRestant());

                String lettre = this.getUserInputs("Entrer une lettre : ");
                boolean isCorrect = this.ReplaceLetter(lettre);

                if (!isCorrect){
                    this.numberCoupsRestant -= 1;
                    System.out.println("Lettre non présente dans le mot, " + this.printNumberCoupsRestant());
                }
                else {
                    System.out.println("Lettre présente dans le mot, " + this.printNumberCoupsRestant());
                }
            }

            this.printEnd();
            this.stillPlaying = this.getUserInputs("Enter (Y) to continue or (E) to exit : ").equals("Y");
        }
    }


    public String getUserInputs(String textToAsk){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n" + textToAsk);

        return scanner.nextLine();

    }

    public boolean ReplaceLetter(String letter){
        boolean atLeastOne = false;
        for (int i = 0; i < this.random_word.length; i++){
            if (this.random_word[i].equals(letter)){
                mot_cache[i] = letter;
                atLeastOne = true;
            }
        }

        return atLeastOne;
    }

    public void printEnd(){
        if (this.numberCoupsRestant <= 0){
            System.out.println("Dommage vous avez perdu, le mot était : " + Arrays.toString(this.random_word));
        }
        else {
            System.out.println("Bravo, vous avez gagné en : " + (MAX_COUP - this.numberCoupsRestant));
        }
    }



    /* GETTER list_word */
    public String[] getList_word() {
        return list_word;
    }
    /*=======================*/

    /* GETTER / SETTER random_word */
    public String[] getRandom_word() {
        return random_word;
    }

    public void setRandom_word() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(this.list_word.length);
        this.random_word = this.list_word[randomIndex].split("");
    }
    /*===========================*/


    /* GETTER / SETTER mot_cache */
    public String[] getMot_cache() {
        return mot_cache;
    }

    public void setMot_cache() {
        String[] mot_cache = new String[this.random_word.length];
        Arrays.fill(mot_cache, "_");
        this.mot_cache = mot_cache;
    }

    /*==============================*/


    /* SETTER stillPlaying */

    public void setStillPlaying(Boolean stillPlaying) {
        this.stillPlaying = stillPlaying;
    }

    /*==============================*/

    /* GETTER numberCoupRestant*/

    public int getNumberCoupsRestant() {
        return numberCoupsRestant;
    }

    public String printNumberCoupsRestant() {
        return "Nombre de coups restant : " + this.numberCoupsRestant;
    }
    /*==============================*/

}