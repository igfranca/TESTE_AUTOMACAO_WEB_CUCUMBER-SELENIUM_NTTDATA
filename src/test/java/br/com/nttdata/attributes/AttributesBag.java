package br.com.nttdata.attributes;
import org.openqa.selenium.By;

public class AttributesBag {
  public By valorProdutoPaginaSacola =  By.xpath("//div[@data-testid='ptz-resume-value-subtotal']//span[contains(text(), 'R$')]");
}
