#encoding: utf-8
#language: pt

  Funcionalidade: Comprar produto no site Petz

    @CenarioCompra
    Cenario: Validar o valor do produto no site Petz
      Dado que um usuario entra no site "https://www.petz.com.br/"
      Quando que seleciona um produto com o nome "Escolher o produto que deseja comprar"
      E na pagina do produto capturo o preco do produto
      E adiciono o produto e envio para a sacola
      Então devera verificar se estao corretos os valores do produto