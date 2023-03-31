package com.example.jpamapping.manyToMany.api;

import com.example.jpamapping.manyToMany.service.MAuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mauthor")
public class MAuthorController {
    @Autowired MAuthorService mAuthorService;
    Logger logger = LoggerFactory.getLogger(MAuthorController.class);
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getMAuthor(@PathVariable Long id){
        logger.info("controller received request{}",id);
        return ResponseEntity.ok(mAuthorService.getAuthor(id));
    }
}
