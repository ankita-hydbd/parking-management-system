package com.example.parkingmanagementsystem.parking.ticket;


import com.example.parkingmanagementsystem.config.ParkingManagementConfig;
import com.example.parkingmanagementsystem.parking.ticket.exception.ParkingTicketNotFoundException;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j2
public class ParkingTicketServiceImpl implements ParkingTicketService{
    private ParkingTicketRepository parkingTicketRepository;
    private ParkingManagementConfig config;

    public ParkingTicketServiceImpl(ParkingTicketRepository parkingTicketRepository,
                                    ParkingManagementConfig config) {
        this.parkingTicketRepository = parkingTicketRepository;
        this.config = config;
    }


    @Override
    public ParkingTicket createParkingTicket(ParkingTicket parkingTicket) {
        return parkingTicketRepository.save(parkingTicket);
    }

    @Override
    public ParkingTicket updateParkingTicket(ParkingTicket parkingTicket) {
        return parkingTicketRepository.save(parkingTicket);
    }

    @Override
    public String deleteParkingTicket(String tokenNumber) {
        parkingTicketRepository.deleteById(tokenNumber);
        return "successfully deleted";
    }

    @SneakyThrows
    @Override
    public ParkingTicket getParkingTicket(String tokenNumber)  {
        if(parkingTicketRepository.findById(tokenNumber).isEmpty())
            throw new ParkingTicketNotFoundException("ParkingTicket detail doesn't exist");

        return  parkingTicketRepository.findById(tokenNumber).get();
    }

    @Override
    public List<ParkingTicket> getAllParkingTicket() {
        log.info("Config values = {}", config);
        return parkingTicketRepository.findAll();
    }
}
