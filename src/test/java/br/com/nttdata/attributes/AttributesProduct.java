package br.com.nttdata.attributes;
import org.openqa.selenium.By;

public class AttributesProduct {
  public By valorProdutoPaginaProduto = By.xpath("//p[@class='text-ptz-md font-bold']");
  public By adicionarProduto = By.xpath("//div[@class='ds-button w-full']");
  public By irSacola = By.xpath("//button[@data-testid='drawer-bag-checkout-button']");
}
