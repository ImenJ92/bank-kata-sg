package org.bank.repository;

import org.bank.model.Account;
import org.bank.model.OPERATION_TYPE;
import org.bank.model.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OperationRepositoryTest {

    @Autowired
    private OperationRepository operationRepository;


    @Test
    public void should_create_new_Client() {
        Operation operation = new Operation(40l, OPERATION_TYPE.DEPOSIT, 100.0,0.0, new Date());
        operationRepository.save(operation);

        List<Operation> operationByAccountId = operationRepository.findOperationsByAccountId(40l);
        assertThat(operationByAccountId).isNotNull();
        assertThat(operationByAccountId.size()).isEqualTo(1);
        assertThat(operationByAccountId.get(0).getAmount()).isEqualTo(100.0);

    }

    @Test
    public void should_find_all_operations() {
        Iterable<Operation> operations = operationRepository.findAll();
        assertThat(operations).hasSize(2);
    }

    @Test
    public void should_delete_operation() {
        List<Operation> operationsByClientId = operationRepository.findOperationsByAccountId(20l);
        assertThat(operationsByClientId).isNotNull();
        assertThat(operationsByClientId).hasSize(2);

        operationRepository.delete(operationsByClientId.get(0));

        Iterable<Operation> operations = operationRepository.findAll();
        assertThat(operations).hasSize(1);
    }
}
