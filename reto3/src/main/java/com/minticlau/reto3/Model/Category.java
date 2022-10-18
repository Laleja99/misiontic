/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minticlau.reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

/**
 *
 * @author familia
 */

@Entity
@Table(name="category")
@Getter
@Setter

public class Category implements Serializable {
    
    @Id //identifica que el atributo debajo de él sea la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sea autoincrementable
    
    @javax.persistence.Id
    private Integer id;
    private String name;
    private String description;

    
@OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Skate> skates;

    
}
