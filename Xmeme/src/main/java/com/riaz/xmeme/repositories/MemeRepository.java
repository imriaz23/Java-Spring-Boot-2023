package com.riaz.xmeme.repositories;

import com.riaz.xmeme.entities.Meme;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends JpaRepository<Meme, String> {
  @Query("SELECT m from Meme m ORDER BY m.createdAt DESC ")
  List<Meme> findTop100ByOrderByCreatedAtDESC();

  Optional<Meme> findMemesByUserNameAndAndCaptionAndAndUrl(String userName, String caption,
                                                           String url);
}
