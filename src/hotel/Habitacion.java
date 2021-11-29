package hotel;

import java.sql.Date;

public class Habitacion 
{
    private String numeroHabitacion;
    private int numCamas;
    private int numBannos;
    private String tipoHabitacion;
    private int precioDiario;
    private boolean disponibilidad;
    private String cantidadDias;
    private String fechaInicio;
    private String fechaTermino;

    public Habitacion() {
    }

    public Habitacion(String numeroHabitacion, int numCamas, int numBannos, String tipoHabitacion, int precioDiario, boolean disponibilidad, String cantidadDias, String fechaInicio, String fechaTermino) {
        this.numeroHabitacion = numeroHabitacion;
        this.numCamas = numCamas;
        this.numBannos = numBannos;
        this.tipoHabitacion = tipoHabitacion;
        this.precioDiario = precioDiario;
        this.disponibilidad = disponibilidad;
        this.cantidadDias = cantidadDias;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }



    
    public String getNumeroHabitacion() 
    {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) 
    {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getNumCamas() 
    {
        return numCamas;
    }

    public void setNumCamas(int numCamas) 
    {
        this.numCamas = numCamas;
    }

    public int getNumBannos() 
    {
        return numBannos;
    }

    public void setNumBannos(int numBannos) 
    {
        this.numBannos = numBannos;
    }

    public String getTipoHabitacion() 
    {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) 
    {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getPrecioDiario() 
    {
        return precioDiario;
    }

    public void setPrecioDiario(int precioDiario) 
    {
        this.precioDiario = precioDiario;
    }

    public boolean isDisponibilidad() 
    {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) 
    {
        this.disponibilidad = disponibilidad;
    }

    public String getCantidadDias() 
    {
        return cantidadDias;
    }

    public void setCantidadDias(String cantidadDias) 
    {
        this.cantidadDias = cantidadDias;
    }
    
    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(String fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    
    
    
    public String infoHabitacion()
    {
        return  "=== informacion de habitacion ===\n"+
                "numero de habitacion: "+numeroHabitacion+"\n"+
                "numero de camas: "+numCamas+"\n"+
                "numero de baños"+numBannos+"\n"+
                "tipo de habitacion"+tipoHabitacion+"\n"+
                "precio diario: "+precioDiario+"\n"+
                "disponibilidad: "+disponibilidad+"\n"+
                "cantidad de dias: "+cantidadDias;
    }

    


}
