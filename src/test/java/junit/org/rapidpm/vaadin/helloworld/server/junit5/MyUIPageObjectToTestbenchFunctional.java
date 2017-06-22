package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;

import java.util.function.Function;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class MyUIPageObjectToTestbenchFunctional extends AbstractVaadinPageObject {
  public MyUIPageObjectToTestbenchFunctional(WebDriver webDriver) {
    super(webDriver);
  }

  //selenium inject to testbench - functional style with TestBench Methods
  private Function<WebElement, ButtonElement> toButton = (webElement) -> wrap(ButtonElement.class, webElement);
  private Function<WebElement, TextFieldElement> toTextField = (webElement) -> wrap(TextFieldElement.class, webElement);


  public Supplier<ButtonElement> buttonSupplier = () -> element.andThen(toButton).apply(BUTTON_ID);
  public Supplier<TextFieldElement> inputASupplier = () -> element.andThen(toTextField).apply(INPUT_ID_A);
  public Supplier<TextFieldElement> inputBSupplier = () -> element.andThen(toTextField).apply(INPUT_ID_B);


  public Function<String, ButtonElement> button = element.andThen(toButton);


  //ButtonElement btn = button.apply(BUTTON_ID);

}
