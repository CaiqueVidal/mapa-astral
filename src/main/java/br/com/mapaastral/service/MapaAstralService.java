package br.com.mapaastral.service;

import br.com.mapaastral.enums.Ascendente;
import br.com.mapaastral.enums.Signo;
import br.com.mapaastral.model.Pessoa;

import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class MapaAstralService {
    public void displayAstrologyChart(Pessoa pessoa) {
        String information = gatherInformationAstrologyChart(pessoa);
        JOptionPane.showMessageDialog(null, information, "Mapa Astral", JOptionPane.INFORMATION_MESSAGE);
    }

    private String gatherInformationAstrologyChart(Pessoa pessoa) {
        LocalDateTime dateTimeBirth = LocalDateTime.of(pessoa.getDateBirth(), pessoa.getTimeBirth());

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(String.format("%s%n",pessoa.getName()));
        stringBuffer.append(getAge(dateTimeBirth));
        stringBuffer.append(getFormattedDate(dateTimeBirth));
        stringBuffer.append(getTimeZone(dateTimeBirth, pessoa.getZoneId()));
        stringBuffer.append(String.format("Ano bissexto: %s%n", isLeapYear(dateTimeBirth)));
        stringBuffer.append(String.format(
                "Signo: %s%n", Signo.getSigno(MonthDay.of(dateTimeBirth.getMonth(), dateTimeBirth.getDayOfMonth()))
        ));
        stringBuffer.append(String.format(
                "Ascendente: %s%n", Ascendente.getAscendente(dateTimeBirth.toLocalTime())
        ));
        stringBuffer.append(String.format(
                "Signo Lunar: %s%n", getSignoLunar(dateTimeBirth.toLocalTime(), pessoa.getZoneId().toString())
        ));

        return stringBuffer.toString();
    }

    private String getAge(LocalDateTime localDateTime) {
        Period idade = Period.between(localDateTime.toLocalDate(), LocalDate.now());
        if (idade.getYears() > 0) {
            return String.format("Idade: %d ano(s) %n", idade.getYears());
        } else if (idade.getMonths() > 0) {
            return String.format("Idade: %d mes(es) %n", idade.getMonths());
        } else {
            return String.format("Idade: %d dia(s) %n", idade.getMonths());
        }
    }

    private String getFormattedDate(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("Data/Hora nascimento: %s%n", localDateTime.format(formatter));
    }

    public String getTimeZone(LocalDateTime localDateTime, ZoneId zoneId) {
        ZoneOffset zoneOffSet = zoneId.getRules().getOffset(localDateTime);
        return String.format("TZ: %s%n", zoneOffSet);
    }

    private boolean isLeapYear(LocalDateTime localDateTime) {
        return Year.isLeap(localDateTime.getYear());
    }

    private String getSignoLunar(LocalTime localTime, String zone) {
        if (zone.equals("America/Recife") && localTime.isAfter(LocalTime.NOON)) {
            return "CASEMIRO";
        }
        if (zone.equals("America/Cuiaba") && localTime.isBefore(LocalTime.NOON)) {
            return "ODIN";
        }
        if (zone.equals("America/Sao_Paulo")) {
            return "GANDALF";
        }
        return "DINOSSAURO";
    }
}
