package session34.practice.machine.factory;

import session34.practice.machine.Cash;
import session34.practice.machine.impl.CashierManager;
import session34.practice.machine.impl.PriceManager;
import session34.practice.machine.impl.StockManager;
import session34.practice.machine.intf.ICashierManager;
import session34.practice.machine.intf.IPriceManager;
import session34.practice.machine.intf.IStockManager;

import java.util.HashMap;

public class VendingMachineMainFactory {
    private static VendingMachineMainFactory instance = null;

    public static VendingMachineMainFactory getInstance() {
        return instance != null ? instance : new VendingMachineMainFactory();
    }

    private VendingMachineMainFactory() {
    }

    public IStockManager getStockManager() {
        HashMap<Integer,Integer> stockMap = new HashMap<>();
        stockMap.put(1,1);
        stockMap.put(2,1);
        stockMap.put(3,1);
        IStockManager stockManager = new StockManager();
        stockManager.loadInitialStock(stockMap);
        return stockManager;
    }

    public IPriceManager getPriceManager() {
        HashMap<Integer,Integer> priceMap = new HashMap<>();
        priceMap.put(1,1);
        priceMap.put(2,4);
        priceMap.put(3,7);
        IPriceManager priceManager = new PriceManager();
        priceManager.loadInitialPrice(priceMap);
        return priceManager;
    }

    public ICashierManager getCashierManager() {
        HashMap<Cash,Integer> cashierMap = new HashMap<>();
        cashierMap.put(Cash.ONE,5);
        cashierMap.put(Cash.FIVE,5);
        cashierMap.put(Cash.TEN,5);
        ICashierManager cashierManager = new CashierManager();
        cashierManager.loadInitialCashier(cashierMap);
        return cashierManager;
    }
}
