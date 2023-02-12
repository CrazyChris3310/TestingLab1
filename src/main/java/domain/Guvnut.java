package domain;

public class Guvnut extends Alien {
    private Guvnut chief;
    private String vapour;

    public Guvnut(String name, int health, String vapor) {
        super(name, health);
        this.vapour = vapor;
    }

    public Guvnut getChief() {
        return chief;
    }

    public void setChief(Guvnut chief) {
        this.chief = chief;
    }

    public String getVapour() {
        return vapour;
    }

    public void setVapour(String vapour) {
        this.vapour = vapour;
    }
}
