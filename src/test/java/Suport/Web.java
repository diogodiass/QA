package Suport;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	
	public static WebDriver createChrome()
	{
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Diogo Dias\\Drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().window().maximize();
	    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Tempo de Espera Implicito
	    
	    
	    navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador;
	}

}
