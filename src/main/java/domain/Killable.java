package domain;

public interface Killable {
    void damage(int damage);
    int getHealth();

    String getName();
}
