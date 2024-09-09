package fxe.funding_match;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FundingMatchApplicationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void getAllProductsShouldReturn5Products() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/allProducts",
				List.class)).hasSize(5);
	}

	@Test
	void findMatchesShouldReturn0Products() {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/findMatches?industry=farming&companyType=PARTNERSHIP&fundingAmount=15000&currentDebt=50000",
				List.class)).hasSize(0);
	}
}
