INSERT INTO client(id, FIRST_NAME, LAST_NAME, address, birthdate) VALUES(15, 'paul', 'charles', '8 Rue Beaurepaire, 75010 Paris', PARSEDATETIME(FORMATDATETIME('1984-01-12', 'yyyy-MM-dd'), 'yyyy-MM-dd'));
INSERT INTO account(id, client_id, creation_date, balance) VALUES(20, 15, CURRENT_TIMESTAMP, 0);
INSERT INTO operation(id, account_id, creation_date, type, amount, balance) VALUES(40, 20, CURRENT_TIMESTAMP, 'DEPOSIT', 100.5, 100.5);
INSERT INTO operation(id, account_id, creation_date, type, amount, balance) VALUES(50, 20, CURRENT_TIMESTAMP, 'DEPOSIT', 50.5, 50.0);
