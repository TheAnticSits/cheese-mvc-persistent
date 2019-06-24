package org.launchcode.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    //////////////////////////////////////////////PROPERTIES/////////////////////////////////////////////////////////

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    ////////////////////////represent the list of all items in a given category/////////////////////////////////
    //Each one category will have many cheeses, but each cheese can have only one category. So, we use the @OneToMany//
    ////@JoinColumn///////////////////
    //tells Hib to use the category_id column of the cheese table to determine which cheese belong to a given category.
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();
    /////////////////////////////////////////////CONSTRUCTORS/////////////////////////////////////////////////////////

    ///-----default constructor--------////////
    public Category() { }

    //////------setName constructor-----------///////////

    public Category(String name){
        this.name = name;
    }



    /////////////////////////////GETTERS AND SETTERS//////////////////////////////////////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }
}
