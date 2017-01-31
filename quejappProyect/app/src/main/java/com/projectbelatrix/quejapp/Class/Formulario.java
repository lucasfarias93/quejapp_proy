package com.projectbelatrix.quejapp.Class;

/**
 * Created by lfarias on 1/31/17.
 */
public class Formulario {


    private String descripcion, motivo_reclamo, hora_realizacion, asistencia, form_nombre;

    public Formulario() {
    }

    public String getForm_nombre() {
        return form_nombre;
    }

    public void setForm_nombre(String form_nombre) {
        this.form_nombre = form_nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMotivo_reclamo() {
        return motivo_reclamo;
    }

    public String getHora_realizacion() {
        return hora_realizacion;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMotivo_reclamo(String motivo_reclamo) {
        this.motivo_reclamo = motivo_reclamo;
    }

    public void setHora_realizacion(String hora_realizacion) {
        this.hora_realizacion = hora_realizacion;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }
}
