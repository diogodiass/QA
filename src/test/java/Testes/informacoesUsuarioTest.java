package Testes;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import Suport.Generator;
import Suport.Screenshot;
import Suport.Web;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioTest.csv")
public class informacoesUsuarioTest {
	
    private WebDriver navegador;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp(){
        
      navegador = Web.createChrome();

      WebElement linkSignIn = navegador.findElement(By.linkText("Sign in"));//Criando  uma variavel do tipo WebElement estou recebendo nela o retorno
      linkSignIn.click();

      WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

      formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

      formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

  
      navegador.findElement(By.linkText("SIGN IN")).click();
      
      navegador.findElement(By.className("me")).click();
      
      navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

  }
    	
   @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo,@Param(name="contato")String contato,@Param(name="mensagemR")String mensagemR){

       //button {@data-target="addmoredata"}
       navegador.findElement(new By.ByXPath("//button[@data-target=\"addmoredata\"]")).click();     
       WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));
       
       WebElement campoType = popupAddMoreData.findElement(By.name("type"));	
       new Select(campoType).selectByVisibleText(tipo);
       
       popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

       popupAddMoreData.findElement(By.linkText("SAVE")).click();

       WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
       
       String mensagem = mensagemPop.getText();

       assertEquals("Your contact has been added!", mensagemR);
   }

   //@Test
   public void removeContactUser()
   {
       //Clicar no elemento pelo xpath //span[text()=\"551133334444\"]/following-sibling::a
       navegador.findElement(By.xpath("//span[text()=\"551133334444\"]/following-sibling::a")).click();

       //Confirmar a janela JS
       navegador.switchTo().alert().accept();

       //Validar que a mensagem apresentada foi "Rest in peace, dear phone"
       WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
       String mensagem = mensagemPop.getText();
       assertEquals("Rest in peace, dear phone!", mensagem);

       String screnshotArquivo1 = "C:\\Users\\Diogo Dias\\Screen\\"+Generator.dataHoraParaArquivo()+test.getMethodName()+".png";
       Screenshot.take(navegador, screnshotArquivo1);
       
       //Depois que a janela for apresentada aguardar 10 segundos para que a janela desapareca
       WebDriverWait aguardar = new WebDriverWait(navegador, 10);
       aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));

       //Clicar no link do texto logout
       navegador.findElement(By.linkText("Logout")).click();

   }

   @After
    public void tearDown(){
        //navegador.quit();
  }
}
