package model;

import java.util.Objects;


public class PetModel {

    private Long id;
    private String name;
    private PetType type;
    private int age;

    public PetModel() {
    }

    public PetModel(String name, PetType type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;
    }

    public PetModel(Long id, String name, PetType type, int age) {
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

    public PetType getType() {
        return type;
    }

    public void setType(PetType type) {
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
        PetModel petModel = (PetModel) o;
        return age == petModel.age && Objects.equals(id, petModel.id) && Objects.equals(name, petModel.name) && type == petModel.type;
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
