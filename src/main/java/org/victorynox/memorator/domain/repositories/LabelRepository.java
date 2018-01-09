package org.victorynox.memorator.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.victorynox.memorator.domain.Label;

import java.util.UUID;

/**
 * @author victorynox
 * @version 0.1
 */
public interface LabelRepository extends CrudRepository<Label, UUID> {
}
