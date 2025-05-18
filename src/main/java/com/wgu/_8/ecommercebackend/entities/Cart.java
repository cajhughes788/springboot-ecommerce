package com.wgu._8.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.HashSet;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

    @JsonProperty("package_price")
    @Column(name = "package_price", nullable = false)
    private BigDecimal packagePrice;

    @JsonProperty("party_size")
    @Column(name = "party_size", nullable = false)
    private int partySize;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CartStatus status;

    @JsonProperty("order_tracking_number")
    @Column(name = "order_tracking_number", nullable = false)
    private String orderTrackingNumber;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> cartItems;

    public void add(CartItem cartItem) {
        if (cartItem != null) {
            if (cartItems == null) {
                cartItems = new HashSet<>();
            }
            cartItems.add(cartItem);
            cartItem.setCart(this);
        }
    }


}
