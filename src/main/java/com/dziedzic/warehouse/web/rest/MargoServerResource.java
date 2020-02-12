package com.dziedzic.warehouse.web.rest;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */
import com.dziedzic.warehouse.model.Offer;
import com.dziedzic.warehouse.service.OfferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/margo")
public class MargoServerResource {
    private final OfferService offerService;

    public MargoServerResource(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/offers")
    public List<Offer> getOffers() {
        return offerService.getAllOffers();
    }
}
