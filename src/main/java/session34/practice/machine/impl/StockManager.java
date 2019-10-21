package session34.practice.machine.impl;

import session34.practice.machine.intf.IStockManager;

import java.util.*;

public class StockManager implements IStockManager {

    private Map<Integer, Integer> stockMap;

    public StockManager() {
        stockMap = new HashMap<>();
    }

    @Override
    public Set<Integer> getAvailableItems() {
        Set<Integer> availableItems = new HashSet<>();
        for (int itemId :
                stockMap.keySet()) {
            if (checkItemFromStock(itemId)) {
                availableItems.add(itemId);
            }
        }
        return Collections.unmodifiableSet(availableItems);
    }

    @Override
    public void loadInitialStock(Map<Integer, Integer> initialStockMap) {
        stockMap = new HashMap<>(initialStockMap);
    }


    @Override
    public boolean checkItemFromStock(int id) {
        return stockMap.get(id) != null && stockMap.get(id).intValue() > 0;
    }

    @Override
    public Object getItemFromStock(int id) {
        if (checkItemFromStock(id)) {
            int itemCount = stockMap.get(id);
            stockMap.put(id, itemCount - 1);
            return _getItem(id);
        }
        return null;
    }

    private Object _getItem(int id) {
        return "Item "+id;
    }

    @Override
    public void replenishStock(Map<Integer, Integer> supplementStockMap) {
        for (Map.Entry<Integer, Integer> itemEntry : supplementStockMap.entrySet()) {
            if (itemEntry.getValue() != null && !itemEntry.getValue().equals(0)) {
                int itemId = itemEntry.getKey();
                int itemCount = itemEntry.getValue();
                int stockItemCount = stockMap.getOrDefault(itemId, 0);
                stockMap.put(itemId, stockItemCount + itemCount);
            }
        }
    }
}
