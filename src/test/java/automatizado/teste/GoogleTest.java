package automatizado.teste;

import automatizado.page.GooglePO;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GoogleTest extends BaseTest{

    private  static GooglePO googlePage;
    @BeforeClass
    public  static void prepararTestes(){
        driver.get("https://www.google.com/");
        googlePage = new GooglePO(driver);
    }

    @Test
    public void TC001_deveSerPossivelPesquisarNoGoogleOTexto(){
        googlePage.pesquisar("O senhor dos anéis");

        String resultado = googlePage.obterResultadoDaPesquisa();
        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }

    @Test
    public void TC002_deveSerPossivelPesquisarNoGoogleOTexto(){
        googlePage.pesquisar("O Fantasma da Opera");

        String resultado = googlePage.obterResultadoDaPesquisa();
        assertTrue(resultado, resultado.contains("resultados"));
    }

}




































