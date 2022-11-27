package com.qc.photos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Builder
@Table("PHOTOS")
public class Photo {

  @Id
  private Integer id;

  @NonNull
  private String fileName;

  private String contentType;

  @JsonIgnore
  private byte[] data;

}
