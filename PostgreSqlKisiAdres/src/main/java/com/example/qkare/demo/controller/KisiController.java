package com.example.qkare.demo.controller;

import com.example.qkare.demo.dto.KisiDto;
import com.example.qkare.demo.service.KisiService;
import com.example.qkare.demo.entity.Kisi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController  {

    private final KisiService kisiService;

    @PostMapping("postKisiKaydet")
    public ResponseEntity<KisiDto> kaydet(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(kisiService.save(kisiDto));
    }

    @GetMapping("KisiListele")
    public ResponseEntity<List<KisiDto>> tumunuListele() {return ResponseEntity.ok(kisiService.getAll());}

    @GetMapping("/mesajGet")
    public String getMyMessage(@RequestParam("deneme") String message){
        return "my message is " + message;
    }
}
