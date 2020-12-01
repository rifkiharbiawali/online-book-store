package com.g2academy.gramedia.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Audited
@AuditTable("warehouse_audit")
@Table(name = "warehouse")
public class Warehouse extends BaseEntity<String> implements Serializable {

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Wb> wbs;
}
