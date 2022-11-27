package com.lab.sidesafe.repositories;

import com.lab.sidesafe.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventServiceRepositore extends JpaRepository<Events, Long> {
}
