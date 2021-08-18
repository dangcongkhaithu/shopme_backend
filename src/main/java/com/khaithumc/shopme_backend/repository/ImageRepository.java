package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
