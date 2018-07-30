package Setup;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestRule {

	protected static WebDriver driver;
	public static String nomeCenario;
	
	@Before
	public void beforeCenario(Scenario cenario) throws SQLException {
		String  headless = "false";
		String pathProjeto = System.getProperty("user.dir");
		String SO = System.getProperty("os.name").toLowerCase();
		switch (SO) {
		case "windows 10":
			System.setProperty("webdriver.chrome.driver", pathProjeto + "/resources/drivers/chromedriver_Win.exe");
			break;
		case "linux":
			System.setProperty("webdriver.chrome.driver", pathProjeto + "/resources/drivers/chromedriver_Linux");
			break;	
		case "mac":
			System.setProperty("webdriver.chrome.driver", pathProjeto + "/resources/drivers/chromedriver_Mac");
			break;	
		default:
			break;
		}
		ChromeOptions options = new ChromeOptions();
		
		if(headless.equalsIgnoreCase("true")) {
			  options.addArguments("headless");
			  String pluginToDisable = "Chrome PDF Viewer";
			  options.addArguments("plugins.plugins_enable", pluginToDisable);
		      options.addArguments("window-size=1200x600");//A opção window-size é importante para sites responsivos
		      System.out.println("Iniciando ChromeDriver em modo Headless.");
		      driver = new ChromeDriver(options);
		}else {
			System.out.println("Iniciando ChromeDriver.");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		nomeCenario = cenario.getName();
		System.out.println("Executando Cenario de Teste: " + nomeCenario);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getNomeCensario() {
		return nomeCenario;
	}

	@After
	public void afterCenario(Scenario cenario) {
		System.out.println("Finalizando estância do chromeDriver");
		System.out.println("Cenário " + cenario + " fincalizado");		
		driver.quit();
		
	}
}
