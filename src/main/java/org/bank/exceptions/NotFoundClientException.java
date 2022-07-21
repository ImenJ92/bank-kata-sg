package org.bank.exceptions;

import org.bank.model.dto.OperationRequest;

public class NotFoundClientException  extends Throwable {
    public NotFoundClientException(Long clientId) {
    }
}
