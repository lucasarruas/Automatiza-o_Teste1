package automatizado.teste;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;

import automatizado.page.LoginPO;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
    private  static LoginPO loginPage;

    @BeforeClass
    public  static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TS0001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
        LoginPO.executarAcaoDeLogar("","");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TS0002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazios(){
        LoginPO.executarAcaoDeLogar("Teste","");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }
    @Test
    public void TS0003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
        LoginPO.executarAcaoDeLogar("","Teste");
        String mensagem = loginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TS0007_DeveLogarNoSistemaComEmailESenhaCorretos(){
        loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");
        assertEquals(loginPage.obterTituloPagina(),"Controle de Produtos");
    }
}












































