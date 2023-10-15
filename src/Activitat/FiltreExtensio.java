package Activitat;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Classe per a filtrar determinats arxius segons l'extensió que ens indiquen
 * com ".txt".
 * 
 */

public class FiltreExtensio implements FilenameFilter {
	String extensio;

	/**
	 * Mètode constructor de filtre d'extensió per arxius.
	 * 
	 * @param extension Extensió de l'arxiu
	 */
	public FiltreExtensio(String extensio) {
		this.extensio = extensio;
	}

	/**
	 * Mètode per a filtrar arxius segons l'extensió indicada.
	 * 
	 * @param dir  Directori en el qual es troba l'arxiu.
	 * @param name Nom de l'arxiu
	 * @return Retorna true si l'arxiu coincideix amb l'extensió indicada, en cas
	 *         contrari false.
	 */

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extensio);
	}
}
