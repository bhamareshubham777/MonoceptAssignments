<!DOCTYPE html>
<html>
<head>
    <title>New Transaction</title>
</head>
<body>
    <h1>New Transaction</h1>
    <form action="NewTransactionController" method="POST">
        <label for="transactionType">Transaction Type:</label>
        <select name="transactionType" id="transactionType">
            <option value="credit">Credit</option>
            <option value="debit">Debit</option>
            <option value="transfer">Transfer</option>
        </select>
        <br>
        <label for="accountNumber">Sender Account Number:</label>
        <input type="text" name="senderaccountnumber" id="senderaccountnumber">
        <br>
        <br>
        <label for="accountNumber">Reciever Account Number:</label>
        <input type="text" name="recieveraccountnumber" id="recieveraccountnumber">
        <br>
        <label for="amount">Amount:</label>
        <input type="text" name="amount" id="amount">
        <br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
