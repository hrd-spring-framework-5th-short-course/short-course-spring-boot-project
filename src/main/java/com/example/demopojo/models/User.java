package com.example.demopojo.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {

//    @NotNull(message = "Not null error custom!")
    @NotNull
    private Integer id;


    @NotBlank
    @NotEmpty
    private String name;

    private String gender;

    private String profile;

    public User() {
    }

    public User(@NotNull Integer id, @NotBlank @NotEmpty String name, String gender, String profile) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.profile = profile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
