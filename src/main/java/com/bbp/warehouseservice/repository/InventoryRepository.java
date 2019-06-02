package com.bbp.warehouseservice.repository;

import com.bbp.warehouseservice.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Modifying
    @Query("UPDATE Inventory i SET quantity = quantity - :subtrahend WHERE i = :inventory")
    void reduceInventoryQuantity(@Param("inventory") Inventory inventory,
                                 @Param("subtrahend") int subtrahend);
}
