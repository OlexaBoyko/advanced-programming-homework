abstract class Character {
    int power;
    int hp;

    Character() {
        this.power = 0;
        this.hp = 0;
    }

    abstract void kick(Character c);
    final boolean isAlive() {
        return hp > 0;
    }
}

class Hobbit extends Character {

    Hobbit() {
        this.power = 0;
        this.hp = 3;
    }

    @Override
    void kick(Character c) {
        System.out.println("Cry");
    }
}

class Elf extends Character {

    Elf() {
        this.power = 10;
        this.hp = 10;
    }

    @Override
    void kick(Character c) {
        if (this.power > c.power) c.hp = 0;
        else  c.power--;
    }
}

class King extends Character {

    King() {
        this.power = 5 + (int)(Math.random() * 15);
        this.hp = 5 + (int)(Math.random() * 15);
    }

    @Override
    void kick(Character c) {
        c.hp += -(int)(Math.random() * this.power);
    }
}

class Knight extends Character {

    Knight() {
        this.power = 2 + (int)(Math.random() * 12);
        this.hp = 2 + (int)(Math.random() * 12);
    }

    @Override
    void kick(Character c) {
        c.hp += -(int)(Math.random() * this.power);
    }
}

class CharacterFactory {
    static Character createCharacter() {
        switch ((int)(Math.random() * 4)) {
            case 0:
                return new Hobbit();
            case 1:
                return new Elf();
            case 2:
                return new King();
            case 3:
                return new Knight();
        }

        return new Hobbit();
    }
}

class GameManager {
    static void fight(Character c1, Character c2) {
        do {
            int oldC1hp = c1.hp;
            int oldC2hp = c2.hp;
            c1.kick(c2);
            System.out.println("C1 was kicked on " + (oldC1hp - c1.hp) + "hp");
            c2.kick(c1);
            System.out.println("C2 was kicked on " + (oldC2hp - c2.hp) + "hp");
        } while (c1.isAlive() && c2.isAlive());
        System.out.println((c1.isAlive() ? "C1" : "C2") + " was killed");
    }
}

public class Main {

    public static void main(String[] args) {

        Character c1 = CharacterFactory.createCharacter();
        Character c2 = CharacterFactory.createCharacter();

        GameManager.fight(c1, c2);
    }
}
