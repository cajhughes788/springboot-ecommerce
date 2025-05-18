package com.wgu._8.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name= "vacation_id")
    private Vacation vacation;

@ManyToMany
@JoinTable(
        name = "excursion_cartitem",
        joinColumns = @JoinColumn(name = "cart_item_id"),
        inverseJoinColumns = @JoinColumn(name = "excursion_id")
)
private Set<Excursion> excursions;
}
