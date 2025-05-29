package sk.posam.fsa.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDto {
    private Long id;
    @NotBlank(message = "Meno nesmie byť prázdne")
    private String name;
    @NotBlank(message = "Email nesmie byť prázdny")
    private String email;
    private String role;
    @NotBlank(message = "Heslo nesmie byť prázdne")
    private String password;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}