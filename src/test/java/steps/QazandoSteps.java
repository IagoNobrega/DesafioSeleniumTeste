package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import pages.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QazandoSteps {

    HomePage home;

    @Dado("que estou no site da qazando")
    public void que_estou_no_site_da_qazando() {

        home = new HomePage(Hooks.driver);

        home.acessarSite();

        assertTrue(home.validarSite(),
                "Erro: Não foi possível acessar a aplicação da Qazando.");
    }

    @Quando("eu preencha meu e-mail")
    public void eu_preencha_meu_email() throws InterruptedException {

        home.rolarTela();

        Thread.sleep(2000);

        home.preencherEmail("iago@qazando.com.br");
    }

    @Quando("clico em ganhar cupom")
    public void clico_em_ganhar_cupom() {

        home.clicarCupom();
    }

    @Então("eu vejo o código de desconto")
    public void eu_vejo_o_codigo_de_desconto() {

        String cupom = home.pegarCupom();

        System.out.println(cupom);
    }
}