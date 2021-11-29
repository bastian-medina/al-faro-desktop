package hotel;

public class Huesped extends Persona
{
    private String tipoHuesped;
    private String correo;
    private String numeroTelefono;
    private String pais;
    private int acompannantes;

    public Huesped() {

    }

    public Huesped(String tipoHuesped, String correo, String numeroTelefono, String pais, int acompannantes, String rut, String nombre, String apellido, int edad, String sexo) {
        super(rut, nombre, apellido, edad, sexo);
        this.tipoHuesped = tipoHuesped;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
        this.pais = pais;
        this.acompannantes = acompannantes;
    }

    public String getTipoHuesped() {
        return tipoHuesped;
    }

    public void setTipoHuesped(String tipoHuesped) {
        this.tipoHuesped = tipoHuesped;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAcompannantes() {
        return acompannantes;
    }

    public void setAcompannantes(int acompannantes) {
        this.acompannantes = acompannantes;
    }
    
     @Override
    public String toString()
    {
        Habitacion habitacion = new Habitacion();
        
        return "rut: " + super.rut +"\n"+
                "nombre: "+super.nombre+" "+super.apellido+"\n"+
                "edad: "+super.edad+"\n"+
                "sexo: "+super.sexo+"\n"+
                "tipo de huesped: "+ tipoHuesped+"\n"+
                "correo: "+correo+"\n"+
                "telefono: "+numeroTelefono+"\n"+
                "pais: "+pais+"\n"+
                "acompañantes: "+acompannantes+"\n"+
                habitacion.infoHabitacion();
        
    }
    
    @Override
    public void informacionPersona() 
    {
        System.out.println("=== informacion de persona ===");
        System.out.println(this);
    }
}