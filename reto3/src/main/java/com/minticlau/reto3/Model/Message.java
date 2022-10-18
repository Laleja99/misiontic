
package com.minticlau.reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="message")
@Getter
@Setter

public class Message {
    
    @Id //identifica que el atributo debajo de él sea la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //sea autoincrementable
    
    @javax.persistence.Id
    private Integer idMessage;
    private String messageText;

@ManyToOne
    @JoinColumn(name="skateId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Skate skate;

@ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
 

}
