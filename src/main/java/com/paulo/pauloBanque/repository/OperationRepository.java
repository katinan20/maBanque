package com.paulo.pauloBanque.repository;

import com.paulo.pauloBanque.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
