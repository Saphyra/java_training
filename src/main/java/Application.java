import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<String>();
        Map<String, String> map = new HashMap<>();
        lista.add("asd");
        lista.add("aedfea");
        lista.add("wsfgrweg");

        lista.get(0);

        for (String o : lista) {
        }

        Doboz<String> doboz = Doboz.letrehoz("érték");
        String ertek = doboz.getErtek();
    }

    private static void printLista(List lista) {

    }
}
