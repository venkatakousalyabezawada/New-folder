import java.util.*;

public class BankingApp {
    static class BankAccount {
        private String name;
        private double balance;

        public BankAccount(String name, double initialDeposit) {
            this.name = name;
            this.balance = initialDeposit;
        }

        public String getName() {
            return name;
        }
        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount);
            } else {
                System.out.println("Invalid withdrawal amount or insufficient funds.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();
        String currentUser = "";

        while (true) {
            System.out.println("\nWelcome to our Bank!");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.nextLine();
                    if (accounts.containsKey(name)) {
                        System.out.println("Account with that name already exists!");
                    } else {
                        System.out.print("Enter initial deposit: ");
                        double initialDeposit = scanner.nextDouble();
                        scanner.nextLine(); 
                        accounts.put(name, new BankAccount(name, initialDeposit));
                        System.out.println("Account created successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter account name to login: ");
                    String loginName = scanner.nextLine();
                    if (accounts.containsKey(loginName)) {
                        currentUser = loginName;
                        BankAccount account = accounts.get(currentUser);
                        System.out.println("Logged in successfully as " + currentUser);

                        while (true) {
                            System.out.println("\nHello " + currentUser + "!");
                            System.out.println("1. Deposit");
                            System.out.println("2. Withdraw");
                            System.out.println("3. Check Balance");
                            System.out.println("4. Logout");
                            System.out.print("Enter your choice: ");
                            int action = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (action) {
                                case 1:
                                    System.out.print("Enter deposit amount: ");
                                    double deposit = scanner.nextDouble();
                                    scanner.nextLine(); 
                                    account.deposit(deposit);
                                    break;

                                case 2:
                                    System.out.print("Enter withdrawal amount: ");
                                    double withdrawal = scanner.nextDouble();
                                    scanner.nextLine(); 
                                    account.withdraw(withdrawal);
                                    break;

                                case 3:
                                    System.out.println("Balance: $" + account.getBalance());
                                    break;

                                case 4:
                                    System.out.println("Logging out...");
                                    currentUser = "";
                                    break;

                                default:
                                    System.out.println("Invalid choice.");
                            }

                            if (currentUser.isEmpty()) break; 
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using our Bank!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

