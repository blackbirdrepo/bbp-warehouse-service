package com.bbp.warehouseservice.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(of = {"user", "inventory"})
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rate")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_rate", name = "seq_rate")
    private Long id;

    private float score;

    @ManyToOne(fetch = FetchType.LAZY)
    private Inventory inventory;

    @Column(name = "user_id")
    private Long user;

    public static Rate create(float rate, Inventory inventory, Long userId) {
        return new Rate()
                .setScore(rate)
                .setInventory(inventory)
                .setUser(userId);
    }
}
