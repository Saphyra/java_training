package jarmu.szarazfoldi;

import jarmu.Jarmu;

public abstract class SzarazfoldiJarmu implements Jarmu {
    private static final int ALAPERTELMEZETT_SEBESEG = 50;

    public Szin color;
    protected Integer sebesség = 0;
    public Integer kerekekSzama;

    public final void elindul() {
        sebesség = ALAPERTELMEZETT_SEBESEG;
    }

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall() {
        sebesség = 0;
    }

    public Integer getSebesség(){
        return sebesség;
    }
}
