package com.paulo.pauloBanque;

import com.paulo.pauloBanque.entity.*;
import com.paulo.pauloBanque.mettier.BanqueMettier;
import com.paulo.pauloBanque.repository.ClientRepository;
import com.paulo.pauloBanque.repository.CompteRepository;
import com.paulo.pauloBanque.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PauloBanqueApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private BanqueMettier banqueMettier;


	public static void main(String[] args) {
		SpringApplication.run(PauloBanqueApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Client client1 =  clientRepository.save(new Client("Paulo","paulo@gmail.com"));
		Client client2 =  clientRepository.save(new Client("Davido","davido@gmail.com"));
		Client client3 =  clientRepository.save(new Client("Elieo","elieo@gmail.com"));

		Compte cpt1 = compteRepository.save(new CompteEpargne("codePaulo",new Date(), 600000.0, client1, 5.5 ));
		Compte cpt2 = compteRepository.save(new CompteEpargne("codeDavido",new Date(), 700000.0, client2, 5.5 ));
		Compte cpt3 = compteRepository.save(new CompteEpargne("codeElieo",new Date(), 800000.0, client3, 5.5 ));

		operationRepository.save(new Versement(new Date(), 500000.0, cpt1));
		operationRepository.save(new Versement(new Date(), 6000000.0, cpt2));
		operationRepository.save(new Versement(new Date(), 7000000.0, cpt3));

		banqueMettier.verser("codePaulo" , 500000);
		banqueMettier.verser("codeDavido" , 600000);
		banqueMettier.verser("codeElieo" , 700000);
	}
}
