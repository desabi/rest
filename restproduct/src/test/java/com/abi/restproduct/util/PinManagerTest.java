package com.abi.restproduct.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("PinManager ")
class PinManagerTest {

    @Test
    @DisplayName("Generar pin y encodearlo")
    void encodePin() {
        // Invocar metodos static de clase
        String pinGenerado = PinManager.generateSafePin();
        String pinEncodeado = PinManager.encodePin(pinGenerado);

        // JUnit - asserts
        assertNotNull(pinGenerado);
        assertEquals(56, pinGenerado.length());
        assertNotNull(pinEncodeado);

    }

    @Test
    @DisplayName("Generar pin")
    void generateSafePin() {
        // Invocar metodo static de clase
        String pinGenerado = PinManager.generateSafePin();

        assertNotNull(pinGenerado);
        assertEquals(56, pinGenerado.length());
    }

}