package com.g2academy.gramedia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
@AuditTable("customers_audit")
@Table(name = "customers")
public class Customer extends BaseEntity<String> implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Basket> baskets;

    public void addBasket(Basket basket){
        if (baskets == null){
            baskets = new HashSet<Basket>();
        }
        baskets.add(basket);
        basket.setCustomer(this);
    }
}
