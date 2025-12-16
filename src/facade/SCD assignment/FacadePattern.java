// Subsystem class responsible for user authentication
class AuthenticationService {
    void authenticateUser() {
        System.out.println("Authenticating user...");
    }
}

// Subsystem class responsible for account-related operations
class AccountService {
    void checkBalance() {
        System.out.println("Checking account balance...");
    }
}

// Subsystem class responsible for transaction processing
class TransactionService {
    void transferFunds() {
        System.out.println("Transferring funds...");
    }
}

// Subsystem class responsible for notifications
class NotificationService {
    void sendNotification() {
        System.out.println("Sending notification to user...");
    }
}

// Facade class that simplifies interaction with subsystems
class OnlineBankingFacade {

    private AuthenticationService authService;
    private AccountService accountService;
    private TransactionService transactionService;
    private NotificationService notificationService;

    // Facade constructor initializes all subsystem services
    public OnlineBankingFacade() {
        authService = new AuthenticationService();
        accountService = new AccountService();
        transactionService = new TransactionService();
        notificationService = new NotificationService();
    }

    // High-level method that hides complex subsystem interactions
    public void performFundTransfer() {
        authService.authenticateUser();
        accountService.checkBalance();
        transactionService.transferFunds();
        notificationService.sendNotification();
    }
}

// Client class
public class FacadePattern {
    public static void main(String[] args) {
        OnlineBankingFacade bankingFacade = new OnlineBankingFacade();
        bankingFacade.performFundTransfer();
    }
}
