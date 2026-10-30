package com.example.jobhunting.controller;

import com.example.jobhunting.dto.Apply;
import com.example.jobhunting.service.applicationService;
import com.example.jobhunting.service.companyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/applications")

public class applicationController {
    private final applicationService applicationService;
    private final companyService companyService;

    public applicationController(applicationService applicationService, companyService companyService) {
        this.applicationService = applicationService;
        this.companyService = companyService;
    }
    // 全ての応募情報を取得
    @GetMapping
    public ResponseEntity<List<Apply>> findAllApplications(){
        List<Apply> applications = applicationService.findAllApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    // IDの応募の取得
    public ResponseEntity<Apply> findApplicationById(@PathVariable long id){
        Apply apply = applicationService.findApplicationById(id);
        return ResponseEntity.ok(apply);
    }

    // 応募の新規登録
    @PostMapping
    public ResponseEntity<Apply> insertApplication(@RequestBody Apply apply,
                                                   UriComponentsBuilder uriBuilder){
        Apply createApply = applicationService.insertApplication(apply);

        URI location = uriBuilder.path("/api/applications/{id}")
                .buildAndExpand(createApply.getApplicationId()).toUri();

        return ResponseEntity.created(location).body(createApply);
    }

    // 応募の編集
    @PutMapping("/{id}")
    public ResponseEntity<Apply> updateApplication(@RequestBody Apply apply, @PathVariable long id){
        Apply applyUpdate = applicationService.updateApplication(apply,id);
        return ResponseEntity.ok(applyUpdate);
    }

    // 応募の削除
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicationById(@PathVariable long id){
        applicationService.deleteApplicationById(id);
        return ResponseEntity.noContent().build();
    }

}
