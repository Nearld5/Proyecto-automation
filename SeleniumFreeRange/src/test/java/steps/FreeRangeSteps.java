package steps;
 
import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaPrincipal;
 
public class FreeRangeSteps {
 
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }
 
    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }
    @And("select Introducción al Testing")
    public void navigatetoIntro(){
        cursosPage.clickFundamentosTestingLink();
    }

 
}