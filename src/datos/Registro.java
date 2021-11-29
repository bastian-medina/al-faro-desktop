package datos;

import hotel.Persona;
import java.util.ArrayList;

public class Registro 
{
   public ArrayList<Persona> lista = new ArrayList();
   
   //se guarda la persona
   public void ingresarPersona(Persona persona)
   {
       lista.add(persona);
       System.out.println("persona ingresada...");
   }
   
   public void listarPersonas()
   {
       for(Persona persona:lista)
       {
           persona.informacionPersona();
       }
   }
}
