import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class Day6 {
    public static void main(String[] args){
        String[] input =new String[2];
        String[] time;
        String[] distance;

        long geschwindigkeit;
        long uebrigeZeit;
        long reichweite;
        long counter = 0;
        long[] moeglichkeiten = new long[4];
        long gesamt = 1;

        try {
            //Textdatei aufindig machen
            File file = new File("Input6.txt");
            //Lese Textdatei
            FileReader fileReader = new FileReader(file);
            //einzelne Zeilen lesen
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            //lesen der Zeilen bis kein Zeileninhalt vorhanden
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                //Time:        35     93     73     66
                //Distance:   212   2060   1201   1044
                //35,93,73,66
                //212,2060,1201,1044
                input[i] = line.replace("Time:","").trim().replace("Distance:","")
                        .trim().replaceAll("\\s+","");
                i++;
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //trennen der Kontextbezogenen Blöcke
        time = input[0].split(",");
        distance =  input[1].split(",");
        //fuer jede Zeit, einmal alles durchlaufen
        for(int k = 0 ; k< time.length;k++) {
            //zaehlen und rechnen
            for (int i = 0; i <= Long.parseLong(time[k]); i++) {
                geschwindigkeit = i;
                uebrigeZeit = Long.parseLong(time[k]) - i;
                reichweite = geschwindigkeit * uebrigeZeit;

                if (reichweite > Long.parseLong(distance[k])) {
                    counter += 1;
                }
            }
            // nur für Teil 1
            //moeglichkeiten[k] = counter;
            // counter = 0;
        }
        //nur für Teil 1
        // for(int j = 0; j < moeglichkeiten.length; j++){
        //    gesamt *= moeglichkeiten[j];
        //}
        System.out.println(counter);

    }
}
