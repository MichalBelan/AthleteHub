package sk.posam.fsa.mapper;

import org.springframework.stereotype.Component;
import sk.posam.fsa.Notification;
import sk.posam.fsa.dto.NotificationDto;

@Component
public class NotificationMapper {

    public NotificationDto toDto(Notification n) {
        NotificationDto dto = new NotificationDto();
        dto.setId(n.getId());
        dto.setUserId(n.getUserId());
        dto.setMessage(n.getMessage());
        dto.setRead(n.isRead());
        return dto;
    }

    public Notification toDomain(NotificationDto dto) {
        Notification n = new Notification();
        n.setId(dto.getId());
        n.setUserId(dto.getUserId());
        n.setMessage(dto.getMessage());
        n.setRead(dto.isRead());
        return n;
    }
}
