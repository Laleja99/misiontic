package com.minticlau.reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "skate")
@Getter
@Setter

public class Skate {

    @Id //identifica que el atributo debajo de él sea la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sea autoincrementable

    @javax.persistence.Id

    private Integer id;
    private String name;
    private String brand;

    @Column(name = "years")

    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("skates")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "messages"})
    private List<Reservation> reservations;

}
