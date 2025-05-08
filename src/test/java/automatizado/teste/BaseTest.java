package automatizado.teste;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que serve de herança para todas as classes de teste.
 */
public abstract class BaseTest {
    /**Driver do navegador da página atual*/
    protected static WebDriver driver;
    /**Caminho base da URL do sistema a ser testado.*/
    private static final String URL_BASE = "file:///C:/Users/Lucas/OneDrive/Documentos%201/Automa%C3%A7%C3%A3o%20QA/controle-de-produtos/sistema/login.html";
    /**Caminho relativo do driver ao projeto referente ao path.*/
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver -v 136.0.7103.93.exe";

    /**
     * Metodo para iniciar o driver do navegador antes de qualquer classe de teste.
     */
    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.chrome.driver",CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }
    /**
     * Metodo que finaliza o driver do navegador depois de qualquer classe de teste.
     */
    @AfterClass
    public  static void finalizar(){
        driver.quit();
    }
}







































