package com.wgu._8.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;

import java.time.LocalDateTime;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    public void add(Cart cart) {
        if (cart != null) {
            if (carts == null) {
                carts = new HashSet<>();
            }
            carts.add(cart);
            cart.setCustomer(this); // Ensure bidirectional linkage
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "address", nullable = false)
    private String address;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts;

    public String getPostal_code() {
        return this.postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

}

