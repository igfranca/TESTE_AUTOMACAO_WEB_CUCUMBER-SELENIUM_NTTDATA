package br.com.nttdata.steps;

import br.com.nttdata.hooks.Hooks;
import br.com.nttdata.pages.PageBag;
import br.com.nttdata.pages.PageHome;
import br.com.nttdata.pages.PageProduct;
import br.com.nttdata.support.DriverManager;
import br.com.nttdata.support.ScreenshotUtil;
import com.aventstack.extentreports.Status;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

public class LojaPetzSteps {

  String precoProdutoPagina, precoProdutoSacola;

  @Dado("que um usuario entra no site {string}")
  public void queUmUsuarioEntraNoSite(String url) throws InterruptedException {
    PageHome home = new PageHome(DriverManager.getDriver());
    home.acessarOSite();
    Hooks.getCurrentTest().log(Status.PASS, "Acessou o site: " + url, ScreenshotUtil.capture(DriverManager.getDriver()));
    home.clicarNoBotaoCookie();
    Hooks.getCurrentTest().log(Status.PASS, "Clicar no botão cookie: " + url, ScreenshotUtil.capture(DriverManager.getDriver()));
  }

  @Então("que seleciona um produto com o nome {string}")
  public void queSelecionaUmProdutoComONome(String produto) {
    PageHome home = new PageHome(DriverManager.getDriver());

    //Na variável "oQueBuscar", digitar o nome do produto que deseja comprar
    home.clicarNaPesquisaEDigitarItem("Escada Baw & Miaw Grafite para Cães e Gatos");
    Hooks.getCurrentTest().log(Status.PASS, "Seleciona o produto: " + produto, ScreenshotUtil.capture(DriverManager.getDriver()));
  }

  @E("na pagina do produto capturo o preco do produto")
  public void naPaginaDoProdutoCapturoOPrecoDoProduto() {
    precoProdutoPagina = new PageProduct(DriverManager.driver).pegarValorDoProduto();
  }

  @E("adiciono o produto e envio para a sacola")
  public void adicionoOProdutoEEnvioParaASacola() {
    new PageProduct(DriverManager.driver).adicionarProdutoEIrParaASacola();
    Hooks.getCurrentTest().log(Status.PASS, "Adiciona o produto e envia para a sacola: ", ScreenshotUtil.capture(DriverManager.getDriver()));
  }

  @Então("devera verificar se estao corretos os valores do produto")
  public void deveraVerificarSeEstaoCorretosOsValoresDoProduto() {
    precoProdutoSacola = new PageBag(DriverManager.driver).pegarValorDoProdutoNaSacola();
    Hooks.getCurrentTest().log(Status.PASS, "Verifica se os valores estão corretos: ", ScreenshotUtil.capture(DriverManager.getDriver()));

    System.out.println("Preço do produto na página do produto: " + precoProdutoPagina);
    System.out.println("Preço do produto na página da sacola: " +  precoProdutoSacola);

    if (precoProdutoPagina.equals(precoProdutoSacola)) {
      System.out.println("Os valores da página do produto e página da sacola estão corretos");
    } else System.out.println("Os valores da página do produto e página da sacola não estão corretos");
  }
}
