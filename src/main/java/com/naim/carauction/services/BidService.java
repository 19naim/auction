package com.naim.carauction.services;

import com.naim.carauction.dtos.SocketDTO;
import com.naim.carauction.entities.Bid;
import com.naim.carauction.repositories.BidRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService {
    @Autowired
    BidRepo bidRepo;

    public List<Bid> getAllBids() {
        return bidRepo.findAll();
    }

    public Optional<Bid> getBidById(Long id) {
        return bidRepo.findById(id);
    }

    public List<Bid> findBidsByAuctionId(long auctionID) {
        return bidRepo.findBidsByAuctionId(auctionID);
    }

    public Bid postNewBid(Bid bid) {
        Bid savedBid = bidRepo.save(bid);
        SocketDTO socketData = new SocketDTO("bid", savedBid);
        return savedBid;
    }

}

