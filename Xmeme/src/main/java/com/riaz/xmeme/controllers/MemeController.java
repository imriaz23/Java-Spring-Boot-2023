package com.riaz.xmeme.controllers;

import com.riaz.xmeme.entities.Meme;
import com.riaz.xmeme.payloads.MemeRequest;
import com.riaz.xmeme.payloads.MemeResponse;
import com.riaz.xmeme.services.MemeService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memes")
public class MemeController {
  Logger logger = LoggerFactory.getLogger(MemeController.class);
  @Autowired
  private MemeService memeService;

  @PostMapping("/")
  public ResponseEntity<?> uploadMeme(@RequestBody MemeRequest memeRequest) {
    logger.info("Received meme creation request {} ", memeRequest);
    MemeResponse memeResponse = memeService.createMemeAndSave(memeRequest);
    return ResponseEntity.ok(memeResponse);
  }

  @GetMapping("/")
  public ResponseEntity<List<Meme>> getLatest100Memes() {
    List<Meme> memes = memeService.getLatest100memes();
    return ResponseEntity.ok(memes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Meme> findMemeById(@PathVariable String id) {
    Meme memeById = memeService.findMemeById(id);
    return ResponseEntity.ok(memeById);
  }
}
