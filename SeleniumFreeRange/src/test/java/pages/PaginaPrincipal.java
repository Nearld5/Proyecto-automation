package pages;
 
public class PaginaPrincipal extends BasePage {
 
    private String sectionLink = "//a[normalize-space()='%s' and @href]";
    private String comprarButton = "//a[normalize-space()='Compra ahora' and @href]";
 
    public PaginaPrincipal() {
        super(driver);
    }
 
    // Método para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters() {
        this.maximizeWindow();
        navigateTo("https://www.freerangetesters.com");
 
    }
 
    public void clickOnSectionNavigationBar(String section) {
        // Reemplaza el marcador de posición en sectionLink con el nombre
        this.maximizeWindow();
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }
    
    public void ClickOnElegirPlanButton (){
        clickElement(comprarButton);
    }



    
}