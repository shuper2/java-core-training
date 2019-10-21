package session34.practice.machine.impl;

import session34.practice.machine.Cash;
import session34.practice.machine.intf.ICashierManager;

import java.util.*;

public class CashierManager implements ICashierManager {

    private Map<Cash, Integer> cashierMap;
    private final Cash[] descSortedCashDenominations;

    public CashierManager() {
        cashierMap = new HashMap<>();
        Cash[] cashes = Cash.values();
        Arrays.sort(cashes, (o1, o2) -> o2.getDenomination() - o1.getDenomination());
        descSortedCashDenominations = cashes;
    }

    @Override
    public void loadInitialCashier(Map<Cash, Integer> initialCashierMap) {
        this.cashierMap = new HashMap<>(initialCashierMap);
    }

    @Override
    public List<Cash> getChange(int amount) {
        if (amount < 0) {
            return null;
        } else if (amount == 0) {
            return new ArrayList<>();
        }
        for (Cash cash : descSortedCashDenominations) {
            if (!checkCashAvailable(cash)) {
                continue;
            }
            int cashCount = cashierMap.get(cash);
            cashierMap.put(cash,cashCount - 1);
            int denomination = cash.getDenomination();
            if (denomination == amount) {
                List<Cash> changeList = new ArrayList<>();
                changeList.add(cash);
                return changeList;
            } else if (denomination < amount) {
                List<Cash> changeList = getChange(amount - denomination);
                if (changeList != null) {
                    changeList.add(cash);
                    return changeList;
                }
            }
            cashierMap.put(cash,cashCount);
        }
        return null;
    }

    @Override
    public boolean checkCashAvailable(Cash cash) {
        return cashierMap.getOrDefault(cash,0) > 0;
    }

    @Override
    public Map<Cash, Integer> getCashierMap() {
        return Collections.unmodifiableMap(cashierMap);
    }
}
