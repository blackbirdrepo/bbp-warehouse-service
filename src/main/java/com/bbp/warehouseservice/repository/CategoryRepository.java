package com.bbp.warehouseservice.repository;

import com.bbp.warehouseservice.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
