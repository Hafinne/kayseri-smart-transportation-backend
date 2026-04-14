package com.kayseri.akillihatanalizoru.service;

import com.kayseri.akillihatanalizoru.dto.BusRecommendation;
import com.kayseri.akillihatanalizoru.entity.Bus;
import com.kayseri.akillihatanalizoru.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {

    private static final double EARTH_RADIUS_KM = 6371.0;

    private final BusRepository busRepository;

    public RecommendationService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public Optional<BusRecommendation> findNearestAndLeastCrowdedBus(double latitude, double longitude) {
        List<Bus> buses = busRepository.findAll();

        return buses.stream()
                .filter(this::hasAvailableSeat)
                .map(bus -> toRecommendation(bus, latitude, longitude))
                .min(Comparator.comparingDouble(BusRecommendation::getDistanceInKm)
                        .thenComparing(Comparator.comparingInt(BusRecommendation::getAvailableSeats).reversed()));
    }

    private boolean hasAvailableSeat(Bus bus) {
        return bus.getCapacity() > bus.getCurrentPassengers();
    }

    private BusRecommendation toRecommendation(Bus bus, double userLat, double userLon) {
        double distance = calculateDistanceInKm(userLat, userLon, bus.getLatitude(), bus.getLongitude());
        int availableSeats = bus.getCapacity() - bus.getCurrentPassengers();
        return new BusRecommendation(bus.getId(), bus.getPlate(), distance, availableSeats);
    }

    private double calculateDistanceInKm(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }
}
