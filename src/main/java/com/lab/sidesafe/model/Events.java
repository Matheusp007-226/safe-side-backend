package com.lab.sidesafe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Events {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String typeEvent;

    private String dateEvent;

    @JsonIgnore
    @OneToMany
    private List<FeedBack>  feedBacksEventes;

}
