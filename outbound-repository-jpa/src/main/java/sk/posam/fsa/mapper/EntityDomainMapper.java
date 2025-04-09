package sk.posam.fsa.mapper;

import sk.posam.fsa.*;
import sk.posam.fsa.entity.*;

public class EntityDomainMapper {

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setRole(user.getRole().name());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                UserRole.valueOf(entity.getRole())
        );
    }
    public static TrainingPlanEntity toEntity(TrainingPlan plan) {
        TrainingPlanEntity entity = new TrainingPlanEntity();
        entity.setId(plan.getId());
        entity.setTitle(plan.getTitle());
        entity.setSchedule(plan.getSchedule());
        entity.setAthleteId(plan.getAthleteId());
        return entity;
    }

    public static TrainingPlan toDomain(TrainingPlanEntity entity) {
        TrainingPlan plan = new TrainingPlan();
        plan.setId(entity.getId());
        plan.setTitle(entity.getTitle());
        plan.setSchedule(entity.getSchedule());
        plan.setAthleteId(entity.getAthleteId());
        return plan;
    }

    public static PerformanceEntity toEntity(Performance perf) {
        PerformanceEntity entity = new PerformanceEntity();
        entity.setId(perf.getId());
        entity.setAthleteId(perf.getAthleteId());
        entity.setExerciseId(perf.getExerciseId());
        entity.setResult(perf.getResult());
        return entity;
    }

    public static Performance toDomain(PerformanceEntity entity) {
        Performance perf = new Performance();
        perf.setId(entity.getId());
        perf.setAthleteId(entity.getAthleteId());
        perf.setExerciseId(entity.getExerciseId());
        perf.setResult(entity.getResult());
        return perf;
    }

    public static GoalEntity toEntity(Goal goal) {
        GoalEntity entity = new GoalEntity();
        entity.setId(goal.getId());
        entity.setAthleteId(goal.getAthleteId());
        entity.setDescription(goal.getDescription());
        entity.setTargetDate(goal.getTargetDate());
        return entity;
    }

    public static Goal toDomain(GoalEntity entity) {
        Goal goal = new Goal();
        goal.setId(entity.getId());
        goal.setAthleteId(entity.getAthleteId());
        goal.setDescription(entity.getDescription());
        goal.setTargetDate(entity.getTargetDate());
        return goal;
    }

    public static NotificationEntity toEntity(Notification n) {
        NotificationEntity e = new NotificationEntity();
        e.setId(n.getId());
        e.setUserId(n.getUserId());
        e.setMessage(n.getMessage());
        e.setRead(n.isRead());
        return e;
    }

    public static Notification toDomain(NotificationEntity e) {
        Notification n = new Notification();
        n.setId(e.getId());
        n.setUserId(e.getUserId());
        n.setMessage(e.getMessage());
        n.setRead(e.isRead());
        return n;
    }


}
