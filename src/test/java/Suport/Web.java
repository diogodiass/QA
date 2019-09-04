package Suport;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Web {
	
	public static final String USERNAME = "diogodias2";
	public static final String AUTOMATE_KEY = "AKBqoQzZGVayv8j8zgHS";
    public static final String URL = "https://" + USERNAME + ":" + 	AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static WebDriver createChrome()
	{
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Diogo Dias\\Drivers\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		navegador.manage().window().maximize();
	    navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Tempo de Espera Implicito
	    
	    
	    navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador;
	}
	
	public static WebDriver createBrowserSatck() {
	
	    DesiredCapabilities caps = new DesiredCapabilities();
	    
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "60.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1280x800");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");	

	    WebDriver navegador = null;
	    		
	    try {
	    	navegador = new RemoteWebDriver(new URL(URL), caps);
	    	navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    	//Navegar
	    	navegador.get("http://www.juliodelima.com.br/taskit");
	    }catch(MalformedURLException e) {
	    	System.out.println("Houveram  problemas com a URL: 	"+ e.getMessage());	
	    }
	    		
	    
		return navegador;

	 
		
	}

}
