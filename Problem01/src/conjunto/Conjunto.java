package conjunto;

import java.util.ArrayList;

/**
 * Clase Conjunto, sirve para representar conjuntos en java.
 * Consta de las operaciones agrega, elimina, esta, union y interseccion.
 * 
 * @author garciparedes
 *
 * @param <E>
 */
public class Conjunto<E> implements Cloneable{
	
	
	private ArrayList<E> arrayList;
	
	
	/**
	 * Constructor principal de la clase. Es quien inicializa la clase.
	 * Sin este método la clase no funcionaría.
	 * 
	 */
	public Conjunto(){
		super();
		arrayList = new ArrayList<E>();
	}
	
	
	/**
	 * Constructor principal de la clase. Es quien inicializa la clase.
	 * Sin este método la clase no funcionaría.
	 * 
	 * @param elements Lista de elementos con los que inicializar el conjunto.
	 */
	public Conjunto(E... elements){
		this();
		for (E element : elements){
			
			assert(element != null);
			arrayList.add(element);
		}
	}
	
	
	/**
	 * Getter de arrayList.
	 * 
	 * @return arrayList Devuelve una lista ArrayList con los elementos contenidos en el Conjunto.
	 */
	public ArrayList<E> getArrayList(){
		assert (arrayList != null);

		return arrayList;
	}
	
	/**
	 * Getter de E[].
	 * 
	 * @return array Devuelve una lista E[] con los elementos contenidos en el Conjunto.
	 */
	@SuppressWarnings("unchecked")
	public E[] getArray(){
		assert (arrayList != null);

		return (E[]) arrayList.toArray();
	}


	
	/**
	 * Procedimiento agrega.
	 * 
	 * Es el encargado de agregar los elementos al Conjunto.
	 * 
	 * @param element Elemento a agregar.
	 */
	public void agrega(E element){
		assert (element != null);
		
		if (!esta(element)){
			getArrayList().add(element);
		}
	}
	
	
	/**
	 * Procedimiento elimina.
	 *
	 * Es el encargado de eliminar elementos del conjunto.
	 * 
	 * @param element Elemento a eliminar.
	 */
	public void elimina(E element){
		assert (element != null);

		if (esta(element)){
			getArrayList().remove(element);
		}
	}
	
	
	/**
	 * Metodo esta.
	 * 
	 * Este metodo se encarga de comprobar si un elemento esta o no en el conjunto.
	 * 
	 * @param element Elemento a comprobar.
	 * @return boolean Boolean con el que contiene la pertenencia de element al Conjunto.
	 */
	public boolean esta(E element){
		assert (element != null);

		return getArrayList().contains(element);
	}
	
	
	/**
	 * Metodo que genera la union de dos conjuntos.
	 * 
	 * A partir del conjunto invocante junto con conjuntoB se genera
	 * la union de conjuntos y se devuelve un nuevo Conjunto.
	 * 
	 * @param conjuntoB Segundo Conjunto necesario para la union.
	 * @return conjuntoFinal Conjunto union de conjunto invocante y conjuntoB.
	 */
	public Conjunto<E> union(Conjunto<E> conjuntoB ){
		Conjunto<E> conjuntoFinal = (Conjunto<E>) conjuntoB.clone();
		for (E element : getArrayList()){
			assert (element != null);
			conjuntoFinal.agrega(element);
		}
		return conjuntoFinal;
	}
	
	
	/**
	 * Metodo que genera la interseccion de dos conjuntos.
	 * 
	 * A partir del conjunto invocante junto con conjuntoB se genera
	 * la interseccion de conjuntos y se devuelve un nuevo Conjunto.
	 * 
	 * @param conjuntoB Segundo Conjunto necesario para la interseccion.
	 * @return conjuntoFinal Conjunto interseccion de conjunto invocante y conjuntoB.
	 */
	public Conjunto<E> interseccion(Conjunto<E> conjuntoB){
		Conjunto<E> conjuntoFinal = new Conjunto<E>();
		for (E element : getArrayList()){
			assert (element != null);
			if (conjuntoB.esta(element)){
				conjuntoFinal.agrega(element);
			}
		}
		return conjuntoFinal;
	}
	
	
	
	/**
     * Metodo que sobreescribe el metodo toString() de la clase <code>Object</code>.
     *
     * Devuelve una cadena de caracteres.
     *
     * @return String con el contenido de <code>Conjunto</code>.
     */
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	
    	for (E element : getArrayList()){
    		assert (element != null);
    		sb.append(element.toString());
    		sb.append(" ");
    	}
    	
        return sb.toString();
    }
    
    
    /**
     * Metodo que sobreescribe el metodo clone() de la clase <code>Object</code>.
     * 
     * Devuelve una copia de Conjunto.
     *
     * @return Object con el contenido de <code>Conjunto</code>.
     */
    @Override
    public Object clone (){
    	return new Conjunto<E>(getArray());
	}

}
