package fxe.funding_match.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Represents a funding product. THis is the DAO equivalent of the {@link Product} entity.
 */
@Entity(name = "funding_product")
public class FundingProduct {

    @Id
    private String id;
    private String name;
    private String funder;

    @Column(name = "maximum_term_months")
    private int maximumTermMonths;
    private float price;

    public FundingProduct() {

    }

    public FundingProduct(final String id, final String name, final String funder, final int maximumTermMonths, final float price) {
        this.id = id;
        this.name = name;
        this.funder = funder;
        this.maximumTermMonths = maximumTermMonths;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getFunder() {
        return funder;
    }

    public int getMaximumTermMonths() {
        return maximumTermMonths;
    }

    public float getPrice() {
        return price;
    }
}
