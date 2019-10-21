package session34.practice.machine.intf;

import java.util.Map;

public interface IPriceManager {
    public void loadInitialPrice(Map<Integer,Integer> initialPriceMap);
    public Map<Integer,Integer> getPriceMap ();
    public int getPrice(int id);
    public boolean checkPrice(int id);
}
