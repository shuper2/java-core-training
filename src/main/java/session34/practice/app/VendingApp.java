package session34.practice.app;

import session34.practice.machine.VendingMachineFacade;

import static org.assertj.core.api.Assertions.assertThat;

public class VendingApp {
    public static void main(String[] args) {
        VendingMachineFacade vendingMachineFacade = null;
        //implement...
        assertThat(vendingMachineFacade.getItem()).isNotNull();
    }
}
