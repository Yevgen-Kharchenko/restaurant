package com.restaurant.config;

import com.restaurant.model.enums.Role;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecurityConfig {

    private static Map<Role, List<String>> securityPages = new HashMap<>();

    static {
        securityPages.put(Role.ADMIN, Arrays.asList("/edit-menu", "/dish", "/chef", "/master",
                "/order", "/user-profile", "/my-orders",
                "/users", "/ui-element", "/chart", "/tab-panel",
                "/table", "/form", "/empty", "/order-list",
                "/menu", "/invoice", "/admin"));
        securityPages.put(Role.GUEST, Arrays.asList("/my-orders", "/menu", "/invoice"));
        securityPages.put(Role.CHEF, Arrays.asList("/chef"));

    }

    public static boolean isSecurePage(String page) {
        return securityPages.values().stream()
                .anyMatch(list -> list.stream()
                        .anyMatch(pageValue -> pageValue.equals(page)));
    }

    public static boolean hasPermission(String page, Role role) {
        return securityPages.containsKey(role) && securityPages.get(role).contains(page);
    }
}
