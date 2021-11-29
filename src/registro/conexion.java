package registro;
import hotel.Habitacion;
import hotel.Huesped;
import hotel.Persona;
import hotel.Trabajador;
import java.sql.*;
import java.util.*;


public class conexion 
{
    private Connection con;
    private Statement state;
    private String rut;

    
    //El Puerto lógico de MySql siempre es el 3306 no se cambia
    public void conectar() 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", null);
            state = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * inserta al cliente y sus datos
     * @param huesped 
     */
    public void insertar(Huesped huesped) {
        try {

            conectar();
            state.executeUpdate("INSERT INTO huesped VALUES"
                    + "('" + huesped.getRut() + "', '" + 
                             huesped.getNombre() + "', '" + 
                             huesped.getApellido() + "', "+
                             huesped.getEdad() + ", '"+
                             huesped.getSexo() + "', '"+
                             huesped.getTipoHuesped() + "', '"+
                             huesped.getCorreo() + "', '"+
                             huesped.getNumeroTelefono() + "', '"+
                             huesped.getPais() + "', '"+
                             huesped.getAcompannantes() +"');");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    
    
    //Si devuelve un valor distinto de cero significa que modificó correctamente y se guardan los nuevos datos
    public int modificar(Huesped huesped) {
        int entero = 0;
        try {
            conectar();
            entero = state.executeUpdate("update huesped set "+  
                             "nombre = '" + huesped.getNombre() + 
                             "', apellido = '" + huesped.getApellido() + 
                             "', edad = "+ huesped.getEdad() + 
                             ", sexo = '"+huesped.getSexo() + 
                             "', tipoHuesped = '"+huesped.getTipoHuesped() + 
                             "', correo = '"+ huesped.getCorreo() + 
                             "', numeroTelefono = '"+ huesped.getNumeroTelefono() + 
                             "', pais = '"+huesped.getPais() + 
                             "', acompannantes = '"+huesped.getAcompannantes() +"' "+
                             "where rut = '"+huesped.getRut()+"';");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }


    /**
     * metodo que busca un cliente y devuelve
     * un huesped con los datos consultados
     * @param rut
     * @return
     * @throws SQLException 
     */
    public Huesped buscar(String rut) throws SQLException, Exception {
        
        conectar();
        Huesped huesped1 = new Huesped();
        ResultSet result = state.executeQuery("select * from huesped Where rut ='"+rut+"'  ;");

        while (result.next()) 
        {
            huesped1.setRut((String)result.getObject(1));
            huesped1.setNombre((String)result.getObject(2));
            huesped1.setApellido((String)result.getObject(3));
            huesped1.setEdad((Integer)result.getObject(4));
            huesped1.setSexo((String)result.getObject(5));
            huesped1.setTipoHuesped((String)result.getObject(6));
            huesped1.setCorreo((String)result.getObject(7));
            huesped1.setNumeroTelefono((String)result.getObject(8));
            huesped1.setPais((String)result.getObject(9));
            huesped1.setAcompannantes((Integer)result.getObject(10));
        }
        return huesped1;
    }

    
    
    /**
     * parametro que elimina al huesped y todos sus datos
     * @param codigo
     */
    public int eliminarRut(String rut) {
        int entero = 0;
        try {
            conectar();
            entero = state.executeUpdate("DELETE FROM huesped WHERE rut='" + rut + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }
    
    //huesped y boleta tiene una relacion en la base de datos, por lo que para eliminar un huesped
    //se tiene que eliminar un rut en la boleta
    public int eliminarRutBoleta(String rut) {
        int entero = 0;
        try {
            conectar();
            entero = state.executeUpdate("DELETE FROM boleta WHERE rut='" + rut + "';");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return entero;
    }    
    
    
    //metodo que devuelve una lista que se usará para lista a los clientes en una tabla en gui -> listaDeClientes.java
    //la consulta tambien aborda habitacion, asi que se hace un join para obtener la habitacion que habita
     public ArrayList<Huesped> listar() throws SQLException, Exception {
        conectar();

        ArrayList<Huesped> listaHuesped = new ArrayList<Huesped>();
        ResultSet result = state.executeQuery("select  h.nombre, h.rut, h.acompannantes, habi.numeroHabitacion "
                                            + "from huesped h "
                                            + "join boleta b "
                                            + "on b.rut = h.rut "
                                            + "left join habitacion habi "
                                            + "on b.numeroHabitacion = habi.numeroHabitacion;");
        while (result.next()) {
            Huesped hues = new Huesped();
            hues.setNombre((String)result.getObject(1));
            hues.setRut((String)result.getObject(2));
            hues.setAcompannantes((Integer)result.getObject(3));
            hues.setApellido((String)result.getObject(4));       //apesar que no devuelve apellido, solo es una consulta, asi que los datos no se ven afectados
            listaHuesped.add(hues);
        }
        return listaHuesped;
    }
     
     
     
     //cuando se ingresa un cliente, se genera una boleta que tiene al cliente, la habitacion y sus pagos
     //osea, la TABLA cliente obtiene todos estos datos
     //el valor null es debido que en la bases de datos se usa AUTO_INCREMENT
     public int insertarBoleta(Huesped huesped, Habitacion habitacion,
             Integer PagoSinDescuento, Integer PagoConDescuento, Integer PagoFinal)
     {
         int entero = 0;
         
         try
         {
            conectar();
            entero = state.executeUpdate("INSERT INTO boleta VALUES"
                    + "(" + "NULL" + ", '" + 
                             huesped.getRut() + "', '" + 
                             habitacion.getNumeroHabitacion()+ "', "+
                             PagoSinDescuento + ", "+
                             PagoConDescuento + ", "+
                             PagoFinal + ");");             
         }
         catch(Exception ex)
         {
            ex.printStackTrace();
         }
         return entero;
     }
     
     
     //metodo que al ingresar o eliminar un cliente, automaticamente cambia el estado 
     // y algunos atributos de la habitacion, como sus fechas de ingresos y su disponibilidad
     public int estadoHabitacion(Habitacion habitacion)
     {
         int entero = 0;
         try
         {
             conectar();
             int disponibilidad;
             
             if(habitacion.isDisponibilidad() == true)
             {
                 disponibilidad = 1;
             }
             else
             {
                 disponibilidad = 0;
             }
             
             entero = state.executeUpdate("update habitacion set " + 
                                          "disponibilidad = " +disponibilidad+", "+
                                          "fechaInicio = '"+habitacion.getFechaInicio()+"', "+
                                          "fechaTermino = '"+habitacion.getFechaTermino()+"', "+
                                          "cantidadDias = "+habitacion.getCantidadDias()+" "+
                                          "where numeroHabitacion = '"+habitacion.getNumeroHabitacion()+"';");
         }
         catch(Exception ex)
         {
             ex.printStackTrace();     
         }
         return entero;
     }

     
     //metodo que retorna al trabajador y su rut, para poder validarlo con el rut ingresado
     public ArrayList<Trabajador> validarRut(String rut) throws SQLException, Exception
     {
         conectar();
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();         
        
        ResultSet result = state.executeQuery("select rut from trabajador "
                                    +"where rut = '"+rut+"';");
        
        while (result.next()) 
        {
            Trabajador traba = new Trabajador();
            traba.setRut((String)result.getObject(1));
            listaTrabajadores.add(traba);
        }

        return listaTrabajadores;
     }
     
     
     //metodo que retorna a Trabajador y su contrasenna, para poder validarlo con la contraseña ingresada
     public ArrayList<Trabajador> validarContrasenna(String rut, String contrasenna) throws SQLException 
     {
         conectar();
        ArrayList<Trabajador> listaTrabajadores = new ArrayList<Trabajador>();         
        
        ResultSet result = state.executeQuery("select contrasenna from trabajador "
                                    +"where rut = '"+rut+"' and contrasenna = '"+contrasenna+"';");
        
        while (result.next()) 
        {
            Trabajador traba = new Trabajador();
            traba.setContrasenna((String)result.getObject(1));
            listaTrabajadores.add(traba);
        }

        return listaTrabajadores;
     }
    
     
     //en buscar persona, tambien se busca la habitacion en que está y sus dias de entrada y salida
     //asi que este metodo busca la habitacion que habita y sus atributos
     public Habitacion buscarHabitacion(String rut) throws SQLException
     {
         conectar();
         Habitacion habitacion = new Habitacion();
         
         ResultSet result = state.executeQuery("select h.numeroHabitacion, h.tipoHabitacion, "
                                             + "h.cantidadDias, h.fechaInicio, h.fechaTermino"
                                             + " from boleta b "
                                             + "join habitacion h "
                                             + "on h.numeroHabitacion = b.numeroHabitacion "
                                             + "where b.rut = '"+rut+"' ;");
         
        while (result.next()) 
        {
            habitacion.setNumeroHabitacion((String)result.getObject(1));
            habitacion.setTipoHabitacion((String)result.getObject(2));
            habitacion.setCantidadDias((String)result.getObject(3));
            habitacion.setFechaInicio((String)result.getObject(4));
            habitacion.setFechaTermino((String)result.getObject(5));
        }        
         
         
        return habitacion;
         
     }
     
     //metodo que retorna habitacion y su disponibilidad paara utilizarla 
     //y se desactiven las habitaciones ya desocupadas
     public Habitacion disponibilidadHabitacion(String numeroHabitacion) throws SQLException
     {
         conectar();
         
         Habitacion habitacion = new Habitacion();
         
         ResultSet result = state.executeQuery("select disponibilidad from habitacion "
                                             + "where numeroHabitacion = '"+numeroHabitacion+"';");
        while (result.next()) 
        {
            habitacion.setDisponibilidad((boolean)result.getObject(1));
        }  
         
         return habitacion;
     }
}
