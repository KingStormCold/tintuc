package com.example.controller.admin.api;

import com.example.dto.NewDTO;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewAPI {

    @Autowired
    private INewService newService;

    @PostMapping("/api/admin/new")
    public ResponseEntity<NewDTO> createdNew(@RequestBody NewDTO newDTO){//vn cua ResponseEntity converter tu kieu json ve javabean

        return ResponseEntity.ok(new NewDTO());
    }
}
