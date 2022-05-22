package com.staff.flight.repository;

import com.staff.flight.model.entity.Passage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PassageRepository extends JpaRepository<Passage, Long> {

    Passage findByIdPassenger(Long idPassenger);
}
