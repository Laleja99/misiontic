package com.minticlau.reto3.Reports;

import com.minticlau.reto3.Model.Client;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CountClients {

    private long total;
    private Client client;

    public CountClients(Long total, Client client) {
        this.total = total;
        this.client = client;

    }
}
