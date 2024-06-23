package org.example.veiculo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Veiculos;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VeiculoServiceTest {

    private static VeiculoService veiculoService;

    @BeforeAll
    public static void setup() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

        Veiculos veiculos = objectMapper.readValue(new File("src/main/resources/veiculos.json"), Veiculos.class);
        veiculoService = new VeiculoService(veiculos);
    }

    @Test
    void testFiltrarVeiculosPorMarca() {
        List<Veiculo> chevroletCarros = veiculoService.filtrarVeiculosPorMarca("carros", "Chevrolet");
        assertEquals(3, chevroletCarros.size());

        List<Veiculo> yamahaMotos = veiculoService.filtrarVeiculosPorMarca("motos", "Yamaha");
        assertEquals(3, yamahaMotos.size());
    }

    @Test
    public void testSomarValoresPorMarca() {
        double valorChevroletCarros = veiculoService.somarValoresPorMarca("carros", "Chevrolet");
        assertEquals(259000.00, valorChevroletCarros);

        double valorYamahaMotos = veiculoService.somarValoresPorMarca("motos", "Yamaha");
        assertEquals(71000.00, valorYamahaMotos);
    }

    @Test
    public void testFiltrarVeiculosPorAno() {
        List<Veiculo> carrosNovos = veiculoService.filtrarVeiculosPorAno("carros", 2020);
        assertEquals(7, carrosNovos.size());

        List<Veiculo> motosNovas = veiculoService.filtrarVeiculosPorAno("motos", 2020);
        assertEquals(3, motosNovas.size());
    }
}
