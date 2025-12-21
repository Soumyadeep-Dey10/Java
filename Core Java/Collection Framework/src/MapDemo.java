import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Cole");
        map.put(2, "Reece");
        map.put(3, "Joao");

        for(String name: map.values()){
            System.out.println(name);
        }
        for(int key: map.keySet()){
            System.out.println(key+" "+map.get(key));
        }

        for (Map.Entry<Integer, String > entry : map.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
