package org.telegram.messenger;

import java.util.HashMap;

public class PegramRoles {
    
    public static final int ROLE_NONE = 0;
    public static final int ROLE_DEVELOPER = 1;
    public static final int ROLE_MODERATOR = 2;
    public static final int ROLE_ADMIN = 3;

    // Сюда добавляй ID пользователей вручную
    private static final HashMap<Long, Integer> roles = new HashMap<>();
    
    static {
        // Твой Telegram ID — поменяй на свой
        roles.put(8882790626L, ROLE_DEVELOPER); // замени 0L на твой ID
    }

    public static int getRole(long userId) {
        Integer role = roles.get(userId);
        return role != null ? role : ROLE_NONE;
    }

    public static String getRoleName(long userId) {
        switch (getRole(userId)) {
            case ROLE_DEVELOPER: return "Developer & Tech Admin";
            case ROLE_MODERATOR: return "Moderator";
            case ROLE_ADMIN: return "Administrator";
            default: return null;
        }
    }

    public static int getRoleColor(long userId) {
        switch (getRole(userId)) {
            case ROLE_DEVELOPER: return 0xFFFF3B30; // красный
            case ROLE_MODERATOR: return 0xFF007AFF; // синий
            case ROLE_ADMIN: return 0xFFFF2D78;     // розовый
            default: return 0;
        }
    }
}
