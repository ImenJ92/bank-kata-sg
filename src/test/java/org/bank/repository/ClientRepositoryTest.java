package org.bank.repository;

import org.bank.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void should_create_new_Client() throws ParseException {
        Client client = new Client("Nicolas", "Bernard", "8 Rue Beaurepaire, 75010 Paris", new SimpleDateFormat("yyyy-MM-dd").parse("1982-01-01"));
        clientRepository.save(client);

        Client clientByName = clientRepository.findOneByLastName("Bernard");
        assertThat(clientByName).isNotNull();
        assertThat(clientByName.getFirstName()).isEqualTo("Nicolas");


    }

    @Test
    public void should_find_all_clients() {
        Iterable<Client> users = clientRepository.findAll();
        assertThat(users).hasSize(1);
    }

    @Test
    public void should_delete_client() {
        Client userByName = clientRepository.findOneByLastName("charles");
        assertThat(userByName).isNotNull();

        clientRepository.delete(userByName);

        Iterable<Client> users = clientRepository.findAll();
        assertThat(users).hasSize(0);
    }

}
