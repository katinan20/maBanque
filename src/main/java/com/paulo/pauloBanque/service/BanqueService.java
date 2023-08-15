package com.paulo.pauloBanque.service;

import com.paulo.pauloBanque.entity.Compte;
import com.paulo.pauloBanque.entity.Operation;
import org.springframework.data.domain.Page;

public interface BanqueService {
    Compte consulteCompte(String code);
    void retirer(String codeCompte, double montant);
    void verser(String codeCompte, double montant);
    void virement(String codeCompte1, String codeCmpte2, double mantant);
    Page<Operation> listeOperation(String codeCompte, int page, int size);
}
