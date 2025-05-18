package com.wgu._8.ecommercebackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url")
    private String image_URL;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Column(name = "travel_fare_price", nullable = false)
    private BigDecimal travel_price;

    @Column(name = "vacation_title", nullable = false)
    private String vacation_title;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL)
    private java.util.List<Excursion> excursions;
}
