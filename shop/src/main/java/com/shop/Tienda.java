package com.shop;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private String nombre;
    private String propietario;
    private String identificadorTributario;
    private List<Computador> computadores;

    public Tienda(String nombre, String propietario, String identificadorTributario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.identificadorTributario = identificadorTributario;
        this.computadores = new ArrayList<>();
    }

    public void agregarComputador(Computador computador) {
        computadores.add(computador);
    }

    public void eliminarComputador(String marca) {
        computadores.removeIf(c -> c.getMarca().equals(marca));
    }

    public Computador buscarComputador(String marca) {
        return computadores.stream()
                .filter(c -> c.getMarca().equals(marca))
                .findFirst()
                .orElse(null);
    }

    public String listarComputadores() {
        StringBuilder lista = new StringBuilder();
        for (Computador c : computadores) {
            lista.append(c.toString()).append("\n");
        }
        return lista.toString();
    }
}
