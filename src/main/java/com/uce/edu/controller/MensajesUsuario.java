package com.uce.edu.controller;

import org.hibernate.action.internal.BulkOperationCleanupAction;

public enum MensajesUsuario {
    ADVERTENCIA("¡Advertencia!"),
    MENSAJE_PRINCIPAL("Si no esta registrado se lo mandara a un formulario de registro."),
    MENSAJE_PRINCIPAL_Dos("Si no esta registrado se lo mandara a un formulario de registro."),
    ERROR("¡Error!"),
    EN_BLANCO("No ingresaste ningun dato"),
    DATO_MAL_INGRESADO("No ingresarate datos validos. Intenta de Nuevo"),
    BUCLE("Si no ingresa datos validos no podra continar con la busqueda")
    ;

    private final String mensaje;

    MensajesUsuario(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
