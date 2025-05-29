package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.dto.TrainingPlanDto;
import sk.posam.fsa.mapper.TrainingPlanMapper;
import sk.posam.fsa.security.TrainingPlanService;


import java.util.List;

@RestController
@RequestMapping("/api/training-plans")
public class TrainingPlanController {

    private final TrainingPlanService service;
    private final TrainingPlanMapper mapper;

    public TrainingPlanController(TrainingPlanService service, TrainingPlanMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @PreAuthorize("hasRole('COACH')")
    public ResponseEntity<Void> create(@RequestBody TrainingPlanDto dto) {
        service.create(mapper.toDomain(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/athlete/{athleteId}")
    @PreAuthorize("hasRole('ATHLETE')")
    public ResponseEntity<List<TrainingPlanDto>> getByAthlete(@PathVariable("athleteId") Long athleteId) {
        return ResponseEntity.ok(
                service.findByAthlete(athleteId).stream().map(mapper::toDto).toList()
        );
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ATHLETE', 'COACH')")
    public ResponseEntity<TrainingPlanDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.toDto(service.findById(id)));
    }
}
