package BrokerEC.alelo.com.br.BrokerCancelar;

import BrokerEc.alelo.com.br.params.Brokerparams;
import BrokerEc.alelo.com.br.requests.BrokerCancelar;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class BrokerCancelarSteps {
    Brokerparams brokerparams = new Brokerparams();
    BrokerCancelar brokerCancelar = new BrokerCancelar();

    @Dado("uma simulação de pagamento para um {string} com {string} válido")
    public void uma_simulação_de_pagamento_para_um_com_válido(String ec, String cpf) {
        brokerparams.setEc(ec);
        brokerparams.setCpf(cpf);
    }
    @Quando("eu informo minhas informaçoes para acesso")
    public void eu_informo_minhas_informaçoes_para_acesso() {

        brokerCancelar.GerarToken(brokerparams);

    }
    @Quando("realizo uma simulação de pagamento")
    public void realizo_uma_simulação_de_pagamento() {

        brokerCancelar.Simulacao(brokerparams);
    }
    @Quando("recebo uma chave de acesso")
    public void recebo_uma_chave_de_acesso() {

        brokerCancelar.GetToken(brokerparams);
    }

    @Quando("informo a confirmação de simulação feita")
    public void informo_a_confirmação_de_simulação_feita() {

        brokerCancelar.AceiteContrato(brokerparams);

    }
    @Quando("realizo o cancelamento desta simualação de pagamento informando os campos necessarios")
    public void realizo_o_cancelamento_desta_simualação_de_pagamento_informando_os_campos_necessarios() {

        brokerCancelar.Cancelamento(brokerparams);

    }

    @Entao("recebo a validação se a contratação foi cancelada")
    public void recebo_a_validação_se_a_contratação_foi_cancelada() {

        brokerCancelar.RetornoStatus();

    }
}
