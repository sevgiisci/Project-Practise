package OkulYonetim;

import java.util.ArrayList;
import java.util.Scanner;

public class OgretmenMenu implements Islemler {
      /*
============= İŞLEMLER =============
		 1-EKLEME
		 2-ARAMA
		 3-LİSTELEME
		 4-SİLME
		 Q-ÇIKIŞ
	SEÇİMİNİZ:
 */
    ArrayList<Ogretmen> ogretmenList=new ArrayList<>();
    Scanner scan=new Scanner(System.in);

    void ogrtmnMenu(){
        System.out.println("============= İŞLEMLER =============\n" +
                             " 1-EKLEME\n" +
                             " 2-ARAMA\n" +
                             " 3-LİSTELEME\n" +
                             " 4-SİLME\n" +
                             " Q-ÇIKIŞ\n" +
                             "SEÇİMİNİZ:");
        while (true){
            char secim=scan.next().toUpperCase().charAt(0);
            switch (secim){
                case '1' :{
                    ekleme();
                }

                case '2' :{
                    arama();
                }

                case '3' :{
                    listeleme();
                }

                case '4' :{
                    silme();
                }

                case 'Q' :{
                    cikis();
                }
            }

        }
    }

    @Override
    public void ekleme() {
        System.out.print("Ogretmen adi giriniz :");
        scan.nextLine();
        String isim=scan.nextLine();
        System.out.print("Ogretmen soyadını giriniz :");
        String soyIsim=scan.nextLine();
        System.out.print("Ogretmen Tc No giriniz :");
        String tcNo=scan.next();
        System.out.print("Ogretmen yas giriniz :");
        int yas=scan.nextInt();
        System.out.print("Ogretmen bolum giriniz :");
        scan.nextLine();
        String bolum=scan.next();
        System.out.print("Ogretmen sicil no giriniz :");
        int sicilNo=scan.nextInt();
        Ogretmen ogretmenBilgi=new Ogretmen(isim,soyIsim,tcNo,yas,bolum,sicilNo);
        ogretmenList.add(ogretmenBilgi);
        ogrtmnMenu();
    }

    @Override
    public void arama() {
        if (!ogretmenList.isEmpty()){
            System.out.print("Arama yapılacak Tc No giriniz :");
            String aranilacakTcNo= scan.next();

            for (int i = 0; i < ogretmenList.size(); i++) {
                if (ogretmenList.get(i).getTcNo().equals(aranilacakTcNo)){
                    System.out.println(ogretmenList.toString());
                    ogrtmnMenu();
                }else{
                    System.out.println("Tc NO ya ait ogretmen bulunamamıstır");
                }
            }

        }else{
            System.out.println("Ogretmen listesi bos");
            ogrtmnMenu();
        }

    }

    @Override
    public void listeleme() {
        if (!ogretmenList.isEmpty()){
            for (Ogretmen each:ogretmenList) {
                System.out.println(each.toString());
            }
            ogrtmnMenu();
        }else{
            System.out.println("Ogretmen listesi bos");
            ogrtmnMenu();
        }

    }

    @Override
    public void silme() {
        if (!ogretmenList.isEmpty()){
            System.out.print("Silmek istediginiz Tc No giriniz :");
            String silinecekTcNo=scan.next();

            for (int i = 0; i < ogretmenList.size(); i++) {
                if (ogretmenList.get(i).getTcNo().equals(silinecekTcNo)){
                    ogretmenList.remove(i);
                    System.out.println("TcNo'lu ogrenci silindi");
                    ogrtmnMenu();
                }
            }

        }else{
            System.out.println("Ogretmen listesi bos");
            ogrtmnMenu();
        }

    }

    @Override
    public void cikis() {
        AnaMenu anaMenuDon=new AnaMenu();
        anaMenuDon.anaMenu();

    }
}
