package hotel;

public class ServicioAdicional 
{
    private String tipoServicio;
    private int precioServicio;
    private String comentario;

    public ServicioAdicional() 
    {
        
    }

    public ServicioAdicional(String tipoServicio, int precioServicio, String comentario) 
    {
        this.tipoServicio = tipoServicio;
        this.precioServicio = precioServicio;
        this.comentario = comentario;
    }
    
    public String getTipoServicio() 
    {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) 
    {
        this.tipoServicio = tipoServicio;
    }

    public int getPrecioServicio() 
    {
        return precioServicio;
    }

    public void setPrecioServicio(int precioServicio) 
    {
        this.precioServicio = precioServicio;
    }

    public String getComentario() 
    {
        return comentario;
    }

    public void setComentario(String comentario) 
    {
        this.comentario = comentario;
    }
    
    
}
