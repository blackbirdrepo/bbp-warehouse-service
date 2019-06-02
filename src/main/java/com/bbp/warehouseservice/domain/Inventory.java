package com.bbp.warehouseservice.domain;


import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@EqualsAndHashCode(of = {"sku", "name", "model"}, callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Check(constraints = "quantity >= 0")
public class Inventory extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inventory")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_inventory", name = "seq_inventory")
    private Long id;

    private String sku;

    private String name;

    private String model;

    private BigDecimal price;

    private int quantity;

    @ManyToOne
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    //TODO replace with table containing certain products
    @OneToMany(mappedBy = "inventory")
    private Set<Rate> rates;

    //TODO possibly replace with builder
    public static Inventory create(String sku, String name, String model, BigDecimal price, int quantity,
                                   Brand brand, Category category) {
        return new Inventory()
                .setSku(sku)
                .setName(name)
                .setModel(model)
                .setPrice(price)
                .setQuantity(quantity)
                .setBrand(brand)
                .setCategory(category);
    }
}
