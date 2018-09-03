package Steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import Page.OportunidadesPage;
import Utils.SeleniumUtils;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Entao;

public class OportunidadesSteps extends SeleniumUtils {

	OportunidadesPage oportunidadespage = new OportunidadesPage();

	@Entao("verifico se a vaga esta disponivel")
	public void verificaExistenciaDaVaga(DataTable vaga) {
		System.out.println("Entao verifico se a vaga esta disponivel.");
		List<Map<String, String>> data = vaga.asMaps(String.class, String.class);
		Assert.assertTrue("", oportunidadespage.verificaDisponibilidadeDaVaga(data.get(0).get("vaga")));
	}

	@Entao("tiro um print da tela")
	public void tiraPrint() {
		try {
			printaTela();
		} catch (java.awt.AWTException e) {
			e.printStackTrace();
		}
	}

	@Entao("verifico quantas vagas estao disponiveis para (.*)")
	public void verificaQuantidadePOA(String cidade) {
		System.out.println("Entao verifico quantas vagas estao disponiveis para " + cidade);
		System.out.println("Vagas disponiveis para a cidade de " + cidade + ": " + oportunidadespage.getVagas());
	}

	@Entao("visualizo apenas as oportunidades de")
	public void ligaFiltroPOA() {
		System.out.println("Entao visualizo apenas as oportunidades de " + "Porto Alegre - RS");
		oportunidadespage.selecionaCidade("Porto Alegre - RS");
	}
}
