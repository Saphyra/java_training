package jarmu.szarazfoldi;

public enum Szin {
    ZOLD("Zöld"),
    KEK("Kék"),
    SARGA("Sárga");

    private final String ertek;

    Szin(String ertek) {
        this.ertek = ertek;
    }

    public String getErtek(){
        return ertek;
    }
}
