package Elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.SeleniumUtils;

public class HomePageElements extends SeleniumUtils{

	@FindBy(css="[class='oportunidades']")
	public WebElement MENU_OPORTUNIDADES;
	

}
