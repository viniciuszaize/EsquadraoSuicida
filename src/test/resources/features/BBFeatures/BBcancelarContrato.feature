# language: pt

@BBcancelar
Funcionalidade: Testar Pagamento com contratação assinada

  Esquema do Cenário: Simulação de pagamento porem cancelando a contratação do Banco do Brasil

    Dado uma simulação de pagamento para o <EC>
    Quando eu informo minhas informaçoes de acessos
    E faço um envio de simulação de pagamento
    E recebo uma chave temporaria para realizar a confirmação do processo
    E informo as informaçoes de simulação de pagamento feita
    E faço o cancelamento de contratação
    Entao recebo o status do cancelamento de contratação


    Exemplos:

      |       EC       |
      |   "1000985927" |