package com.bitspilani.leadmanager.Controller;

import com.bitspilani.leadmanager.model.Policy;
import com.bitspilani.leadmanager.model.Transaction;
import com.bitspilani.leadmanager.model.TransactionType;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserBalanceCalculator {

    /**
     * Calculates remaining balance for a user on a given date.
     */
    public double calculateRemainingBalance(String userId, Policy policy, LocalDate date) {
        boolean isTravelling = isUserTravellingOn(userId, date);
        double dailyLimit = determineApplicableLimit(policy, isTravelling);

        if (dailyLimit == 0) {
            return 0;
        }

        List<Transaction> transactions = getTransactionsForDate(userId, date);
        double netAmount = calculateNetTransactionAmount(transactions);

        return Math.max(0, dailyLimit + netAmount);
    }

    // -------------------- Core Logic --------------------

    private double determineApplicableLimit(Policy policy, boolean isTravelling) {
        if (policy.isAllowTravelMeals() && policy.isAllowNonTravelMeals()) {
            return isTravelling
                    ? policy.getTravelDailyLimit()
                    : policy.getNonTravelDailyLimit();
        }

        if (policy.isAllowTravelMeals() && isTravelling) {
            return policy.getTravelDailyLimit();
        }

        if (policy.isAllowNonTravelMeals() && !isTravelling) {
            return policy.getNonTravelDailyLimit();
        }

        return 0;
    }

    private double calculateNetTransactionAmount(List<Transaction> transactions) {
        double total = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.CREDIT) {
                total += transaction.getAmount();
            } else {
                total -= transaction.getAmount();
            }
        }

        return total;
    }

    /**
     * Checks if user is travelling on a specific date.
     */
    private boolean isUserTravellingOn(String userId, LocalDate date) {
        return getTravellingDates(userId).contains(date);
    }

    // -------------------- Supporting Methods --------------------

    /**
     * Fetches policy for a given user.
     */
    @Tool
    public Policy getPolicyForUser(String userId) {
        // sample logic
        if ("123456".equals(userId)) {
            return new Policy(true, false, 500, 0);
        }
        return new Policy(true, true, 500, 300);
    }

    /**
     * Returns all dates when the user is travelling.
     */
    @Tool
    public List<LocalDate> getTravellingDates(String userId) {
        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.now()); // sample data
        return dates;
    }

    /**
     * Returns all transactions (credit/debit) for the given date.
     */
    @Tool
    public List<Transaction> getTransactionsForDate(String userId, LocalDate date) {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(200, TransactionType.DEBIT));
        transactions.add(new Transaction(50, TransactionType.CREDIT));
        return transactions;
    }

    public static void main(String[] args) {
        UserBalanceCalculator calculator = new UserBalanceCalculator();
        String userId = "user_123";
        Policy policy = calculator.getPolicyForUser(userId);
        LocalDate date = LocalDate.of(2025, 12, 13);

        double balance = calculator.calculateRemainingBalance(userId, policy, date);
        System.out.println("Remaining balance: " + balance);
    }
}

