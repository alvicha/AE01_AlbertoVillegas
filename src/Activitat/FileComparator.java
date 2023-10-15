package Activitat;

import java.io.File;
import java.util.Comparator;

/**
 * Classe per a comparar el llistat d´arxius i tenir-los de manera ordenada per
 * nom
 */

public class FileComparator implements Comparator<File> {

	/**
	 * Mètode per a comparar dos arxius i ordenar-los adequadament
	 * 
	 * @param file1 Nom del primer arxiu
	 * @param file2 Nom del segon arxiu
	 * @return Retorna un número negatiu si file1 és menor que file2, sinó si file1
	 *         és major que file2, un número positiu. I si són iguals retorna 0.
	 * 
	 */
	@Override
	public int compare(File file1, File file2) {
		return file1.getName().compareTo(file2.getName());
	}
}
