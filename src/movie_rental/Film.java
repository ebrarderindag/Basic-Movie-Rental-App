/**
 * @file proje_uc
 * @description Bu proje bir film kiralama mağazası uygulamasıdır.
 * @assignment 3.ödev
 * @date 30.01.2021
 * @author Ebrar Derindağ ebrar.derindag@stu.fsm.edu.tr
 */
package movie_rental;

public class Film {

    protected String filmAd;
    protected Musteri[] kiralayanKisiler;

    public Film(String filmAd) {
        this.filmAd = filmAd;
        kiralayanKisiler = new Musteri[10];
    }

    public void KisiListele(Film film) {
        if (film.kiralayanKisiler == null) {
            System.out.println("Bu filmi kiralayan kimse yok!");
        } else if (filmAd == null || filmAd == "") {
            System.out.println("Böyle bir film bulunamamıştır.");
        } else {
        System.out.println("\n" + filmAd + " adlı filmi kiralayan kişiler: ");
        for (int i = 0; i < film.kiralayanKisiler.length; i++) {
            if (film.kiralayanKisiler[i] != null) {
                System.out.println("-" + film.kiralayanKisiler[i].adSoyad);
            }
            }
        }
    }

    public void KisiSil(Musteri m, Musteri m2, Musteri m3) {

        if (m.getKiralananFilmler().length != 0) {
            if (m.getHarcanan() <= m2.getBakiye()) {
                for (int i = 0; i < m.kiralananFilmler.length; i++) {
                    if (m.getKiralananFilmler()[i] != null) {
                        m2.FilmEkle2(m.getKiralananFilmler()[i], m2);
                    }
                }
            } else if (m.getHarcanan() <= m3.getBakiye()) {
                for (int i = 0; i < m.kiralananFilmler.length; i++) {
                    if (m.getKiralananFilmler()[i] != null) {
                        m3.FilmEkle2(m.kiralananFilmler[i], m3);
                    }
                }
            } else {
                System.out.println("Diğer kullanıcılarda yeterli bakiye bulunmamaktadır.");
            }
        }
        for (int i = 0; i < m.kiralananFilmler.length; i++) {
            if (m.kiralananFilmler[i] != null && m != null) {
                m.kiralananFilmler[i] = null;
                m.adSoyad = null;
            }
        }
        System.out.println("Müşteri Silindi!");
    }

    public void Kisi_Listele() {
        System.out.println("\n" + filmAd + " adlı filmi kiralayan kişiler: ");
        for (int i = 0; i < kiralayanKisiler.length; i++) {
            if (kiralayanKisiler[i] != null && kiralayanKisiler[i].adSoyad != null) {
                System.out.println("-" + kiralayanKisiler[i].adSoyad);
            }
        }
    }

    public int MaxKiralanan(int a, int b, int c) {
        int max = 0;
        int kiralayanlar[] = {a, b, c};
        for (int i = 0; i < kiralayanlar.length; i++) {
            if (kiralayanlar[i] > max) {
                max = kiralayanlar[i];
            }
        }
        System.out.println("\nKiraladığı toplam film sayısı: " + max);
        if (max == a) {
            System.out.println("En çok film kiralayan kişi: " + kiralayanKisiler[2].adSoyad);
            return max;
        } else if (max == b) {
            System.out.println("En çok film kiralayan kişi: " + kiralayanKisiler[1].adSoyad);
            return max;
        } else if (max == c) {
            System.out.println("En çok film kiralayan kişi: " + kiralayanKisiler[0].adSoyad);
            return max;
        }
        return 0;
    }

    public int film_fiyatları() {
        int sayi = (int) (Math.random() * 5) + 10;
        return sayi;
    }

    public String getFilmAd() {
        return filmAd;
    }

    public Musteri[] getKiralayanKisiler() {
        return kiralayanKisiler;
    }

}
