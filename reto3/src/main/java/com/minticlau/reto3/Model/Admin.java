package com.minticlau.reto3.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "admin")
@Getter
@Setter

public class Admin {
  
    @Id //identifica que el atributo debajo de él sea la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sea autoincrementable

    @javax.persistence.Id
    private Integer idAdmin;
    private String email;
    private String password;
    private String name;
   
}
