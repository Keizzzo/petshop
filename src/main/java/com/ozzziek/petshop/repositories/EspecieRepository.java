package com.ozzziek.petshop.repositories;

import com.ozzziek.petshop.domain.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {
}
