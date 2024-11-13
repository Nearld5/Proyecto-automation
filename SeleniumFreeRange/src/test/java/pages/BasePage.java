package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    /*
     * Declaración de una variable estática 'driver' de tipo WebDriver
     * Esta variable va a ser compartida por todas las instancias de BasePage y sus
     * subclases
     */
    protected static WebDriver driver;
    /*
     * Declaración de una variable de instancia 'wait' de tipo WebDriverWait.
     * Se inicializa inmediatamente con una instancia dew WebDriverWait utilizando
     * el 'driver' estático
     * WebDriverWait se usa para poner esperas explícitas en los elementos web
     */
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    /*
     * Configura el WebDriver para Chrome usando WebDriverManager.
     * WebDriverManager va a estar descargando y configurando automáticamente el
     * driver del navegador
     */
    static {
        WebDriverManager.chromedriver().setup();

        // Inicializa la variable estática 'driver' con una instancia de ChromeDriver
        driver = new ChromeDriver();
    }

    /*
     * Este es el constructor de BasePage que acepta un objeto WebDriver como
     * argumento.
     */
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Método estático para cerrar la instancia del driver.
    public static void closeBrowser() {
        driver.quit();
    }

    //Método para maximizar la pantalla
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        Find(locator).click();
    }

    public void write(String locator, String keysToSend) {
        Find(locator).clear();
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index) {
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index);
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();

        return dropdownOptions.size();
    }

    // Método que retorna XPaths de todos los elementos 'input' encontrados en un
    // contenedor 'div'. Retornará los textos encontrados en los inputs
    public List<String> getInputXPaths(String containerSelector) {
        //Encontrará todos los inputs del contenedor = containerSelector
        WebElement container = driver.findElement(By.xpath(containerSelector));
        List<WebElement> inputs = container.findElements(By.tagName("input"));
        //Elimino el último elemento de la lista ya que no es necesario
        inputs.remove(inputs.size() - 1);

        System.out.println("Número de elementos input encontrados: " + inputs.size());
        List<String> inputXPaths = new ArrayList<>();
        //Recorrido por cada elemento encontrado yu almacenado en inputs
        for (WebElement input : inputs) {
            String inputXPath = null;
            //Recogerá los id de los inputs
            String inputId = input.getAttribute("id");
            //Recogerá value de los inputs
            String inputValue = input.getAttribute("value");
            
            if (inputId != null && !inputId.isEmpty()) {
                inputXPath = "//*[@id='" + inputId + "']";
            } else if (inputValue != null && !inputValue.isEmpty()) {
                // Si el 'id' no está presente, intentamos con el 'value'
                inputXPath = containerSelector + "//*[@value='" + inputValue + "']";
            }
            
            System.out.println("XPath generado para agregar a la lista de inputs: " + inputXPath);

            //Recogerá los textos de los xpaths generados y encontrados en el DOM
            String TextElement = input.findElement(By.xpath(inputXPath+"//following-sibling::label")).getText();
            System.out.println("Los textos asociados al input son: "+ TextElement);
            
            //Agregará los textos recogidos a la lista inputXPaths
            inputXPaths.add(TextElement);
        }

        return inputXPaths;
    }

    
// Este metodo devuelve el texto de todos los valores (texto) de un Dropdown
public List<String> getDropDownValues(String locator) {
    Select dropdown = new Select(Find(locator));
    List<WebElement> dropdownOptions = dropdown.getOptions();
    List<String> values = new ArrayList<>();
    for (WebElement options : dropdownOptions) {
        values.add(options.getText());
    }
    return values;
}


}