package entity;

import element.Label;
import org.openqa.selenium.By;

public abstract class BaseForm{

    protected final By locator;
    protected final String name;

    protected BaseForm(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public Label getFormElement(){
        return new Label(locator, name);
    }

    public boolean isFormDisplayed() {
        return getFormElement().isVisible();
    }
}
