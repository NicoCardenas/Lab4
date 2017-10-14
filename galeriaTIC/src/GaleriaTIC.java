package aplicacion;   

import java.util.LinkedList;
import java.util.ArrayList;

/**
 * @version ECI 2017-1
 */

public class GaleriaTIC{
    private LinkedList <Personaje> personajes;



    public GaleriaTIC(){
        personajes = new LinkedList<Personaje>();
    }
    
    /**
     * Adiciona algunos personajes
     */
    public void adicione(){
        	Personaje ejemplos[] = {
	        new Personaje("AdaLovelace","Augusta Ada King, Condesa de Lovelace", "1815-1852","Máquina analítica" , 
	        "Fue una matemática y escritora británica cuya fama le viene principalmente por su trabajo sobre la "+
	        "máquina calculadora mecánica de uso general de Charles Babbage, la denominada máquina analítica. Entre sus notas sobre la máquina se encuentra "+
	        "lo que se reconoce hoy como el primer algoritmo destinado a ser procesado por una máquina, por lo que se la considera como la primera programadora de ordenadores. (WIKIPEDIA)"),
            new Personaje("Turing","Alan Mathison Turing,", "1912-1954","Máquina de Turin, Test de Turing" , 
	        "Es considerado uno de los padres de la ciencia de la computación y precursor de la informática moderna. "+
	        "Proporcionó una influyente formalización de los conceptos de algoritmo y computación: la máquina de Turing. "+
	        "Formuló su propia versión que hoy es ampliamente aceptada como la tesis de Church-Turing (1936). "+
	        "En el campo de la inteligencia artificial, es conocido sobre todo por la concepción del test de Turing (1950), "+
	        "un criterio según el cual puede juzgarse la inteligencia de una máquina si sus respuestas en la prueba son "+
	        "indistinguibles de las de un ser humano.(WIKIPEDIA)"),
            new Personaje("Jimbo","Jimmy Donal «Jimbo» Wales", "1966-","Wikipedia" , 
	        "Ees un empresario de Internet estadounidense, cofundador y promotor junto a Larry Sanger de Wikipedia, "+
	        "una enciclopedia basada en el concepto wiki y el modelo de software libre. Fue fundador también de Nupedia, "+
	        "antecesora de Wikipedia, y junto con Tim Shell de la compañía Bomis. También fue cofundador de la empresa con fines de lucro Wikia, "+
	        "junto con Angela Beesley. Se graduó en las universidades de Auburn y Alabama. (WIKIPEDIA)"	        
	        )
        };
        for(Personaje informacion : ejemplos) {
            adicioneInformacion(informacion);
        }
    }
    
   
    
    /**
     * Consulta la información de un personaje
     */
    public Personaje getInformacion(String nombreCorto,String nombre){
    	Personaje c=null;
    	for(int i=0;i<personajes.size() && c == null;i++){
    	    if (personajes.get(i).getNombreCorto().compareToIgnoreCase(nombreCorto)==0 &&
                   (personajes.get(i).getNombre().compareToIgnoreCase(nombre)==0)){
                   c=personajes.get(i);
                }
    	}
    	return c;
    }


    /**
     * Adiciona un nuevo personaje
     */
    public void adicione(String nombreCorto, String nombre,String epoca, String productos, String descripcion){
	   adicioneInformacion(new Personaje(nombreCorto, nombre, epoca, productos, descripcion));
    }

    /**
     * Adiciona un nuevo personajes
     */
    public void adicioneInformacion(Personaje informacion){
    	int i=0;
    	while ((i<personajes.size()) && (personajes.get(i).getNombreCorto().compareToIgnoreCase(informacion.getNombreCorto())<0)){
    	    i++;
    	}
    	personajes.add(i,informacion);
    }
    

    
    /**
     * Consulta las personajes que inican con un prefijo
     * @param prefijo El prefijo a buscar
     * @return 
     */
    public ArrayList<Personaje> busque(String prefijo){
        ArrayList<Personaje> resultados=null;
    	prefijo=prefijo.toUpperCase();
    	for(int i=0;i<personajes.size();i++){
    	    if(personajes.get(i).getNombreCorto().toUpperCase().startsWith(prefijo)){
    	       resultados.add(personajes.get(i));
    	    }	
    	}
        return resultados;
    }

    /**
     * Consulta el numero de personajes
     * @return 
     */
    public int numeroProgramas(){
        return personajes.size();
    }


    /**
     * Consulta todos los personajes
     * @return 
     */
    public String toString(){
	StringBuffer allEntries=new StringBuffer();
        for(Personaje informacion : personajes) {
            allEntries.append(informacion.toString().length()<=150? informacion:informacion.toString().substring(0,149)+"...");
            allEntries.append('\n');
            allEntries.append('\n');
        }
        return allEntries.toString();
    }
}
