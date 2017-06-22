package junit.org.rapidpm.vaadin.helloworld.server.junit5.vaadin;

import org.openqa.selenium.WebDriver;

/**
 *
 * We are now using {@link com.vaadin.testbench.HasDriver}
 */
@Deprecated
public interface HasWebDriver {
  WebDriver getWebDriver();

  void setWebDriver(WebDriver webDriver);
}
