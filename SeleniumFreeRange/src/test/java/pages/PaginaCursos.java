package pages;

public class PaginaCursos extends BasePage{

    private String fundamentosTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    public PaginaCursos(){
        super(driver);
    }

    public void clickFundamentosTestingLink(){
        this.maximizeWindow();
        clickElement(fundamentosTestingLink);
    }
}
