package OkulYonetim;
/*
============= İŞLEMLER =============
		 1-EKLEME
		 2-ARAMA
		 3-LİSTELEME
		 4-SİLME
		 Q-ÇIKIŞ
	SEÇİMİNİZ:
 */

import java.util.ArrayList;
import java.util.Scanner;

public class OgrenciMenu implements Islemler{
   ArrayList<Ogrenci> ogrenciList=new ArrayList<>();
    Scanner scan=new Scanner(System.in);
        void ogrMenu(){
        System.out.print("============= İŞLEMLER =============\n"+
                           "1-EKLEME\n" +
                           "2-ARAMA\n" +
                           "3-LİSTELEME\n" +
                            "4-SİLME\n" +
                            "Q-ÇIKIŞ\n" +
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
        System.out.print("Isminizi giriniz :");
        scan.nextLine();
        String isim=scan.nextLine();
        System.out.print("Soyisminizi giriniz :");
        String soyIsim=scan.nextLine();
        System.out.print("Tc no giriniz :");
        String tcNo=scan.next();
        System.out.print("Yas giriniz :");
        scan.nextLine();
        int yas=scan.nextInt();
        System.out.print("Sinif giriniz :");
        String sinif=scan.next();
        System.out.print("Ogrenci No giriniz :");
        int ogrNo=scan.nextInt();
        Ogrenci ogrenciBilgi=new Ogrenci(isim,soyIsim,tcNo,yas,sinif,ogrNo);
        ogrenciList.add(ogrenciBilgi);
        ogrMenu();

    }

    @Override
    public void arama() {
        if (!ogrenciList.isEmpty()){
            System.out.print("Aranacak Tc No giriniz :");
            String aranacakTcNo=scan.next();
            for (int i = 0; i < ogrenciList.size(); i++) {
                if (ogrenciList.get(i).getTcNo().equals(aranacakTcNo)){
                    System.out.println(ogrenciList.get(i));
                }
            }
            ogrMenu();

        }else{
            System.out.println("Ogrenci listesi bos");
            ogrMenu();
        }

    }

    @Override
    public void listeleme() {
        if (!ogrenciList.isEmpty()){
            for (Ogrenci each:ogrenciList) {
                System.out.println(each.toString());
            }
            ogrMenu();

        }else{
            System.out.println("Ogrenci listesi bos");
            ogrMenu();
        }

    }

    @Override
    public void silme() {
        if (!ogrenciList.isEmpty()){
            System.out.print("Silme yapılacak Tc No giriniz :");
            String silinecekTcNo=scan.nextLine();
            for (int i = 0; i < ogrenciList.size(); i++) {
                if(ogrenciList.get(i).getTcNo().equals(silinecekTcNo)){
                  ogrenciList.remove(i);
                    System.out.println("TcNo'lu ogrenci silindi");
                    ogrMenu();
                }
            }

        }else {
            System.out.println("Ogrenci listesi bos");
            ogrMenu();
        }

    }

    @Override
    public void cikis() {
        AnaMenu anaMenuDon=new AnaMenu();
        anaMenuDon.anaMenu();

    }
}
