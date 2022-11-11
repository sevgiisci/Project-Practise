package Project1;

import java.util.Scanner;

public class Atm {
     /*
    ATM
Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme ve cikis islemleri olacaktır.

Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina
geri donsun.
Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
     */
    static String kartNo="1234567890123456";
    static String sifre="1234";
    static double bakiye=20000;
   static Scanner scan=new Scanner(System.in);

    public static void main(String[] args) {
        giris();
    }

    private static void giris() {
        System.out.println("KART NUMARANIZI GIRINIZ :");
        String kKartNo=scan.nextLine();
        System.out.println("SIFRENIZI GIRINIZ :");
        String ksifre=scan.nextLine();
        kartNo=kKartNo.replaceAll("\\s","");
        if (kKartNo.equals(kartNo) && ksifre.equals(sifre)){
            menu();
        }else{
            System.out.println("HATALI GIRIS YAPTINIZ");
            giris();
        }
    }
    private static void menu() {
        System.out.println("************JAVABANKA HOSGELDINIZ************\n"+
                "YAPMAK ISTEDIGIN ISLEMI SECINIZ\n"+
                "1.BAKIYE SORGULAMA\n"+
                "2.PARA YATIRMA\n"+
                "3.PARA CEKME\n"+
                "4.PARA GONDERME\n"+
                "5.SIFRE DEGISTIRME\n"+
                "6.CIKIS");
        int secim=scan.nextInt();
        switch (secim){
            case 1 :{
                bakiyeSorgula();
            }
            case 2 :{
                System.out.println("YATIRMAK ISTEDIGINIZ MIKTARI GIRINIZ");
                double miktar=scan.nextDouble();
                paraYatırma(miktar);
            }
            case 3 :{
                System.out.println("CEKMEK ISTEDIGINIZ MIKTARI GIRINIZ");
                double miktar=scan.nextDouble();
                paraCekme(miktar);
            }
            case 4 :{
                System.out.println("IBAN GIRINIZ");
                String iban=scan.nextLine();
                scan.nextLine();
                System.out.println("GONDERECEGINIZ MIKTARI GIRINIZ");
                double miktar=scan.nextDouble();
                ibanKontrolu(iban);
                paraGonderme( ibanKontrolu(iban),miktar);
            }
            case 5 :{
                sifreDegiştir();
            }
            case 6 :{
                System.out.println("**********HOSCAKALIN*************");
                System.exit(0);

            }

        }


    }



    private static void sifreDegiştir() {
        System.out.println("ESKI SIFRENIZI GIRINIZ :");
        String ksifre=scan.next();
        if (ksifre.equals(sifre)){
            System.out.println("YENI SIFREYI GIRINIZ :");
            sifre=scan.next();
            scan.nextLine();
            giris();
        }else {
            System.out.println("GECERLI SIFRE GIRINIZ");
            sifreDegiştir();
        }
    }

    private static void paraGonderme(String iban, double miktar) {
        if (miktar<=bakiye){
            bakiye-=miktar;
            System.out.println("iban + \" NOLU IBANA \" + miktar + \" GONDERILDI\"");
            bakiyeSorgula();
        }else {
            System.out.println("GECERLI MIKTAR GIRINIZ");
            paraGonderme(iban,scan.nextDouble());
        }
    }

    private static String ibanKontrolu(String iban) {
        iban = iban.replaceAll("\\s", "");
        if (iban.startsWith("TR") && iban.length() == 26) {

        } else {

            System.out.println("GECERLI IBAN GIRINIZ");
            scan.nextLine();
            ibanKontrolu(scan.nextLine());

        }
        return iban;
    }

    private static void paraCekme(double miktar) {
        if(miktar<=bakiye){
            bakiye-=miktar;
            bakiyeSorgula();
        }
    }

    private static void paraYatırma(double miktar) {
        bakiye+=miktar;
        bakiyeSorgula();
    }

    private static void bakiyeSorgula() {
        System.out.println("BAKIYENIZ :" + bakiye);
        menu();
    }


}



