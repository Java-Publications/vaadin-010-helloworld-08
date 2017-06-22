package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.openqa.selenium.By.id;
import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;
import static org.rapidpm.vaadin.helloworld.server.MyUI.OUTPUT_ID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class MyUIPageObjectToTestbenchOO extends AbstractVaadinPageObject {

  public MyUIPageObjectToTestbenchOO(WebDriver webDriver) {
    super(webDriver);
  }

  public WebElement elementByID(String id) { return driver.findElement(id(id)); }

  public WebElement buttonWE() { return elementByID(BUTTON_ID); }
  public WebElement outputWE() { return elementByID(OUTPUT_ID); }
  public WebElement inputAWE() { return elementByID(INPUT_ID_A); }
  public WebElement inputBWE() { return elementByID(INPUT_ID_B); }

  // object oriented style
  public ButtonElement button() {return wrap(ButtonElement.class, elementByID(BUTTON_ID));}
  public TextFieldElement output() {return wrap(TextFieldElement.class, elementByID(OUTPUT_ID));}
  public TextFieldElement inputA() {return wrap(TextFieldElement.class, elementByID(INPUT_ID_A));}
  public TextFieldElement inputB() {return wrap(TextFieldElement.class, elementByID(INPUT_ID_B));}






}
