package org.bank.service.impl;

import org.bank.exceptions.NotFoundClientException;
import org.bank.model.Account;
import org.bank.model.OPERATION_TYPE;
import org.bank.model.Operation;
import org.bank.model.dto.OperationRequest;
import org.bank.repository.AccountRepository;
import org.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account findAccountsByClientId(Long clientId) throws NotFoundClientException {
        Account account = accountRepository.findByClientId(clientId);
        if (account == null){
            throw new NotFoundClientException(clientId);}
        return account;
    }

    public void updateAccount(Account account){
        accountRepository.save(account);
    }

    public Account updateBalance(OperationRequest operationRequest) throws NotFoundClientException{
        Account account = findAccountsByClientId(operationRequest.getClientId());
        if (operationRequest.getType().equals(OPERATION_TYPE.DEPOSIT)) {
            account.setBalance(account.getBalance() + operationRequest.getAmount());
        } else {
            account.setBalance(account.getBalance() - operationRequest.getAmount());
        }
        return account;
    }

}
