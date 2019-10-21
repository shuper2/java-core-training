package session34.practice.machine.intf;

import java.util.Map;
import java.util.Set;

public interface IStockManager {
    public Set<Integer> getAvailableItems();

    public void loadInitialStock(Map<Integer, Integer> initialStockMap);

    public boolean checkItemFromStock(int id);

    public Object getItemFromStock(int id);

    public void replenishStock(Map<Integer, Integer> supplementStockMap);
}
