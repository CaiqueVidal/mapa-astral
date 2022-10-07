package br.com.mapaastral.view;

import br.com.mapaastral.model.Pessoa;
import br.com.mapaastral.service.MapaAstralService;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Menu {

    private static final Pessoa pessoa = new Pessoa();
    private static final MapaAstralService mapaAstralService = new MapaAstralService();
    public static void loadMenu() {
        int option;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(null, "0-Sair  \n1-Mapa Astral"));
            switch (option) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando...");
                    break;

                case 1:
                    String name = JOptionPane.showInputDialog("Digite o nome");
                    String birthDate = JOptionPane.showInputDialog("Digite a data de nascimento. Ex. 00/00/0000");
                    String birthTime = JOptionPane.showInputDialog("Digite o horário do nascimento. Ex. 00:00");
                    String birthIdZone = JOptionPane.showInputDialog("Digite a zona id de nascimento. Ex. America/Sao_Paulo");

                    try {
                        pessoa.setName(name);
                        pessoa.setDateBirth(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        pessoa.setTimeBirth(LocalTime.parse(birthTime));
                        pessoa.setZoneId(ZoneId.of(birthIdZone));
                        mapaAstralService.displayAstrologyChart(pessoa);

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Informações inválidas! Verifique e tente novamente.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (option != 0);
    }

}
