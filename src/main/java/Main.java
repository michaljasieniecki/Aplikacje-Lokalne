import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Download download = new Download("https://2k4k.pl/kategoria-produktu/kamery/");
        Download download2 = new Download("https://2k4k.pl/kategoria-produktu/kamery/page/2/");
        Download download3 = new Download("https://2k4k.pl/kategoria-produktu/kamery/page/3/");
        Download download4 = new Download("https://2k4k.pl/kategoria-produktu/kamery/page/4/");
        Download download5 = new Download("https://2k4k.pl/kategoria-produktu/kamery/page/5/");
        ArrayList<String> nazwa = new ArrayList<>();
        ArrayList<String> cena = new ArrayList<>();

        for(int i = 0; i<12; i++) {
            nazwa.add(download.content(".name", i));
            cena.add(download.content(".price", i));
        }
        for(int i = 0; i<12; i++) {
            nazwa.add(download2.content(".name", i));
            cena.add(download2.content(".price", i));
        }
        for(int i = 0; i<12; i++) {
            nazwa.add(download3.content(".name", i));
            cena.add(download3.content(".price", i));
        }
        for(int i = 0; i<12; i++) {
            nazwa.add(download4.content(".name", i));
            cena.add(download4.content(".price", i));
        }
        for(int i = 0; i<12; i++) {
            nazwa.add(download5.content(".name", i));
            cena.add(download5.content(".price", i));
        }
        File file = new File("kamery.txt");
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
            for(int i = 0; i < nazwa.size(); i++){
                writer.append(nazwa.get(i)+"\n");
                writer.append(cena.get(i)+"\n");
                writer.append("__________________________________\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
