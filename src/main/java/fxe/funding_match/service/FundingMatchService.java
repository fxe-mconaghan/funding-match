package fxe.funding_match.service;

import fxe.funding_match.data.model.Product;
import fxe.funding_match.data.model.FundingProduct;
import fxe.funding_match.data.repository.FundingProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A service which matches funding requests to funding products.
 */
@Service
public class FundingMatchService {

    private final FundingProductRepository repository;

    public FundingMatchService(final FundingProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAllProducts() {
        List<FundingProduct> all = repository.findAll();
        return all.stream().map(it -> new Product(it.getName(), it.getFunder(), it.getMaximumTermMonths(), it.getPrice())).toList();
    }
}
