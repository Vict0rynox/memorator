package org.victorynox.memorator.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.victorynox.memorator.domain.Image;

import java.util.UUID;

/**
 * @author victorynox
 * @version 0.1
 */
public interface ImageRepository extends CrudRepository<Image, UUID>{
}
