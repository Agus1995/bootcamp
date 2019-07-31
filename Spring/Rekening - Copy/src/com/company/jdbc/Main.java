package com.company.jdbc;

import com.company.jdbc.entity.Account;
import com.company.jdbc.entity.Customer;
import com.company.jdbc.entity.Transaction;
import com.company.jdbc.entity.Wallet;
import com.company.jdbc.service.*;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static ICustomer serviceCustomer = new CustomerImpl();
    private static IAccount serviceAccount = new AccountImpl();
    private static IWallet serviceWallet = new WalletImpl();
    private static ITransaction serviceTransaction = new TransactionImpl();
    private static Scanner input = new Scanner(System.in);
    private static Customer customer = new Customer();
    private static Account account = new Account();
    private static Wallet wallet = new Wallet();
    private static final AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) {
	// write your code here
    //    addCustomer();
    //    getById();
    //    addAccount();
        //   getAccountById();
     //   getByIdWallet();
      //  addWallet();
      //  registerWallet();
        // System.out.println(serviceWallet.getAccountWallet(1,"A001"));
        // System.out.println(serviceTransaction.getCode("T001"));
    //topUp();
    // addTransaction();
    //    login();
       dashboard();

    }
    public static void dashboard(){
        boolean isExit = false;
        do {
            System.out.println("1. New Customer");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice : ");
            String in = input.nextLine();

            if (in.equals("1")){
                addCustomer();
            }
            else if (in.equals("2")){
                login();
            }
            else if(in.equals("3")){
                isExit = true;
            }
            else {
                System.out.println("wrong choice");
            //    isExit = true;
            }
        }while (!isExit);
    }

    public static void login(){
        boolean isExit2 = false;
        try {
            System.out.print("Enter Your Customer Number  : ");
            String cusNumb = input.nextLine();
            customer = serviceCustomer.getById(cusNumb);
            if (customer.getCustomer_number() == null){
                System.out.println("Your ID is not registered");
            }
            else {
                int choice;
                do {
                    System.out.println("=============================================================");
                    showAccount(cusNumb);
                    System.out.println("=============================================================");
                    showWallet(cusNumb);
                    System.out.println("=============================================================");

                    System.out.println("1. Add Account");
                    System.out.println("2. Add Wallet");
                    System.out.println("3. Register Wallet");
                    System.out.println("4. TopUp");
                    System.out.println("5. Transfer");
                    System.out.println("6. Withdraw");
                    System.out.println("7. Unreg");
                    System.out.println("8. Print Transaction");
                    System.out.println("9. Exit");
                    System.out.println("Enter your choice");
                    choice = input.nextInt();

                    if (choice == 9){
                        isExit2 = true;
                        //   dashboard();
                    } else  if (choice == 1){
                        addAccount(cusNumb);
                    }
                    else if (choice == 2){
                        addWallet(cusNumb);
                    }
                    else if (choice == 3){
                        registerWallet();
                    }
                    else if (choice == 4){
                        topUp("T001");
                    }
                    else if (choice == 5){
                        transfer();
                    }
                    else if (choice == 6){
                        tarik();
                    }
                    else if (choice == 7){
                        unReg();
                    }
                    else if (choice == 8){
                        getTransaction();
                    }
                } while (!isExit2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void unReg(){
        System.out.println("Enter Your Account Number");
        String accNumb = input.next();
        System.out.println("Enter Your Wallet ID");
        int id = input.nextInt();
        if (serviceWallet.getAccountWallet(id, accNumb)){
            serviceWallet.unReg(id, accNumb);
        }else {
            System.out.println("Your wallet has not been registered");
        }

    }

    public static void tarik(){
        System.out.println("Enter Your Account number");
        String myAcc = input.next();
        System.out.println("Enter Your Wallet id");
        int idwal = input.nextInt();
        System.out.println("Enter Nominal");
        double nominal = input.nextDouble();
        String code = "T003";

        if (serviceWallet.getAccountWallet(idwal,myAcc)){
            serviceAccount.updateTfmin(myAcc,nominal,code);
        }else {
            System.out.println("Your wallet has not been registered");
        }
    }

    public static void transfer(){
        System.out.println("Enter your Account");
        String myAcc = input.next();
        System.out.println("Enter your Wallet id");
        int idwal = input.nextInt();
        System.out.println("Enter the destination account number");
        String descAcc = input.next();
        System.out.println("Enter Nominal");
        double nominal = input.nextDouble();
        String code = "T002";

        if (serviceWallet.getAccountWallet(idwal, myAcc)){
            serviceAccount.updateTfmin(myAcc,nominal,code);
            serviceAccount.updateTfplus(descAcc,nominal,code);
        }else {
            System.out.println("Your wallet has not been registered");
        }
    }

    public static void getTransaction(){
        System.out.print("Enter Account Number  : ");
        String accNumb = input.next();

        List<Transaction> transactions = new ArrayList<>();
        transactions = serviceTransaction.getTransaction(accNumb);

        System.out.println("Your Transaction");
        System.out.println("|" + padRight("Transaction Type", 20)
                + "|" + padRight("Date", 30)
                + "|" + padRight("Amount", 20)
                + "|");

        for (Transaction transaction : transactions) {
            String amount = String.format("%.2f", transaction.getAmount());
            System.out.println("|" + padRight("" + transaction.getTransactionType(), 20)
                    + "|" + padRight(""+transaction.getDate(), 30) + "|"
                    + padRight("Rp." + amount, 20)
                    + "|");
        }
        System.out.println("=====================================================");
    }

    public static void showAccount(String code){
        List<Account> accounts = new ArrayList<>();
        accounts = serviceAccount.getByCode(code);

        System.out.println("Your Account");
        System.out.println("|" + padRight("Account Number", 20)
                + "|" + padRight("Account Name", 20)
                + "|" + padRight("Balance", 20)
                + "|");

        for (Account account: accounts){
            String balance = String.format("%.2f", account.getBalance());
            System.out.println("|" + padRight("" + account.getAccount_number(), 20)
                    + "|" + padRight(account.getAccount_name(), 20) + "|"
                    + padRight("Rp." + balance, 20)
                    + "|");
        }
    }
    public static void showWallet(String code){
        List<Wallet> wallets = new ArrayList<>();
        wallets = serviceWallet.getByCode(code);

        System.out.println("Your Wallets");
        System.out.println("|" + padRight("ID Wallet", 10)
                + "|" + padRight("Description", 10)
                + "|");

        for (Wallet wallet: wallets){
            System.out.println("|" + padRight("" + wallet.getId(), 10)
                    + "|" + padRight(wallet.getDescription(), 10)
                    + "|");
        }
    }

    public static void registerWallet(){
        System.out.println("Enter account number");
        String accNum = input.next();
        System.out.println("Masukkan id wallet");
        int wltid = input.nextInt();
        serviceWallet.registerWallet(wltid,accNum);
    }
    public static void topUp(String code){
        System.out.println("Enter account number");
        String accNumb = input.next();
        System.out.println("Enter ID Wallet");
        int idWal = input.nextInt();
        System.out.println("Enter new balance");
        double newBlance = input.nextDouble();
        //String code = "T001";
        if (serviceWallet.getAccountWallet(idWal,accNumb)) {
        //    System.out.println("U've Registered");
            serviceAccount.updateTfplus(accNumb, newBlance, code);
        }else {
            System.out.println("Your wallet has not been registered");
        }

    }

    public static void getAccountById(){

        account = serviceAccount.getById("A001");
        System.out.println(account.getAccount_number());
    }
    public static void getByIdWallet(){
        wallet = serviceWallet.getById(1);
        System.out.println(wallet.getDescription());
    }
    public static void addAccount(String code){
/*        System.out.print("Enter Customer Number     :");
        String CNumber = input.nextLine();*/

        int number = new Random().nextInt(1 + 1000000);
        String ANumber = "AN-" + String.valueOf(number);

/*        System.out.println("Enter Account Number      :");
        String ANumber = input.next();*/
        System.out.println("Enter Account Name        :");
        String AName = input.next();
        System.out.println("Enter Balance             :");
        double balance = input.nextDouble();

        account.setAccount_number(ANumber);
        account.setAccount_name(AName);
        account.setBalance(balance);
        account.setCustomer_number(code);

        serviceAccount.addAccount(account);

    }
    public static void addWallet(String code){
        System.out.println("Input description of wallet");
        String desc = input.next();

        wallet.setDescription(desc);
        wallet.setCustomer_number(code);
        serviceWallet.addWallet(wallet);

    }
    public static void addCustomer(){

        int number = new Random().nextInt(1 + 1000000);
        String Cnumber = "CS-" + String.valueOf(number);

/*        System.out.print("Enter customer number :");
        String Cnumber = input.nextLine();*/
        System.out.print("Enter First Name      :");
        String firstname = input.nextLine();
        System.out.print("Enter Last Name       :");
        String lastname = input.nextLine();
        System.out.print("Enter birth date      :");
        String birth = input.nextLine();

        customer.setCustomer_number(Cnumber);
        customer.setFirst_name(firstname);
        customer.setLast_name(lastname);
        customer.setBirth_date(birth);

        System.out.println("Your Customer Number "+Cnumber);

        serviceCustomer.addCustomer(customer);
    }

    public static void getById(){
        String id = input.nextLine();
        customer = serviceCustomer.getById(id);
        System.out.println(customer.getCustomer_number());
    }

    public static String padRight(String inputString, int length) {
        return String.format("%1$-" + length + "s", inputString);

    }
}
