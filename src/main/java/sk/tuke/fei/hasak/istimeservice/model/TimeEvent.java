/*
 * Copyright (c) 2020 Šimon Hašák.
 * All rights reserved.
 */

package sk.tuke.fei.hasak.istimeservice.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The type Time event.
 *
 * @author Šimon Hašák
 */
@Entity
@Data
@Table(name = "event")
public class TimeEvent extends RepresentationModel<TimeEvent> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

}
