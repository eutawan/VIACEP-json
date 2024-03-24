package main;

import api.CepApiConsumer;

import javax.swing.*;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {

        var cepConsumer = new CepApiConsumer();

        var cep = JOptionPane.showInputDialog("Enter the desired zip code: ");
        var name = JOptionPane.showInputDialog("Input your name: ");



        var address = cepConsumer.getAddress(cep, name);

        var addressBuilder = new StringBuilder();

        JOptionPane.showMessageDialog(null,
                addressBuilder.append("Endereço: \n")
                        .append("Cidade: " + address.getLocalidade()).append("\n")
                        .append("UF: " + address.getUf()).append("\n")
                        .append("Rua: " + address.getLogradouro()).append("\n")
                        .append("Bairro: " + address.getBairro()).append("\n")
                        .append("DDD: " + address.getDdd()).append("\n")
                        .append("Siafi: " + address.getSiafi()).append("\n")
                        .append("IBGE: " + address.getIbge()).append("\n")
                        .append("Nome: " + address.getName()).append("\n")
                        .append("gia: " + address.getGia()).append("\n")


        );

    }
}
