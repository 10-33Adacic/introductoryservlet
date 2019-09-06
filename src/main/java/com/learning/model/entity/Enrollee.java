package com.learning.model.entity;

public class Enrollee {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //Builder
    public static Builder builder() {
        return new Enrollee().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder id(Long id) {
            Enrollee.this.id = id;
            return this;
        }

        public Builder name(String name) {
            Enrollee.this.name = name;
            return this;
        }

        public Builder email(String email) {
            Enrollee.this.email = email;
            return this;
        }

        public Builder password(String password) {
            Enrollee.this.password = password;
            return this;
        }

        public Builder role(Role role) {
            Enrollee.this.role = role;
            return this;
        }

        public Builder active(boolean active) {
            Enrollee.this.active = active;
            return this;
        }
        public Enrollee build() {
            return Enrollee.this;
        }
    }

    @Override
    public String toString() {
        return "Enrollee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}

