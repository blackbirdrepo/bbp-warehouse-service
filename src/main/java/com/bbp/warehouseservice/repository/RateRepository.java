package com.bbp.warehouseservice.repository;

import com.bbp.warehouseservice.domain.Inventory;
import com.bbp.warehouseservice.domain.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RateRepository extends JpaRepository<Rate, Long> {

    Page<Rate> findAllByInventory(Inventory inventory, Pageable pageable);

    @Query("select r from Rate r where r.inventory.id = :inventoryId and r.user = :userId")
    Optional<Rate> findByInventoryAndUser(@Param("inventoryId") Long inventoryId, @Param("userId") Long userId);

    @Query("SELECT AVG(r.score) FROM Rate r WHERE inventory_id = :inventoryId")
    Float findAverageRate(@Param("inventoryId") Long inventoryId);
}
