package com.kayseri.akillihatanalizoru.controller;

import com.kayseri.akillihatanalizoru.dto.BusRecommendation;
import com.kayseri.akillihatanalizoru.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping
    public ResponseEntity<BusRecommendation> getRecommendation(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        return recommendationService.findNearestAndLeastCrowdedBus(latitude, longitude)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
