package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesBag;
import br.com.nttdata.support.ActionEvidenceUtil;
import org.openqa.selenium.WebDriver;

public class PageBag extends AttributesBag {

  private WebDriver driver;

  public PageBag(WebDriver getdriver) {
    this.driver = getdriver;
  }

  public String pegarValorDoProdutoNaSacola() {
    return ActionEvidenceUtil.getText(driver, valorProdutoPaginaSacola, "Ação: capturar preço na página da sacola");
  }
}
