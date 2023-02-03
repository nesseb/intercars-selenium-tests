package pl.intercars.wheels.service;

import pl.intercars.wheels.page.ShoppingBasket;
import pl.intercars.wheels.value.Product;

public class ShoppingBasketService {

    private final ShoppingBasket shoppingBasket;

    public ShoppingBasketService() {
        this.shoppingBasket = new ShoppingBasket();
    }

    public Product getProduct() {
        if (shoppingBasket.countProducts() > 0) {
            return new Product(shoppingBasket.getProductName(), shoppingBasket.getProductPrice());
        }
        return null;
    }

    public void removeProduct() {
        shoppingBasket.removeProductFromBasket();
    }

    public String getRemoveProductConfirmMessage() {
        return shoppingBasket.removeProductConfirm();
    }

    public String getShoppingBasketStatement() {
        return shoppingBasket.getBasketStatement();
    }
}
