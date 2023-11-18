package com.paulo.pauloBanque.mettier;

import com.paulo.pauloBanque.entity.*;
import com.paulo.pauloBanque.repository.ClientRepository;
import com.paulo.pauloBanque.repository.CompteRepository;
import com.paulo.pauloBanque.repository.OperationRepository;
import com.paulo.pauloBanque.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BanqueMettier implements BanqueService {

    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte consulteCompte(String code) {
        Compte cp = compteRepository.findById(code).orElse(null);
        if (cp==null)throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void retirer(String codeCompte, double montant) {
        Compte cp = consulteCompte(codeCompte);
        double intban = 0;
        if (cp instanceof CompteCourant)
            intban = ((CompteCourant)cp).getDecouvert();
        if (cp.getSolde() + intban < montant)throw new RuntimeException("Solde insuffisant");
        Retrait r = new Retrait(new Date(), montant, cp);
        operationRepository.save(r);
        cp.setSolde(cp.getSolde() - montant);
        compteRepository.save(cp);
    }

    @Override
    public void verser(String codeCompte, double montant) {
        Compte cp = consulteCompte(codeCompte);
        Versement v = new Versement(new Date(), montant, cp);
        operationRepository.save(v);
        cp.setSolde(cp.getSolde() + montant);
        compteRepository.save(cp);
    }

    @Override
    public void virement(String codeCompte1, String codeCmpte2, double mantant) {
        if (codeCompte1.equals(codeCmpte2))throw new RuntimeException("virement sur le même compte imposible");
        retirer(codeCompte1, mantant);
        verser(codeCmpte2, mantant);
    }

    @Override
    public Page<Operation> listeOperation(String codeCompte, int page, int size) {
        return operationRepository.listeOperation(codeCompte, PageRequest.of(page, size));
    }
}
