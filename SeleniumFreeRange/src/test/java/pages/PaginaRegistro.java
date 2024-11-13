package pages;

import java.util.List;

public class PaginaRegistro extends BasePage {

    private String containerdiv = "//div[@class='d-flex flex-column gap-y-1']";

    public PaginaRegistro(){
        super(driver);
    }

    public List <String> returnPlanInputsValues(){
        return getInputXPaths(containerdiv);
    }

}
