import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class Download{
    private Document document = null;

    public Download(String url){
        try{
            this.document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Element page(){
        return this.document.getAllElements().first();
    }
    public String content(String cQ, int i){
        return page().select(cQ).get(i).text();
    }
    @Override
    public String toString() {
        return "Download{" +
                "document=" + document +
                '}';
    }
}