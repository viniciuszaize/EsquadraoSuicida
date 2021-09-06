package BrokerEC.alelo.com.br.BrokerContratar;

import BrokerEc.alelo.com.br.params.Brokerparams;

import BrokerEc.alelo.com.br.requests.BrokerContratar;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BrokerContratarSteps {
    BrokerContratar brokerContratar = new BrokerContratar();
    Brokerparams brokerparams = new Brokerparams();

    @Dado("uma simulação de pagamento para um {string} com {string} válido")
    public void uma_simulação_de_pagamento_para_um_com_válido(String ec, String cpf) {
        brokerparams.setCpf(cpf);
        brokerparams.setEc(ec);
    }
    @Quando("eu informo minhas informaçoes para acesso")
    public void eu_informo_minhas_informaçoes_para_acesso() {
        brokerContratar.GerarToken(brokerparams);
    }
    @Quando("realizo uma simulação de pagamento")
    public void realizo_uma_simulação_de_pagamento() {
        brokerContratar.Simulacao(brokerparams);
    }
    @Quando("recebo uma chave de acesso")
    public void recebo_uma_chave_de_acesso() {
        brokerContratar.GetToken(brokerparams);
    }
    @Quando("informo a confirmação de simulação feita")
    public void informo_a_confirmação_de_simulação_feita() {
        brokerContratar.AceiteContrato(brokerparams);

    }

    @Quando("realizo a assinatura de contratação")
    public void realizo_a_assinatura_de_contratação() {

        brokerContratar.GerarAssinatura(brokerparams);

    }
    @Entao("recebo o numero de contratação criada")
    public void recebo_o_numero_de_contratação_criada() {

        brokerContratar.RespostaContrato();

    }

}
