package com.restaurant.config;

import com.restaurant.model.User;
import com.restaurant.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SecurityConfig {

    private static Map<Role, List<String>> securityPages = new HashMap<>();

    static {
        securityPages.put(Role.ADMIN, Arrays.asList("/admin", "/user", "/manager", "/master", "/feedback", "/order", "/order-comment", "/user-profile", "/users"));
        securityPages.put(Role.GUEST, Arrays.asList("/user", "/feedback", "/order", "/order-comment"));
        securityPages.put(Role.CHEF, Arrays.asList("/manager", "/master", "/order-comment"));

    }

    public static boolean isSecurePage(String page) {
        return securityPages.values().stream()
                .anyMatch(list -> list.stream()
                        .anyMatch(pageValue -> pageValue.equals(page)));
    }

    public static boolean hasPermission(String page, Role role) {
        return securityPages.getOrDefault(role, Collections.EMPTY_LIST)
                .stream()
                .anyMatch(securePage -> securePage.equals(page));
    }

    public static boolean hasPermission(HttpServletRequest request, Role role) {
        User currentUser = getCurrentUser(request);
        return currentUser != null && currentUser.getRole().equals(role);
    }

    public static User getCurrentUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }

}
