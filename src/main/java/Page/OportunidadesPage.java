package Page;

import org.openqa.selenium.support.PageFactory;

import Elements.OportunidadePageElements;
import Setup.TestRule;

public class OportunidadesPage extends OportunidadePageElements {

	public OportunidadesPage() {
		driver = TestRule.getDriver();
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public Boolean verificaDisponibilidadeDaVaga(String vaga) {
		esperaElemento(MURAL_DE_OPORTUNIDADES, 10);
		boolean ok = false;
		if (OPORTUNIDADE_ANALISTA_TESTES_SENIOR.size() > 0) {
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

	public void selecionaCidade(String cidade) {
		for (int i = 0; i < LISTA_CIDADES.size(); i++) {
			if (LISTA_CIDADES.get(i).getText().contains(cidade)) {
				LISTA_CIDADES.get(i).click();
				break;
			}
		}
	}

	public int getVagas() {
		int contadorVagas = 0;
		for (int i = 0; i < LISTA_OPORTUNIDADES.size(); i++) {
			if (LISTA_OPORTUNIDADES.get(i).isDisplayed()) {
				contadorVagas++;
			}

		}
		return contadorVagas;
	}
}
