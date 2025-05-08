package automatizado.teste;

import automatizado.builder.ProdutoBuilder;
import automatizado.page.ControleDeProdutoPO;
import automatizado.page.LoginPO;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.lang.model.type.NullType;

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
        //ToDo: Remover esse clique assim que o sistema for corrigido.
        controleDeProdutoPage.buttonAdicionar.click();

        String titulo = controleDeProdutoPage.tituloModal.getText();

        assertEquals("Produto",titulo);
        controleDeProdutoPage.buttonSair.click();
        //ToDo: Remover esse clique assim que o sistema for corrigido.
        controleDeProdutoPage.buttonSair.click();
    }

   // @Test
    //public void TS0002_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
       // controleDeProdutoPage.buttonAdicionar.click();

        //controleDeProdutoPage.cadastrarProduto("0001", "Martelo",10,59.9,"");

        //Aqui vamos capturar a mensagem de erro.
        //String mensagem = controleDeProdutoPage.spanMensagem.getText();

        //Compara se as duas mensagem são iguais.
        //assertEquals("Todos os campos são obrigatórios para o cadastro!",mensagem);
    //}

    @Test
    public void TS0003_DeveSerPossivelCadastrarTresProdutosPreenchendoTodosOsCampos(){
        controleDeProdutoPage.buttonAdicionar.click();
        //controleDeProdutoPage.buttonAdicionar.click();
        // Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);
        // Aqui realmente ele adiciona as informações na tela.
        produtoBuilder
                .builder();
        // Aqui adiciona outro produto com valores diferentes do default.
        produtoBuilder
                .builder();
        // Aqui adiciona outro produto com valores diferentes do default.
        produtoBuilder
                .builder();
        controleDeProdutoPage.buttonSair.click();
    }

    @Test
    public void TS0004_naoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos(){
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        //controleDeProdutoPage.buttonAdicionar.click();
        controleDeProdutoPage.buttonAdicionar.click();

        // Aqui cria o objeto para adicionar na tela.
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleDeProdutoPage);

        // Aqui realmente ele adiciona as informações na tela, porém com campo codigo em branco.
        produtoBuilder
                .adicionarCodigo("")
                .builder();
        //Compara se as duas mensagem são iguais.
        assertEquals(mensagem,controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem quantidade.
        produtoBuilder
                .adicionarCodigo("00005")
                .adicionarQuantidade(null)
                .builder();
        assertEquals(mensagem,controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem nome.
        produtoBuilder
                .adicionarQuantidade(5)
                .adicionarNome("")
                .builder();
        assertEquals(mensagem,controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem valor.
        produtoBuilder
                .adicionarNome("Abacaxi")
                .adicionarValor(null)
                .builder();
        assertEquals(mensagem,controleDeProdutoPage.spanMensagem.getText());

        // Aqui estamos testando se o produto é adicionado sem data.
        produtoBuilder
                .adicionarValor(50.0)
                .adicionarData("")
                .builder();
        assertEquals(mensagem,controleDeProdutoPage.spanMensagem.getText());

        controleDeProdutoPage.buttonSair.click();
    }
}
