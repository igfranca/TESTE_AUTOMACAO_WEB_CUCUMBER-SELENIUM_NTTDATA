package br.com.nttdata.steps;

import br.com.nttdata.pages.PageBag;
import br.com.nttdata.pages.PageHome;
import br.com.nttdata.pages.PageProduct;
import br.com.nttdata.support.DriverManager;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;

import static org.junit.Assert.assertTrue;

public class LojaPetzSteps {

  String precoProdutoPagina, precoProdutoSacola;
  boolean precoProdutoFlag;

  @Dado("que um usuario entra no site {string}")
  public void queUmUsuarioEntraNoSite(String url) throws InterruptedException {
    PageHome home = new PageHome(DriverManager.getDriver());
    home.acessarOSite();
    home.clicarNoBotaoCookie();
  }

  @Então("que seleciona um produto com o nome {string}")
  public void queSelecionaUmProdutoComONome(String produto) {
    PageHome home = new PageHome(DriverManager.getDriver());

    //Na variável "oQueBuscar", digitar o nome do produto que deseja comprar
    home.clicarNaPesquisaEDigitarItem("Escada Baw & Miaw Grafite para Cães e Gatos");
  }

  @E("na pagina do produto capturo o preco do produto")
  public void naPaginaDoProdutoCapturoOPrecoDoProduto() {
    precoProdutoPagina = new PageProduct(DriverManager.driver).pegarValorDoProduto();

    if (precoProdutoPagina != null) {precoProdutoFlag = true;}

    assertTrue("Preço do produto capturado com sucesso", precoProdutoFlag);
  }

  @E("adiciono o produto e envio para a sacola")
  public void adicionoOProdutoEEnvioParaASacola() {
    new PageProduct(DriverManager.driver).adicionarProdutoEIrParaASacola();
  }

  @Então("devera verificar se estao corretos os valores do produto")
  public void deveraVerificarSeEstaoCorretosOsValoresDoProduto() {
    precoProdutoSacola = new PageBag(DriverManager.driver).pegarValorDoProdutoNaSacola();

    System.out.println("Preço do produto na página do produto: " + precoProdutoPagina);
    System.out.println("Preço do produto na página da sacola: " +  precoProdutoSacola);

    if (precoProdutoPagina.equals(precoProdutoSacola)) {
      System.out.println("Os valores da página do produto e página da sacola estão corretos");
    } else System.out.println("Os valores da página do produto e página da sacola não estão corretos");

  }
}
