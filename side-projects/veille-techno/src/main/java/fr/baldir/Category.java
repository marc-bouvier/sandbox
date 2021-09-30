package fr.baldir;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Category extends PanacheEntity {

    public String name;
    public String label;
}
