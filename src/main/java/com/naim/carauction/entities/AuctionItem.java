package com.naim.carauction.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "auction_items")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String item_name;
    private String description;
    @Column(nullable = true)
    private int owner_id;
    private String item_image;
    private int initial_price;
    private long start_date;
    private long stop_date;
}
