package testdouble;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GenerateIdServiceTest {

    @Test
    @DisplayName("[DEMO STUB] ID = XYZ7")
    public void case01() {
        GenerateIdService service = new GenerateIdService();
        service.setRandom(new StubRandom(9));
        String id = service.get();
        assertEquals("XYZ9", id);
    }

    @Test
    @DisplayName("[DEMO SPY] Called nextInt()")
    public void case02() {
        GenerateIdService service = new GenerateIdService();
        SpyRandom spyRandom = new SpyRandom();
        service.setRandom(spyRandom);
        service.get();
        spyRandom.verify(1);
    }

}

class SpyRandom extends Random {

    private int counter = 0;

    @Override
    public int nextInt(int bound) {
        this.counter++;
        return 1000;
    }

    public void verify(int expectedCount) {
        if (expectedCount != counter) {
            fail("จำนวนการเรียกใช้งาน method nextInt() ไม่ถูกต้อง");
        }
    }
}

class StubRandom extends Random {

    private final int number;

    public StubRandom(int number) {
        this.number = number;
    }

    @Override
    public int nextInt(int bound) {
        return number;
    }
}
