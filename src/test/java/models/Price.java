package models;

import java.util.Objects;

public class Price {

    private double flatCharge;
    private double perTonne;
    private double item;

    public Price(double flatCharge, double perTonne, double item) {
        this.flatCharge = flatCharge;
        this.perTonne = perTonne;
        this.item = item;
    }

    public double getFlatCharge() {
        return flatCharge;
    }

    public void setFlatCharge(double flatCharge) {
        this.flatCharge = flatCharge;
    }

    public double getPerTonne() {
        return perTonne;
    }

    public void setPerTonne(double perTonne) {
        this.perTonne = perTonne;
    }

    public double getItem() {
        return item;
    }

    public void setItem(double item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.flatCharge, flatCharge) == 0 &&
                Double.compare(price.perTonne, perTonne) == 0 &&
                Double.compare(price.item, item) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flatCharge, perTonne, item);
    }

    @Override
    public String toString() {
        return "Price{" +
                "flatCharge=" + flatCharge +
                ", perTonne=" + perTonne +
                ", item=" + item +
                '}';
    }
}
