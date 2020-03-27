/*
 * Copyright (c) 2020 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.istimeservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.tuke.fei.hasak.istimeservice.model.SchedulledEvent;

import java.util.Optional;

/**
 * The interface Is time repository.
 *
 * @author Šimon Hašák
 */
@Repository
public interface IsTimeRepository extends CrudRepository<SchedulledEvent, Long> {

    Optional<SchedulledEvent> findByMessageId(Long id);
}
