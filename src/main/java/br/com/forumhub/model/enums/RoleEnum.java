package br.com.forumhub.model.enums;

public enum RoleEnum {
    USER("ROLE_USER"),

    ADMIN("ROLE_ADMIN");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
