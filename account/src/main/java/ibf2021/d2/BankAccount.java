package ibf2021.d2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAccount 
{
    private String name;
    private String accountNumber;
    private float accountBalance;
    private List<String> transactions;
    private boolean closed;
    private String accountCreateDate;
    private String accountClosedDate;

    private String createTimeStamp() {
        SimpleDateFormat simpleDateFormat = 
                new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        return simpleDateFormat.format(new Date());
    }

    public BankAccount(String name, float accountBalance) { 
        this.name = name;
        this.accountBalance = accountBalance;
        transactions = new ArrayList<>();
        accountCreateDate = createTimeStamp();
    }

    public BankAccount(String name) {
        this.name = name;
        this.accountBalance = 0f;
        this.accountNumber = 
            Integer.toString((int) (Math.random()*1000000000));
        transactions = new ArrayList<>();
        accountCreateDate = createTimeStamp();
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return String return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return float return the accountBalance
     */
    public float getAccountBalance() {
        return accountBalance;
    }

    /**
     * @return List<String> return the transactions
     */
    public List<String> getTransactions() {
        return transactions;
    }

    /**
     * @return boolean return the isClosed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * @param isClosed the isClosed to set
     */
    public void setIsClosed(boolean isClosed) {
        this.closed = isClosed;

        if (this.closed == true)
            accountClosedDate = createTimeStamp();
        else
            accountClosedDate = null;
    }

    /**
     * @return String return the accountCreateDate
     */
    public String getAccountCreateDate() {
        return accountCreateDate;
    }

    /**
     * @return String return the accountClosedDate
     */
    public String getAccountClosedDate() {
        return accountClosedDate;
    }

    public void deposit(float amount) {

        boolean isNegativeAmount = 0.0 - amount > 0.001;

        if (isNegativeAmount == true || closed)
            throw new IllegalArgumentException();

        String transaction = "Deposit $" +  amount + " at " +
                createTimeStamp();
        transactions.add(transaction);
        // this.accountBalance = this.accountBalance + amount;
        this.accountBalance += amount;
    }

    public void withdraw(float amount) {

        boolean isNegativeAmount = 0.0 - amount > 0.001;

        if (isNegativeAmount == true || amount > this.accountBalance || closed)
            throw new IllegalArgumentException();

        String transaction = "Withdraw $" +  amount + " at " +
                createTimeStamp();
        transactions.add(transaction);
        // this.accountBalance = this.accountBalance - amount;
        this.accountBalance -= amount;
    }

}
