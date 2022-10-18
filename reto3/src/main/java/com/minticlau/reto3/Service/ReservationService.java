package com.minticlau.reto3.Service;

import com.minticlau.reto3.Model.Client;
import com.minticlau.reto3.Model.Reservation;
import com.minticlau.reto3.Reports.CountClients;
import com.minticlau.reto3.Reports.ReservationStatus;
import com.minticlau.reto3.Repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ReservationService {

    @Autowired

    private ReservationRepository reservationRepository;

    public List<Reservation> getReservationAll() {
        return reservationRepository.getReservationAll();
    }

    public Optional<Reservation> getReservationId(Integer id) {
        return reservationRepository.getReservationId(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.saveReservation(reservation);
        } else {
            Optional<Reservation> reservationAuxiliar = reservationRepository.getReservationId(reservation.getIdReservation());
            if (reservationAuxiliar.isEmpty()) {
                return reservationRepository.saveReservation(reservation);
            } else {
                return reservation;
            }
        }
    }

    public boolean deleteReservation(Integer reservationId) {
        boolean flag = false;
        Optional<Reservation> reservationAuxiliar = reservationRepository.getReservationId(reservationId);
        if (reservationAuxiliar.isPresent()) {
            reservationRepository.deleteReservation(reservationAuxiliar.get());
        }
        return flag;

    }

    public ReservationStatus reservationStatus() {

        List<Reservation> completed = reservationRepository.ReservationStatus("completed");
        List<Reservation> cancelled = reservationRepository.ReservationStatus("cancelled");

        return new ReservationStatus(completed.size(), cancelled.size());
    }

    public List<Reservation> ReservationTime(String startDate, String endDate) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date dateOne = new Date();
        Date dateTwo = new Date();

        try {
            dateOne = parser.parse(startDate);
            dateTwo = parser.parse(endDate);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (dateOne.before(dateTwo)) {
            return reservationRepository.ReservationTime(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }

    public List<CountClients> reportClients() {
        List<CountClients> result = new ArrayList<>();
        List<Object[]> report = reservationRepository.ReportClients();
        System.out.println(report);
        for (Integer i = 0; i < report.size(); i++) {
            result.add(new CountClients((long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return result;
    }

}
