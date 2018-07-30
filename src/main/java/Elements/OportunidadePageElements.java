package Elements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utils.SeleniumUtils;

public class OportunidadePageElements extends SeleniumUtils{

	@FindBy(css="[class='mural-title']")
	public WebElement MURAL_DE_OPORTUNIDADES;
	
	@FindBy(xpath="//*[@id='jobs-list']//*[contains(text(),'Analista de Testes Sênior')]")
	public List<WebElement> OPORTUNIDADE_ANALISTA_TESTES_SENIOR;
	
	@FindBy(css="[id='cidade-select']")
	public WebElement CIDADE_SELECT;
	
	@FindBy(css="[class='numer-of-jobs']")
	public WebElement NUMERO_DE_VAGAS;
	
	
	
	
}
