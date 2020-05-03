package pages;

import element.Label;
import entity.BaseForm;
import io.qameta.allure.Step;
import models.Invoice;
import models.Price;
import org.openqa.selenium.By;

import static utils.PriceFunctions.parsePrice;

public class MainPage extends BaseForm {

    private final By table = By.id("MyYardDisclosure9577009378082_frm");
    private final By company = By.xpath("//tbody[contains(@class, 'select')][2]//td[contains(@class, 'cal')][4]");
    private final By invoiceAddress = By.xpath("//tbody[contains(@class, 'select')][2]//td[contains(@class, 'cal')][5]");
    private final By grade = By.xpath("//td[@colspan = '7' and contains(text(), ' ')]");
    private final By weight = By.xpath("//tr[.//td[@colspan = '7' and contains(text(), ' ')]]//td[contains(@class, 'car')]");
    private final By flatChargePrice = By.xpath("//tbody[contains(@class, '3')][2]//td[8]");
    private final By perTonnePrice = By.xpath("//tbody[contains(@class, '3')][3]//td[8]");
    private final By itemPrice = By.xpath("//tbody[contains(@class, '3')][4]//td[8]");

    public MainPage() {
        super(
                By.id("myyard-contents"),
                "Main page"
        );
    }

    @Step("Getting invoice model from 'Main' page")
    public Invoice getInvoice() {
        Price price = new Price(
                parsePrice(getTableValue(flatChargePrice)),
                parsePrice(getTableValue(perTonnePrice)),
                parsePrice(getTableValue(itemPrice))
        );

        return new Invoice(
                getTableValue(company),
                getTableValue(invoiceAddress),
                getTableValue(grade),
                getTableValue(weight),
                price
        );
    }

    @Step("Getting table value with loc {0}")
    private String getTableValue(By by) {
        return getTable().getElement().findElement(by).getText();
    }

    private Label getTable() {
        return new Label(table, "Table with Invoices");
    }
}
