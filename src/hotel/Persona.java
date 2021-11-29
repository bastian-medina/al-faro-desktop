package hotel;

public abstract class Persona implements Operable
{
    protected String rut;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String sexo;
    public abstract void informacionPersona();

    public Persona() 
    {
        
    }

    public Persona(String rut, String nombre, String apellido, int edad, String sexo) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre){
            this.nombre = nombre;
    }

    public String getApellido() 
    {
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public int getEdad() 
    {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        this.edad = edad;
    }

    public String getSexo() 
    {
        return sexo;
    }

    public void setSexo(String sexo) throws Exception {

            this.sexo = sexo;
    }

    @Override
    public int totalConDescuento() 
    {
        Habitacion habitacion = new Habitacion();
        int cantidadDias;
        cantidadDias = Integer.valueOf(habitacion.getCantidadDias());
        int precioDiario;
        precioDiario = habitacion.getPrecioDiario();
        return cantidadDias*precioDiario;
    }

    @Override
    public int totalSindescuento() 
    {
        Habitacion habitacion = new Habitacion();
        int cantidadDias;
        cantidadDias = Integer.valueOf(habitacion.getCantidadDias());
        int precioDiario;
        precioDiario = habitacion.getPrecioDiario();
        return ( cantidadDias*precioDiario)*(100-DESCUENTO)/100;
    }
}