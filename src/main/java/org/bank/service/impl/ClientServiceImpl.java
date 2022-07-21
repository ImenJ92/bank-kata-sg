package org.bank.service.impl;

import org.bank.model.Client;
import org.bank.repository.ClientRepository;
import org.bank.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }
}
