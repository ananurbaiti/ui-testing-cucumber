package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class AlertHandler {

    private static final Logger logger = LoggerFactory.getLogger(AlertHandler.class);
    private final WebDriver driver = DriverManager.getDriver();

    // Mengambil teks dari alert yang muncul
    public String getAlertText() {
        try {
            waitAlert();
            String alertText = driver.switchTo().alert().getText();
            logger.info("Alert Text: {}", alertText);
            return alertText;
        } catch (Exception e) {
            logger.error("Alert not found or can't read alert text: {}", e.getMessage());
            return null;
        }
    }

    // Menunggu alert muncul maksimal 30 detik
    public void waitAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // Menerima (klik OK) alert yang muncul
    public void acceptAlert() {
        waitAlert();
        driver.switchTo().alert().accept();
    }
}
