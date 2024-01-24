package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CoffeeForm;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    //GET
    @GetMapping("/api/coffees")
    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }
    @GetMapping("/api/coffees/{id}")
    public Coffee show(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    //POST
    @PostMapping("/api/coffees")
    public Coffee coffee(@RequestBody CoffeeForm dto) {
        Coffee coffee = dto.toEntity();
        return coffeeRepository.save(coffee);
    }

    //PATCH
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeForm dto) {
        //1. DTO -> 엔티티 변환하기
        Coffee coffee = dto.toEntity();
        log.info("id: {}, article: {}", id, coffee.toString());

        //2. 타깃 조회하기
        Coffee target = coffeeRepository.findById(id).orElse(null);

        //3. 잘못된 요청 처리하기
        if (target == null || id != coffee.getId()) {
            log.info("잘못된 요청! id: {}, article: {}", id, coffee.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //4. 업데이트 및 정상 응답(200)하기
        target.patch(coffee);
        Coffee update = coffeeRepository.save(target);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    //DELETE
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id) {
        //1. 대상 찾기
        Coffee target = coffeeRepository.findById(id).orElse(null);

        //2. 잘못된 요청 처리하기
        if (target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        //3. 대상 삭제하기
        coffeeRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
