package com.qc.photos.web;

import com.qc.photos.model.Photo;
import com.qc.photos.service.PhotosService;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

  private final PhotosService photosService;

  public DownloadController(PhotosService photosService) {
    this.photosService = photosService;
  }

  @GetMapping("/download/{id}")
  public ResponseEntity<byte[]> download(@PathVariable Integer id) {
    Photo photo = photosService.get(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    byte[] data = photo.getData();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));
    ContentDisposition build = ContentDisposition
        .builder("attachment")
        .filename(photo.getFileName())
        .build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
  
  @GetMapping("view/{id}")
  public ResponseEntity<byte[]> view(@PathVariable Integer id) {
    Photo photo = photosService.get(id);
    if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    byte[] data = photo.getData();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.valueOf(photo.getContentType()));
    ContentDisposition build = ContentDisposition
        .builder("inline")
        .filename(photo.getFileName())
        .build();
    headers.setContentDisposition(build);

    return new ResponseEntity<>(data, headers, HttpStatus.OK);
  }
}
