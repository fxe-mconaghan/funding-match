package fxe.funding_match.api;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import fxe.funding_match.data.model.Product;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import fxe.funding_match.service.FundingMatchService;

import java.util.Collections;

@WebMvcTest(ProductMatchController.class)
class ProductMatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FundingMatchService service;

    @Test
    void allProductsShouldBeReturnedToAllProductsEndpoint() throws Exception {
        when(service.findAllProducts()).thenReturn(Collections.singletonList(new Product("Test product Name", "Test Funder", 1, (float) 1.0)));
        mockMvc.perform(get("/allProducts")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Test product Name")));
    }

    @Test
    void noProductsShouldBeReturnedToFindMatchesEndpoint() throws Exception {
        mockMvc.perform(get("/findMatches?industry=farming&companyType=PARTNERSHIP&fundingAmount=15000&currentDebt=50000")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}
