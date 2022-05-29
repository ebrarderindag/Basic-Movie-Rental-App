/**
 * @file proje_uc
 * @description Bu proje bir film kiralama mağazası uygulamasıdır.
 * @assignment 3.ödev
 * @date 30.01.2021
 * @author Ebrar Derindağ ebrar.derindag@stu.fsm.edu.tr
 */
package movie_rental;

public class Musteri {

    protected String adSoyad, id;
    protected Film[] kiralananFilmler;
    protected int bakiye;
    protected int harcanan;

    public Musteri(String adSoyad, String id, int bakiye) {
        this.adSoyad = adSoyad;
        this.id = id;
        kiralananFilmler = new Film[10];
        this.bakiye = bakiye;
    }

    public void FilmEkle(Film film, Musteri m) {
        int sayac = 0;
        for (int i = 0; i < kiralananFilmler.length; i++) {
            if (kiralananFilmler[i] == null && sayac == 0) {
                m.kiralananFilmler[i] = film;
                film.getKiralayanKisiler()[i] = m;
                sayac++;
                int sayi = film.film_fiyatları();
                bakiye -= sayi;
                harcanan += sayi;
            }
        }
    }

    public void FilmEkle2(Film film, Musteri m) {

        for (int i = 0; i < kiralananFilmler.length; i++) {
            if ((kiralananFilmler[i] == null) && kiralananFilmler[i] != film) {
                kiralananFilmler[i] = film;
                if ((film.kiralayanKisiler[i] == null) && film.kiralayanKisiler[i] != m) {
                    film.getKiralayanKisiler()[i] = m;
                    int sayi = film.film_fiyatları();
                    bakiye -= sayi;
                    harcanan += sayi;
                    break;
                }
            }
        }
    }

    public void filmListele(Musteri m) {
        for (int i = 0; i < kiralananFilmler.length; i++) {
            if (kiralananFilmler[i] != null && kiralananFilmler[i].filmAd != "") {
                System.out.println("Kullanıcının filmlere harcadığı toplam fiyat: " + m.harcanan);
                System.out.println("\n" + m.adSoyad + " adlı müşterinin kiraladığı filmler");
                break;
            }
        }
        for (int i = 0; i < kiralananFilmler.length; i++) {
            if (kiralananFilmler[i] != null && kiralananFilmler[i].filmAd != "") {
                System.out.println("-" + kiralananFilmler[i].filmAd);
            }
        }
        if (m.adSoyad == null || m.adSoyad == "") {
            System.out.println("Böyle bir kullanıcı bulunmamaktadır.");
        }

    }

    public void film_listele() {
        if (getAdSoyad() != null && getAdSoyad() != "") {
            String[] AdıSoyadı = getAdSoyad().split(" ");
            String ad = AdıSoyadı[0];

            for (int i = 1; i < ad.length(); i++) {
                if (ad.charAt(0) == 'A') {
                    if ((ad.charAt(i) == 'h' || ad.charAt(i) == 'H') || (ad.charAt(i) == 'M' || ad.charAt(i) == 'm')) {
                        if (ad.charAt(ad.length() - 1) == 't' || ad.charAt(ad.length() - 1) == 'e') {
                            System.out.println("\n" + adSoyad + " adlı müşterinin kiraladığı filmler");
                            for (int j = 0; j < kiralananFilmler.length; j++) {
                                if (kiralananFilmler[j] != null && kiralananFilmler[j].filmAd != "") {
                                    System.out.println("-" + kiralananFilmler[j].filmAd);

                                }
                            }
                            System.out.println("Kullanıcının filmlere harcadığı toplam fiyat: " + harcanan);
                            break;
                        }
                    }
                }

            }
        } else if (getAdSoyad() == null || getAdSoyad() == "") {
            System.out.println("Böyle bir kullanıcı bulunmamaktadır.");

        }
    }

    public int film_sayac() {
        int sayac = 0;
        for (int i = 0; i < kiralananFilmler.length; i++) {
            if (kiralananFilmler[i] != null) {
                sayac++;
            }
        }
        return sayac;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public void setHarcanan(int harcanan) {
        this.harcanan = harcanan;
    }

    public int getBakiye() {
        return bakiye;
    }

    public int getHarcanan() {
        return harcanan;
    }

    public Film[] getKiralananFilmler() {
        return kiralananFilmler;
    }

    public String getAdSoyad() {
        return adSoyad;
    }
}
