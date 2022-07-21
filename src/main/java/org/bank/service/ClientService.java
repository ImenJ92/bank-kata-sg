package org.bank.service;

import org.bank.model.Client;

import java.util.Optional;

public interface ClientService {

    Client createClient(Client client);

    Optional<Client> findClientById(Long clientId);

}
