package com.example.qkare.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import java.util.List;

@Entity
@Table
@AllArgsConstructor //tüm filedların olduğu bir constructor oluşturmak için
@NoArgsConstructor //hiç parametre olmayan bir constructor oluşturmak için
@Getter //Tüm fieldların getter methodunu eklemek için
@Setter //Tüm filedların setter methodunu eklemek için
public class    Kisi{

    @Id
    @SequenceGenerator(name="seq_kisi", allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, name="ad")
    private String ad;

    @Column(length = 100, name="soyad")
    private String soyad;


    @OneToMany //onetoMany ilişki kurmak için
    @JoinColumn(name = "kisi_adres_id") //standart join işlemi
    private List<Adres> adresleri;

}
