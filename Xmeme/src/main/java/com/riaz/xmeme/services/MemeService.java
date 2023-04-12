package com.riaz.xmeme.services;

import com.riaz.xmeme.entities.Meme;
import com.riaz.xmeme.exceptions.DuplicatePostException;
import com.riaz.xmeme.exceptions.MemeNotFoundExecption;
import com.riaz.xmeme.payloads.MemeRequest;
import com.riaz.xmeme.payloads.MemeResponse;
import com.riaz.xmeme.repositories.MemeRepository;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "xmeme")
public class MemeService {
  Logger logger = LoggerFactory.getLogger(MemeService.class);
  @Autowired
  private MemeRepository memeRepository;
  @Autowired
  private ModelMapper modelMapper;

  @CacheEvict(cacheNames = "meme",allEntries = true)
  public MemeResponse createMemeAndSave(MemeRequest memeRequest) {
    if (isDuplicate(memeRequest)) {
      throw new DuplicatePostException("Could not completed the request meme already exist .");
    }
    Meme meme = modelMapper.map(memeRequest, Meme.class);
    Meme savedMeme = memeRepository.save(meme);
    MemeResponse memeResponse = new MemeResponse();
    memeResponse.setId(savedMeme.getId());
    logger.info("meme created with id {} ", savedMeme.getId());
    return memeResponse;
  }

  @Cacheable(cacheNames = "meme")
  public List<Meme> getLatest100memes() {
    return memeRepository.findTop100ByOrderByCreatedAtDESC();
  }

  @Cacheable(cacheNames = "meme")
  public Meme findMemeById(String id) {
    Optional<Meme> optionalMeme = memeRepository.findById(id);
    if (optionalMeme.isPresent()) {
      return optionalMeme.get();
    } else {
      throw (new MemeNotFoundExecption("Meme is not found with id : " + id));
    }
  }

  public boolean isDuplicate(MemeRequest memeRequest) {
    Optional<Meme> meme =
        memeRepository.findMemesByUserNameAndAndCaptionAndAndUrl(memeRequest.getUsername(),
            memeRequest.getCaption(), memeRequest.getUrl());
    return meme.isPresent();
  }
}
