package org.bank.service.impl;

import org.bank.exceptions.NotFoundClientException;
import org.bank.exceptions.UnauthorizedOperationException;
import org.bank.model.Account;
import org.bank.model.OPERATION_TYPE;
import org.bank.model.Operation;
import org.bank.model.dto.OperationRequest;
import org.bank.service.AccountService;
import org.bank.service.BankService;
import org.bank.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    AccountService accountService;

    @Autowired
    OperationService operationService;

    @Override
    public void validateOperation(OperationRequest operationRequest) throws UnauthorizedOperationException, NotFoundClientException {
        Account account = accountService.findAccountsByClientId(operationRequest.getClientId());
        if (operationRequest.getType().equals(OPERATION_TYPE.WITHDRAW) && (account.getBalance() - operationRequest.getAmount()) < 0) {
            throw new UnauthorizedOperationException(operationRequest);
        }
    }

    @Override
    public void deposit(OperationRequest operationRequest) throws NotFoundClientException {
        applyOperation(operationRequest, OPERATION_TYPE.DEPOSIT);
    }

    @Override
    public void withdrawal(OperationRequest operationRequest) throws NotFoundClientException {
        applyOperation(operationRequest, OPERATION_TYPE.WITHDRAW);
    }

    public void applyOperation(OperationRequest operationRequest, OPERATION_TYPE operation_type) throws NotFoundClientException {
        Account account = accountService.updateBalance(operationRequest);
        Operation operation = new Operation(account.getId(), operation_type, operationRequest.getAmount(), account.getBalance(), new Date());
        operationService.createOperation(operation);
        accountService.updateAccount(account);
    }

    @Override
    public List<Operation> operationsHistory(Long clientId) throws NotFoundClientException {
        Account account = accountService.findAccountsByClientId(clientId);
        List<Operation> operationList = operationService.findOperationsByAccountId(account.getId());
        return operationList;
    }

    @Override
    public Account accountStatement(Long clientId) throws NotFoundClientException {
        return accountService.findAccountsByClientId(clientId);
    }
}
