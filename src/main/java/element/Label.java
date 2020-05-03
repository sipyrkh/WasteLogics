package element;

import entity.BaseElement;
import org.openqa.selenium.By;

public class Label extends BaseElement {

    public Label(By locator, String name) {
        super(locator, name);
    }

    protected String getElementType() {
        return "Label";
    }
}
