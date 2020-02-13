package com.dziedzic.warehouse.repository;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 13.02.2020
 */

import com.dziedzic.warehouse.model.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParameterRepository extends JpaRepository<Parameter, String> {
    List<Parameter> findAll();
}
