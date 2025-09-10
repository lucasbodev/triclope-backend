package com.triclope.dto.business;

import javax.security.auth.Subject;
import java.security.Principal;

public class TriclopePrincipal  implements Principal {

    private final String userName;

    private final String userId;

    public TriclopePrincipal (String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }
    @Override
    public String getName() {
        return "";
    }

    public String getUserId() {
        return userId;
    }

}
