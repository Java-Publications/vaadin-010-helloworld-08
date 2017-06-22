package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;
import static org.rapidpm.vaadin.helloworld.server.MyUI.OUTPUT_ID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rapidpm.vaadin.helloworld.server.Main;
import com.vaadin.testbench.ElementQuery;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;

/**
 *
 */
public class TestBenchHelloWorldTest extends TestBenchTestCase {


  @BeforeEach
  void setUp() {
    System.setProperty("webdriver.chrome.driver", "_data/webdrivers/chromedriver-mac-64bit");
    Main.start();
    setDriver(new ChromeDriver());
  }

  @AfterEach
  void tearDown() {
    WebDriver driver = getDriver();
    if (driver != null) driver.quit();
    Main.shutdown();
  }


  @Test
  void testHelloWorld() {
    getDriver().get("http://127.0.0.1:8080/");
    $(TextFieldElement.class).id(INPUT_ID_A).sendKeys("5");

    TextFieldElement textField_B = $(TextFieldElement.class).id(INPUT_ID_B);
    textField_B.sendKeys("5");

    $(ButtonElement.class).id(BUTTON_ID).click();

    ElementQuery<TextFieldElement> elementQuery = $(TextFieldElement.class);
    TextFieldElement textFieldElement = elementQuery.id(OUTPUT_ID);
    String value =  textFieldElement.getValue();

    Assertions.assertEquals("10", value);
  }
}
