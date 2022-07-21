package org.bank.repository;

import org.bank.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    Client findOneByLastName(String lastName);
}
