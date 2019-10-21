package session34.practice.machine;

import session34.practice.machine.factory.VendingMachineMainFactory;
import session34.practice.machine.intf.ICashierManager;
import session34.practice.machine.intf.IPriceManager;
import session34.practice.machine.intf.IStockManager;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.*;

public class MyVendingMachine implements VendingMachineFacade {

    private final IStockManager stockManager;
    private final IPriceManager priceManager;
    private final ICashierManager cashierManager;

    private int selectedItemId = Integer.MIN_VALUE;
    private int selectedItemPrice = Integer.MIN_VALUE;


    public MyVendingMachine() {
        stockManager = VendingMachineMainFactory.getInstance().getStockManager();
        priceManager = VendingMachineMainFactory.getInstance().getPriceManager();
        cashierManager = VendingMachineMainFactory.getInstance().getCashierManager();
    }

    public void init(HashMap<Integer,Integer> stockMap,HashMap<Integer,Integer> priceMap,HashMap<Cash, Integer> cashierMap) {
        stockManager.loadInitialStock(stockMap);
        priceManager.loadInitialPrice(priceMap);
        cashierManager.loadInitialCashier(cashierMap);
    }

    @Override
    public boolean chooseItem(int id) {
        Set<Integer> availableItemSet = stockManager.getAvailableItems();
        if (availableItemSet.contains(id)) {
            selectedItemId = id;
            selectedItemPrice = priceManager.getPrice(id);
            return true;
        }
        return false;
    }

    public void getStatus () {
        System.out.println("Stock:");
        System.out.println(stockManager.getAvailableItems());
        System.out.println("Price:");
        System.out.println(priceManager.getPriceMap());
        System.out.println("Cashier:");
        System.out.println(cashierManager.getCashierMap());
    }

    @Override
    public List<Cash> pay(Cash money) {
        return cashierManager.getChange(money.getDenomination() - selectedItemPrice);
    }

    @Override
    public Object getItem() {
        return stockManager.getItemFromStock(selectedItemId);
    }

    public static void main(String[] args) {
        MyVendingMachine vendingMachine = new MyVendingMachine();
        HashMap<Integer,Integer> stockMap = new HashMap<>();
        stockMap.put(1,1);
        stockMap.put(2,1);
        stockMap.put(3,1);
        HashMap<Integer,Integer> priceMap = new HashMap<>();
        priceMap.put(1,1);
        priceMap.put(2,4);
        priceMap.put(3,7);
        HashMap<Cash,Integer> cashierMap = new HashMap<>();
        cashierMap.put(Cash.ONE,1);
        cashierMap.put(Cash.FIVE,5);
        cashierMap.put(Cash.TEN,5);

        vendingMachine.init(stockMap,priceMap,cashierMap);
        vendingMachine.getStatus();
        if(vendingMachine.chooseItem(1)) {
            List<Cash> changeList = vendingMachine.pay(Cash.TEN);
            if (changeList != null) {
                System.out.println("Trade Complete.");
                System.out.println(changeList);
                System.out.println(vendingMachine.getItem());
            } else {
                System.out.println("Trade Fail.");
            }
        }
        vendingMachine.getStatus();
    }
}
