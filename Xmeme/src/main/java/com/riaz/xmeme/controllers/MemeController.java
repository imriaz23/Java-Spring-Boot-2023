package com.riaz.xmeme.controllers;

import com.riaz.xmeme.entities.Meme;
import com.riaz.xmeme.payloads.MemeRequest;
import com.riaz.xmeme.payloads.MemeResponse;
import com.riaz.xmeme.services.MemeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memes")
@Tag(name = "meme", description = "the meme api")
public class MemeController {
  Logger logger = LoggerFactory.getLogger(MemeController.class);
  @Autowired
  private MemeService memeService;

  @Operation(summary = "Create a meme", description = "Endpoint to send a meme to the backend", tags = {
      "meme"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Meme Created"),
      @ApiResponse(responseCode = "400", description = "Invalid input"),
      @ApiResponse(responseCode = "409", description = "Meme already exists")
  })
  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> uploadMeme(@RequestBody @Valid MemeRequest memeRequest) {
    logger.info("Received meme creation request {} ", memeRequest);
    MemeResponse memeResponse = memeService.createMemeAndSave(memeRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body(memeResponse);
  }

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Find latest 100 memes", description = "Endpoint to fetch the latest 100 memes created", tags = {
      "meme"})
  public ResponseEntity<List<Meme>> getLatest100Memes() {
    List<Meme> memes = memeService.getLatest100memes();
    return ResponseEntity.ok(memes);
  }

  @Operation(summary = "Find meme by id", description = "Endpoint to specify a particular id (identifying the meme) to fetch a single Meme", tags = {
      "meme"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "successful operation"),
      @ApiResponse(responseCode = "404", description = "Meme does not exist")
  })
  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Meme> findMemeById(@PathVariable String id) {
    Meme memeById = memeService.findMemeById(id);
    return ResponseEntity.ok(memeById);
  }

  @Operation(summary = "Delete a meme",description = "Delete a meme by id if exists",tags = {"meme"})
  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> deleteMemeById(@PathVariable String id) {
    memeService.deleteMemeById(id);
    MemeResponse memeResponse = new MemeResponse();
    memeResponse.setId(id);
    return ResponseEntity.ok().body(memeResponse);
  }
  @Operation(summary = "delete all memes",description = "Api to delete all the memes",tags = {"meme"})
  @DeleteMapping("/")
  public ResponseEntity<?> deleteAll(){
    memeService.deleteAll();
    return ResponseEntity.status(HttpStatus.OK).body("Deleted");
  }
  @Operation(summary = "Generate 10 random memes",description = "Api to create random memes ",tags = {"meme"})
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Memes Created")
  })
  @PostMapping("/random-memes")
  public ResponseEntity<List<Meme>> generate(){
    List<Meme> memes = memeService.saveAll();
    return ResponseEntity.status(HttpStatus.CREATED).body(memes);
  }

}
