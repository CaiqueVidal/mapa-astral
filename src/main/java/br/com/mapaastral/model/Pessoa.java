package br.com.mapaastral.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class Pessoa {
    private String name;
    private LocalDate dateBirth;
    private LocalTime timeBirth;
    private ZoneId zoneId;


    public String getName() {
        return name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalTime getTimeBirth() {
        return timeBirth;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setTimeBirth(LocalTime timeBirth) {
        this.timeBirth = timeBirth;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }
}
