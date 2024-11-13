package steps;
 
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;
 
public class FreeRangeSteps {
 
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }
 
    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("I select elegir plan")
    public void selectElegirPlan() {
        landingPage.ClickOnElegirPlanButton();
    }

    @And("Select Introducción al Testing")
    public void navigatetoIntro(){
        cursosPage.clickFundamentosTestingLink();
    }

    @Then("I can validate the options in the checkout page") 
    public void returnPlanInputsValues(){
      List<String> lista = registro.returnPlanInputsValues();
      List<String> listaEsperada = Arrays.asList("$25", "6 pagos mensuales de $4.50");

    Assert.assertEquals(lista, listaEsperada);

    }
}