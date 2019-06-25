package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by LaunchCode
 */
@Entity
public class Cheese {

    //////////////@Id tells hibernate that this is supposed to be a primary key in the database/////////
    //////////////@GeneratedValue says hibernate should generate the value of that Id for us////////////
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty")
    private String description;

    //////Hibernate will create a column named category_id (based on the field name) //////////////////////////////////
    //////when a Cheese object is stored, this column will contain the id of its category//////////////////////////
    ////////data for the category object itself will go in the table for the Category class///////////////////////
    @ManyToOne
    private Category category;

    //////////Added for the Menu Class//This field will configure the other side of our many-to-many relationship////
    //////represents the list of Menu objects that a given cheese is contained in.///////////////////////////////////
    //The items in Menu.cheeses should correspond to Cheese objects that have a given Menu object in their menus list.//
    @ManyToMany(mappedBy = "cheeses")
    private List<Menu> menus;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Cheese() { }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
