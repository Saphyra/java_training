package com.github.saphyra.menu;

import com.github.saphyra.read.ConsoleReader;
import com.github.saphyra.repository.user.User;
import com.github.saphyra.repository.user.UserRepository;
import com.github.saphyra.service.DepositService;
import com.github.saphyra.service.TransferService;
import com.github.saphyra.service.WithdrawService;
import com.github.saphyra.util.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.github.saphyra.util.Constants.*;

@Component
@RequiredArgsConstructor
public class AccountMenu implements Menu {
    private final ConsoleReader consoleReader;
    private final Session session;
    private final UserRepository userRepository;
    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final TransferService transferService;

    @Override
    public void enterMenu() {
        String username = session.getUsername();
        User user = userRepository.findByUsername(username);

        String input;

        do {
            System.out.println();
            System.out.println("Account menu, Hello " + username);
            System.out.println("Commands:");
            System.out.println("balance - Check actual balance");
            System.out.println("deposit - Deposit");
            System.out.println("withdraw - Withdraw");
            System.out.println("transfer - Transfer money to another account");
            System.out.println("logout - Logout");
            System.out.println("Choose one command from above:");

            input = consoleReader.readInput();

            switch (input) {
                case ACCOUNT_MENU_BALANCE_OPTION:
                    System.out.println();
                    System.out.println("Your balance is: " + user.getBalance());
                    break;
                case ACCOUNT_MENU_DEPOSIT_OPTION:
                    depositService.deposit(user);
                    break;
                case ACCOUNT_MENU_WITHDRAW_OPTION:
                    withdrawService.withdraw(user);
                    break;
                case ACCOUNT_MENU_TRANSFER_OPTION:
                    transferService.transfer(user);
                    break;
                case ACCOUNT_MENU_LOGOUT_OPTION:
                    break;
                default:
                    System.err.println("Unknown command");
            }
        } while (!ACCOUNT_MENU_LOGOUT_OPTION.equals(input));
    }
}
