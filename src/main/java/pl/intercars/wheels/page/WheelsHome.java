package pl.intercars.wheels.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.intercars.WebDriverUtils;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class WheelsHome {

    @FindBy(id = "jqs-vehicle-brands-2-button")
    private WebElement brandButton;
    @FindBy(className = "ui-selectmenu-open")
    private WebElement brandDropDownMenu;

    @FindBy(xpath = "//a[contains(@class, 'ui-selectmenu') and not(contains(@class,'ui-selectmenu-disabled')) and starts-with(@id,'ui-selectmenu')]")
    private List<WebElement> modelButtonList;
    @FindBy(className = "ui-selectmenu-open")
    private WebElement modelTable;

    @FindBy(xpath = "//a[contains(@class, 'ui-selectmenu') and not(contains(@class,'ui-selectmenu-disabled')) and starts-with(@id,'ui-selectmenu') and contains(.,'Wybierz...')]")
    private List<WebElement> engineButtonList;
    @FindBy(className = "ui-selectmenu-open")
    private WebElement engineTable;

    @FindBy(className = "btn-submit")
    private WebElement submit;

    public WheelsHome() {
        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }

    public WheelsHome chooseBrand(String brand) {
        brandButton.click();
        while (!brandButton.getText().equals(brand)) {
            brandDropDownMenu.findElements(By.tagName("a"))
                    .stream()
                    .filter(webElement -> webElement.getText().equals(brand))
                    .findFirst().get().click();
        }
        return this;
    }

    public WheelsHome chooseModelCar(String carModel) {
        checkCondition(() -> modelButtonList.size() >= 2);
        WebElement modelButton = modelButtonList.stream().filter(WebElement::isDisplayed).findFirst().get();
        modelButton.click();
        modelTable.findElements(By.tagName("li"))
                .stream()
                .filter(webElement -> webElement.getText().equals(carModel))
                .findFirst().get().click();

        return this;
    }

    public WheelsHome chooseEngineModel(String engineModel) {
        checkCondition(() -> engineButtonList.size() >= 2);
        WebElement engineButton = engineButtonList.stream().filter(WebElement::isDisplayed).findFirst().get();
        engineButton.click();
        while (!engineButton.getText().equals(engineModel)) {
            engineTable.findElements(By.tagName("td"))
                    .stream()
                    .filter(webElement -> webElement.getText().equals(engineModel))
                    .findFirst().get().click();
        }

        return this;
    }

    public void submit() {
        submit.click();
    }

    private void checkCondition(Callable<Boolean> callable) {
        await()
                .atMost(10, TimeUnit.SECONDS)
                .pollInterval(1, TimeUnit.SECONDS)
                .until(callable);
    }
}