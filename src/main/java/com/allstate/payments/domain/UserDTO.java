package com.allstate.payments.domain;

import java.util.Objects;

public class UserDTO {

    private String username;
    private String name;
    private UserRole role;

    public UserDTO(User user){
        this.username = user.getUsername();
        this.name = user.getName();
        this.role = user.getRole();
    }
    public UserDTO(){

    }
    public User asUser(){
        return new User(username, name, null, role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(username, userDTO.username) && Objects.equals(name, userDTO.name) && role == userDTO.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }


}
