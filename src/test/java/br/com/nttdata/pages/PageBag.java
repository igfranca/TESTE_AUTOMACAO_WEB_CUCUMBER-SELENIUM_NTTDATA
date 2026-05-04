package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesBag;
import org.openqa.selenium.WebDriver;

public class PageBag extends AttributesBag {

  private WebDriver driver;

  public PageBag(WebDriver getdriver) {
    this.driver = getdriver;
  }

  public String pegarValorDoProdutoNaSacola() {
    return driver.findElement(valorProdutoPaginaSacola).getText();
  }
}
