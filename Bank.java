public class Bank {

    public static void transferMoney(BankAccount from, BankAccount to) {
        double amountToTransfer = from.getBalance();

        // Конвертація валют, якщо необхідно
        if (!from.getCurrency().equals(to.getCurrency())) {
            amountToTransfer = exchangeUAHToUSD(amountToTransfer, from.getCurrency());
            from.setCurrency(exchangeCurrency(from.getCurrency()));
        }

        // Комісії та умови для переказу
        if (from.getUser().equals(to.getUser())) {
            if (from.getAccount().equals(to.getAccount())) {
                to.setBalance(to.getBalance() + amountToTransfer);
            } else {
                to.setBalance(to.getBalance() + amountToTransfer * 0.98);
            }
        } else if (from.getAccount().equals(to.getAccount())) {
            to.setBalance(to.getBalance() + amountToTransfer * 0.97);
        } else {
            to.setBalance(to.getBalance() + amountToTransfer * 0.94);
        }

        // Оновлення балансу "from" акаунта
        from.setBalance(0);

        System.out.println(from.getUser() + " " + from.getAccount() + ": 0 (" + from.getCurrency() + ")");
        System.out.println(to.getUser() + " " + to.getAccount() + ": " + to.getBalance() + " (" + to.getCurrency() + ")");
    }

    // Метод для конвертації У UAH
    private static double exchangeUAHToUSD(double amount, String currency) {
        final double usdRate = 0.042;  // 1 UAH = 0.042 USD
        final double euroRate = 0.045; // 1 UAH = 0.045 EUR
        final double cadRate = 0.03;   // 1 UAH = 0.03 CAD

        switch (currency) {
            case "UAH":
                return amount;
            case "USD":
                return amount * usdRate;
            case "EURO":
                return amount * euroRate;
            case "CAD":
                return amount * cadRate;
            default:
                return amount; // Якщо валюта невідома, повертаємо оригінальну суму
        }
    }

    // Метод для зміни валюти на UAH
    private static String exchangeCurrency(String currency) {
        return "UAH";
    }
}