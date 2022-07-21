package org.bank.service;

import org.bank.exceptions.NotFoundClientException;
import org.bank.exceptions.UnauthorizedOperationException;
import org.bank.model.Account;
import org.bank.model.Operation;
import org.bank.model.dto.OperationRequest;

import java.util.List;

public interface BankService {

    void validateOperation(OperationRequest operationRequest) throws UnauthorizedOperationException, NotFoundClientException;

    void deposit(OperationRequest operationRequest) throws NotFoundClientException;

    void withdrawal(OperationRequest operationRequest) throws NotFoundClientException;

    List<Operation> operationsHistory(Long clientId) throws NotFoundClientException;

    Account accountStatement(Long clientId) throws NotFoundClientException;
}
