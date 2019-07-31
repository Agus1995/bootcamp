package com.company.store;

public class Main {

    static IBook bookService = new BookImpl();
    static ITransaksi transService = new TransaksiImpl();

    public static void main(String[] args) {

        //Add Book

        Book book1 = new Book();
        book1.setId("B001");
        book1.setJudul("Aku Terharu");
        book1.setPenulis("Paijo");
        book1.setPenerbit("Andi");
        book1.setHarga(3000000);
        book1.setStock(10);
        bookService.addBook(book1);

        Book book2 = new Book();
        book2.setId("B002");
        book2.setJudul("Aku Terharu");
        book2.setPenulis("Paijo");
        book2.setPenerbit("Andi");
        book2.setHarga(3000000);
        book2.setStock(10);
        bookService.addBook(book2);

        Book book3 = new Book();
        book3.setId("B003");
        book3.setJudul("Aku Terharu");
        book3.setPenulis("Paijo");
        book3.setPenerbit("Andi");
        book3.setHarga(3000000);
        book3.setStock(10);
        bookService.addBook(book3);

        /*Show Detail Book */

        Book book9 = bookService.showDetail("B003");

        // print data mahasiswa
        System.out.println("id          :"+ book9.getId());
        System.out.println("Judul       :"+book9.getJudul());
        System.out.println("penulis     :"+book9.getPenulis());
        System.out.println("penerbit    :"+book9.getPenerbit());
        System.out.println("Harga       :"+book9.getHarga());
        System.out.println("stock       :"+book9.getStock());

        System.out.println();
        System.out.println();
        System.out.println();


        // Header table book List
        System.out.println("|" + padRight("Book Id", 15) + "| " + padRight("Judul Buku", 15) + "| " + padRight("Penulis", 15)
                + "|" + padRight("Penerbit", 15) + "|" + padRight("Harga", 15) + "|" + padRight("Stock", 15)+"|");

        printBook();

        System.out.println();
        System.out.println();

        Transaksi ts1 = new Transaksi();
        ts1.setId("B001");
        ts1.setQty(1);
        ts1.setBook();

        Transaksi ts2 = new Transaksi();
        ts2.setId("B002");
        ts2.setQty(3);



        transService.addTransaction(ts1);
        transService.addTransaction(ts2);

        double total=0;
        for (Transaksi tr : transService.getListTrans()) {
            Book bk = bookService.showDetail(tr.getId());

            double subtotal = bk.getHarga() * tr.getQty();

            System.out.println("|"
                    + padRight(""+bk.getJudul(), 15) + "| "
                    + padRight(""+tr.getQty(), 15) + "|   "
                    + padRight(""+tr.getBook().getHarga(), 15) + "| "
                    + padRight(""+bk.getHarga(), 15) + "| "
                    + padRight(""+subtotal, 15) + "| ");

            bookService.updateStock(tr.getId(), tr.getQty());
            total += subtotal;
        }
        System.out.println(String.format("%.2f", total));
        System.out.println(total);
     //   System.out.println("|" + padRight("" + (int)total, 45) + "|");
        System.out.println();
        System.out.println();
        // Update List Book

        printBook();

    }

    public static String padRight(String inputString, int length) {
        return String.format("%1$-" + length + "s", inputString);
    }

    public static void printBook(){
        for (Book book : bookService.getListBook()) {

            // print data mahasiswa
            System.out.println("|"

                    + padRight(""+book.getId(), 15) + "| "
                    + padRight(book.getJudul(), 15) + "| "
                    + padRight(book.getPenulis(), 15) + "|"
                    + padRight(book.getPenerbit(), 15) + "|"
                    + padRight(""+book.getHarga(), 15) + "|"
                    + padRight(""+book.getStock(), 15) + "|" );
        }
    }
}
