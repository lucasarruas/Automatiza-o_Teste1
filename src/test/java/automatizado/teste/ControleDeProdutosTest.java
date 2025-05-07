package automatizado.teste;

import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutosTest extends BaseTest{

    private static ControleDeProdutoPO controleDeProdutoPage;
    private  static LoginPO loginPage;

    @BeforeClass
    public  static void prepararTestes(){
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");

        controleDeProdutoPage = new ControleDeProdutoPO(driver);
        assertEquals(controleDeProdutoPage.obterTituloPagina(),"Controle de Produtos");
    }
    @Test
    public void TS0001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleDeProdutoPage.buttonAdicionar.click();
        String titulo = controleDeProdutoPage.tituloModal.getText();
        assertEquals("Produtos",titulo);
    }
}
