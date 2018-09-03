package Setup;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRule {

	private static WebDriver driver;
	private static String nomeCenario;
	
	@Before
	public void beforeCenario(Scenario cenario) {
		String  headless = "false";
		String pathProjeto = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pathProjeto + "/resources/drivers/chromedriver_Win.exe");

		if(headless.equalsIgnoreCase("true")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			String pluginToDisable = "Chrome PDF Viewer";
			options.addArguments("plugins.plugins_enable", pluginToDisable);
			options.addArguments("window-size=1200x600");//A opção window-size é importante para sites responsivos
			System.out.println("Iniciando ChromeDriver em modo Headless.");
			driver = new ChromeDriver(options);
		}else {
			System.out.println("Iniciando ChromeDriver");
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
		System.out.println("Finalizando instância do ChromeDriver");
		System.out.println("Cenário " + cenario + " finalizado");
		driver.quit();
	}
}
