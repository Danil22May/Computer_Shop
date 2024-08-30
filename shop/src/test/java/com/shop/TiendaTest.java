package com.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TiendaTest {

    private Tienda tienda;
    private Computador computador1;
    private Computador computador2;

    @BeforeEach
    public void setUp() {
        tienda = new Tienda("TechStore", "Juan Perez", "123456789");
        computador1 = new Computador("Dell", 16, "Intel Core i7", "Windows 10", 1200.00);
        computador2 = new Computador("Apple", 8, "M1", "macOS", 2500.00);
    }

    @Test
    public void testAgregarComputador() {
        tienda.agregarComputador(computador1);
        assertEquals(1, tienda.listarComputadores().split("\n").length);
    }

    @Test
    public void testEliminarComputador() {
        tienda.agregarComputador(computador1);
        tienda.agregarComputador(computador2);
        tienda.eliminarComputador("Dell");
        assertEquals(1, tienda.listarComputadores().split("\n").length);
        assertNull(tienda.buscarComputador("Dell"));
    }

    @Test
    public void testBuscarComputador() {
        tienda.agregarComputador(computador1);
        Computador encontrado = tienda.buscarComputador("Dell");
        assertNotNull(encontrado);
        assertEquals("Dell", encontrado.getMarca());
    }

    @Test
    public void testListarComputadores() {
        tienda.agregarComputador(computador1);
        tienda.agregarComputador(computador2);
        String lista = tienda.listarComputadores();
        assertTrue(lista.contains("Dell"));
        assertTrue(lista.contains("Apple"));
    }

    @Test
    public void testEliminarComputadorQueNoExiste() {
        tienda.agregarComputador(computador1);
        tienda.eliminarComputador("Asus");
        assertEquals(1, tienda.listarComputadores().split("\n").length);
    }

    @Test
    public void testBuscarComputadorQueНеExiste() {
        Computador noEncontrado = tienda.buscarComputador("Asus");
        assertNull(noEncontrado);
    }
}
