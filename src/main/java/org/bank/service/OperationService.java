package org.bank.service;

import org.bank.model.Operation;

import java.util.List;

public interface OperationService {

    Operation createOperation(Operation operation);

    List<Operation> findOperationsByAccountId(Long accountId);
}
