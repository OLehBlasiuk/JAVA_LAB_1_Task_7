public class Main {
    public static void main(String[] args) {
        BankAccount mono1 = new BankAccount("Leo", "MonoBank", 2005, "USD");
        BankAccount mono2 = new BankAccount("Leo", "MonoBank", 2125, "EURO");
        BankAccount mono3 = new BankAccount("Dorian", "MonoBank", 2400, "CAD");
        BankAccount priv1 = new BankAccount("Dorian", "Privat24", 2600, "UAH");
        BankAccount priv2 = new BankAccount("Leo", "Privat24", 1800, "CAD");

        Bank.transferMoney(mono2, mono1);
        Bank.transferMoney(mono3, mono1);
        Bank.transferMoney(priv1, mono1);
        Bank.transferMoney(priv2, mono1);

        // Виведення результатів
        mono1.printAccountInfo();
        mono2.printAccountInfo();
        mono3.printAccountInfo();
        priv1.printAccountInfo();
        priv2.printAccountInfo();
    }
}