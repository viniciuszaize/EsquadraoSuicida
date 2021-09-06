# language: pt

@1002
Funcionalidade: Testar Pagamento com contratação assinada

    Esquema do Cenário: Simulação de pagamento com assinatura do  Banco do Brasil

    Dado que eu desejo criar um Pagamento para um <EC>
    Quando eu informo minhas informaçoes de acessos solicitados
    E envio a simulação de pagamento
    E recebo uma chave temporaria
    E informo a confirmação de termos do pagamento
    E faço a assinatura de contrato
    Entao recebo o numero de contratação criada


    Exemplos:

    |       EC       |
    |   "1000985927" |