package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.PageResponse;
import com.restaurant.model.User;
import com.restaurant.model.enums.Role;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.restaurant.controller.PageUrlConstants.*;

public class LoginCommand extends UniCommand {
    private UserService userService;
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);

    public LoginCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected PageResponse performGet(HttpServletRequest request) {
        return new PageResponse(LOGIN_PAGE);
    }

    @Override
    protected PageResponse performPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login: " + login + ", password: " + password);

        HttpSession session = request.getSession();

        if (userService.validateUser(login, password)) {
            User user = userService.getUserByLogin(login);
            LOG.info("get user by login" + user);
            session.setAttribute("user", user);
            if (user.getRole() == Role.ADMIN) {
                return new PageResponse( ADMIN_PAGE, true);
            } else if (user.getRole() == Role.CHEF) {
                return new PageResponse( CHEF_PAGE, true);
            } else {
                return new PageResponse(REDIRECT_HOME_PAGE, true);
            }
        }
        request.setAttribute("notification", "Login or password invalid!");
        return new PageResponse(LOGIN_PAGE, false);

    }
}
