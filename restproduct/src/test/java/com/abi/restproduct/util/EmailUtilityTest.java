package com.abi.restproduct.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Email Utility")
class EmailUtilityTest {

    @Test
    @DisplayName(" Ocultar correo")
    void ocultaCorreo() {
        // crear instancia de la clase a testear
        EmailUtility emailUtility = new EmailUtility();
        // invocar metodo de clase a testear
        String correoOculto = emailUtility.ocultar("desabisc@gmail.com");

        // JUnit - asserts
        assertNotNull(correoOculto);
        assertEquals("d*****c@gmail.com", correoOculto);
    }
}