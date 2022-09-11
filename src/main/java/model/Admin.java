package model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    public Admin(){
    }

    public Admin(Integer Id, String Name){
        this.Id = Id;
        this.Name = Name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
