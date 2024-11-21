package steps;
 
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;
 
public class FreeRangeSteps {
 
    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursosPage = new PaginaCursos();
    PaginaRegistro registro = new PaginaRegistro();

//Instancia para usar softAssert de TestNG

SoftAssert softAs = new SoftAssert();


    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }
 
    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("^(?:I|The user|The client) selects? elegir plan$")
    public void selectElegirPlan() {
        landingPage.ClickOnElegirPlanButton();
    }

    @And("^(?:I|The user|The client) Selects? Introducción al Testing$")
    public void navigatetoIntro(){
        cursosPage.clickFundamentosTestingLink();
    }

    @Then("^(?:I|The user|The client) can validate the options in the checkout page$") 
    public void returnPlanInputsValues(){
      List<String> lista = registro.returnPlanInputsValues();
      List<String> listaEsperada = Arrays.asList("$25", "6 pagos mensuales de $4.50");

    Assert.assertEquals(lista, listaEsperada);

    }


        //EJEMPLOS ASSERTIONS MAS COMUNES

    public void ejemplosAssertions(){
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";

        //Verificar que dos valores son iguales 

        Assert.assertEquals(palabraEsperada, palabraEncontrada);

        //Verificar que dos valores son iguales, pero con numeros
        int numeroloco = 1;
        int numeroloco2 = 2;
        Assert.assertEquals(numeroloco, numeroloco2);

        // Verificar que dos valores NO son iguales

        Assert.assertNotEquals(palabraEsperada, palabraEncontrada);

        //Verificar que una condición es verdadera

        Assert.assertTrue(palabraEncontrada.contains(palabraEsperada));

        //Verificar que una condición es falsa

        Assert.assertFalse(palabraEncontrada.contains(palabraEsperada));

        //Verifica que el objeto sea null.

        Assert.assertNull(numeroloco);

        //Verifica que el objeto NO sea null.

        Assert.assertNotNull(numeroloco);

        //soft Assertions: No detienen la ejecucion al fallar. Ideal para verificar muchas cosas pequeñas a la vez
        softAs.assertEquals(palabraEsperada, palabraEncontrada);
        softAs.assertTrue(palabraEncontrada.contains(palabraEsperada));
        softAs.assertNotEquals(palabraEncontrada, palabraEsperada);

        softAs.assertAll();
    }

  

}