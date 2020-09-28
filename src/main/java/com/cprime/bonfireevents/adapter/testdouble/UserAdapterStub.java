package com.cprime.bonfireevents.adapter.testdouble;

import com.cprime.bonfireevents.adapter.UserAdapter;
import org.springframework.stereotype.Service;

@Service("userAdapterStub")
public class UserAdapterStub implements UserAdapter {

    @Override
    public int getUserId() {
        return 17;
    }
}
