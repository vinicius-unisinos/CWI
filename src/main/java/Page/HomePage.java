package Page;

import org.openqa.selenium.support.PageFactory;

import Elements.HomePageElements;
import Setup.TestRule;

public class HomePage extends HomePageElements {

	String URL = "https://www.cwi.com.br";

	public HomePage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void acessaOSiteDaCWI() {
		driver.navigate().to(URL);
	}

	public void acessaOMenuOportunidades() throws Exception {
		MENU_OPORTUNIDADES.click();
	}
	
}
