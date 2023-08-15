package com.paulo.pauloBanque.repository;

import com.paulo.pauloBanque.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
