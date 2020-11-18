public class BreakingLoopApplication {
    public static void main(String[] args) {
        /*
        while(true){
        }

        Végtelen ciklus, fut az idők végezetéig
         */
        int counter = 0;
        while (true) {
            counter++; //Minden egyes ciklusban megnöveli counter értékét 1-el

            System.out.println("Counter: " + counter);

            if (counter > 10) {
                /*
                Viszont ha a counter értéke túllépi a 10-et, akkor a "break" parancs megakasztja a futást.

                A "break" azonnal abbahagyja az adott loop végrehajtását.
                 */
                break;
            }
        }

        /*
        Egy for ciklussal elszámolunk egyesével 100-ig, mivel:
            "i" 0-val kezd
            addig fut a loop, amig i < 100
            "i" értékét minen futás után megnöveljük egyel
         */
        for(int i = 0; i < 100; i++){
            /*
            szám % osztó = maradékos osztás maradéka
             */
            int maradek = i % 2;
            /*
            Ha 2-vel elosztjuk a számot, és a maradék "0" (tehát a szám páros)
             */
            if (maradek == 0) {
                /*
                A "continue" parancs abban különbözik a "break"-tól, hogy nem az egész ciklus futását hagyja abba, hanem csak az adott lépését.
                Tehát ha "i" páros szám, akkor itt instant a következő iterációra ugrik, és a System.out.println nem fut le ebben az iterációban.
                Eredmény: Kiírjuk 0-100-ig a páratlan számokat
                 */
                continue;
            }

            System.out.println("Index: " + i);
        }
    }
}
