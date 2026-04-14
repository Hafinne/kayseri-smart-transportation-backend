package com.kayseri.akillihatanalizoru.dto;

public class BusRecommendation {

    private Long busId;
    private String plate;
    private double distanceInKm;
    private int availableSeats;

    public BusRecommendation(Long busId, String plate, double distanceInKm, int availableSeats) {
        this.busId = busId;
        this.plate = plate;
        this.distanceInKm = distanceInKm;
        this.availableSeats = availableSeats;
    }

    public Long getBusId() {
        return busId;
    }

    public String getPlate() {
        return plate;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
