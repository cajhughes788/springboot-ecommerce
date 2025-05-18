package com.wgu._8.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "excursions")
@Getter
@Setter
@NoArgsConstructor
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "excursion_price", nullable = false)
    private BigDecimal excursion_price;

    @Column(name = "excursion_title", nullable = false)
    private String excursion_title;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}
