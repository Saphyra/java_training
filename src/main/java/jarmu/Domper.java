package jarmu;

import exception.NemJarAMotorException;
import exception.TulSokRakomanyException;

public class Domper {
    private final int kapacitas;
    private final int maxSebesseg;

    private boolean jarAMotor;
    private boolean platoNyitva;
    private int sebesseg;
    private int rakomany;

    public Domper(int kapacitas, int maxSebesseg) {
        this.kapacitas = kapacitas;
        this.maxSebesseg = maxSebesseg;
        System.out.println("A Dömper elkészült: " + this);
    }

    public void motorBeindit() {
        jarAMotor = true;
    }

    public void motorLeallit() {
        jarAMotor = false;
    }

    public void platoKinyit() {
        if (sebesseg != 0) {
            throw new IllegalStateException("A Dömper halad. Sebesség: " + sebesseg);
        }
        platoNyitva = true;
    }

    public void platoBecsuk() {
        platoNyitva = false;
    }

    public void elindul(Integer sebesseg) throws NemJarAMotorException {
        if (this.sebesseg != 0) {
            throw new IllegalStateException("A Dömper már halad. Sebesség: " + sebesseg);
        }
        if (platoNyitva) {
            throw new IllegalStateException("A plató nyitva.");
        }
        if (!jarAMotor) {
            throw new NemJarAMotorException();
        }
        if (sebesseg > maxSebesseg) {
            throw new IllegalArgumentException("Ez a jármű nem tud ilyen gyorsan menni, a max sebessége " + maxSebesseg);
        }
        this.sebesseg = sebesseg;
    }

    public void megall() {
        sebesseg = 0;
    }

    public void gyorsit(Integer sebesseg) throws NemJarAMotorException {
        int ujSebesseg = this.sebesseg + sebesseg;
        if (!jarAMotor) {
            throw new NemJarAMotorException();
        }
        if (platoNyitva) {
            throw new IllegalStateException("A plató nyitva.");
        }
        if (ujSebesseg > maxSebesseg) {
            throw new IllegalArgumentException("Ez a jármű nem tud ilyen gyorsan menni, a max sebessége " + maxSebesseg);
        }
        this.sebesseg = ujSebesseg;
    }

    public void felrakod(Integer rakomany) {
        int ujRakomany = this.rakomany + rakomany;

        if (ujRakomany > kapacitas) {
            throw new TulSokRakomanyException(ujRakomany + " meghaladja a maximum kapacitást.");
        }

        this.rakomany = ujRakomany;
    }

    public void lerakod() {
        if (!platoNyitva) {
            throw new IllegalStateException("A plató nincs nyitva.");
        }
        rakomany = 0;
    }

    @Override
    public String toString() {
        return "Domper ["
                + "kapacitas: " + kapacitas
                + ", maxSebesseg: " + maxSebesseg
                + ", jarAMotor: " + jarAMotor
                + ", platoNyitva: " + platoNyitva
                + ", sebesseg: " + sebesseg
                + ", rakomany: " + rakomany
                + "]";
    }
}
