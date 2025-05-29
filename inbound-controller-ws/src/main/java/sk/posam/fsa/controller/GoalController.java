package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.Goal;
import sk.posam.fsa.dto.GoalDto;
import sk.posam.fsa.mapper.GoalMapper;
import sk.posam.fsa.security.GoalService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService service;
    private final GoalMapper mapper;

    public GoalController(GoalService service, GoalMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody GoalDto dto) {
        Goal goal = mapper.toDomain(dto);
        service.create(goal);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/athlete/{athleteId}")
    public ResponseEntity<List<GoalDto>> getByAthlete(@PathVariable("athleteId") Long athleteId) {
        List<GoalDto> goals = service.findByAthlete(athleteId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(goals);
    }


}
