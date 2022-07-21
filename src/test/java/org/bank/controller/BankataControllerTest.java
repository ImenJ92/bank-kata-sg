package org.bank.controller;

import org.bank.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BankataController.class)
public class BankataControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    @Autowired
    BankService bankService;

    @Test
    public void getAccountStatement() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/bankata/account_statement/{id}", 15)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getOperationsHistory() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/bankata/operation_history/{id}", 15)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
