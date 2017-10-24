import javax.swing.*;

// - MARK: - Task 1 Classes
class Animal {
    void sound() {}
}

class Dog extends Animal {
    @Override
    void  sound() {
        System.out.println("Hav");
    }
}

class Cat extends Animal {
    @Override
    void  sound() {
        System.out.println("Meow");
    }
}

class Cow extends Animal {
    @Override
    void  sound() {
        System.out.println("Moo");
    }
}

public class Main {

    // - MARK: - Task 2 Classes

    static class GuessGame {

        private float bestScore;

        public GuessGame() {
            bestScore = 0;
        }

        void play(int max) {
            int currentScore = 0;
            int number = (int)(Math.random() * max);
            int ans;
            do {
                currentScore++;
                ans = Integer.parseInt( JOptionPane.showInputDialog("Guess which num I've entered?"));
            } while (!compare(number, ans));
            float result = max / currentScore;
            if (bestScore < result || bestScore == 0) {
                System.out.println("New best score: " + result);
                bestScore = result;
            }
        }

        private boolean compare(int number, int ans) {
            if (number > ans) {
                System.out.println("Number is greater than your answer");
                return false;
            } else if (ans > number) {
                System.out.println("Number is less than your answer");
                return false;
            }

            System.out.println("You won!");
            return true;
        }
    }

    public static void main(String[] args) {

        //Task 1 Implementation

        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        Animal[] animals = {dog, cat, cow};

        for (Animal animal: animals) {
            animal.sound();
        }

        //Task 2 Implementation

        GuessGame game = new GuessGame();
        game.play(20);
        game.play(20);
        game.play(20);
    }
}
