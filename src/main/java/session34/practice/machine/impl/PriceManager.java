package session34.practice.machine.impl;

import session34.practice.machine.intf.IPriceManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PriceManager implements IPriceManager {
    private Map<Integer,Integer> priceMap;

    public PriceManager() {
        priceMap = new HashMap<>();
    }

    @Override
    public void loadInitialPrice(Map<Integer, Integer> intialPriceMap) {
        this.priceMap = new HashMap<>(intialPriceMap);
    }

    @Override
    public Map<Integer, Integer> getPriceMap() {
        return Collections.unmodifiableMap(priceMap);
    }

    @Override
    public int getPrice(int id) {
        if (checkPrice(id)) {
            return priceMap.get(id);
        } else {
            return -1;
        }
    }

    @Override
    public boolean checkPrice(int id) {
        return priceMap.get(id) != null || priceMap.get(id).intValue() > 0;
    }

}
