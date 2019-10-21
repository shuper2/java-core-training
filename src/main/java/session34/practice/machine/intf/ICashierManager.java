package session34.practice.machine.intf;

import session34.practice.machine.Cash;

import java.util.List;
import java.util.Map;

public interface ICashierManager {
    public void loadInitialCashier(Map<Cash, Integer> initialCashierMap);
    public List<Cash> getChange(int amount);
    public boolean checkCashAvailable(Cash cash);
    public Map<Cash,Integer> getCashierMap();
}
