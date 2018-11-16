/* author : @aashish
 * time: 02:47:18TO04/30/2018*/
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class test {
    static Set<String> set = new TreeSet<>();
    static List<String> name = new ArrayList<>();
    static long totalPg=-1;
    static String inline="";

    static void getData(String substr,long pg) throws IOException {
        URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page="+pg);
        HttpURLConnection conn =(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if(conn.getResponseCode() ==200){
            Scanner sc = new Scanner(url.openStream());
            while(sc.hasNext()){
                inline += sc.nextLine();
            }
        }
    }
    static ArrayList<String> getMovieTitles(String substr) throws IOException, ParseException {
        long pg = 1;
        getData(substr,pg);
        if(inline!=null|| inline !=""){
            addToListt(inline);

            for(long it=1; it <= totalPg;it++){
                inline ="";
                getData(substr,it);
                addToListt(inline);
            }
        }
        return new ArrayList<String>(set);
    }

    static void addToListt(String inline) throws ParseException {
        JSONParser j= new JSONParser();
        JSONObject obj = (JSONObject) j.parse(inline);
        if(totalPg ==-1){
            totalPg =(Long)obj.get("per_page");
        }
        List<Object> data = (List)obj.get("data");
        for(int i =0; i < data.size(); i++){
            JSONParser k= new JSONParser();
            JSONObject jl = (JSONObject) j.parse(String.valueOf(data.get(i)));
            set.add(String.valueOf(jl.get("Title")));
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<String> a =getMovieTitles("spiderman");
        for(String s : a){
            System.out.println(s);
        }
    }
}
