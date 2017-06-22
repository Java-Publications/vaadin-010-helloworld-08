package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;

import java.util.function.Function;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class MyUIPageObjectFindByFunctional extends AbstractVaadinPageObject {
  public MyUIPageObjectFindByFunctional(WebDriver webDriver) {
    super(webDriver);
  }

  //Selenium style for PageObjectPattern - PageFactory.initElements(..) needed
  @FindBy(id = BUTTON_ID) private WebElement btnWE;
  @FindBy(id = INPUT_ID_A) private WebElement inputAWE;
  @FindBy(id = INPUT_ID_B) private WebElement inputBWE;


  //selenium inject to testbench - functional style with TestBench Methods
  private Function<WebElement, ButtonElement> toButton = (webElement) -> wrap(ButtonElement.class, webElement);
  private Function<WebElement, TextFieldElement> toTextField = (webElement) -> wrap(TextFieldElement.class, webElement);

  public Supplier<ButtonElement> button = () -> toButton.apply(btnWE);
  public Supplier<TextFieldElement> inputA = () -> toTextField.apply(inputAWE);
  public Supplier<TextFieldElement> inputB = () -> toTextField.apply(inputBWE);

}
