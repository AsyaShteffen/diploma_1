package praktikum;

import java.util.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {
    Burger burger;

    public Ingredient getMockedIngredient(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    public Bun getMockedBun(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }
    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun expected = getMockedBun("incredible bun", 77);
        burger.setBuns(expected);
        Assert.assertEquals("Ждем бургер с булкой - \"incredible bun\" по цене 77", expected, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Ingredient expected = getMockedIngredient(IngredientType.FILLING, "blue cheese", 300);
        burger.addIngredient(expected);
        Ingredient actual = burger.ingredients.get(0);
        Assert.assertEquals("Ждем бургер с начинкой - \"blue cheese\" по цене 300", expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, "blue cheese", 300);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Ждем бургер без начинки", burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        Ingredient ingredient1 = getMockedIngredient(IngredientType.FILLING, "blue cheese", 300);
        Ingredient ingredient2 = getMockedIngredient(IngredientType.SAUCE, "star mayonnaise", 50);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        Assert.assertEquals("Ждем в бургере \"star mayonnaise\"", ingredient1.name, burger.ingredients.get(1).name);
    }

    @Test
    public void getPriceTest() {
        Bun bun = getMockedBun("wonderful bun", 55);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, "cosmic crunchy stones", 140);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals("Ждем цену за бургер 250", 250, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        Bun bun = getMockedBun("neon bun", 100);
        Ingredient ingredient = getMockedIngredient(IngredientType.FILLING, "moon stones", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== neon bun ====)\r\n" +
                "= moon stones =\r\n" +
                "(==== neon bun ====)\r\n" +
                "\r\n" +
                "Price: 300,000000\r\n";
        Assert.assertEquals("Ждем чек покупки бургера: " + expected, expected, actual);
    }


}
