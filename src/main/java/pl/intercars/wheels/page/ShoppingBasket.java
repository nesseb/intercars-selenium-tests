package pl.intercars.wheels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.intercars.WebDriverUtils;

import java.util.List;

public class ShoppingBasket {

    @FindBy(className = "product-info")
    private List<WebElement> product;

    @FindBy(className = "text-right")
    private WebElement productPrice;

    @FindBy(className = "clean-button")
    private WebElement removeProduct;

    @FindBy(className = "alert-success")
    private WebElement alert;

    @FindBy(className = "page-header")
    private WebElement basketStatement;

    public ShoppingBasket() {
        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    public String getProductName() {
        return product.get(0).findElement(By.tagName("a")).getText();
    }

    public double getProductPrice() {
        String price = productPrice.getText();
        price = price.replaceFirst(",", ".");
        return Double.parseDouble(price.split(" ")[0]);
    }

    public int countProducts() {
        return product.size();
    }

    public ShoppingBasket removeProductFromBasket() {
        removeProduct.click();
        return this;
    }

    public String removeProductConfirm() {
        return alert.getText();
    }

    public String getBasketStatement() {
        return basketStatement.getText();
    }
}
