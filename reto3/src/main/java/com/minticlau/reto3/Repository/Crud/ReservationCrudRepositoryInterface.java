package com.minticlau.reto3.Repository.Crud;

import com.minticlau.reto3.Model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author familia
 */
public interface ReservationCrudRepositoryInterface extends CrudRepository<Reservation, Integer> {

    public List<Reservation> findAllByStatus(String status); //funcion de busqueda

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date startDate, Date endDate);

    @Query("SELECT c.client, COUNT(c.client) from Reservation  AS c  group by c.client order by COUNT(c.client)DESC ")

    public List<Object[]> reportClients();

}
