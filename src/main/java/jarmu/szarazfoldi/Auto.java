package jarmu.szarazfoldi;

public class Auto extends SzarazfoldiJarmu {
    public Auto(Szin color) {
        this.color = color;
        this.kerekekSzama = 4;
    }

    public void elindul(short mertek) {
        sebesség = (int) mertek;
    }

    public void elindul(Integer mertek) {
        this.sebesség = mertek;
    }

    @Override
    public void gyorsit(Integer mertek) {
        sebesség += mertek;
    }
}
