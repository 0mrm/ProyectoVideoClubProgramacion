package controller;

import model.Multimedia;

import java.time.LocalDate;

public class GestionAlquilerMultimedia {
    private Multimedia multimediaAlquilado;
    private LocalDate fechaAlquiler;

    public GestionAlquilerMultimedia(Multimedia multimedia) {
        setFechaAlquiler(LocalDate.now());
        setMultimediaAlquilado(multimedia);
    }

    public Multimedia getMultimediaAlquilado() {
        return multimediaAlquilado;
    }

    public void setMultimediaAlquilado(Multimedia multimediaAlquilado) {
        this.multimediaAlquilado = multimediaAlquilado;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
}
