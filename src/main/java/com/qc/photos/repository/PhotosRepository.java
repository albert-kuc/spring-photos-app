package com.qc.photos.repository;

import com.qc.photos.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {

}
