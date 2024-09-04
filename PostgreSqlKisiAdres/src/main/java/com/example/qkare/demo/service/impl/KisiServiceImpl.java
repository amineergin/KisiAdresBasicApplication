package com.example.qkare.demo.service.impl;

import com.example.qkare.demo.dto.KisiDto;
import com.example.qkare.demo.entity.Adres;
import com.example.qkare.demo.entity.Kisi;
import com.example.qkare.demo.repository.AdresRepository;
import com.example.qkare.demo.repository.KisiRepository;
import com.example.qkare.demo.service.KisiService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service //Spring contextinde bir instance yaratmak için???
@RequiredArgsConstructor //İhtiyaç duyulduğunda constructor yaratılması için.
public class KisiServiceImpl implements KisiService {

    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;

    @Override
    @Transactional //Bu işlemin hepsini bir seferde vertabanına uygulamak için
    public KisiDto save(KisiDto kisiDto){
        //Assert.isNull(kisiDto.getAd(), "Adi alani zorunludur"); //Bu şekilde yazınca adı alanı boş geliyor,
        Objects.requireNonNull(kisiDto.getAd(), "Adi alanı zorunludur");

        Kisi kisi = new Kisi();
        kisi.setAd(kisiDto.getAd());
        kisi.setSoyad(kisiDto.getSoyad());
        final Kisi kisiDb = kisiRepository.save(kisi); //Burası neden böyle oldu?
        List<Adres> liste = new ArrayList<>();

        kisiDto.getAdresleri().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id){

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(it -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAd(it.getAd());
            kisiDto.setSoyad((it.getSoyad()));
            kisiDto.setAdresleri(it.getAdresleri().stream().map(Adres::getAdres).collect(Collectors.toList()));
            //son satırda adreslerin hepsinin sadece adres columnlarını bir liste halinde getir demiş olduk.

            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable){
        return null;
    }
}
