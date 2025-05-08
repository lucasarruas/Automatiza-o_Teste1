package automatizado.builder;

import automatizado.page.ControleDeProdutoPO;
import org.openqa.selenium.WebDriver;

public class ProdutoBuilder {

    private static String codigo = "00001";
    private static String nome = "Produto Padrão";
    private static Integer quantidade = 1;
    private static Double valor = 1.0;
    private static String data = "03/11/2021";

    private static ControleDeProdutoPO controleDeProdutoPO;

    public  ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return  this;
    }

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return  this;
    }

    public ProdutoBuilder adicionarQuantidade(Integer quantidade){
        this.quantidade = quantidade;
        return  this;
    }

    public ProdutoBuilder adicionarValor(Double valor){
        this.valor = valor;
        return  this;
    }

    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return  this;
    }

    public static void builder(){
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade,(quantidade != null) ? quantidade.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, (valor != null) ? valor.toString() : "");
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.buttonSalvar.click();
    }
}
