package hotel;


public class Trabajador extends Persona
{
    private String cargo;
    private int sueldo;
    private String contrasenna;

    public Trabajador() 
    {
        
    }

    public Trabajador(String cargo, int sueldo, String contrasenna, String rut, String nombre, String apellido, int edad, String sexo) {
        super(rut, nombre, apellido, edad, sexo);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.contrasenna = contrasenna;
    }
    
    
    public String getCargo() 
    {
        return cargo;
    }

    public void setCargo(String cargo) 
    {
        this.cargo = cargo;
    }

    public int getSueldo() 
    {
        return sueldo;
    }

    public void setSueldo(int sueldo) 
    {
        this.sueldo = sueldo;
    }
    
    public String getContrasenna() 
    {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) 
    {
        this.contrasenna = contrasenna;
    }
        
    
    public String toString()
    {
        return "rut: " + super.rut +"\n"+
                "nombre: "+super.nombre+" "+super.apellido+"\n"+
                "edad: "+super.edad+"\n"+
                "sexo: "+super.sexo+"\n"+
                "cargo: "+cargo+"\n";        
    }
    
    @Override
    public void informacionPersona() 
    {
        System.out.println("=== informacion persona ===");
        System.out.println(this);
    }

    
}
