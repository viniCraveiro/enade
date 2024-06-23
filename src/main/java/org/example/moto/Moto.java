package org.example.moto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.veiculo.Veiculo;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Moto extends Veiculo {

    List<Veiculo> usados = new ArrayList<>();
    List<Veiculo> novos = new ArrayList<>();

    public Moto(Long id, String marca, String modelo, Long ano, Double valor) {
        super(id, marca, modelo, ano, valor);
    }

    public Moto() {
    }
}
