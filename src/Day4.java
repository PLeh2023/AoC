import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day4 {
    public static int i = 0;
    public static int[] amount = new int[204];

    public static void main(String[] args){
        String[] input =new String[203];
        int summe;
        int anzahl;

        try {
            //Textdatei aufindig machen
            File file = new File("Input4.txt");
            //Lese Textdatei
            FileReader fileReader = new FileReader(file);
            //einzelne Zeilen lesen
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            //lesen der Zeilen bis kein Zeileninhalt vorhanden
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                //Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
                //1;,41,48,83,86,17;83,86,6,31,17,9,48,53
                input[i] = line.replace("Card","").trim().replace(":",";")
                        .replace("|",";").replaceAll("\\s+",",")
                        .replace(",;,",";").replace(";,",";");
                i++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        summe = Addition(input);
        System.out.println(summe);

        anzahl = spezielleAddition(input);
        System.out.println(anzahl);


    }
    private static int Addition(String[] zeilen){
        int summe = 0;

        for(String zeile : zeilen) {
            summe += kartenWert(zeile);
        }

        return summe;
    }
    private static int kartenWert(String zeile) {
            int wert = 0;
            String[] teiler = zeile.split(";");
            String[] ichZahl = teiler[1].split(",");
            String[] gewinnZahl = teiler[2].split(",");

        for (String tmp : ichZahl){
            for (String s : gewinnZahl) {
                if (tmp.equals(s)) {
                    if (wert == 0) {
                        wert = 1;
                    } else {
                        wert *= 2;
                    }
                }
            }
        }
        return wert;
    }
    private static int spezielleAddition(String[] zeilen){
        int summe = 0;
        for(String zeile : zeilen) {
                summe += scratchKartenanzahl(zeile);
        }
        return summe;
    }
    private static int scratchKartenanzahl(String zeile) {
        int wins = 0;
        int gewinne = 0;
        int wiederhohlungen;

        String[] teiler = zeile.split(";");
        String[] ichZahl = teiler[1].split(",");
        String[] gewinnZahl = teiler[2].split(",");

        // checken, ob eine meiner Zahlen mit einer der Gewinn Zahlen übereinstimmt
        for (String tmp : ichZahl){
                for (String s : gewinnZahl) {
                    if (tmp.equals(s)) {
                        if (wins == 0) {
                            wins = 1;
                        } else {
                            wins += 1;
                        }
                    }
                }
        }
            // wiederholungen muss mit +1 im debug gesehen werden
            wiederhohlungen = amount[i];
            //die Anzahl an Scratchkarten wird hier wiedergegeben, um die Gewinne mehrfach zu erhalten
            for(int k = 0; k <=wiederhohlungen; k++) {
                //Scratchkarten werden nach gewinnen einsortiert
                for (int j = 1; j <= wins; j++) {
                    amount[i + j] += 1;

                }
            }
        i++;

        return amount[i]+1;
    }
}
