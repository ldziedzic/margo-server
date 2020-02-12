package com.dziedzic.warehouse.repository;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */

import com.dziedzic.warehouse.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, String> {

    Optional<Offer> findOneBySignature(String signature);
    List<Offer> findAll();
}
