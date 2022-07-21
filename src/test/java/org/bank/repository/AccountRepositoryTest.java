package org.bank.repository;


import org.bank.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {


    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void should_create_new_Client() {
        Account account = new Account(30l,new Date(),900.0);
        accountRepository.save(account);

        Account accountByClientId = accountRepository.findByClientId(30l);
        assertThat(accountByClientId).isNotNull();
        assertThat(accountByClientId.getBalance()).isEqualTo(900.0);

    }

    @Test
    public void should_find_all_accounts() {
        Iterable<Account> accounts = accountRepository.findAll();
        assertThat(accounts).hasSize(1);
    }

    @Test
    public void should_delete_account() {
        Account accountByClientId = accountRepository.findByClientId(15l);
        assertThat(accountByClientId).isNotNull();

        accountRepository.delete(accountByClientId);

        Iterable<Account> accounts = accountRepository.findAll();
        assertThat(accounts).hasSize(0);
    }


}
