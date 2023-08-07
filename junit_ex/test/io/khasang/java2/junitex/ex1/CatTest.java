package io.khasang.java2.junitex.ex1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CatTest {

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat("Murka", 4);
    }

    @Test
    public void testFeed() {
        cat.feed(10);
        assertEquals(-10, cat.hungry);
    }

    @Test
    public void testTimeTick() {
        cat.timeTick();
        assertEquals(1, cat.hungry);
    }

    @Test(expected = ArithmeticException.class)
    public void testSomeCheck() {
        cat.someCheck();
    }

    @Test(timeout = 4000)
    public void testSleep() {
        cat.sleep(3000);
    }

    @Test(timeout = 5000)
    public void testInfiniteLoop() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Cat cat = new Cat("Murka", 4);
            cat.infiniteLoop();
        });

        thread.start();

        Thread.sleep(2000);
        thread.interrupt();
    }

    @Test
    public void testNegativeFeed() {
        cat.feed(100);
        assertEquals(0, cat.hungry);
    }
    @Test
    public void testNegativeSleep() {
        assertDoesNotThrow(() -> cat.sleep(-100));
    }


}

