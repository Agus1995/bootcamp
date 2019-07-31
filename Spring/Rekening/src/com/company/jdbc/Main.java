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
                loginCustomer();
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

    public static  void loginCustomer(){
        boolean isExit3 = false;

        System.out.print("Enter your customer Number    : ");
        String cusNumb = input.nextLine();
        customer = serviceCustomer.getById(cusNumb);

        if (customer.getCustomer_number() != null) {
            do {
                System.out.println("======================================================================");
                System.out.println("1. My Account");
                System.out.println("2. My Wallet");
                System.out.println("3. Transaction");
                System.out.println("4. My Report");
                System.out.println("5. Logout");
                System.out.println("======================================================================");
                System.out.print("Enter your choice     : ");
                int pil = input.nextInt();
                System.out.println("======================================================================");
                if (pil==1){
                    showAccount(cusNumb);
                }
                else if (pil==2){
                    showWallet(cusNumb);
                }
                else if (pil==3){
                    addTransaction(cusNumb);
                }
                else if (pil == 4){
                    getTransaction();
                }
                else if (pil==5){
                    isExit3 = true;
                }
            } while (!isExit3);
        }else {
            System.out.println("Your ID is not registered");
        }
    }
    public static void addTransaction(String code){
        boolean exit = false;
        do {
            System.out.println("1. By Account Number");
            System.out.println("2. By Wallet");
            System.out.println("3. Back");
            System.out.print("Enter your choice : ");
            int pil = input.nextInt();
            if (pil == 1){
                transRek(code);
            }else if (pil == 2){
                transWallet(code);
            }else if (pil == 3){
                exit = true;
            }
        }while (!exit);
    }

    public static void transWallet(String code){
        boolean exit = false;
        do {
            showRegWal(code);
            System.out.println("1. Top Up");
            System.out.println("2. Transfer");
            System.out.println("3. Withdraw");
            System.out.println("4. Back");
            System.out.print("Enter your choice");
            int pil = input.nextInt();

            if(pil == 1){
                topUp();
            }
            else if (pil == 2){
                transfer();
            }
            else if (pil == 3){
                tarik();
            }
            else if (pil == 4){
                exit = true;
            }
        }while (!exit);
    }

    public static void transRek(String code){
        boolean exit = false;
        do {
           // showAccount(code);
            System.out.println("1. Top Up");
            System.out.println("2. Transfer");
            System.out.println("3. Withdraw");
            System.out.println("4. Back");
            System.out.print("Enter your choice");
            int pil = input.nextInt();

            if(pil == 1){
                topUpRek(code);
            }
            else if (pil == 2){
                transbyRek(code);
            }
            else if (pil == 3){
                tarikByRek(code);
            }
            else if (pil == 4){
                exit = true;
            }
        }while (!exit);
    }

    public static void unReg(){
        System.out.println("Enter Your Account Number");
        String accNumb = input.next();
        System.out.println("Enter Your Wallet ID");
        int id = input.nextInt();
        if (serviceWallet.getAccountWallet(id, accNumb)){
            serviceWallet.unReg(id, accNumb);
        }else {
            System.out.println("Your account is not registered");
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
            if (serviceAccount.updateTfmin(myAcc,nominal,code)){
                System.out.println("Success");
            }else {
                System.out.println("Your balance is not enough");
            }
        }else {
            System.out.println("Your wallet is not registered");
        }
    }

    public static void tarikByRek(String cusNumb){
        System.out.println("Enter your account number");
        String myAcc = input.next();
        System.out.println("Enter nominal");
        double nominal = input.nextDouble();
        String code = "T003";
        if (serviceAccount.getByAccCus(myAcc, cusNumb)){
            if (serviceAccount.updateTfmin(myAcc, nominal,code)){
                System.out.println("Success");
            }else {
                System.out.println("Your balance is not enough");
            }
        }else {
            System.out.println("Not your account");
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
            if(serviceAccount.updateTfmin(myAcc,nominal,code)){
                serviceAccount.updateTfplus(descAcc,nominal,code);
            }else {
                System.out.println("Your balance is not enough");
            }
        }else {
            System.out.println("Your wallet is not registered");
        }
    }

    public static void transbyRek(String cusNumb){
        System.out.println("Enter your Account");
        String myAcc = input.next();
        System.out.println("Enter the destination account number");
        String descAcc = input.next();
        System.out.println("Enter Nominal");
        double nominal = input.nextDouble();
        String code = "T002";
        if (serviceAccount.getByAccCus(myAcc,cusNumb)){
            if (serviceAccount.updateTfmin(myAcc,nominal,code)){
                serviceAccount.updateTfplus(descAcc,nominal,code);
            }else {
                System.out.println("Your balance is not enough");
            }
        }else {
            System.out.println("Not your account");
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
        System.out.println("======================================================================");
    }
    public static void showRegWal(String code){
        List<Wallet> wallets = new ArrayList<>();
        wallets = serviceWallet.getWalleteReg(code);

        System.out.println("=========================registered wallet============================");
        System.out.println("|" + padRight("ID WAllet", 20)
                + "|" + padRight("Account Number", 30)
                + "|");

        for (Wallet wallet: wallets) {
            System.out.println("|" + padRight("" + wallet.getId(), 20)
                    + "|" + padRight(wallet.getAccount_number(), 30) + "|"
                    + "|");
        }
    }

    public static void showAccount(String code){
        boolean exit = false;
        do {
            List<Account> accounts = new ArrayList<>();
            accounts = serviceAccount.getByCode(code);

            System.out.println("===========================Your Account===============================");
            System.out.println("======================================================================");
            System.out.println("|" + padRight("Account Number", 20)
                    + "|" + padRight("Account Name", 20)
                    + "|" + padRight("Balance", 20)
                    + "|");
            System.out.println("======================================================================");
            for (Account account: accounts){
                String balance = String.format("%.2f", account.getBalance());
                System.out.println("|" + padRight("" + account.getAccount_number(), 20)
                        + "|" + padRight(account.getAccount_name(), 20) + "|"
                        + padRight("Rp." + balance, 20)
                        + "|");
            }
            System.out.println("======================================================================");
            System.out.println("1. Add Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Back");
            System.out.println("======================================================================");
            System.out.print("Enter your choice : ");
            int pil = input.nextInt();
            System.out.println("======================================================================");
            if (pil==3){
                exit = true;
            }
            else if (pil == 1){
                addAccount(code);
            }
            else if (pil == 2){
                deleteAccount(code);
            }
        }while (!exit);

    }

    public static void deleteAccount(String code){
        System.out.println("======================================================================");
        System.out.println("Enter Account number to delete    :");
        String accNumb = input.next();
        System.out.println("======================================================================");
        serviceAccount.deleteAccount(accNumb,code);
    }

    public static void deleteWallet(String code){
        System.out.println("======================================================================");
        System.out.println("Enter Wallet number to delete    :");
        int walNumb = input.nextInt();
        System.out.println("======================================================================");
        serviceWallet.delete(walNumb,code);
    }

    public static void showWallet(String code){
        boolean exit = false;
        do {
            List<Wallet> wallets = new ArrayList<>();
            wallets = serviceWallet.getByCode(code);
            System.out.println("======================================================================");
            System.out.println("Your Wallets");
            System.out.println("======================================================================");
            System.out.println("|" + padRight("ID Wallet", 10)
                    + "|" + padRight("Description", 10)
                    + "|");
            System.out.println("======================================================================");
            for (Wallet wallet: wallets){
                System.out.println("|" + padRight("" + wallet.getId(), 10)
                        + "|" + padRight(wallet.getDescription(), 10)
                        + "|");
            }
            System.out.println("======================================================================");
            System.out.println("1. Add Wallet");
            System.out.println("2. Show Registered");
            System.out.println("3. Register Wallet");
            System.out.println("4. Unregister Wallet");
            System.out.println("5. Delete Wallet");
            System.out.println("6. Back");
            System.out.println("======================================================================");
            System.out.print("Enter your choice : ");
            int pil = input.nextInt();
            System.out.println("======================================================================");
            if (pil == 1){
                addWallet(code);
            }
            else if (pil == 2){
                showRegWal(code);
            }
            else if (pil == 3){
                registerWallet();
            }
            else if (pil == 4){
                unReg();
            }
            else if (pil == 5){
                deleteWallet(code);
            }
            else if (pil == 6){
                exit = true;
            }
        }while (!exit);
    }

    public static void registerWallet(){
        System.out.println("Enter account number");
        String accNum = input.next();
        System.out.println("Masukkan id wallet");
        int wltid = input.nextInt();

        serviceWallet.registerWallet(wltid,accNum);
    }
    public static void topUp(){
        System.out.println("Enter account number");
        String accNumb = input.next();
        System.out.println("Enter ID Wallet");
        int idWal = input.nextInt();
        System.out.println("Enter new balance");
        double newBlance = input.nextDouble();
        String code = "T001";
        if (serviceWallet.getAccountWallet(idWal,accNumb)) {
        //    System.out.println("U've Registered");
            serviceAccount.updateTfplus(accNumb, newBlance, code);
        }else {
            System.out.println("Your wallet is not registered");
        }

    }

    public static void topUpRek(String cusNumb){
        System.out.println("Enter account number");
        String accNumb = input.next();
        //     System.out.println("Enter ID Wallet");
        //      int idWal = input.nextInt();
        System.out.println("Enter new balance");
        double newBlance = input.nextDouble();
        String code = "T001";
        if (serviceAccount.getByAccCus(accNumb,cusNumb)){
            serviceAccount.updateTfplus(accNumb, newBlance, code);
        }else {
            System.out.println("Not your account");
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

        int number = new Random().nextInt(1 + 1000000);
        String ANumber = "AN-" + String.valueOf(number);

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
