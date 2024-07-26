package com.example.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;
    static {
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(39)));
        users.add(new User(++usersCount,"Eva", LocalDate.now().minusYears(20)));
        users.add(new User(++usersCount,"Tom", LocalDate.now().minusYears(15)));
    }

    public List<User> findAll() {
        return users;
    }

    public User getUser(int id) {
        User user = users.stream()
                .filter(e -> e.getId() == id)
                .findFirst().orElse(null);
        return user;
    }

    public User createUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User deleteUser(int id) {
        User user = users.stream()
            .filter(e -> e.getId() == id)
            .findFirst().orElse(null);
        users.remove(user);
        return user;
    }
}
