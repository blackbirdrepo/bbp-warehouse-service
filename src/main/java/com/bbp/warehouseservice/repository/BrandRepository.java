package com.bbp.warehouseservice.repository;

import com.bbp.warehouseservice.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
