package com.simple.basicbootswaginmem.controllers;

import com.simple.basicbootswaginmem.db.User;
import com.simple.basicbootswaginmem.db.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spring boot 2 mockito2 Junit5 example")
class UserControllerTest {
    @Mock
    UserRepository mockRepo;

    @InjectMocks
    UserController uc;

    @BeforeEach
    void setMockOutput() {
        User user = new User();
        user.setName("Fred");
        when(mockRepo.getOne(1L)).thenReturn(user);
    }

    @Test
    void user() {
      User result = uc.user(1L);
      assertEquals("Fred", result.getName());
    }


}