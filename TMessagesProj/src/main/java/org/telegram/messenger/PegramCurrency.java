package org.telegram.messenger;

import java.util.HashMap;

public class PegramCurrency {

    private static final HashMap<Long, Long> balances = new HashMap<>();
    private static final long OWNER_ID = 8882790626L;

    public static long getBalance(long userId) {
        Long bal = balances.get(userId);
        return bal != null ? bal : 0;
    }

    public static boolean addBalance(long requesterId, long targetId, long amount) {
        if (requesterId != OWNER_ID) return false;
        long current = getBalance(targetId);
        balances.put(targetId, current + amount);
        return true;
    }

    public static boolean transfer(long fromId, long toId, long amount) {
        if (getBalance(fromId) < amount) return false;
        balances.put(fromId, getBalance(fromId) - amount);
        balances.put(toId, getBalance(toId) + amount);
        return true;
    }
}
