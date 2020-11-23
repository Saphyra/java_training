import exception.NemJarAMotorException;
import jarmu.Domper;

public class Application {
    public static void main(String[] args) {
        Domper domper = new Domper(100, 90);
        domper.felrakod(100);
        System.out.println("Felrakod: " + domper);

        //domper.motorBeindit();
        System.out.println("motorBeindit: " + domper);

        try {
            domper.elindul(10);
        } catch (NemJarAMotorException ex) {
            System.out.println("Nem jár a motor. Beindítom most.");
            domper.motorBeindit();
            try {
                domper.elindul(10);
            } catch (NemJarAMotorException e) {
                throw new RuntimeException("Nem sikerült beindítani a motort", e);
            }
        }
        System.out.println("Elindul: " + domper);

        try {
            domper.gyorsit(150);
        } catch (NemJarAMotorException | IllegalStateException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Ennyivel nem tudok menni. Akkor kicsit lassabben...");
            try {
                domper.gyorsit(50);
            } catch (NemJarAMotorException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Gyorsit: " + domper);

        domper.megall();
        System.out.println("Megall: " + domper);

        //domper.platoKinyit();
        System.out.println("PlatoKinyit: " + domper);

        domper.lerakod();
        System.out.println("Lerakod: " + domper);

        domper.platoBecsuk();
        System.out.println("PlatoBecsuk: " + domper);

        domper.motorLeallit();
        System.out.println("MotorLeallit: " + domper);
    }
}
