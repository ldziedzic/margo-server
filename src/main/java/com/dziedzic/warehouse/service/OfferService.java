package com.dziedzic.warehouse.service;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */

import com.dziedzic.warehouse.model.Offer;
import com.dziedzic.warehouse.repository.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final Logger log = LoggerFactory.getLogger(OfferService.class);

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> getAllOffers() {
        log.info("Getting all offers.");
        return offerRepository.findAll();
    }
}
