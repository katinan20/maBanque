package com.paulo.pauloBanque.repository;

import com.paulo.pauloBanque.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, String> {
}
