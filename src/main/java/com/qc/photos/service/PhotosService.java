package com.qc.photos.service;

import com.qc.photos.model.Photo;
import com.qc.photos.repository.PhotosRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotosService {

  private final PhotosRepository photosRepository;

  public PhotosService(PhotosRepository photosRepository) {
    this.photosRepository = photosRepository;
  }

  public Iterable<Photo> get() {
    return photosRepository.findAll();
  }

  public Photo get(Integer id) {
    return photosRepository.findById(id).orElse(null);
  }

  public Photo save(String fileName, String contentType, byte[] data) {
    Photo photo = Photo.builder()
        .fileName(fileName)
        .contentType(contentType)
        .data(data)
        .build();
    photosRepository.save(photo);
    return photo;
  }

  public void remove(Integer id) {
    photosRepository.deleteById(id);
  }
}
