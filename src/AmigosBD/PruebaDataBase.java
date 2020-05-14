package AmigosBD;

import java.util.HashMap;

public class PruebaDataBase {
    public static void main(String[] args) {
        HashMap<String, String> bases = new HashMap();
        bases.put("Amigos", "jdbc:mysql://localhost:3306/FRIENDS");
        bases.put("Test", "jdbc:mysql://localhost:3306/test");
        
        new Gui(bases);
    }
}
