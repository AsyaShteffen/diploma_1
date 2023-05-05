package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class IngredientTest {

    Ingredient ingredient;
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBurgerData(){
        return new Object[][] {
                {IngredientType.FILLING, "dino eggs", 200},
                {IngredientType.SAUCE, "saint moist", 300},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void getPriceIngredientTest() {
        float actual = ingredient.getPrice();
        Assert.assertEquals("Ждем цену ингредиента " + price, price, actual, 0);
    }

    @Test
    public void getNameIngredientTest() {
        String actual = ingredient.getName();
        Assert.assertEquals("Ждем название ингредиента - " + name, name, actual);
    }

    @Test
    public void getTypeIngredientTest() {
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Ждем тип ингредиента -" + type, type, actual);
    }
}