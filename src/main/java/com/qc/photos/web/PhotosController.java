package com.qc.photos.web;

import com.qc.photos.model.Photo;
import com.qc.photos.service.PhotosService;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PhotosController {

  private final PhotosService photosService;

  public PhotosController(PhotosService photosService) {
    this.photosService = photosService;
  }

  @GetMapping("/")
  public String hello() {
    return "Hello world!";
  }

  @GetMapping("/photos")
  public Iterable<Photo> get() {
    return photosService.get();
  }

  @GetMapping("/photos/{id}")
  public Photo get(@PathVariable Integer id) {
    Photo photo = photosService.get(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return photo;
  }

  @PostMapping("/photos")
  public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
    return photosService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
  }

  @DeleteMapping("/photos/{id}")
  public void delete(@PathVariable Integer id) {
    photosService.remove(id);
  }
}
