package fr.baldir;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Article extends PanacheEntity {
    @Id
    @GeneratedValue
    public BigInteger id;
    public String type;
    public String url;
    public String description;
    @OneToMany(mappedBy = "name")
    public List<Category> categories;
}