package model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pet {
    private long id;
    private String name;
    private String type;
    private int age;

    public Pet() {
    }

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public Pet(Long id, String name, String type, int age) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(id, pet.id) && Objects.equals(name, pet.name) && type == pet.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, age);
    }

    @Override
    public String toString() {
        return "PetModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", age=" + age +
                '}';
    }
}
