package junit.org.rapidpm.vaadin.helloworld.server.junit5.selenium;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.openqa.selenium.By.id;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.HasWebDriver;

/**
 *
 */
public interface WebDriverFunctions {


  // not nice to copy all this stuff
  static Supplier<Optional<WebDriver>> newWebDriverChrome() {
    return () -> {
      try {
        final DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
        final ChromeDriver chromeDriver = new ChromeDriver(chromeCapabilities);
        chromeDriver.manage().window().maximize();
        return Optional.of(chromeDriver);
      } catch (Exception e) {
        e.printStackTrace();
        return empty();
      }
    };
  }

  static Supplier<Optional<WebDriver>> newWebDriverFirefox() {
    return () -> {
      try {
        final DesiredCapabilities chromeCapabilities = DesiredCapabilities.firefox();
        final FirefoxDriver driver = new FirefoxDriver(chromeCapabilities);
        driver.manage().window().maximize();
        return Optional.of(driver);
      } catch (Exception e) {
        e.printStackTrace();
        return empty();
      }
    };
  }


  static BiFunction<WebDriver, String, Optional<WebElement>> elementFor() {
    return (driver, id) -> ofNullable(driver.findElement(id(id)));
  }

  static Consumer<WebDriver> takeScreenShot() {
    return (webDriver) -> {
      //take Screenshot
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      try {
        outputStream.write(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        //write to target/screenshot-[timestamp].jpg
        final FileOutputStream out = new FileOutputStream("target/screenshot-" + LocalDateTime.now() + ".png");
        out.write(outputStream.toByteArray());
        out.flush();
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    };
  }

}
