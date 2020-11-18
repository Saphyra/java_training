import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elso szam:");
        Integer szam1 = scanner.nextInt();

        System.out.println("Operandus:");
        String operand = new Scanner(System.in).nextLine();

        System.out.println("Masodik szam:");
        Integer szam2 = scanner.nextInt();

        System.out.println("Ezt muveletet fogjuk elvegezni: " + szam1 + " " + operand + " " + szam2);

        /*
        condition - Bármilyen boolean érték (igaz/hamis)

        if(condition){
            Ez a kód rész fog lefutni, ha condition igaz
        }else if(anotherCondition){
            Ez a kód rész fog lefutni, ha condition hamis, de anotherCondition igaz
        }else{
            Ez a kód rész fog lefutni, ha condition és anotherCondition is hamis
        }

        Az else if és au else rész elhagyható
         */
        Double eredmeny = null;
        if ("+".equals(operand)) {
            eredmeny = (double) szam1 + szam2;
        } else if ("-" == operand) {
            /*
            Figyeld meg, hogy a "+"-nál a .equals() metódust használtuk, itt pedig dupla egyenlőségjelet.
            ==-vel hasonlítunk össze primitíveket, és enumokat
            .equals()-al minden mást (tehát általában ez a preferált)

            Oka:
            az "==" azt vizsgálja, hogy a két változó referenciája ugyanarra a pontra mutat-e a memóriában
            a .equals() azt vizsgálja, hogy a két objektum tartalmilag megegyezik-e.
             */
            eredmeny = (double) szam1 - szam2;
        } else if ("*".equals(operand)) {
            eredmeny = (double) szam1 * szam2;
        } else {
            System.out.println("Ismeretlen operandus: " + operand);
        }

        System.out.println("Eredmeny: " + eredmeny);

        if (szam1 <= 0) {
            System.out.println("Ez egy kis szám");
        }

        /*
        Feltétel több részből is állhat.
        && - "És" kapcsolat. A teljes feltétel akkor igaz, ha minden része igaz
        || - "Vagy" kapcsolat. A teljes feltétel akkor igaz, ha az egyik része igaz.
         */
        if (szam1 < 0 && szam2 < 0) {
            System.out.println("Mindkét szám kisebb mint 0");
        }

        if (szam1 < 0 || szam2 < 0) {
            System.out.println("Az egyik szám kisebb mint 0");
        }

        //============================
        /*
        Különbség &&/& és ||/| között
        Ha a dupla formát használjuk, akkor a Java abba hagyja a feltétel többi részének a vizsgálatát, amennyiben 100%-ra tudja a feltétel eredményét.
        Ha a szimpla formát használjuk, akkor garantáltan megvizsgálja az összes rész eredményét, függetlenül attól, hogy már tudja az eredményt.
         */
        System.out.println("Teszt &&");
        /*
         * Itt az igaz() nem fog lefutni, mivel ha az "És" kapcsolat első fele hamis, akkor az eredmény is garantáltan hamis, ezért a Java abba hagyja a vizsgálatot
         */
        if (hamis() && igaz()) {
            System.out.println("Ennek nem szabad kiíródnia");
        }

        System.out.println("Teszt &");
        /*
         * Itt az igaz() le fog futni, mivel csak egy "&" jelet írtunk, hiába tudható az eredmény.
         */
        if (hamis() & igaz()) {
            System.out.println("Ennek nem szabad kiíródnia");
        }

        System.out.println("Teszt ||");
        /*
        Itt a hamis() nem fog lefutni, mivel a feltétel első részének vizsgálata pozitív eredményt adott, tehát tudható, hogy a teljes feltétel eredménye is igaz lesz.
         */
        if (igaz() || hamis()) {
            System.out.println("Az egyik feltétel igaz volt");
        }

        /*
        Itt a hamis() lefut, mert csak a szimpla "|"-t használtuk, hiába tudható előre az eredmény
         */
        System.out.println("Teszt |");
        if (igaz() | hamis()) {
            System.out.println("Az egyik feltétel igaz volt");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Double eredmeny2 = null;
        /*
        case(bemenet){
            case ertek1:
                Ez a kód akkor fog lefutni, hogyha "bemenet" megegyezik "ertek1"-el
                break;
            case ertek2:
                Ez a kód akkor fog lefutni, hogyha "bemenet" megegyezik "ertek2"-el
                break;
            default:
                Ez a kód akkor fog lefutni, hogyha a "bemenet" nem egyezik egyik case értékével sem
        }

        a case-k és a default is elhagyható
         */
        switch (operand) {
            case "+":
                eredmeny2 = (double) szam1 + szam2;
                break;
            case "-":
                eredmeny2 = (double) szam1 - szam2;
                break;
            default:
                System.out.println("Ismeretlen operandus: " + operand);
        }
        System.out.println("Switch eredmeny: " + eredmeny2);

        Double eredmeny3 = null;
        switch (operand) {
            case "+":
                eredmeny3 = (double) szam1 + szam2;
                /*
                Figyeld meg, hogy itt kimaradt a "break". Ebben az esetben a kód tovább fut (attól függetlenül, hogy az "operand" nem egyezik meg "-"-al) egészen addig,
                amíg eléri a következő break-et, vagy vége a switch-nek
                 */
            case "-":
                eredmeny3 = (double) szam1 - szam2;
                break;
            default:
                System.out.println("Ismeretlen operandus: " + operand);
        }
        /*
        Jelen esetben ha összeadást írsz be, akkor is a kivonás eredménye fog megjelenni, mivel a break hiánya miatt "+" esetén is lefut a "-", felül írva az összeadás eredményét
         */
        System.out.println("Hibás Switch eredmeny: " + eredmeny3);

        System.out.println();
        System.out.println("Írj be valamit!");
        String bemenet = new Scanner(System.in).nextLine();
        /*
        Tenary operator:
        eredmeny = feltetel ? Pozitiv eredmeny : Negativ eredmeny

        Ha a feltétel igaz, akkor a visszatérési érték (eredmény értéke) a ":" bal oldalán feltüntetett érték lesz, ha a feltétel hamis, akkor pedig a ":" jobb oldalán feltüntetett érték.
         */
        boolean hosszabbMintHarom = bemenet.length() > 3;
        String eredmeny4 = hosszabbMintHarom ? "A beírt szöveg 3 karakternél hosszabb" : "A beírt szöveg 3 karakternél nem hosszabb";
        System.out.println(eredmeny4);

        /*
        Ez ugyanaz, csak ifekkel. A tenary operator egy if-else struktúrát helyettesít, egyszerűbb formában.
        Egyszerű műveleteknél érdemes csak a tenary operator alkalmazása mellett dönteni, mivel a bonyolult feltételek olvashatatlanná tehetik a kódot.
         */
        if (hosszabbMintHarom) {
            System.out.println("A beírt szöveg 3 karakternél hosszab");
        } else {
            System.out.println("A beírt szöveg 3 karakternél nem hosszab");
        }
    }

    private static boolean igaz() {
        System.out.println("Az igaz meg lett hívva");
        return true;
    }

    private static boolean hamis() {
        System.out.println("A hamis meg lett hívva");
        return false;
    }
}
