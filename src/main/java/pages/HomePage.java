package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(id = "signin2")
    WebElement signupLink;

    @FindBy(id = "login2")
    WebElement loginLink;

    public void clickSignUpLink() {
        signupLink.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

}
