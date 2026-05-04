package br.com.nttdata.pages;

import br.com.nttdata.attributes.AttributesHome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PageHome extends AttributesHome {

  private WebDriver driver;

  public PageHome(WebDriver getDriver) {
    this.driver = getDriver;
  }

  public void acessarOSite() {
    driver.get("https://www.petz.com.br/");
  }

  public void clicarNoBotaoCookie() throws InterruptedException {
    driver.findElement(botaoCookie).click();
    Thread.sleep(2000);
  }

  public void clicarNaPesquisaEDigitarItem(String oQueBuscar) {
    driver.findElement(campoBusca).sendKeys(oQueBuscar + Keys.ENTER);
    driver.findElement(itemSelecionado).click();
  }
}
