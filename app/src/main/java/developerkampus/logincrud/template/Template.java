package developerkampus.logincrud.template;

/**
 * Created by Wamba on 23/05/2017.
 */

public interface Template {
    interface VolleyRetryPolicy{
        int SOCKET_TIMEOUT = 3000;
        int RETRIES = 1;
    }

    interface Query{
        String TAG = "tag";
        String USERNAME_BEFORE = "usernameBefore";
        String USERNAME = "username";
        String PASSWORD = "password";

        String LOGIN = "login";
        String SIGNUP = "signUp";
        String FIND = "find";
        String UPDATE = "update";
        String DELETE = "delete";
    }
}
