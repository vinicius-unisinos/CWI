package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import Elements.OportunidadePageElements;
import Setup.TestRule;

public class OportunidadesPage extends OportunidadePageElements{

	public OportunidadesPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}
	
	public Boolean verificaDisponibilidadeDaVaga(String vaga) {
		esperaElemento(MURAL_DE_OPORTUNIDADES, 10);
		boolean ok = false;
		if(OPORTUNIDADE_ANALISTA_TESTES_SENIOR.size() > 0) {
			ok = true;
			switch (vaga) {
			case "Analista de Testes S�nior":
				OPORTUNIDADE_ANALISTA_TESTES_SENIOR.get(0).click();
				break;
			default:
				System.out.println("Vaga pesquisada Não está previsa no verificador de vagas, verifique!");
				break;
			}
		}
		return ok;
	}
	
	public void selecionaCidade() throws InterruptedException {
		Thread.sleep(5000);
		CIDADE_SELECT.click();
		CIDADE_SELECT.sendKeys("P");
		CIDADE_SELECT.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	}
	
	public void numeroDeVagas() {
		String msg = NUMERO_DE_VAGAS.getText().toString();
		System.out.println("NUMERO DE VAGAS: "+ msg);
	}
}
