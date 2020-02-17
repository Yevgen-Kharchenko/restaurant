package com.restaurant.service;

import com.restaurant.model.User;
import com.restaurant.model.enums.Role;
import com.restaurant.repository.impl.UserDaoImpl;
import com.restaurant.utils.PasswordsUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserService userService;
    private UserDaoImpl userDao = mock(UserDaoImpl.class);

    @Before
    public void init() {
        userService = new UserService(userDao);
    }

    @Test
    public void shouldReturnTrueValidUser() {
        String name = "John";
        String phone = "123456789";
        String login = "login";
        String password = "password";
        String hashedPass = PasswordsUtil.hash(password.trim());
        when(userDao.getByLogin(anyString())).thenReturn(new User(1, name, phone, login, hashedPass, Role.GUEST));
        assertTrue(userService.validateUser(login, password));
    }

    @Test
    public void shouldReturnFalseInvalidPassword() {
        String name = "John";
        String phone = "123456789";
        String login = "login";
        String password = "password";
        String wrongPassword = "wrongPassword";
        String hashedPass = PasswordsUtil.hash(password.trim());
        when(userDao.getByLogin(anyString())).thenReturn(new User(1, name, phone, login, hashedPass, Role.GUEST));
        assertFalse(userService.validateUser(login, wrongPassword));
    }

    @Test
    public void shouldReturnTrueIfUserExist() {
        String login = "login";
        when(userDao.isUserExists(anyString())).thenReturn(true);
        assertFalse(userService.validateLogin(login));
    }

    @Test
    public void shouldReturnFalseIfUserNotExist() {
        String login = "login";
        when(userDao.isUserExists(anyString())).thenReturn(false);
        assertTrue(userService.validateLogin(login));
    }

    @Test
    public void shouldReturnTrueIfValidPassword() {
        String password = "password";
        String confirmPassword = "password";
        assertTrue(userService.validatePassword(password, confirmPassword));
    }

    @Test
    public void shouldReturnFalseIfInvalidPassword() {
        String password = "password";
        String confirmPassword = "wrongPassword";
        assertFalse(userService.validatePassword(password, confirmPassword));
    }

    @Test
    public void shouldReturnUserById() {
        long id = 1;
        String name = "John";
        String phone = "123456789";
        String login = "login";
        String password = "password";
        String hashedPass = PasswordsUtil.hash(password.trim());
        User user = new User(id, name, phone, login, hashedPass, Role.GUEST);
        when(userDao.getById(anyLong())).thenReturn(user);
        assertEquals(userService.getUser(1), user);
    }

    @Test
    public void shouldReturnUserByLogin() {
        long id = 1;
        String name = "John";
        String phone = "123456789";
        String login = "login";
        String password = "password";
        String hashedPass = PasswordsUtil.hash(password.trim());
        User user = new User(id, name, phone, login, hashedPass, Role.GUEST);
        when(userDao.getByLogin(anyString())).thenReturn(user);
        assertEquals(userService.getUserByLogin(login), user);
    }

    @Test
    public void shouldRegistrationUser() {
        String name = "John";
        String phone = "123456789";
        String login = "login";
        String password = "password";
        String hashedPass = PasswordsUtil.hash(password.trim());
        User newUser = User.builder()
                .name(name)
                .login(login)
                .phone(phone)
                .password(hashedPass)
                .role(Role.GUEST)
                .build();
        when(userDao.create(anyObject())).thenReturn(newUser);
        User actualUser = userService.registrationUser(name, login, phone, password);

        assertEquals(actualUser.getName(), name);
        assertEquals(actualUser.getLogin(), login);
        assertEquals(actualUser.getPhone(), phone);
        assertTrue(PasswordsUtil.verifyHash(password, newUser.getPassword()));
    }
}
