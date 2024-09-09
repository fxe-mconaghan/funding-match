package fxe.funding_match.api;

import fxe.funding_match.data.model.CompanyType;
import fxe.funding_match.data.model.Product;
import fxe.funding_match.service.FundingMatchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductMatchController {

    private final FundingMatchService fundingMatchService;

    public ProductMatchController(final FundingMatchService repository) {
        this.fundingMatchService = repository;
    }

    /**
     * Find all products.
     *
     * @return all products
     */
    @GetMapping("/allProducts")
    public List<Product> all() {
        return fundingMatchService.findAllProducts();
    }

    /**
     * Find any products which match the supplied criteria.
     *
     * @param industry the industry of the company applying for funding
     * @param companyType the type of the company applying for funding
     * @param fundingAmount the amount of funding desired
     * @param currentDebt the amount of debt the company applying for funding currently has
     *
     * @return a list of products which match the criteria, may be an empty list of no products match
     */
    @GetMapping("/findMatches")
    public List<Product> findMatches(@RequestParam String industry, @RequestParam CompanyType companyType, @RequestParam int fundingAmount, @RequestParam int currentDebt) {
        return Collections.emptyList();
    }
}
