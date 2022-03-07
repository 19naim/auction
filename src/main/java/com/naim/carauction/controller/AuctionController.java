package com.naim.carauction.controller;

import com.naim.carauction.entities.AuctionItem;
import com.naim.carauction.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    AuctionService auctionService;

    @GetMapping
    public List<AuctionItem> getAllItems() {
        return auctionService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<AuctionItem> getOneItem(@PathVariable Long id) {
        return auctionService.getOneItem(id);
    }

    @GetMapping("/search/{name}")
    public List<AuctionItem> getByItemName(@PathVariable String name) {
        return auctionService.getByItemName(name);
    }

    @GetMapping("/myauctions/{ownerId}")
    public List<AuctionItem> getByItemOwner(@PathVariable int ownerId) {
        return auctionService.getAuctionByOwner(ownerId);
    }
}
