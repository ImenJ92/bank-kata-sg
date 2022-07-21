package org.bank.model.dto;

import lombok.Data;
import org.bank.model.OPERATION_TYPE;

@Data
public class OperationRequest {
    private long clientId;
    private OPERATION_TYPE type;
    private double amount;
}
