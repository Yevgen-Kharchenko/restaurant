package com.restaurant.controller.command.admin;

import com.restaurant.controller.command.UniCommand;
import com.restaurant.controller.data.Page;
import com.restaurant.model.User;
import com.restaurant.service.ServiceFactory;
import com.restaurant.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.restaurant.controller.PageUrlConstants.LOGIN_PAGE;
import static com.restaurant.controller.PageUrlConstants.REDIRECT_HOME_PAGE;

public class LoginCommand extends UniCommand {
    private UserService userService;
    private static final Logger LOG = Logger.getLogger(LoginCommand.class);
    public LoginCommand() {
        this.userService = ServiceFactory.getUserService();
    }

    @Override
    protected Page performGet(HttpServletRequest request) {
        return new Page(LOGIN_PAGE);
    }

    @Override
    protected Page performPost(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        System.out.println("login: " + login + ", password: " + password);

        HttpSession session = request.getSession();

        if (userService.validateUser(login, password)) {
            User user = userService.getUserByLogin(login);
            LOG.info("get user by login" + user);
            session.setAttribute("user", user);
            return new Page(REDIRECT_HOME_PAGE, true);
        }
        request.setAttribute("notification", "Login or password invalid!");
        return new Page(LOGIN_PAGE, false);

    }
}
