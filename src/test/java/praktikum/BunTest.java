package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {
    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("incredible bun", 77);
    }

    @Test
    public void getNameBunTest() {
        String actual = "incredible bun";
        String expected = bun.getName();
        Assert.assertEquals("Ожидаемое название булки - " + expected, expected, actual);
    }

    @Test
    public void getPriceBunTest() {
        float expected = 77;
        float actual = bun.getPrice();
        Assert.assertEquals("Ожидаемая цена булки - " + expected, expected , actual, 0);
    }
}
