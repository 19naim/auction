package com.naim.carauction.services;

import com.naim.carauction.entities.AuctionItem;
import com.naim.carauction.repositories.AuctionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {
    @Autowired
    AuctionRepo auctionRepo;

    AuctionItem auctionItem;
    public List<AuctionItem> getAllItems() {
        return auctionRepo.findAll();
    }

    public Optional<AuctionItem> getOneItem(Long id) {
        return auctionRepo.findById(id);
    }

    public List<AuctionItem> getByItemName(String item_name) {
        return auctionRepo.findAuctionByName(item_name);
    }

    public List<AuctionItem> getAuctionByOwner(int owner_id) {
        return auctionRepo.findAuctionByOwner(owner_id);
    }

}
