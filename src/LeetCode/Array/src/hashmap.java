import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class hashmap {
    HashMap<String, String> dic =new HashMap<String, String> ();
    FileReader in = new FileReader("data.txt");
    BufferedReader reader = new BufferedReader( in );

    String line, key, value;
    int cutindex;
    while((line = reader.readLine()) != null){
        cutindex =  line.indexOf(",");
        key = line.substring(0, cutindex);
        value = line.substring(cutindex + 1, line.length());
        dic.put(key, value);
        dic.put(value, key);
    }
}
