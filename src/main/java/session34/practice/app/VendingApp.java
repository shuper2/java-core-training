package session34.practice.app;

import session34.practice.machine.Cash;
import session34.practice.machine.MyVendingMachine;
import session34.practice.machine.VendingMachineFacade;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingApp {
    public static void main(String[] args) {
        VendingMachineFacade vendingMachineFacade = new MyVendingMachine();

        vendingMachineFacade.chooseItem(1);
        List<Cash> changeList = vendingMachineFacade.pay(Cash.TEN);
        System.out.println("Trade vendingMachineFacade.");
        System.out.println(changeList);
        assertThat(vendingMachineFacade.getItem()).isNotNull();
    }
}
