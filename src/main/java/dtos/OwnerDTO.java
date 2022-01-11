/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Owner;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author peter
 */
public class OwnerDTO {
    
    private Long id;
    private String name;
    private String address;
    private int phone;

    public OwnerDTO(Owner o) {
        if (o.getId() != null) this.id = o.getId();
        this.name = o.getName();
        this.address = o.getAddress();
        this.phone = o.getPhone();
    }

    public OwnerDTO(String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public static List<OwnerDTO> getDTOs(List<Owner> owners){
        List<OwnerDTO> dtos = new ArrayList();
        owners.forEach(person->dtos.add(new OwnerDTO(person)));
        return dtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    
    
    
}
