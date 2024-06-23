package org.example.veiculo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Veiculo {
    private Long id;
    private String marca;
    private String modelo;
    private Long ano;
    private Double valor;

    protected Veiculo() {
    }

    public Veiculo(Long id, String marca, String modelo, Long ano, Double valor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }
}
