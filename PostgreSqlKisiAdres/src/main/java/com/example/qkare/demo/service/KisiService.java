package com.example.qkare.demo.service;

import com.example.qkare.demo.dto.KisiDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

//Service katmanı dediğimiz API. Bunu direkt olarak dış dünyaya açmamak için DTO kullanıyoruz.
public interface KisiService {
    //Servisler DTO'lar ile çalışır
    KisiDto save(KisiDto kisiDto);
    void delete(Long id);
    List<KisiDto> getAll();
    Page<KisiDto> getAll(Pageable pageable);
}
