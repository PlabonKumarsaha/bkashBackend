package com.bikash.bikashBackend.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class User extends BaseModel{

    private String username;
    private String password;
    private long balance;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    //to make it not exclusable by the api to call
    @ToString.Exclude
    private List<Role> roles;



}
