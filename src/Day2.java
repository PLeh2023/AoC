import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day2 {
    public static void main(String[] args){
       String[] input = new String[100];
        try {
            //Textdatei aufindig machen
            File file = new File("Input2.txt");
            //Lese Textdatei
            FileReader fileReader = new FileReader(file);
            //einzelne Zeilen lesen
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            //lesen der Zeilen bis kein Zeileninhalt vorhanden
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                //"Game 1: 14 green, 8 blue, 9 red; 5 blue, 4 green, 2 red; 4 red, 4 blue, 4 green; 1 blue, 3 green, 2 red; 10 red, 3 blue, 15 green; 2 red, 6 green, 3 blue"
                //"1;14g;8b;9r;5b;4g;2r;4r;4b;4g;1b;3g;2r;10r;3b;15g;2r;6g;3b"
                input[i] = line.replace(",",";").replace("Game","")
                        .replace(":",";").replace("green","g")
                        .replace("red","r").replace("blue","b")
                        .replaceAll("\\s+","").trim();
                i++;
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int value = Addition(input);
        System.out.println(value);

        int value2 = Multiplikation(input);
        System.out.println(value2);
    }
    private static int Addition (String[] zeilen){
        int summe = 0;
        for(String zeile: zeilen) {
            summe += SpielID(zeile);
        }
        return summe;
    }
    private static int Multiplikation(String[] zeilen){
        int produkt = 0;
        for(String zeile: zeilen) {
            produkt += anzahlWuerfel(zeile);
        }
        return produkt;
    }
    //suche 12 red, 13 green, 14 blue
    private static int SpielID(String zeile){
        char zahl1;
        char zahl2;
        int vergleich = 0;
        boolean red = true , green = true , blue = true;
        //Auftrennen des Strings
        String[] farbe = zeile.split(";");
        //erste String zelle für Game Tracker nehmen
        String game = farbe[0];
        //der Game Tracker
        int Game = Integer.parseInt(game);
        //für jedes String Element wird gescheckt nach Farbe und dann nach Nummer
        for(int j = 0; j < farbe.length; j++) {
            if (farbe[j].contains("b")) {
                if (farbe[j].length() == 2) {
                    zahl1 = farbe[j].charAt(0);
                    vergleich = Integer.parseInt(""+zahl1);
                }
                if (farbe[j].length() == 3) {
                    zahl1 = farbe[j].charAt(0);
                    zahl2 = farbe[j].charAt(1);
                    vergleich =Integer.parseInt("" +zahl1 + zahl2);
                }
                //Endgültigkeit gewährleisten
                if (vergleich <= 14) {
                    if(blue) {
                        blue = true;
                    }
                }else{
                    if(blue) {
                        blue = false;
                    }
                }
            } else if (farbe[j].contains("g")) {
                if (farbe[j].length() == 2) {
                    zahl1 = farbe[j].charAt(0);
                    vergleich =Integer.parseInt("" +zahl1);
                }
                if (farbe[j].length() == 3) {
                    zahl1 = farbe[j].charAt(0);
                    zahl2 = farbe[j].charAt(1);
                    vergleich =Integer.parseInt("" +zahl1 + zahl2);
                }
                if (vergleich <= 13) {
                    if(green) {
                        green = true;
                    }
                }else{
                    if(green) {
                        green = false;
                    }
                }
            } else if (farbe[j].contains("r")) {
                if (farbe[j].length() == 2) {
                    zahl1 = farbe[j].charAt(0);
                    vergleich =Integer.parseInt("" +zahl1);
                }
                if (farbe[j].length() == 3) {
                    zahl1 = farbe[j].charAt(0);
                    zahl2 = farbe[j].charAt(1);
                    vergleich =Integer.parseInt("" +zahl1 + zahl2);
                }
                if (vergleich <= 12) {
                    if(red) {
                        red = true;
                    }
                }else{
                    if(red) {
                        red = false;
                    }
                }
            }
        }
        //zwei Fälle entweder spiel gültig oder nicht
        if(red && blue && green){
            return Game;
        }else {
            return 0;
        }
    }
    private static int anzahlWuerfel(String zeile){
        char zahl1;
        char zahl2;
        int grossteZahlR = 0,grossteZahlG = 0,grossteZahlB = 0;
        int vergleich = 0;
        //Auftrennen des Strings
        String[] farbe = zeile.split(";");
        //erste String zelle für Game Tracker nehmen
        String game = farbe[0];
        //der Game Tracker
        int Game = Integer.parseInt(game);
        //für jedes String Element wird gescheckt nach Farbe und dann nach Nummer
        for(int j = 0; j < farbe.length; j++) {
            if (farbe[j].contains("b")) {
                if (farbe[j].length() == 2) {
                    zahl1 = farbe[j].charAt(0);
                    vergleich = Integer.parseInt(""+zahl1);
                }
                if (farbe[j].length() == 3) {
                    zahl1 = farbe[j].charAt(0);
                    zahl2 = farbe[j].charAt(1);
                    vergleich =Integer.parseInt("" +zahl1 + zahl2);
                }
                //vergleich größte Zahl und übernahme
                if(vergleich > grossteZahlB){
                    grossteZahlB = vergleich;
                }
            } else if (farbe[j].contains("g")) {
                if (farbe[j].length() == 2) {
                    zahl1 = farbe[j].charAt(0);
                    vergleich =Integer.parseInt("" +zahl1);
                }
                if (farbe[j].length() == 3) {
                    zahl1 = farbe[j].charAt(0);
                    zahl2 = farbe[j].charAt(1);
                    vergleich =Integer.parseInt("" +zahl1 + zahl2);
                }
                if(vergleich > grossteZahlG){
                    grossteZahlG = vergleich;
                }
            } else if (farbe[j].contains("r")) {
                if (farbe[j].length() == 2) {
                    zahl1 = farbe[j].charAt(0);
                    vergleich = Integer.parseInt("" + zahl1);
                }
                if (farbe[j].length() == 3) {
                    zahl1 = farbe[j].charAt(0);
                    zahl2 = farbe[j].charAt(1);
                    vergleich = Integer.parseInt("" + zahl1 + zahl2);
                }
                if(vergleich > grossteZahlR){
                    grossteZahlR = vergleich;
                }
            }
        }
        return grossteZahlR * grossteZahlG * grossteZahlB;
    }
}
