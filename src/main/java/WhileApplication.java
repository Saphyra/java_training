import java.util.Random;

public class WhileApplication {
    public static void main(String[] args) {
        System.out.println("While");
        /*
        while(condition){
            tartalom
        }

        A "tartalom" kód egészen addig fut egymás után, amíg a "condition" igaz.

        Jelen esetben egészen addig, amíg egy olyan számot dob ki a random generátor, ami nem kisebb, mint 0.8
         */
        double szam = 0;
        while (szam < 0.8) {
            System.out.println("Szam: " + szam);
            szam = new Random().nextDouble();
            System.out.println("Uj Szam: " + szam);
        }

        System.out.println();
        System.out.println("Do...While");
        /*
        do{
            tartalom
        }while(condition);

        A "tartalom" lefut, és ha "condition" igaz, akkor újra és újra

        Itt a szam2 hiába nagyobb, mint 0.8, a random generátor ezt felül írhatja, és ha egy olyan szám jön ki, ami 0.8-nál kisebb, akkor újra és újra
         */
        double szam2 = 2;
        do {
            szam2 = new Random().nextDouble();
            System.out.println("Szam2: " + szam2);
        } while (szam2 < 0.8);
    }
}
