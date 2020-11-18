import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForApplication {
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4};

        System.out.println("Array by index");
        /*
        Így nézne ki, ha egy tömb elemeit egyesével akarnánk feldolgozni.
        Na most képzeljétek el, hogyha a tömbnek több ezer eleme van, vagy épp nem is tudjuk, hogy mekkora a mérete.
         */
        System.out.println(intArray[0]);
        System.out.println(intArray[1]);
        System.out.println(intArray[2]);
        System.out.println(intArray[3]);

        System.out.println();
        System.out.println("Array with for");
        /*
        Array bejárása for looppal.
        for(változó inicializálás;feltétel;változó módosítása){
            Kód ami lefut minden iteráció során
        }

        Változó inicializálása - Ez fut le először, és ez csak egyszer fut le.
            Jelen esetben létre hozzuk "i" változót, és a 0 értéket adjuk neki (Javaban az indexelés 0-tól kezdődik)
        Feltétel - A feltételt minden iteráció előtt megvizsgálja a Java. Ha a feltétel igaz, lefut a for kódja, ha hamis(sá válik), akkor a loop futása befejeződik
            Ebben az esetben addig fut, amíg az "i" értéke kisebb, mint a tömb mérete.
        Változó módosítása - Ez minden iteráció után lefut.
            "i++" jelen esetben minden iteráció után megnöveli "i" értékét 1-el.
         */
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(i + "-edik elem a tömbben: " + intArray[i]);
        }

        System.out.println();
        System.out.println("Array enhanced with for");
        /*
        Ebben a formában a Java aztomatikusan vigig lépked a tömb minden elemén, az elsőtől az utolsóig, és "elem" változóhoz rendeli az aktuális értéket.
        Ez az egyszerűsített mód akkor alkalmazható, ha a teljes tömbön végig szeretnénk sétálni, és nem érdekel, hogy hanyadik elemet dolgozzuk fel éppen
         */
        for (int elem : intArray) {
            System.out.println("Elem: " + elem);
        }

        //==========================

        List<String> stringList = new ArrayList<>();
        stringList.add("Egy");
        stringList.add("Kettő");
        stringList.add("Három");
        stringList.add("Négy");

        System.out.println();
        System.out.println("List with for - every 2nd item");
        /*
        Lista feldolgozása nagyon hasonló a tömb feldolgozásához.
        0-tól kezdve lépkedünk felfelé, egészen addig, amíg az "i" kisebb, mint a lista elemeinek száma ("list.size()")
        "i += 2" - Az i értékét kettessével növeljük, így csak minden második elem lesz kiírva
         */
        for (int i = 0; i < stringList.size(); i += 2) {
            System.out.println(i + "-edik elem a listában: " + stringList.get(i));
        }

        System.out.println();
        System.out.println("List with enhanced for");
        /*
        Lista bejárása ezzel az egyszerűsített formával ugyanúgy néz ki, mintha tömböt járnánk be.
         */
        for (String elem : stringList) {
            System.out.println("Elem: " + elem);
        }

        //==========================

        Map<Integer, String> intStringMap = new HashMap<>();
        intStringMap.put(1, "Egy");
        intStringMap.put(2, "Kettő");
        intStringMap.put(3, "Három");
        intStringMap.put(4, "Négy");

        System.out.println();
        System.out.println("Map with enchanged for");
        /*
        Map elemeinek bejárása
        map.entrySet() - vissza adja a map név-érték párjait egy Set-ként.
        A Set az majdnem olyan, mint a List, annyi a különbség, egy Set-ben egy elem csak egyszer fordulhat elő.
            Ha ugyanazt az elemet többször adjuk hozzá, akkor a második .add(elem) semmit nem csinál
         */
        for (Map.Entry<Integer, String> entry : intStringMap.entrySet()) {
            System.out.println("Kulcs: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
