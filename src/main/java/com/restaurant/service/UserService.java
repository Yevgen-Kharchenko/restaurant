package com.restaurant.service;

import com.restaurant.controller.view.UserDTO;
import com.restaurant.model.User;
import com.restaurant.model.enums.Role;
import com.restaurant.repository.DaoFactory;
import com.restaurant.repository.impl.UserDaoImpl;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;


public class UserService {

    private static final Logger LOG = Logger.getLogger(UserService.class);
    private UserDaoImpl userDao;

    public UserService() {
        this.userDao = DaoFactory.getUserDao();
    }

    /**
     * Validates User's Login and checks if it corresponds with password
     *
     * @param login
     * @param password
     * @return
     */
    public boolean validateUser(String login, String password) {
        User user = userDao.getByLogin(login);
        LOG.info("Get user by login:" + user);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                LOG.info("user validate");
                return true;
            }
        }
        return false;
    }

    /**
     * Validates if Login exists in DB
     *
     * @param login
     * @return
     */
    public boolean validateLogin(String login) {
        List<User> all = userDao.getAll();
        for (User user : all) {
            if (user.getLogin().equals(login)) {
                System.out.println("Not validate login: " + user.getLogin());
                return false;
            }
        }
        return true;
    }

    /**
     * Validates whether confirmPasswords corresponds with Password
     *
     * @param password
     * @param confirmPassword
     * @return
     */
    public boolean validatePassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) return true;
        return false;
    }

    /**
     * Gets User by ID from DB
     *
     * @param id
     * @return
     */
    public User getUser(long id) {
        return userDao.getById(id);
    }

    /**
     * Gets User by Login from DB
     *
     * @param login
     * @return
     */
    public User getUserByLogin(String login) {
        return userDao.getByLogin(login);
    }

    /**
     * Converts data from Post request to User and stores it into DB
     *
     * @param name
     * @param login
     * @param password
     * @return
     */
    public User registrationUser(String name,String login, String phone, String password) {
        User newUser = User.builder()
                .name(name)
                .login(login)
                .phone(phone)
                .password(password)
                .role(Role.GUEST)
                .build();
        userDao.create(newUser);
        return newUser;
    }

    /**
     * Converts data from Post request to User and updates it in DB
     *
     * @param id
     * @param name
     * @param phone
     * @param login
     * @param password
     * @param role
     * @return
     */


    public User updateUser(int id, String name, String phone, String login, String password, Role role) {
        User updatedUser = User.builder()
                .id(id)
                .name(name)
                .phone(phone)
                .login(login)
                .password(password)
                .role(Role.GUEST)
                .build();
        userDao.update(updatedUser);
        return updatedUser;
    }



    /**
     * Gets List UserDTO from DB
     *
     * @return
     */
    public List<UserDTO> getAll() {
        List<User> all = userDao.getAll();
        return mapToUserDTO(all);
    }

    /**
     * Gets a paginated List UserDTO from DB
     *
     * @param page
     * @param size
     * @return
     */
    public List<UserDTO> getAllPaginated(int page, int size) {
        List<User> all = userDao.getAllPaginated(page, size);
        return mapToUserDTO(all);
    }

    /**
     * Adds List User to List UserDTO
     *
     * @param all
     * @return
     */
    private List<UserDTO> mapToUserDTO(List<User> all) {
        return all.stream().map(users -> {
            User userProfile = userDao.getById(users.getId());
            UserDTO userDTO = new UserDTO();

            userDTO.setId(userProfile.getId());
            userDTO.setName(userProfile.getName());
            userDTO.setPhone(userProfile.getPhone());
            userDTO.setLogin(userProfile.getLogin());
            userDTO.setRole(userProfile.getRole());
            return userDTO;
        }).collect(Collectors.toList());
    }

    /**
     * Deletes User from DB
     *
     * @param id
     */
    public void deleteUser(long id) {
        User deletedUser = getUser(id);
        userDao.remove(deletedUser);
    }
}
