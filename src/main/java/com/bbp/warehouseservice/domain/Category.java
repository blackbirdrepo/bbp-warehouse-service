package com.bbp.warehouseservice.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(of = {"name"}, callSuper = true)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Accessors(chain = true)
@Entity
public class Category extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_category", name = "seq_category")

    private Long id;

    private String name;

    public static Category create(String name) {
        return new Category()
                .setName(name);
    }
}
