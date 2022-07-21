package org.bank.controller;


import org.bank.exceptions.NotFoundClientException;
import org.bank.exceptions.UnauthorizedOperationException;
import org.bank.model.Account;
import org.bank.model.Operation;
import org.bank.model.dto.OperationRequest;
import org.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/bankata")
public class BankataController {
    @Autowired
    private BankService bankService;


    @RequestMapping(value = "/deposit", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> deposit(@RequestBody OperationRequest operationRequest) {
        try {
            bankService.deposit(operationRequest);
        } catch (NotFoundClientException e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


    @RequestMapping(value = "/withdrawal", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> withdrawal(@RequestBody OperationRequest operationRequest) {
        try {
            bankService.validateOperation(operationRequest);
            bankService.withdrawal(operationRequest);

        } catch (NotFoundClientException e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
        }  catch (UnauthorizedOperationException e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }


    @RequestMapping(value = "/operation_history/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<List<Operation>> getOperationsHistory(@PathVariable Long clientId){
        List<Operation> operations=null;
        try {
            operations = bankService.operationsHistory(clientId);
        } catch (NotFoundClientException e) {
            return new ResponseEntity<List<Operation>>(operations, HttpStatus.NO_CONTENT);
        }   catch (Exception e) {
            return new ResponseEntity<List<Operation>>(operations, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Operation>>(operations, HttpStatus.OK);

    }

    @RequestMapping(value = "/account_statement/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccountStatement(@PathVariable Long clientId){

        Account account = null;
        try {
            account = bankService.accountStatement(clientId);
        } catch (NotFoundClientException e) {
            return new ResponseEntity<Account>(account, HttpStatus.NO_CONTENT);
        }   catch (Exception e) {
            return new ResponseEntity<Account>(account, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(account, HttpStatus.OK);

    }

}
