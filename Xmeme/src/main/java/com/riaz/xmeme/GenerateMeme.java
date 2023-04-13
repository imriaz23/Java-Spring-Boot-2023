package com.riaz.xmeme;

import com.riaz.xmeme.entities.Meme;
import com.riaz.xmeme.payloads.MemeRequest;
import com.riaz.xmeme.services.MemeService;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenerateMeme {
  @Autowired
  ModelMapper modelMapper;
  public List<Meme> generate(){
    RestTemplate getUrl = new RestTemplate();
    List<Meme> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory() {
        @Override
        protected void prepareConnection(HttpURLConnection connection, String httpMethod)
            throws IOException {
          connection.setInstanceFollowRedirects(false);
        }
      });
      MemeRequest memeRequest = new MemeRequest();
      memeRequest.setUsername(RandomStringUtils.randomAlphabetic(7,23));
      memeRequest.setCaption(RandomStringUtils.randomAlphabetic(8,23));
      ResponseEntity<Object> response =
          restTemplate.exchange("https://picsum.photos/200/300", HttpMethod.GET, null,
              Object.class);
      int statusCode = response.getStatusCodeValue();
      String location = response.getHeaders().getLocation() == null ? "" :
          response.getHeaders().getLocation().toString();
      memeRequest.setUrl(location);
      Meme meme = modelMapper.map(memeRequest,Meme.class);
      list.add(meme);
    }
    return list;
  }

}
