import jarmu.szarazfoldi.Auto;
import jarmu.szarazfoldi.Motor;
import jarmu.szarazfoldi.SzarazfoldiJarmu;
import jarmu.szarazfoldi.Szin;

public class Application {
    public static void main(String[] args) {
        Auto pirosAuto = new Auto(Szin.KEK);
        SzarazfoldiJarmu motor = new Motor();
        motor.color = Szin.SARGA;

        System.out.println(pirosAuto.color.getErtek());
        System.out.println(motor.color);

        System.out.println("Az autónak " + pirosAuto.kerekekSzama + " kereke van.");

        System.out.println("Ennyivel megy az autó: " + pirosAuto.getSebesség());
        pirosAuto.elindul(20);
        System.out.println("Ennyivel megy az autó: " + pirosAuto.getSebesség());
        pirosAuto.gyorsit(40);
        System.out.println("Ennyivel megy az autó: " + pirosAuto.getSebesség());
        pirosAuto.megall();
        System.out.println("Ennyivel megy az autó: " + pirosAuto.getSebesség()        );

        System.out.println("Ennyivel megy a motor: " + motor.getSebesség());
        motor.elindul();
        System.out.println("Ennyivel megy a motor: " + motor.getSebesség());
        motor.megall();
        System.out.println("Ennyivel megy a motor: " + motor.getSebesség());
    }
}
