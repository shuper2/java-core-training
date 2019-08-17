package session34.practice.machine;

import java.util.List;

public interface VendingMachineFacade {
    /** Return true if succeeded. */
    boolean chooseItem(int id);

    /** Return changes if succeeded, return empty list if waiting for another cash, return all cashes if failed. */
    List<Cash> pay(Cash money);

    /** Return null if there's no item vended into the delivery compartment. */
    Object getItem();
}
