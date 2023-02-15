package domain;

public class Guvnut extends Alien {
    private Guvnut chief;
    private final String vapour;

    public Guvnut(String name, int health, String vapor) {
        super(name, health);
        this.vapour = vapor;
        System.out.println("Guvnut " + name + ", covered with " + vapor + " vapour, comes into the room");
    }

    public Guvnut getChief() {
        return chief;
    }

    public void setChief(Guvnut chief) {
        this.chief = chief;
        System.out.println();
    }

    public String getVapour() {
        return vapour;
    }

}
