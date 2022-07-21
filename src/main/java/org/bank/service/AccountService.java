package org.bank.service;

import org.bank.exceptions.NotFoundClientException;
import org.bank.model.Account;
import org.bank.model.dto.OperationRequest;

public interface AccountService {

    Account createAccount(Account account);

    Account findAccountsByClientId(Long clientId) throws NotFoundClientException;

    void updateAccount(Account account);

    Account updateBalance(OperationRequest operationRequest) throws NotFoundClientException;
}
