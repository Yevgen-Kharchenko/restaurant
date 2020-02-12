package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import com.restaurant.model.User;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.restaurant.controller.PageUrlConstants.*;

public class RegisterCommand extends UniCommand {

    private static final Logger LOG = Logger.getLogger(RegisterCommand.class);
    private UserService userService;

    public RegisterCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(REGISTER_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        System.out.println("Registration name: " + name +
                ", login: " + login + ", password: " + password);

        HttpSession session = request.getSession();

        if (userService.validateLogin(login) && userService.validatePassword(password, confirmPassword)) {
            User newUser = userService.registrationUser(name, login, password);
            LOG.debug("registration user: + " + newUser);

            User user = userService.getUserByLogin(login);
            session.setAttribute("user", user);
            LOG.info("registration user setAttribute: + " + user);
            return new Page(REDIRECT_HOME_PAGE, true);
        }
        request.setAttribute("notification", "Not valid login or password");
        return new Page(HOME_PAGE, false);
    }
}
