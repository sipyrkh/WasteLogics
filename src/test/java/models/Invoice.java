package models;

import java.util.Objects;

public class Invoice {

    private String company;
    private String companyAddress;
    private String grade;
    private String weight;
    private Price price;

    public Invoice(String company, String companyAddress, String grade, String weight, Price price) {
        this.company = company;
        this.companyAddress = companyAddress;
        this.grade = grade;
        this.weight = weight;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(company, invoice.company) &&
                Objects.equals(companyAddress, invoice.companyAddress) &&
                Objects.equals(grade, invoice.grade) &&
                Objects.equals(weight, invoice.weight) &&
                Objects.equals(price, invoice.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, companyAddress, grade, weight, price);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "company='" + company + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", grade='" + grade + '\'' +
                ", weight='" + weight + '\'' +
                ", price=" + price +
                '}';
    }
}
