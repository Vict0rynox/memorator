package org.victorynox.memorator.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import org.victorynox.memorator.domain.Mem;

import java.util.List;
import java.util.UUID;

/**
 * @author victorynox
 * @version 0.1
 */
public interface MemRepository extends CrudRepository<Mem, UUID> {
}
