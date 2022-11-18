package Project2;

import java.util.ArrayList;

public class CListing {

    void listele(ArrayList<AUser>kullaniciListe){
        if(!kullaniciListe.isEmpty()){
            for (AUser each:kullaniciListe) {
                if (each.registerDate.getDayOfMonth()<=10){
                    System.out.println(each.name +" sansli kullanicisiniz."+ each.registerDate +" tarihinde kaydoldu.");
                }else {
                    System.out.println(each.name +" sansli kullanici degilsiniz "+ each.registerDate +" tarihinde kaydoldu.");

                }
            }

        }else{
            System.out.println("Liste bos");
        }

    }
}
