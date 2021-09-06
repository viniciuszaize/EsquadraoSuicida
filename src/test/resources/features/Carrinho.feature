# language: pt
Funcionalidade: Carrinho Ecommerce Alelo
  Ambos os cenarios contam com validação de esquima, implicita durante a chamadas das requisicoes
  Esse schema valida as seguintes informacoes:
    Mascara para o campo document(cpf ou cnpj);
    Também e possivel validar qualquer info criando uma REGEX para tal;


  #Cenario utilizando somente Java + Rest Assured + Gson com Fluent Style
  Cenario: Criacao do carrinho no Ecommerce da Alelo
    Dado que eu desejo criar um carrinho para o CNPJ "85271662000159"
    Quando eu informo que desejo aceitar os cookies
    E envio a requisicao
    Entao eu recebo o status code 200
    E o id do carrinho com o status "OPEN"

  #Cenario utilizando POJO + Gerando dados randomicos
  #As classes POJOS foram geradas utilizando o site http://www.jsonschema2pojo.org/
  Cenario: Criacao do carrinho no Ecommerce da Alelo com POJO
    Dado que eu desejo criar um carrinho com um CNPJ valido
    E eu desejo aceitar os cookies
    Quando eu envio a requisicao
    E recebo o status code 200 para a requisicao de Carts
    Entao o ID do carrinho deve ser exibido junto com o status "OPEN"

