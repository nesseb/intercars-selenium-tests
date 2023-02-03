package pl.intercars.wheels.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.intercars.wheels.service.ShoppingBasketService;
import pl.intercars.wheels.service.WheelsService;
import pl.intercars.wheels.value.CarModel;
import pl.intercars.wheels.value.Product;
import pl.intercars.wheels.value.Wheel;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static pl.intercars.wheels.utils.BasketMessage.EMPTY_SHOPPING_BASKET;
import static pl.intercars.wheels.utils.BasketMessage.REMOVE_MESSAGE_CONFIRM;

public class ShoppingBasketDefinitions {

    private WheelsService wheelsService;
    private ShoppingBasketService shoppingBasketService;

    private Wheel expectedWheel;

    @Before(order = 2)
    public void setUp() {
        wheelsService = new WheelsService();
        shoppingBasketService = new ShoppingBasketService();
    }

    @Given("user selects a vehicle {string} {string} with {string} engine")
    public void user_selects_a_vehicle_with_engine(String brand, String model, String engine) {
        wheelsService.selectWheelsByModel(new CarModel(brand, model, engine));
    }

    @When("user add {int} tires to the shopping basket")
    public void user_add_tires_to_the_shopping_basket(int howManyTires) {
        expectedWheel = wheelsService.getTire();
        wheelsService.addTiresToBasket(howManyTires);
    }

    @Then("basket should contain selected tires")
    public void basket_should_contain_selected_tires() {
        Product actualProduct = shoppingBasketService.getProduct();
        assertEquals(actualProduct.getProductName(), expectedWheel.getTireName());
        assertEquals(actualProduct.getPrice(), expectedWheel.getPrice());
    }

    @When("user remove selected tires from shopping basket")
    public void user_remove_selected_tires_from_shopping_basket() {
        shoppingBasketService.removeProduct();
    }

    @Then("shopping basket should be empty")
    public void shopping_basket_should_be_empty() {
        assertNull(shoppingBasketService.getProduct());
        assertEquals(shoppingBasketService.getRemoveProductConfirmMessage(), REMOVE_MESSAGE_CONFIRM);
        assertEquals(shoppingBasketService.getShoppingBasketStatement(), EMPTY_SHOPPING_BASKET);
    }
}
