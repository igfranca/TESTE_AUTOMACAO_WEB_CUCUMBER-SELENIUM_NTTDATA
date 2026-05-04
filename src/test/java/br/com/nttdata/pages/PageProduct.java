package br.com.nttdata.pages;
import br.com.nttdata.attributes.AttributesProduct;
import org.openqa.selenium.WebDriver;

public class PageProduct extends AttributesProduct {

  private WebDriver driver;

  public PageProduct(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public String pegarValorDoProduto() {
    return driver.findElement(valorProdutoPaginaProduto).getText();
  }

  public void adicionarProdutoEIrSacola(){
    driver.findElement(adicionarProduto).click();
    driver.findElement(irSacola).click();
  }
}
