package test;

import io.qameta.allure.Description;
import models.Invoice;
import models.Price;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import static utils.PriceFunctions.parsePrice;
import static utils.ReadPropertyFile.getProperty;

public class InvoiceTest extends BaseTest {

    @Test(description = "Waste Logics")
    @Description("Test Description: Compare and assert information about order")
    public void testWasteLogics() {
        MainPage mainPage = new MainPage();

        Assert.assertTrue(mainPage.isFormDisplayed(), "'Main' page is opened");

        Invoice actualInvoice = mainPage.getInvoice();

        Price price = new Price(
                parsePrice(getProperty("flatCharge")),
                parsePrice(getProperty("perTonne")),
                parsePrice(getProperty("item"))
        );
        Invoice expectedInvoice = new Invoice(
                getProperty("company"),
                getProperty("invoiceAddress"),
                getProperty("grade"),
                getProperty("weight"),
                price
        );

        Assert.assertEquals(actualInvoice, expectedInvoice, "Invoice models aren't equals");
    }
}
