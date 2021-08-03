package solid;

/**
 * 1. Transfer money in Thailand only
 * 2. Transfer money (International)
 */

public class DemoBank {
    public static void main(String[] args) {

        TransferMoney localBank = new LocalBank();
        localBank.transferMoney(1000);

        TransferMoney interBank = new InterBank();
        interBank.transferMoney(2000);
    }
}

interface TransferMoney {
    public void transferMoney(int money);
}

class LocalBank implements TransferMoney {
    public void transferMoney(int money) {
        System.out.println("Transfer money in Thailand only");
    }
}

class InterBank implements TransferMoney {
    public void transferMoney(int money) {
        System.out.println("Transfer money (International)");
    }
}
