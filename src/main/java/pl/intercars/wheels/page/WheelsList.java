package pl.intercars.wheels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.intercars.WebDriverUtils;

import java.util.List;

public class WheelsList {

    @FindBy(className = "prod-info-container")
    private List<WebElement> wheelsInformationList;

    @FindBy(className = "prod-price-box")
    private List<WebElement> wheelsPriceInformationList;

    @FindBy(className = "buttonset")
    private WebElement confirmationDialog;

    public WheelsList() {
        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    public WheelsList addWheelToBasket(int howMany) {
        WebElement quantityField = wheelsPriceInformationList.get(0).findElement(By.name("quantity"));
        quantityField.clear();
        quantityField.sendKeys(String.valueOf(howMany));
        wheelsPriceInformationList.get(0).findElement(By.className("checkout-btn")).click();
        return this;
    }

    public void confirmChoose() {
        confirmationDialog.findElement(By.id("checkout")).click();
    }

    public String getWheelsName() {
        return wheelsInformationList.get(0).findElement(By.tagName("a")).getText();
    }

    public double getWheelsPrice() {
        String price = wheelsPriceInformationList.get(0).findElement(By.className("current-price")).getText();
        price = price.replaceFirst(",", ".");
        return Double.parseDouble(price.split(" ")[0]);
    }
}