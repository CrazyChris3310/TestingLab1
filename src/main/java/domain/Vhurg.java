package domain;

public class Vhurg extends Alien {
    private Vhurg commander;

    public Vhurg(String name, int health) {
        super(name, health);
    }

    public Vhurg getCommander() {
        return commander;
    }

    public void setCommander(Vhurg commander) {
        this.commander = commander;
    }
}
