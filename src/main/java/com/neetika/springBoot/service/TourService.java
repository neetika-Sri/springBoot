package com.neetika.springBoot.service;

import com.neetika.springBoot.domain.Difficulty;
import com.neetika.springBoot.domain.Region;
import com.neetika.springBoot.domain.Tour;
import com.neetika.springBoot.domain.TourPackage;
import com.neetika.springBoot.repo.TourPackageRepository;
import com.neetika.springBoot.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb,
                           Integer price, String duration, String bullets,
                           String keywords, String tourPackageName,
                           Difficulty difficulty, Region region){
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(() -> new RuntimeException("Tour Package does not exists "+tourPackageName));

        return tourRepository.save(new Tour(title,description,blurb,price,
                duration,bullets,keywords,tourPackage,difficulty,region));

    }

    public long total(){
        return tourRepository.count();
    }
}
