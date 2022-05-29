/**
* @file proje_uc
* @description Bu proje bir film kiralama mağazası uygulamasıdır.
* @assignment 3.ödev
* @date 30.01.2021
* @author Ebrar Derindağ ebrar.derindag@stu.fsm.edu.tr
*/
package movie_rental;

public class Magaza {

    protected String ad;
    protected Film[] filmListesi;

    public Magaza(String ad) {
        this.ad = ad;
        filmListesi = new Film[15];
    }

    public void M_filmEkle(Film film) {
        for (int i = 0; i < filmListesi.length; i++) {
            if (filmListesi[i] == null) {
                filmListesi[i] = film;
                break;
            }
        }
    }

    public void FilmSil(Film film, Magaza magaza) {
        for (int i = 0; i < 1; i++) {
            if (film.filmAd == null || film.filmAd == "") {
                System.out.println("Böyle bir film bulunamadı.");
                break;
            } else {
                System.out.println(film.filmAd + " adlı film silindi.");
                System.out.println("Filmi kiralayanlara para iadesi yapıldı.");
            }
        }

        for (int i = 0; i < filmListesi.length; i++) {
            if (filmListesi[i] == film) {
                filmListesi[i].filmAd = "";
                filmListesi[i] = null;

                for (int j = 0; j < film.kiralayanKisiler.length; j++) {
                    if (film.kiralayanKisiler[j] != null && film.kiralayanKisiler[j].getKiralananFilmler()[j] != null) {
                        if (film.kiralayanKisiler[j].getKiralananFilmler()[j] == film) {
                            film.kiralayanKisiler[j].getKiralananFilmler()[j] = null;
                            
                            int yeniBakiye = film.getKiralayanKisiler()[j].bakiye + film.film_fiyatları();
                            int yeniHarcanan = film.getKiralayanKisiler()[j].harcanan - film.film_fiyatları();
                            
                            film.getKiralayanKisiler()[j].setHarcanan(yeniHarcanan);
                            film.getKiralayanKisiler()[j].setBakiye(yeniBakiye);
                        }
                    }
                }
            }
        }
    }

    public Film filmTuru(String filmAd) {
        int y = 1 + (int) (Math.random() * 3);

        if (y == 1) {
            Dram dram = new Dram(filmAd);
            return dram;
        }
        if (y == 2) {
            Komedi komedi = new Komedi(filmAd);
            return komedi;
        }
        if (y == 3) {
            Gerilim gerilim = new Gerilim(filmAd);
            return gerilim;
        }
        return null;
    }

    public void M_filmListele() {
        int DramSayisi = 0;
        int KomediSayisi = 0;
        int GerilimSayisi = 0;
        for (int i = 0; i < filmListesi.length; i++) {
            if (filmListesi[i] instanceof Dram) {
                DramSayisi++;
            }
        }
        for (int i = 0; i < filmListesi.length; i++) {
            if (filmListesi[i] instanceof Komedi) {
                KomediSayisi++;
            }
        }
        for (int i = 0; i < filmListesi.length; i++) {
            if (filmListesi[i] instanceof Gerilim) {
                GerilimSayisi++;
            }
        }
        System.out.println("Toplam film sayısı: " + (DramSayisi + KomediSayisi + GerilimSayisi));
        System.out.println("Komedi filmi sayısı: " + KomediSayisi + "\nDram filmi sayısı: " + DramSayisi + "\nGerilim filmi sayısı: " + GerilimSayisi);
    }
}
