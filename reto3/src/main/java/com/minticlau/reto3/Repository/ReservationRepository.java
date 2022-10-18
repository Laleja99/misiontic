package com.minticlau.reto3.Repository;

import com.minticlau.reto3.Model.Reservation;
import com.minticlau.reto3.Repository.Crud.ReservationCrudRepositoryInterface;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository

public class ReservationRepository {

    @Autowired
    private ReservationCrudRepositoryInterface reservationCrudRepositoryInterface;

    public List<Reservation> getReservationAll() {
        return (List<Reservation>) reservationCrudRepositoryInterface.findAll();
    }

    public Optional<Reservation> getReservationId(Integer id) {
        return reservationCrudRepositoryInterface.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationCrudRepositoryInterface.save(reservation);
    }

    public void deleteReservation(Reservation reservation) {
        reservationCrudRepositoryInterface.delete(reservation);

    }

    public List<Reservation> ReservationStatus(String status){
        return reservationCrudRepositoryInterface.findAllByStatus(status);
    }
    
    public List<Reservation> ReservationTime(Date startDate, Date endDate) {
        return reservationCrudRepositoryInterface.findAllByStartDateAfterAndStartDateBefore(startDate, endDate);
    }
    
    public List<Object[]> ReportClients(){
        return reservationCrudRepositoryInterface.reportClients();
    }
}
