package pages;

public class PaginaPrincipal extends BasePage {
    public PaginaPrincipal() {
        super(driver);
    }

    // Método para navegar a www.freerangertesters.com

    public void navigateToFreeRangeTesters() {
        navigateTo("https://www.freerangetesters.com");
    }

}
