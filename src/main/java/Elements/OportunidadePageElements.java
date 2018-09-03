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
	
	@FindBy(css="[class='numer-of-jobs']")
	public WebElement NUMERO_DE_VAGAS;
	
	@FindBy(css = ".opportunity-by-place")
	protected List<WebElement> LISTA_CIDADES;

	@FindBy(css = ".acc-content h5")
	protected List<WebElement> LISTA_OPORTUNIDADES;


}
