package sk.posam.fsa.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import sk.posam.fsa.UserRole;

@Converter(autoApply = false)
public class UserRoleConverter  implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole attribute) {
        return attribute != null ? attribute.name() : null;
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        return dbData != null ? UserRole.valueOf(dbData) : null;
    }
}
