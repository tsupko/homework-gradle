package service;

import model.User;

/**
 * Service class for {@link model.User}
 *
 * @author Alexander Tsupko
 * @version 1.0
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
