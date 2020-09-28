package com.cprime.bonfireevents.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserAdapterTest {


    @Autowired
    @Qualifier("userAdapterStub")
    private UserAdapter userAdapter;

    @Test
    public void testThatUserAdapterExists() {
        UserAdapter adapter;
    }

    @Test
    public void testThatUserAdapterFakeExistsForTesting() {
        int id = userAdapter.getUserId();
    }

    @Test
    public void testThatUserAdapterFakeGetIdReturns17() {
        assertEquals(17, userAdapter.getUserId());
    }
}
