import java.util.ArrayList;

public class Equipo{
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    
    /**
     * Crea un equipo dado el nombre de sus miembros
     * @param nombres nombres de los miembros del equipo
     */    
    public Equipo(String [] nombres){
        personas= new ArrayList<Persona>();
        for (int i=0; i< nombres.length;i++){
            personas.add(new Persona(nombres[i]));
        }    
    }

    /**
     * Calcula el valor hora de un equipo
     */
    public int valorHora() throws EquipoExcepcion{
        int res = 0;
        if (personas.size() == 0){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        for (Persona i: personas) res+= i.valorHora();
        return res;
    }
    
    /**
     * Calcula el valor hora estimado de un equipo.
     * El valor estimado de una persona a la que no se conoce su valor es el valor
     * minimo del salario de sus compañeros
     * @return el valor hora del equipo
     * @throws EquipoException si en el equipo hay una persona desconocida
     * o no se tiene información para calular el valor estimado
     */
    public int valorHoraEstimado() throws EquipoExcepcion{
        int res = 0;
        if (personas.size() == 0){
            throw new EquipoExcepcion(EquipoExcepcion.EQUIPO_VACIO);
        }
        for (Persona i: personas){
            try{
                res+= i.valorHora();
            }catch (EquipoExcepcion e){
                if (e.getMessage() == EquipoExcepcion.VALOR_DESCONOCIDO){
                    res+=minValue();
                }else{ 
                    throw e;
                }
            }
        }
        return res;
    }
        
    private int minValue(){
        int res = Integer.MAX_VALUE;
        for (Persona i: personas){
            try{
                if (i.valorHora() < res) res = i.valorHora();
            }catch (EquipoExcepcion e){}
        }
        return res;
    }
}
