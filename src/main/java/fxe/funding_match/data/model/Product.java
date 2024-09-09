package fxe.funding_match.data.model;

/**
 * Represents a funding product. THis is the DTO equivalent of the {@link FundingProduct} entity.
 */
public record Product(String name, String funder, int maximumTermMonths, float price) {}
