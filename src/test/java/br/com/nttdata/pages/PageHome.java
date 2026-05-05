package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesHome;
import br.com.nttdata.support.ActionEvidenceUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageHome extends AttributesHome {

  private WebDriver driver;

  public PageHome(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public void acessarOSite() {
    driver.get("https://www.petz.com.br/");
    ActionEvidenceUtil.logAction(driver, "Ação: acessar o site https://www.petz.com.br/");
  }

  public void clicarNoBotaoCookie() throws InterruptedException {
    ActionEvidenceUtil.click(driver, botaoCookie, "Clique: botão de cookies");
    Thread.sleep(2000);
  }

  public void clicarNaPesquisaEDigitarItem(String oQueBuscar) {
    ActionEvidenceUtil.type(driver, campoBusca, oQueBuscar + Keys.ENTER, "Ação: pesquisar produto - " + oQueBuscar);
    ActionEvidenceUtil.click(driver, itemSelecionado, "Clique: selecionar item pesquisado");
  }
}
