package jarmu.szarazfoldi;

public class Motor extends SzarazfoldiJarmu {
    public Motor() {
        this.kerekekSzama = 2;
    }

    @Override
    public void gyorsit(Integer mertek) {
        sebesség += mertek;
    }
}
