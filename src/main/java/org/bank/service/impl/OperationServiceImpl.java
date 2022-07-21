package org.bank.service.impl;

import org.bank.exceptions.UnauthorizedOperationException;
import org.bank.model.Account;
import org.bank.model.Operation;
import org.bank.repository.AccountRepository;
import org.bank.repository.OperationRepository;
import org.bank.service.OperationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @Override
    public Operation createOperation(Operation operation) {
        return operationRepository.save(operation);
    }

    public List<Operation> findOperationsByAccountId(Long accountId) {

        return operationRepository.findOperationsByAccountId(accountId);
    }



}
