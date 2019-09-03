package Testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import Suport.Web;
import pages.*;


public class informacoesUsuariosPageObjetcsTest {
	
	private WebDriver navegador;
	
	@Before
	public void setUp() {
		navegador = Web.createChrome();
	}
	
	@Test	
	public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
		
		new LoginPage(navegador)
		.clickSignin()
		.fazerLogin("julio0001", "123456")
		.clicarMe()
		.clicarAbaMoreDataAboutYou();
		
	}
	
	@After
	public void tearDown() {
		//navegador.quit();
	}

}
