package junit.org.rapidpm.vaadin.helloworld.server.junit5;

import static org.rapidpm.vaadin.helloworld.server.MyUI.BUTTON_ID;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_A;
import static org.rapidpm.vaadin.helloworld.server.MyUI.INPUT_ID_B;
import static org.rapidpm.vaadin.helloworld.server.MyUI.OUTPUT_ID;

import org.openqa.selenium.WebDriver;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.TextFieldElement;
import junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin.AbstractVaadinPageObject;

/**
 *
 */
public class MyUIPageObjectTestbenchOO extends AbstractVaadinPageObject {
  public MyUIPageObjectTestbenchOO(WebDriver webDriver) {
    super(webDriver);
  }

  public ButtonElement buttonTBOO() {return $(ButtonElement.class).id(BUTTON_ID); }
  public TextFieldElement outputTBOO() {return $(TextFieldElement.class).id(OUTPUT_ID); }
  public TextFieldElement inputATBOO() {return $(TextFieldElement.class).id(INPUT_ID_A); }
  public TextFieldElement inputBTBOO() {return $(TextFieldElement.class).id(INPUT_ID_B); }


}
