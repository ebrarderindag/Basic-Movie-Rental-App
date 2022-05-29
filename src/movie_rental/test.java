/**
* @file proje_uc
* @description Bu proje bir film kiralama mağazası uygulamasıdır.
* @assignment 3.ödev
* @date 30.01.2021
* @author Ebrar Derindağ ebrar.derindag@stu.fsm.edu.tr
*/

package movie_rental;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Magaza magaza = new Magaza("Netflix");

        Film f1 = magaza.filmTuru("Harry Potter");
        Film f2 = magaza.filmTuru("Esaretin Bedeli");
        Film f3 = magaza.filmTuru("Matrix");

        Musteri m1 = new Musteri("Ebrar Derindağ", "12457", 150);
        Musteri m2 = new Musteri("Esra Güler", "12457", 500);
        Musteri m3 = new Musteri("Ahmet Elma", "12457", 200);

        magaza.M_filmEkle(f1);
        magaza.M_filmEkle(f2);
        magaza.M_filmEkle(f3);

        m1.FilmEkle(f2, m1);
        m2.FilmEkle(f3, m2);
        m2.FilmEkle(f1, m2);
        m2.FilmEkle(f2, m2);
        m3.FilmEkle(f1, m3);
        m3.FilmEkle(f3, m3);

        Scanner sc = new Scanner(System.in);

        String secenek = menu();

        while (secenek.charAt(0) != '8') {

            if (secenek.charAt(0) == '1') {
                System.out.print("İstediğiniz filmin adını giriniz: ");

                String filmAdi = sc.nextLine();
                

                if (filmAdi.equalsIgnoreCase("Harry Potter")) {
                    f1.KisiListele(f1);

                } else if (filmAdi.equalsIgnoreCase("Esaretin Bedeli")) {
                    f2.KisiListele(f2);

                } else if (filmAdi.equalsIgnoreCase("Matrix")) {
                    f3.KisiListele(f3);
                } else {
                    System.out.println("Böyle bir film bulunamadı.");
                }
            }

            if (secenek.charAt(0) == '2') {
                magaza.M_filmListele();
            }

            if (secenek.charAt(0) == '3') {
                
                System.out.print("\nKullanıcı Soy Adı: ");
                String kullaniciSoyadi = sc.next();

                System.out.print("\nKullanıcı Adı: ");
                String kullaniciAdi = sc.next();

                if (kullaniciAdi.equalsIgnoreCase("Ebrar") || kullaniciSoyadi.equalsIgnoreCase("Derindağ")) {
                    m1.filmListele(m1);

                } else if (kullaniciAdi.equalsIgnoreCase("Esra") || kullaniciSoyadi.equalsIgnoreCase("Güler")) {
                    m2.filmListele(m2);

                } else if (kullaniciAdi.equalsIgnoreCase("Ahmet") || kullaniciSoyadi.equalsIgnoreCase("Elma")) {
                    m3.filmListele(m3);
                } else {
                    System.out.println("Böyle bir kullanıcı bulunamadı.");
                }
            }

            if (secenek.charAt(0) == '4') {

                int max = f1.MaxKiralanan(m1.film_sayac(), m2.film_sayac(), m3.film_sayac());

                if (max == m1.film_sayac()) {
                    m1.filmListele(m1);
                } else if (max == m2.film_sayac()) {
                    m2.filmListele(m2);
                } else if (max == m3.film_sayac()) {
                    m3.filmListele(m3);
                }
            }

            if (secenek.charAt(0) == '5') {
                m1.film_listele();
                m2.film_listele();
                m3.film_listele();
            }

            if (secenek.charAt(0) == '6') {
                System.out.print("\nKullanıcı Soy Adı: ");
                String kullaniciSoyadi = sc.next();

                System.out.print("\nKullanıcı Adı: ");
                String kullaniciAdi = sc.next();

                if (kullaniciAdi.equalsIgnoreCase("Ebrar") || kullaniciSoyadi.equalsIgnoreCase("Derindağ")) {
                    for (int i = 0; i < m1.kiralananFilmler.length; i++) {
                        if (m1.kiralananFilmler[i] != null) {
                            m1.getKiralananFilmler()[i].KisiSil(m1, m2, m3);
                        }
                    }

                } else if (kullaniciAdi.equalsIgnoreCase("Esra") || kullaniciSoyadi.equalsIgnoreCase("Güler")) {
                    for (int i = 0; i < m2.kiralananFilmler.length; i++) {
                        if (m2.kiralananFilmler[i] != null) {
                            m2.getKiralananFilmler()[i].KisiSil(m2, m1, m3);
                        }
                    }
                } else if (kullaniciAdi.equalsIgnoreCase("Ahmet") || kullaniciSoyadi.equalsIgnoreCase("Elma")) {
                    for (int i = 0; i < m3.kiralananFilmler.length; i++) {
                        if (m3.kiralananFilmler[i] != null) {
                            m3.getKiralananFilmler()[i].KisiSil(m3, m2, m1);
                        }
                    }
                } else {
                    System.out.println("Böyle bir kullanıcı bulunamadı.");
                }
            }

            if (secenek.charAt(0) == '7') {
                System.out.print("İstediğiniz filmin adını giriniz: ");

                String filmAdi = sc.next();

                if (filmAdi.equalsIgnoreCase("Harry Potter")) {
                    magaza.FilmSil(f1, magaza);

                } else if (filmAdi.equalsIgnoreCase("Esaretin Bedeli")) {
                    magaza.FilmSil(f2, magaza);

                } else if (filmAdi.equalsIgnoreCase("Matrix")) {
                    magaza.FilmSil(f3, magaza);
                } else {
                    System.out.println("Böyle bir film bulunamadı.");
                }
            }
            secenek = menu();
        }
        if (secenek.charAt(0) == '8') {
            System.out.println("İyi Günler...");
        }
    }

    public static String menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nFilm Mağazasına Hoşgeldiniz!" + "\n1- Belirtilen filmi kiralayanlar " + "\n2- Film türleri ve sayıları" + "\n3- Belirtilen kullanıcının kiraladığı filmler " + "\n4- En çok film kiralayan müşteri");
        System.out.println("5- Belirli özelliklere göre müşteri listeleme " + "\n6- Müşteri silme" + "\n7- Film silme" + "\n8- Çıkış");

        System.out.print("Seçenek: ");
        String secenek = sc.next();

        while (!(48 < secenek.charAt(0) && 57 > secenek.charAt(0) && secenek.length() == 1)) {
            System.out.println("Hata! Lütfen Tekrar Deneyiniz.");
            System.out.print("Seçenek:");
            secenek = sc.next();
        }
        return secenek;
    }
}
