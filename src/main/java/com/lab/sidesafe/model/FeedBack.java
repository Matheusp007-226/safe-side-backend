package com.lab.sidesafe.model;

import com.lab.sidesafe.enums.Eventlevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Eventlevel eventlevel;

    @Column(length = 100)
    private String description;

    private OffsetDateTime dateTime;

}
