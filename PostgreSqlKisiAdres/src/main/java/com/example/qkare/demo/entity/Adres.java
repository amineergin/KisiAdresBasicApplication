package com.example.qkare.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kisi_adres")
@AllArgsConstructor //tüm filedların olduğu bir constructor oluşturmak için
@NoArgsConstructor //hiç parametre olmayan bir constructor oluşturmak için
@Getter //Tüm fieldların getter methodunu eklemek için
@Setter //Tüm filedların setter methodunu eklemek için
@EqualsAndHashCode(of = {"id"}) //İki adresin id'si aynıysa bu iki nesne birbirinin aynısıdır demek için
@ToString //Otomoatik bir toString methodu tanımlar
public class Adres {
    @Id
    @SequenceGenerator(name = "seq_kisi_adres", allocationSize = 1) //auto increment için kulanılıyor
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE) //Id filedı üretilirken eğer id otomatik bir yerden alınacaksa bunu bu anotasyon ile yapıyoruz
    private Long id;

    @Column(length = 500, name="adres") //Opsiyonel, updateable=false bir kere grildikten sonra güncellenemeyecek veriler için, nullable null olabilir ya da olamaz demek için
    private String adres;
    @Enumerated //Enum olduğunu belirtmek için
    private AdresTip adresTip;

    @Column(name="aktif")
    private Boolean aktif;

    public enum AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
    @ManyToOne(fetch = FetchType.EAGER) //Veritabanından adres kaydı her select edildiğinde onunla ilgili kişisi de gelsin demek için fetch
    @JoinColumn(name="kisi_adres_id")
    private Kisi kisi; //her adres kaydına ait bir kişi var anlamına gelmektedir
}
