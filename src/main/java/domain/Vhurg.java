package domain;

public class Vhurg extends Alien {
    private Vhurg commander;

    public Vhurg(String name, int health) {
        super(name, health);
        System.out.println("Vhurg " + name + " comes into the room");
    }

    public Vhurg getCommander() {
        return commander;
    }

    public void setCommander(Vhurg commander) {
        this.commander = commander;
    }

    void look(Alien alien) {
        System.out.println(getName() + " looks at " + alien.getName());
    }
}
