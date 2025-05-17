package pages.home;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import static utilities.DriverManager.getDriver;


public class PopUpSignUp extends BasePage {

    private final WebDriver driver = getDriver();

    @FindBy(id = "sign-username")
    WebElement usernameField;

    @FindBy(id = "sign-password")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    WebElement signUpButton;

    // Method tunggu popup signup muncul dengan menunggu usernameField terlihat
    public void waitForSignUpPopup() {
        try {
            System.out.println("Menunggu popup signup muncul (presence)...");
            getWait(10).until(ExpectedConditions.presenceOfElementLocated(By.id("sign-username")));
            System.out.println("Elemen ditemukan di DOM. Cek visibility selanjutnya...");

            getWait(5).until(ExpectedConditions.visibilityOf(usernameField));
            System.out.println("Elemen sudah terlihat (visible).");
        } catch (TimeoutException e) {
            System.out.println("Gagal menampilkan popup signup (elemen tidak ditemukan atau tidak terlihat).");
            throw e;
        }
    }

    public void enterUsername(String username) {
        getWait(10).until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        getWait(10).until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignUpButton() {
        WebDriverWait wait = getWait(30);

        // Tunggu tombol bisa diklik
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton));

        // Scroll ke tombol agar terlihat
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpButton);

        // Klik tombol signup pakai JS supaya terhindar dari click intercepted
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);

    }




}
