package com.neetika.springBoot.repo;

import com.neetika.springBoot.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {

}
