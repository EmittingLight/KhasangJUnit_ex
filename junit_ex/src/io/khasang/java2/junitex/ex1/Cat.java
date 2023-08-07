package io.khasang.java2.junitex.ex1;

public class Cat {
    String name;
    int age;
    int hungry;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void feed(int food) {
        hungry -= food;
    }

    void timeTick() {
        hungry++;
    }

    void someCheck() {
//        throw new RuntimeException();
        System.out.println(3 / 0);
    }

    void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

            System.err.println("InterruptedException caught: " + e.getMessage());
        }
    }

    void infiniteLoop() {
        while (true);
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Murka", 4);
        cat.feed(10);

//        System.out.println(cat.hungry == -10);

        if (cat.hungry == -10) {
            System.out.println("OK cat.hungry == -10");
        } else {
            System.out.println("ERROR, MUST BE: cat.hungry == -10");
        }

        cat = new Cat("Murka", 4);
        cat.timeTick();

        if (cat.hungry == 1) {
            System.out.println("OK cat.hungry == 1");
        } else {
            System.out.println("ERROR, MUST BE: cat.hungry == 1");
        }
    }
}


