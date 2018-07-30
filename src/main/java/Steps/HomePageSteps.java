package Steps;

import Page.HomePage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Quando;

public class HomePageSteps {

	HomePage homepage = new HomePage();
	
	@Dado ("que estou no site da CWI")
	public void acessaSiteCWI() {
		System.out.println("Dado que estou no site da CWI.");
		homepage.acessaOSiteDaCWI();
	}
	
	@Quando ("acesso o menu oportunidades")
	public void acessaMenuOportunidades() {
		System.out.println("Quando acesso o menu oportunidades.");
		homepage.acessaOMenuOportunidades();
	}
}
