package com.bbp.warehouseservice.repository;

import com.bbp.warehouseservice.domain.CategoryTreePath;
import org.mapstruct.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryTreePathRepository extends JpaRepository<CategoryTreePath, Long> {

    @Modifying
    @Query(value = "INSERT INTO category_tree_path(id, ancestor_id, descendant_id)" +
            " SELECT nextval('seq_category_tree_path'), ancestor_id, :descendantId" +
            " FROM category_tree_path" +
            " WHERE descendant_id = :ancestorId" +
            " UNION ALL SELECT nextval('seq_category_tree_path'), :descendantId, :descendantId", nativeQuery = true)
    void insertNestedCategoryPath(@Param("ancestorId") Long ancestorId, @Param("descendantId") Long descendantId);

    @Modifying
    @Query(value = "INSERT INTO category_tree_path(id, ancestor_id, descendant_id)" +
            " VALUES(nextval('seq_category_tree_path'), :descendantId, :descendantId)", nativeQuery = true)
    void insertRootCategoryPath(@Param("descendantId") Long descendantId);
}
