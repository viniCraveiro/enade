package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.carro.Carro;
import org.example.moto.Moto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Veiculos {
    List<Carro> carros = new ArrayList<>();
    List<Moto> motos = new ArrayList<>();

    public Veiculos(List<Carro> carros, List<Moto> motos) {
        this.carros = carros;
        this.motos = motos;
    }

    public Veiculos() {
    }
}
