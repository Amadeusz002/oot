package command;

import model.Account;
import model.Transaction;

import java.util.List;

public class RemoveTransactionsCommand implements Command {

    private final List<Transaction> transactionsToRemove;
    private final Account account;

    public RemoveTransactionsCommand(List<Transaction> transactionsToRemove, Account account) {
        this.transactionsToRemove = transactionsToRemove;
        this.account = account;
    }

    @Override
    public void execute() {
        transactionsToRemove.forEach(account::removeTransaction);
    }

    @Override
    public String getName() {
        StringBuilder stringBuilder = new StringBuilder();
        transactionsToRemove.forEach(transaction -> stringBuilder.append(transaction.toString()).append(", "));
        return "Remove transactions: " + stringBuilder.toString();
    }

    @Override
    public void undo() {
        transactionsToRemove.forEach(account::addTransaction);
    }

    @Override
    public void redo() {
        execute();
    }
}
