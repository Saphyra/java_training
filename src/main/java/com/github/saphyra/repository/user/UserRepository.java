package com.github.saphyra.repository.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
