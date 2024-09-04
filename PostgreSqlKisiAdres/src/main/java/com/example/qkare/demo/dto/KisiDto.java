package com.example.qkare.demo.dto;

import lombok.Data;

import java.util.List;

@Data //Bu anotasyonu eklersek getter,setter, requiredArgsConstructor, ToString, EqualsAndHashCode, lombok.value anotasyonlarını otomatik olarak eklemişiz gibi oluyor.
public class KisiDto {
    private Long id;
    private String ad;
    private String soyad;
    private List<String> adresleri;

}
