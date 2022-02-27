package com.naim.auction.services;

import com.naim.auction.dtos.SocketDTO;
import com.naim.auction.entities.AuctionItem;
import com.naim.auction.repositories.AuctionRepo;
import com.naim.auction.repositories.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {
    @Autowired
    AuctionRepo auctionRepo;

    @Autowired
    SocketService socketService;

    @Autowired
    BidRepo bidRepo;

    AuctionItem auctionItem;
    public List<AuctionItem> getAllItems() {
        return auctionRepo.findAll();
    }

    public Optional<AuctionItem> getOneItem(Long id) {
        return auctionRepo.findById(id);
    }

    public boolean postNewAuction(AuctionItem auctionItem) {
        AuctionItem savedAuction = auctionRepo.save(auctionItem);
        SocketDTO socketData = new SocketDTO("auction", savedAuction);
        socketService.sendToAllClient(socketData);
        return savedAuction.getId() > 0;
    }

    public List<AuctionItem> getByItemName(String item_name) {
        return auctionRepo.findAuctionByName(item_name);
    }

    public List<AuctionItem> getAuctionByOwner(int owner_id) {
        return auctionRepo.findAuctionByOwner(owner_id);
    }

}
