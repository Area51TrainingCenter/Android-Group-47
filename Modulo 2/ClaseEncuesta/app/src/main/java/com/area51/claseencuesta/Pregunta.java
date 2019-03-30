package com.area51.claseencuesta;

public class Pregunta {
    private String pregunta;
    private boolean responderOpcion;
    private String opciones;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public boolean isResponderOpcion() {
        return responderOpcion;
    }

    public void setResponderOpcion(boolean responderOpcion) {
        this.responderOpcion = responderOpcion;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }
}
