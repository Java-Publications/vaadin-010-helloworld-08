package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;
import static org.rapidpm.vaadin.helloworld.server.MyUI.OUTPUT_ID;

import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import com.vaadin.testbench.elementsbase.AbstractElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class MyUIPageObjectTestbenchFunctional extends AbstractVaadinPageObject {
  public MyUIPageObjectTestbenchFunctional(WebDriver webDriver) {
    super(webDriver);
  }

  //pure Testbench - functional style
//  public Supplier<ButtonElement> buttonSupplier = () -> $(ButtonElement.class).id(BUTTON_ID);
//  public Supplier<TextFieldElement> outputSupplier = () -> $(TextFieldElement.class).id(OUTPUT_ID);
//  public Supplier<TextFieldElement> inputASupplier = () -> $(TextFieldElement.class).id(INPUT_ID_A);
//  public Supplier<TextFieldElement> inputBSupplier = () -> $(TextFieldElement.class).id(INPUT_ID_B);


  // Testbench - functional style more generic
  @FunctionalInterface
  public interface WithID<T extends AbstractElement> {
    T id(String id);
  }
  public WithID<TextFieldElement> textField = (id) -> $(TextFieldElement.class).id(id);
  public WithID<ButtonElement> btn = (id) -> $(ButtonElement.class).id(id);

  public Supplier<ButtonElement> buttonSupplier = () -> btn.id(BUTTON_ID);
  public Supplier<TextFieldElement> outputSupplier = () -> textField.id(OUTPUT_ID);
  public Supplier<TextFieldElement> inputASupplier = () -> textField.id(INPUT_ID_A);
  public Supplier<TextFieldElement> inputBSupplier = () -> textField.id(INPUT_ID_B);

  // Core JDK Version
//  public Function<String, TextFieldElement> textField = (id) -> $(TextFieldElement.class).id(id);
//  public Function<String, ButtonElement> btn = (id) -> $(ButtonElement.class).id(id);
//
//  public Supplier<ButtonElement> buttonSupplier = () -> btn.apply(BUTTON_ID);
//  public Supplier<TextFieldElement> outputSupplier = () -> textField.apply(OUTPUT_ID);
//  public Supplier<TextFieldElement> inputASupplier = () -> textField.apply(INPUT_ID_A);
//  public Supplier<TextFieldElement> inputBSupplier = () -> textField.apply(INPUT_ID_B);


}
