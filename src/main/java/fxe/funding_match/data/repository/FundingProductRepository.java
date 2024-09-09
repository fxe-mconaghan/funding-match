package fxe.funding_match.data.repository;

import fxe.funding_match.data.model.FundingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundingProductRepository extends JpaRepository<FundingProduct, String> {}
