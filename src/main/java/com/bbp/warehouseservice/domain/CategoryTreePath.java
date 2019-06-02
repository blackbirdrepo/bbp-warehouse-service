package com.bbp.warehouseservice.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(of = {"ancestor", "descendant"})
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Accessors(chain = true)
@Entity
public class CategoryTreePath {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_tree_path")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_category_tree_path", name = "seq_category_tree_path")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category ancestor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category descendant;

}