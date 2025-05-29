package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.Performance;
import sk.posam.fsa.dto.PerformanceDto;
import sk.posam.fsa.mapper.PerformanceMapper;
import sk.posam.fsa.ports.PerformanceRepository;
import sk.posam.fsa.security.PerformanceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/performances")
public class PerformanceController {

    private final PerformanceMapper mapper;

    private final PerformanceService service;
    public PerformanceController(PerformanceService service, PerformanceMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PerformanceDto dto) {
        Performance performance = mapper.toDomain(dto);
        service.create(performance);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/athlete/{athleteId}")
    public ResponseEntity<List<PerformanceDto>> getByAthlete(@PathVariable("athleteId") Long athleteId) {
        List<PerformanceDto> dtos = service.findByAthleteId(athleteId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

}