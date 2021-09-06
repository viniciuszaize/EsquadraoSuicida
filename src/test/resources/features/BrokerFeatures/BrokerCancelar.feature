# language: pt

@2001
Funcionalidade: Testar Pagamento com contratação assinada pelo Broker

  Esquema do Cenário: Simulação de pagamento com assinatura de contratação

    Dado uma simulação de pagamento para um <EC> com <CPF> válido
    Quando eu informo minhas informaçoes para acesso
    E realizo uma simulação de pagamento
    E recebo uma chave de acesso
    E informo a confirmação de simulação feita
    E realizo o cancelamento desta simualação de pagamento informando os campos necessarios
    Entao recebo a validação se a contratação foi cancelada


    Exemplos:

      |       EC       |  |     CPF        |
      |   "1000985927" |  | "52964332894"  |