package Project2;

import java.util.Scanner;

public class DMenu {
    BRegistration registration=new BRegistration();
    CListing listing=new CListing();
    void giris() {
        System.out.println("Yapmak istediginiz islemi seciniz\n" +
                "1. Isim girisi\n" +
                "2. Sansli isimleri listeleme\n" +
                "3. Cikis\n" +
                "Seciminiz :");
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNext()) {
                int secim = scan.nextInt();
                switch (secim) {
                    case 1: {
                        registration.register();
                        giris();
                    }
                    case 2: {
                        listing.listele(registration.usersList);
                        giris();
                    }
                    case 3: {
                        System.out.println("Gule gule");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Gecerli deger giriniz");
                        giris();
                    }
                }
                } else{
                    System.out.println("Gecerli deger giriniz");
                    giris();
                }
            }
        }
    }

