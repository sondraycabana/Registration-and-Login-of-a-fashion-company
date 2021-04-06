package com.kc.fashion;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
//@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private  UserRepository repo;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("adu@gmail.com");
        user.setPassword("password");
        user.setFirstName("aduke");
        user.setLastName("adeleke");

        User saveUser = repo.save(user);
        assertThat(saveUser).isNotNull();
        log.info("saving user -> {}", saveUser);
//       User existUser = entityManager.find(User.class, saveUser.getId());

//       assertThat(existUser.getEmail()).isEqualTo(existUser.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email  = "layi@gmail.com";

        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();

    }
}