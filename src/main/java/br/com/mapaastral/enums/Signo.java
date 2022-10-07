package br.com.mapaastral.enums;

import br.com.mapaastral.exception.SignoNotFoundException;

import java.time.Month;
import java.time.MonthDay;
import java.util.Arrays;

public enum Signo {
    ARIES(MonthDay.of(Month.MARCH, 21), MonthDay.of(Month.APRIL, 20)),
    TOURO(MonthDay.of(Month.APRIL, 21), MonthDay.of(Month.MAY, 20)),
    GEMEOS(MonthDay.of(Month.MAY, 21), MonthDay.of(Month.JUNE, 20)),
    CANCER(MonthDay.of(Month.JUNE, 21), MonthDay.of(Month.JULY, 22)),
    LEAO(MonthDay.of(Month.JULY, 23), MonthDay.of(Month.AUGUST, 22)),
    VIRGEM(MonthDay.of(Month.AUGUST, 23), MonthDay.of(Month.SEPTEMBER, 22)),
    LIBRA(MonthDay.of(Month.SEPTEMBER, 23), MonthDay.of(Month.OCTOBER, 22)),
    ESCORPIAO(MonthDay.of(Month.OCTOBER, 23), MonthDay.of(Month.NOVEMBER, 21)),
    SAGITARIO(MonthDay.of(Month.NOVEMBER, 22), MonthDay.of(Month.DECEMBER, 21)),
    CAPRICORNIO(MonthDay.of(Month.DECEMBER, 22), MonthDay.of(Month.JANUARY, 19)),
    AQUARIO(MonthDay.of(Month.JANUARY, 20), MonthDay.of(Month.FEBRUARY, 18)),
    PEIXES(MonthDay.of(Month.FEBRUARY, 19), MonthDay.of(Month.MARCH, 20));

    private final MonthDay startDate;
    private final MonthDay endDate;

    Signo(MonthDay startDate, MonthDay endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public MonthDay getStartDate() {
        return startDate;
    }

    public MonthDay getEndDate() {
        return endDate;
    }

    public static Signo getSigno(MonthDay birthday) {
        return Arrays.stream(Signo.values()).filter(signo -> signo.equals(Signo.CAPRICORNIO) ?
                (!birthday.isBefore(signo.getStartDate()) || !birthday.isAfter(signo.getEndDate())) :
                !(birthday.isBefore(signo.getStartDate()) || birthday.isAfter(signo.getEndDate()))).findFirst().orElseThrow(SignoNotFoundException::new);
    }

}