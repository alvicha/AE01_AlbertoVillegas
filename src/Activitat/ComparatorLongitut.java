package Activitat;

import java.io.File;
import java.util.Comparator;

/**
 * Classe per a comparar els arxius segons la seua grandària per a tenir-los
 * ordenats
 * 
 */
public class ComparatorLongitut implements Comparator<File> {
	/**
	 * Mètode per a comparar dos arxius i ordenar-los adequadament en funció de la
	 * seua grandària en bytes.
	 * 
	 * @param file1 Nom del primer arxiu
	 * @param file2 Nom del segon arxiu
	 * @return Retorna un número negatiu si size1 és menor que size2, sinó si size1
	 *         és major que size2, un número positiu. I si són iguals retorna 0.
	 * 
	 */
	@Override
	public int compare(File file1, File file2) {
		long size1 = file1.length();
		long size2 = file2.length();
		return Long.compare(size1, size2);
	}
}
