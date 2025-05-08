package automatizado.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    /**
     * Construtor base para criação da fabrica de elementos (PageFactory).
     *Construtor padrão para criação de uma nova instancia da pagina de login.
     * @param driver -- Driver da página de login.
     */

    @FindBy(id = "email")
    public static WebElement inputEmail;

    @FindBy(id = "senha")
    public static WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public static WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem(){
        return this.spanMensagem.getText();
    }

    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public static void executarAcaoDeLogar(String email, String senha){
        escrever(inputEmail,email);
        escrever(inputSenha,senha);

        buttonEntrar.click();
    }
}
