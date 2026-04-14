package com.kayseri.akillihatanalizoru.controller;

import com.kayseri.akillihatanalizoru.entity.Bus;
import com.kayseri.akillihatanalizoru.entity.Station;
import com.kayseri.akillihatanalizoru.repository.BusRepository;
import com.kayseri.akillihatanalizoru.repository.StationRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    private final StationRepository stationRepository;
    private final BusRepository busRepository;

    public DataController(StationRepository stationRepository, BusRepository busRepository) {
        this.stationRepository = stationRepository;
        this.busRepository = busRepository;
    }

    @GetMapping("/stations")
    public List<Station> getStations() {
        return stationRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/buses")
    public List<Bus> getBuses() {
        return busRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
