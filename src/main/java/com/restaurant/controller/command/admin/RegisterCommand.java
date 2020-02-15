package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.User;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.restaurant.controller.PageUrlConstants.*;

@AllArgsConstructor
public class RegisterCommand extends UniCommand {

    private static final Logger LOG = Logger.getLogger(RegisterCommand.class);
    private UserService userService;

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        return new PageResponse(REGISTER_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        String name = request.getParameter("name");
        String login = request.getParameter("login");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        System.out.println("Registration name: " + name +
                ", login: " + login + ", password: " + password);

        HttpSession session = request.getSession();

        if (userService.validateLogin(login) && userService.validatePassword(password, confirmPassword)) {
            User newUser = userService.registrationUser(name, login, phone, password);
            LOG.debug("registration user: + " + newUser);

            User user = userService.getUserByLogin(login);
            session.setAttribute("user", user);
            LOG.info("registration user setAttribute: + " + user);
            return new PageResponse(HOME_PAGE,true);
        }
        request.setAttribute("notification", "Not valid login or password");
        return new PageResponse(REGISTER_PAGE);
    }
}
