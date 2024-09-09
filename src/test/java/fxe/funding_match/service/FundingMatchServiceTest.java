package fxe.funding_match.service;

import fxe.funding_match.data.model.FundingProduct;
import fxe.funding_match.data.model.Product;
import fxe.funding_match.data.repository.FundingProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = FundingMatchService.class)
class FundingMatchServiceTest {

    @Autowired
    private FundingMatchService fundingMatchService;

    @MockBean
    private FundingProductRepository fundingProductRepository;

    @Test
    void productsShouldBeReturnedFromRepository() {
        when(fundingProductRepository.findAll()).thenReturn(Collections.singletonList(new FundingProduct("Test ID", "Test product Name", "Test Funder", 1, (float) 1.0)));

        List<Product> actual = fundingMatchService.findAllProducts();
        assertThat(actual).containsExactly(new Product("Test product Name", "Test Funder", 1, (float) 1.0));
    }
}
