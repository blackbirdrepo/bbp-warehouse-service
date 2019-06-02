package com.bbp.warehouseservice.domain;

import com.bbp.warehouseservice.domain.enums.CountryEnum;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(of = {"name", "country"}, callSuper = true)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Accessors(chain = true)
@Entity
public class Brand extends AbstractAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_brand")
    @SequenceGenerator(allocationSize = 1, sequenceName = "seq_brand", name = "seq_brand")
    private Long id;

    private String name;

    private CountryEnum country;

    private boolean premium;

    public static Brand create(String name, CountryEnum country, boolean premium) {
        return new Brand()
                .setName(name)
                .setCountry(country)
                .setPremium(premium);
    }
}
