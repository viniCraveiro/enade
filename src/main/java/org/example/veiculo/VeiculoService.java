package org.example.veiculo;

import org.example.Veiculos;
import org.example.carro.Carro;
import org.example.moto.Moto;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {

    private Veiculos veiculos;

    public VeiculoService(Veiculos veiculos) {
        this.veiculos = veiculos;
    }

    public List<Veiculo> filtrarVeiculosPorMarca(String tipo, String marca) {
        List<Veiculo> veiculosFiltrados = new ArrayList<>();
        if (tipo.equalsIgnoreCase("carros")) {
            veiculosFiltrados.addAll(filtrarPorMarca(veiculos.getCarros(), marca));
        } else if (tipo.equalsIgnoreCase("motos")) {
            veiculosFiltrados.addAll(filtrarPorMarca(veiculos.getMotos(), marca));
        }
        return veiculosFiltrados;
    }

    private List<Veiculo> filtrarPorMarca(List<? extends Object> lista, String marca) {
        List<Veiculo> veiculosFiltrados = new ArrayList<>();
        for (Object obj : lista) {
            if (obj instanceof Carro carro) {
                veiculosFiltrados.addAll(carro.getNovos().stream()
                        .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                        .toList());
                veiculosFiltrados.addAll(carro.getUsados().stream()
                        .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                        .toList());
            } else if (obj instanceof Moto moto) {
                veiculosFiltrados.addAll(moto.getNovos().stream()
                        .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                        .toList());
                veiculosFiltrados.addAll(moto.getUsados().stream()
                        .filter(v -> v.getMarca().equalsIgnoreCase(marca))
                        .toList());
            }
        }
        return veiculosFiltrados;
    }

    public double somarValoresPorMarca(String tipo, String marca) {
        return filtrarVeiculosPorMarca(tipo, marca).stream()
                .mapToDouble(Veiculo::getValor)
                .sum();
    }

    public List<Veiculo> filtrarVeiculosPorAno(String tipo, int ano) {
        List<Veiculo> veiculosFiltrados = new ArrayList<>();
        if (tipo.equalsIgnoreCase("carros")) {
            veiculosFiltrados.addAll(filtrarPorAno(veiculos.getCarros(), ano));
        } else if (tipo.equalsIgnoreCase("motos")) {
            veiculosFiltrados.addAll(filtrarPorAno(veiculos.getMotos(), ano));
        }
        return veiculosFiltrados;
    }

    private List<Veiculo> filtrarPorAno(List<? extends Object> lista, int ano) {
        List<Veiculo> veiculosFiltrados = new ArrayList<>();
        for (Object obj : lista) {
            if (obj instanceof Carro carro) {
                veiculosFiltrados.addAll(carro.getNovos().stream()
                        .filter(v -> v.getAno() > ano)
                        .toList());
                veiculosFiltrados.addAll(carro.getUsados().stream()
                        .filter(v -> v.getAno() > ano)
                        .toList());
            } else if (obj instanceof Moto moto) {
                veiculosFiltrados.addAll(moto.getNovos().stream()
                        .filter(v -> v.getAno() > ano)
                        .toList());
                veiculosFiltrados.addAll(moto.getUsados().stream()
                        .filter(v -> v.getAno() > ano)
                        .toList());
            }
        }
        return veiculosFiltrados;
    }
}
