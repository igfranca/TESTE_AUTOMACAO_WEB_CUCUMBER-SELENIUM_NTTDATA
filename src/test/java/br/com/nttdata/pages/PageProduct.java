package br.com.nttdata.pages;
import br.com.nttdata.attributes.AttributesProduct;
import br.com.nttdata.support.ActionEvidenceUtil;
import org.openqa.selenium.WebDriver;

public class PageProduct extends AttributesProduct {

  private WebDriver driver;

  public PageProduct(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public String pegarValorDoProduto() {
    return ActionEvidenceUtil.getText(driver, valorProdutoPaginaProduto, "Ação: capturar preço na página do produto");
  }

  public void adicionarProdutoEIrParaASacola(){
    ActionEvidenceUtil.click(driver, adicionarProduto, "Clique: adicionar produto");
    ActionEvidenceUtil.click(driver, irSacola, "Clique: ir para a sacola");
  }
}
