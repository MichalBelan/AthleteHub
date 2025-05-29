package sk.posam.fsa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.posam.fsa.Notification;
import sk.posam.fsa.dto.NotificationDto;
import sk.posam.fsa.mapper.NotificationMapper;
import sk.posam.fsa.security.NotificationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;
    private final NotificationMapper mapper;

    public NotificationController(NotificationService service, NotificationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NotificationDto dto) {
        Notification notification = mapper.toDomain(dto);
        service.create(notification);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationDto>> getByUser(@PathVariable("userId") Long userId) {
        List<NotificationDto> result = service.findByUser(userId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<Void> markAsRead(@PathVariable("id") Long id) {
        service.markAsRead(id);
        return ResponseEntity.noContent().build();
    }
}
