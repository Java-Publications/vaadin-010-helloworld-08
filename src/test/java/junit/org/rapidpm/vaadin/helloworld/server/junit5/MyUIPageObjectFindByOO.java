package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class MyUIPageObjectFindByOO extends AbstractVaadinPageObject {
  public MyUIPageObjectFindByOO(WebDriver webDriver) {
    super(webDriver);
  }

  //Selenium style for PageObjectPattern - PageFactory.initElements(..) needed
  @FindBy(id = BUTTON_ID) private WebElement btnWE;
  @FindBy(id = INPUT_ID_A) private WebElement inputAWE;
  @FindBy(id = INPUT_ID_B) private WebElement inputBWE;


  private ButtonElement toButtonElement(WebElement webElement) { return wrap(ButtonElement.class, webElement);}
  private TextFieldElement toTextFieldElement(WebElement webElement) { return wrap(TextFieldElement.class, webElement);}

  public ButtonElement button() { return toButtonElement(btnWE);}
  public TextFieldElement inputA() { return toTextFieldElement(inputAWE);}
  public TextFieldElement inputB() { return toTextFieldElement(inputBWE);}


}
