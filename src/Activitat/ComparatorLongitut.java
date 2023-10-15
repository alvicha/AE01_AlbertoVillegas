package Activitat;

import java.io.File;
import java.util.Comparator;

/**
 * Classe per a comparar els arxius segons la seua grandària per a tenir-los
 * ordenats
 * 
 */
public class ComparatorLongitut implements Comparator<File> {
	@Override
	public int compare(File file1, File file2) {
		long size1 = file1.length();
		long size2 = file2.length();
		return Long.compare(size1, size2);
	}
}
