package org.bank.exceptions;

import org.bank.model.dto.OperationRequest;

public class UnauthorizedOperationException extends Throwable {
    public UnauthorizedOperationException(OperationRequest operationRequest) {
    }
}
