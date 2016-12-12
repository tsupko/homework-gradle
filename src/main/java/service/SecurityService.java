package service;

/**
 * Service for Security.
 *
 * @author Alexander Tsupko
 * @version 1.0
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
