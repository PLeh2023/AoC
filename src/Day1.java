import java.io.*;

public class Day1 {
    public static void main(String[] args){
        //Definition allgemeiner Variablen
        String[] input =new String[1000];
        int summe;

        try {
            //Textdatei aufindig machen
            File file = new File("Input.txt");
            //Lese Textdatei
            FileReader fileReader = new FileReader(file);
            //einzelne Zeilen lesen
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            //lesen der Zeilen bis kein Zeileninhalt vorhanden
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {

                input[i] = line .replace("one","o1e").replace("two","t2o")
                                .replace("three","thr3e").replace("four","fo4r")
                                .replace("five","fi5e").replace("six","s6x")
                                .replace("seven","se7en").replace("eight","eig8t")
                                .replace("nine","ni9e");
                i++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        summe = addieren(input);
        System.out.println(summe);

    }
    //Additionsmethode von den mehreren Strings
    private static int addieren(String[] zeilen){
        //Lokale Variable
        int addition = 0;
        //Foreach Schleife, die so lange läuft bis alle Strings des Inputs durchlaufen sind
        for(String zeile : zeilen){
            addition +=zahlenFinder(zeile);
        }
        return addition;
    }
    //Additionsmethode von einem String
    private static int zahlenFinder(String zeile){
        String neuInput = "";
        //Lokale Variablen
        char Zahl1 ='\0';
        char Zahl2 ='\0';

        //Foreach Schleife, die die erste Zahl findet und merkt und dann alle weiteren Zahlen überschreibt bis zur letzten
        for(char tmp : zeile.toCharArray()){
            if(Character.isDigit(tmp)){
                if(Zahl1 == '\0'){
                    Zahl1 = tmp;
                }
                Zahl2 = tmp;
            }
        }
        int additionEinzel = 0;

            additionEinzel = Integer.parseInt("" + Zahl1 + Zahl2);

        return additionEinzel;
    }

}