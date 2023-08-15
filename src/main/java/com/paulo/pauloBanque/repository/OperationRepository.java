package com.paulo.pauloBanque.repository;

import com.paulo.pauloBanque.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    @Query("select o from Operation o where o.compte.numCompte=:x order by o.dateOperation desc")
    public Page<Operation> listeOperation(@Param("x") String codecpt, Pageable pageable);
}

