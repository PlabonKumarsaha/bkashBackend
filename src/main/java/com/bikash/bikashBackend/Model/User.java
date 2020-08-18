package com.bikash.bikashBackend.Model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class User extends BaseModel {

    private String username;
    private String password;
    private Boolean isMerchant;
    private double openingBalance;
    private Long nid;
    private String phone;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Role> roles;
}
