package com.restaurant.config;

import com.restaurant.model.User;
import com.restaurant.model.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SecurityConfig {

    private static Map<Role, List<String>> securityPages = new HashMap<>();

    static {
        securityPages.put(Role.ADMIN, Arrays.asList("/edit-menu", "/dish", "/chef", "/master",
                "/index", "/order", "/user-profile","/my-orders",
                "/users", "/ui-element", "/chart", "/tab-panel",
                "/table", "/form", "/empty","/order-list", "/menu","/invoice"));
        securityPages.put(Role.GUEST, Arrays.asList("/my-orders", "/menu","/invoice"));
        securityPages.put(Role.CHEF, Arrays.asList("/chef"));

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
