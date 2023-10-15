package Activitat;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ButtonGroup;
import javax.swing.JEditorPane;
import java.awt.List;

public class InterficieAEV1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel lblContingut;
	private JFrame frame;
	private JTextField txtdirectori;
	private JTextField txtDirectoriTreball;
	private JTextField txtString;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtDirectoriDeTreball;

	/**
	 * Mètode per a comptar el nombre de coincidències que hi ha de la cadena de
	 * String respecte al contingut dels arxius.
	 * 
	 * @param text         Línia de text que representa el contingut dels arxius
	 * @param cadenaString Cadena de string que li passem a cercar.
	 * @return Retorna un contandor amb el nombre total de coincidències del string
	 *         indicat.
	 */
	private int CoincidenciesString(String text, String cadenaString) {
		int comptador = 0;
		int index = text.indexOf(cadenaString);
		while (index != -1) {
			comptador++;
			index = text.indexOf(cadenaString, index + 1);
		}
		while (index != -1)
			;
		return comptador;
	}

	/**
	 * Mètode que s´usa per a ordenar els arxius per nom de manera ascendent
	 * 
	 * @param arxius Llistat de fitxer del directori corresponent de la classe File
	 * 
	 */
	public static void ordenarArxiusNomDescendent(File[] arxius) {
		Arrays.sort(arxius, Collections.reverseOrder());
	}

	/**
	 * Mètode que s´usa per a ordenar els arxius per nom de manera descendent
	 * 
	 * @param arxius Llistat de fitxer del directori corresponent de la classe File
	 * 
	 */

	public static void ordenarArxiusNomAscendent(File[] arxius) {
		Arrays.sort(arxius, new FileComparator());
	}

	/**
	 * Mètode que s'usa per a ordenar els arxius per grandària de manera descendent
	 * 
	 * @param arxius Llistat de fitxer del directori corresponent de la classe File
	 * 
	 */
	public static void ordenarArxiusGrandariaDescendent(File[] arxius) {
		Arrays.sort(arxius, new ComparatorLongitut().reversed());
	}

	/**
	 * Mètode que s'usa per a ordenar els arxius per grandària de manera ascendent
	 * 
	 * @param arxius Llistat de fitxer del directori corresponent de la classe File
	 * 
	 */

	public static void ordenarArxiusGrandariaAscendent(File[] arxius) {
		Arrays.sort(arxius, new ComparatorLongitut());
	}

	/**
	 * Mètode que s'usa per a ordenar els arxius per l´ultima data de modificació de
	 * manera ascendent
	 * 
	 * @param arxius Llistat de fitxer del directori corresponent de la classe File
	 * 
	 */

	public static void ordenarArxiusDataModificacioAscendent(File[] arxius) {
		Arrays.sort(arxius, Comparator.comparingLong(File::lastModified));
	}

	/**
	 * Mètode que s'usa per a ordenar els arxius per l´ultima data de modificació de
	 * manera descendent
	 * 
	 * @param arxius Llistat de fitxer del directori corresponent de la classe File
	 */

	public static void ordenarArxiusDataModificacioDescendent(File[] arxius) {
		Arrays.sort(arxius, Comparator.comparingLong(File::lastModified).reversed());
	}

	/**
	 * Launch the application.
	 * 
	 * @param args Arguments passats per paràmetre al programa
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterficieAEV1 frame = new InterficieAEV1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterficieAEV1() {
		setTitle("Gestionar fitxers de text");

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		getContentPane().add(chckbxNewCheckBox, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1253, 643);
		lblContingut = new JPanel();
		lblContingut.setBackground(new Color(204, 255, 208));
		lblContingut.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(lblContingut);
		lblContingut.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(373, 71, 471, 510);
		lblContingut.add(scrollPane);

		JTextArea txaFitxers = new JTextArea();
		scrollPane.setViewportView(txaFitxers);
		txaFitxers.setEditable(false);

		JPanel pnlGestioDirectori = new JPanel();
		pnlGestioDirectori.setBounds(10, 47, 331, 268);
		pnlGestioDirectori.setBackground(new Color(215, 223, 255));
		pnlGestioDirectori.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"GESTI\u00D3 DIRECTORI", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblContingut.add(pnlGestioDirectori);
		pnlGestioDirectori.setLayout(null);

		JRadioButton rdbtnNom = new JRadioButton("NOM");
		buttonGroup.add(rdbtnNom);
		rdbtnNom.setSelected(true);
		rdbtnNom.setBackground(new Color(215, 223, 255));
		rdbtnNom.setBounds(20, 129, 81, 23);
		pnlGestioDirectori.add(rdbtnNom);

		JRadioButton rdbtnGrandaria = new JRadioButton("GRANDÀRIA");
		buttonGroup.add(rdbtnGrandaria);
		rdbtnGrandaria.setBackground(new Color(215, 223, 255));
		rdbtnGrandaria.setBounds(20, 155, 118, 23);
		pnlGestioDirectori.add(rdbtnGrandaria);

		JRadioButton rdbtnDataModificacio = new JRadioButton("DATA DE MODIFICACIÓ");
		buttonGroup.add(rdbtnDataModificacio);
		rdbtnDataModificacio.setBackground(new Color(215, 223, 255));
		rdbtnDataModificacio.setBounds(21, 181, 191, 23);
		pnlGestioDirectori.add(rdbtnDataModificacio);

		JLabel lblDirectori = DefaultComponentFactory.getInstance().createLabel("NOM DE DIRECTORI:");
		lblDirectori.setBounds(44, 26, 232, 20);
		pnlGestioDirectori.add(lblDirectori);
		lblDirectori.setHorizontalAlignment(SwingConstants.CENTER);
		lblDirectori.setFont(new Font("Times New Roman", Font.BOLD, 14));

		txtdirectori = new JTextField();
		txtdirectori.setBounds(20, 58, 294, 20);
		pnlGestioDirectori.add(txtdirectori);
		txtdirectori.setColumns(10);

		JButton btnLlistarFitxers = new JButton("LLISTAR FITXERS");
		btnLlistarFitxers.setBounds(78, 89, 177, 23);
		pnlGestioDirectori.add(btnLlistarFitxers);

		JRadioButton rdbtnAscendent = new JRadioButton("ASCENDENT");
		buttonGroup_1.add(rdbtnAscendent);
		rdbtnAscendent.setSelected(true);
		rdbtnAscendent.setBackground(new Color(215, 223, 255));
		rdbtnAscendent.setBounds(173, 129, 141, 23);
		pnlGestioDirectori.add(rdbtnAscendent);

		JRadioButton rdbtnDescendent = new JRadioButton("DESCENDENT");
		buttonGroup_1.add(rdbtnDescendent);
		rdbtnDescendent.setBackground(new Color(215, 223, 255));
		rdbtnDescendent.setBounds(173, 155, 141, 23);
		pnlGestioDirectori.add(rdbtnDescendent);

		JPanel pnlBuscarFitxers = new JPanel();
		pnlBuscarFitxers.setBounds(10, 351, 331, 205);
		pnlBuscarFitxers.setBackground(new Color(215, 223, 255));
		pnlBuscarFitxers
				.setBorder(new TitledBorder(null, "CERCA FITXERS", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		lblContingut.add(pnlBuscarFitxers);
		pnlBuscarFitxers.setLayout(null);

		txtDirectoriTreball = new JTextField();
		txtDirectoriTreball.setBounds(38, 62, 245, 20);
		pnlBuscarFitxers.add(txtDirectoriTreball);
		txtDirectoriTreball.setColumns(10);
		JButton btnBuscarFitxers = new JButton("BUSCAR FITXERS");
		btnBuscarFitxers.setBounds(87, 159, 143, 23);
		pnlBuscarFitxers.add(btnBuscarFitxers);
		btnBuscarFitxers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directori = txtDirectoriTreball.getText();
				String cadenaString = txtString.getText();
				if (directori.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Has d'introduir un nom de directori.", "ADVERTÈNCIA",
							JOptionPane.WARNING_MESSAGE);
				} else if (cadenaString.isEmpty()) {
					JOptionPane.showMessageDialog(null, "La cadena està buida. Introdueix una cadena per favor",
							"ADVERTÈNCIA", JOptionPane.WARNING_MESSAGE);
				} else {
					File directoriArxius = new File(directori);
					if (directoriArxius.exists() && directoriArxius.isDirectory()) {
						String extensio = ".txt";
						FiltreExtensio filtre = new FiltreExtensio(extensio);
						File[] arxius = directoriArxius.listFiles(filtre);
						if (arxius != null) {
							txaFitxers.setText("");
							txaFitxers.append("COINCIDÈNCIES ARXIUS");
							for (File arxiu : arxius) {
								int comptadorCoincidencies = 0;
								try {
									FileReader fileReader = new FileReader(arxiu);
									BufferedReader bufferedReader = new BufferedReader(fileReader);
									String linea;
									while ((linea = bufferedReader.readLine()) != null) {
										comptadorCoincidencies += CoincidenciesString(linea, cadenaString);
									}
									bufferedReader.close();
									fileReader.close();
									txaFitxers.append("\n" + arxiu.getName() + " => " + comptadorCoincidencies
											+ " coincidències.\n");
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "El directori " + directori + " no és un directori",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		txtString = new JTextField();
		txtString.setBounds(38, 128, 245, 20);
		pnlBuscarFitxers.add(txtString);
		txtString.setColumns(10);

		JButton btnMostrarFitxers = new JButton("MOSTRAR FITXERS");
		btnMostrarFitxers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directori = txtdirectori.getText();
				if (directori.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Has d'introduir un nom de directori.", "ADVERTÈNCIA",
							JOptionPane.WARNING_MESSAGE);
				} else {
					File directoriArxius = new File(directori);
					if (directoriArxius.exists() && directoriArxius.isDirectory()) {
						String extensio = ".txt";
						FiltreExtensio filtre = new FiltreExtensio(extensio);
						File[] arxius = directoriArxius.listFiles(filtre);
						if (arxius != null) {
							if (rdbtnNom.isSelected() && rdbtnAscendent.isSelected()) {
								ordenarArxiusNomAscendent(arxius);
								txaFitxers.setText("");
								txaFitxers.append("ARXIUS ORDENATS PER NOM I ASCENDENTMENT:\n");
								for (File arxiu : arxius) {
									int grandaria = (int) arxiu.length();
									String extensioArxiu = extensio;
									Date dataModificacioAmbHora = new Date(arxiu.lastModified());
									SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
									String dataModificacio = formatData.format(dataModificacioAmbHora);
									String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
											+ grandaria + " | Extensió: " + extensioArxiu
											+ " |  Última data de modificació: " + dataModificacio + "\n");
									txaFitxers.append(linea);
								}
							} else if (rdbtnNom.isSelected() && rdbtnDescendent.isSelected()) {
								ordenarArxiusNomDescendent(arxius);
								txaFitxers.setText("");
								txaFitxers.append("ARXIUS ORDENATS PER NOM I DESCENDENTMENT:\n");
								for (File arxiu : arxius) {
									int grandaria = (int) arxiu.length();
									String extensioArxiu = extensio;
									Date dataModificacioAmbHora = new Date(arxiu.lastModified());
									SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
									String dataModificacio = formatData.format(dataModificacioAmbHora);
									String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
											+ grandaria + " | Extensió: " + extensioArxiu
											+ " | Última data de modificació: " + dataModificacio + "\n");
									txaFitxers.append(linea);
								}
							} else if (rdbtnGrandaria.isSelected() && rdbtnDescendent.isSelected()) {
								ordenarArxiusGrandariaDescendent(arxius);
								txaFitxers.setText("");
								txaFitxers.append("ARXIUS ORDENATS PER GRANDÀRIA I DESCENDENTMENT\n");
								for (File arxiu : arxius) {
									int grandaria = (int) arxiu.length();
									String extensioArxiu = extensio;
									Date dataModificacioAmbHora = new Date(arxiu.lastModified());
									SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
									String dataModificacio = formatData.format(dataModificacioAmbHora);
									String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
											+ grandaria + " | Extensió: " + extensioArxiu
											+ " |  Última data de modificació: " + dataModificacio + "\n");
									txaFitxers.append(linea);
								}
							} else if (rdbtnGrandaria.isSelected() && rdbtnAscendent.isSelected()) {
								ordenarArxiusGrandariaAscendent(arxius);
								txaFitxers.setText("");
								txaFitxers.append("ARXIUS ORDENATS PER GRANDÀRIA I ASCENDENTMENT\n");
								for (File arxiu : arxius) {
									int grandaria = (int) arxiu.length();
									String extensioArxiu = extensio;
									Date dataModificacioAmbHora = new Date(arxiu.lastModified());
									SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
									String dataModificacio = formatData.format(dataModificacioAmbHora);
									String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
											+ grandaria + " | Extensió: " + extensioArxiu
											+ " |  Última data de modificació: " + dataModificacio + "\n");
									txaFitxers.append(linea);
								}
							} else if (rdbtnDataModificacio.isSelected() && rdbtnAscendent.isSelected()) {
								ordenarArxiusDataModificacioAscendent(arxius);
								txaFitxers.setText("");
								txaFitxers.append("ARXIUS ORDENATS PER ÚLTIMA DATA DE MODIFICACIÓ I ASCENDENTMENT\n");
								for (File arxiu : arxius) {
									int grandaria = (int) arxiu.length();
									String extensioArxiu = extensio;
									Date dataModificacioAmbHora = new Date(arxiu.lastModified());
									SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
									String dataModificacio = formatData.format(dataModificacioAmbHora);
									String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
											+ grandaria + " | Extensió: " + extensioArxiu
											+ " |  Última data de modificació: " + dataModificacio + "\n");
									txaFitxers.append(linea);
								}
							} else if (rdbtnDataModificacio.isSelected() && rdbtnDescendent.isSelected()) {
								ordenarArxiusDataModificacioDescendent(arxius);
								txaFitxers.setText("");
								txaFitxers.append("ARXIUS ORDENATS PER ÚLTIMA DATA DE MODIFICACIÓ I DESCENDENTMENT\n");
								for (File arxiu : arxius) {
									int grandaria = (int) arxiu.length();
									String extensioArxiu = extensio;
									Date dataModificacioAmbHora = new Date(arxiu.lastModified());
									SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
									String dataModificacio = formatData.format(dataModificacioAmbHora);
									String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
											+ grandaria + " | Extensió: " + extensioArxiu
											+ " |  Última data de modificació: " + dataModificacio + "\n");
									txaFitxers.append(linea);
								}
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "El directori " + directori + " no és un directori.",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnMostrarFitxers.setBounds(78, 217, 177, 23);
		pnlGestioDirectori.add(btnMostrarFitxers);

		JLabel lblDirectoriTreball = new JLabel("DIRECTORI DE TREBALL:");
		lblDirectoriTreball.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDirectoriTreball.setBounds(67, 37, 189, 14);
		pnlBuscarFitxers.add(lblDirectoriTreball);

		JLabel lblString = new JLabel("STRING  PER A BUSCAR EN FITXERS:");
		lblString.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblString.setBounds(38, 103, 271, 14);
		pnlBuscarFitxers.add(lblString);

		JPanel pnlFusioFitxers = new JPanel();
		pnlFusioFitxers.setBounds(874, 47, 342, 480);
		pnlFusioFitxers.setLayout(null);
		pnlFusioFitxers.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"FUSI\u00D3 FITXERS", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlFusioFitxers.setBackground(new Color(215, 223, 255));
		lblContingut.add(pnlFusioFitxers);

		txtDirectoriDeTreball = new JTextField();
		txtDirectoriDeTreball.setColumns(10);
		txtDirectoriDeTreball.setBounds(40, 60, 257, 20);
		pnlFusioFitxers.add(txtDirectoriDeTreball);

		JLabel lblOpcions = new JLabel("Selecciona dos o més fitxers:");
		lblOpcions.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblOpcions.setBounds(65, 147, 217, 14);
		pnlFusioFitxers.add(lblOpcions);

		List listFitxers = new List();
		listFitxers.setMultipleSelections(true);
		listFitxers.setBounds(27, 172, 283, 198);
		pnlFusioFitxers.add(listFitxers);

		JButton btnVisualitzarFitxers = new JButton("VISUALITZAR FITXERS");
		btnVisualitzarFitxers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directori = txtDirectoriDeTreball.getText();
				if (directori.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Has d'introduir un nom de directori.", "ADVERTÈNCIA",
							JOptionPane.WARNING_MESSAGE);
				} else {
					File directoriArxius = new File(directori);
					if (directoriArxius.isDirectory()) {
						String extensio = ".txt";
						FiltreExtensio filtre = new FiltreExtensio(extensio);
						File[] arxius = directoriArxius.listFiles(filtre);
						if (arxius != null) {
							listFitxers.clear();
							for (File arxiu : arxius) {
								listFitxers.add(arxiu.getName());
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "El directori " + directori + " no és un directori",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnVisualitzarFitxers.setBounds(91, 91, 160, 23);
		pnlFusioFitxers.add(btnVisualitzarFitxers);

		JButton btnGuardarFitxers = new JButton("GUARDAR FITXERS");
		btnGuardarFitxers.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String[] arxiusSeleccionats = listFitxers.getSelectedItems();
				if (arxiusSeleccionats.length < 2) {
					JOptionPane.showMessageDialog(null, "El nombre d'arxius seleccionats no és el correcte", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Els arxius s'han guardat correctament", "INFORMACIÓ",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnGuardarFitxers.setBounds(86, 381, 160, 23);
		pnlFusioFitxers.add(btnGuardarFitxers);

		JButton btnFusionarFitxers = new JButton("FUSIONAR FITXERS");
		btnFusionarFitxers.setBounds(86, 429, 160, 23);
		pnlFusioFitxers.add(btnFusionarFitxers);

		JLabel lblDirectoriDeTreball = new JLabel("DIRECTORI:");
		lblDirectoriDeTreball.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDirectoriDeTreball.setBounds(124, 35, 135, 14);
		pnlFusioFitxers.add(lblDirectoriDeTreball);
		btnFusionarFitxers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fitxerNou = JOptionPane.showInputDialog("Introdueix el nom del nou arxiu: ");
				String[] arxiusSeleccionats = listFitxers.getSelectedItems();
				String ruta = txtDirectoriDeTreball.getText();
				File rutaDirectori = new File(ruta);
				File fitxer = new File(rutaDirectori, fitxerNou);

				if (fitxerNou.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Nom de fitxer no vàlid. Has d'introduir un nom d'arxiu",
							"ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				} else {
					if (fitxer.exists()) {
						int respuesta = JOptionPane.showConfirmDialog(null,
								"L'arxiu ja existeix. Desitges sobreescriure l'arxiu?", "Confirmació de sobrescriptura",
								JOptionPane.YES_NO_OPTION);
						if (respuesta == JOptionPane.YES_OPTION) {
							try {
								FileWriter fw = new FileWriter(fitxer);
								BufferedWriter bf = new BufferedWriter(fw);
								for (String arxiu : arxiusSeleccionats) {
									File arxiuSeleccionat = new File(rutaDirectori, arxiu);
									try {
										FileReader fileReader = new FileReader(arxiuSeleccionat);
										BufferedReader bufferedReader = new BufferedReader(fileReader);
										String linea;
										while ((linea = bufferedReader.readLine()) != null) {
											bf.write(linea);
											bf.newLine();
										}
										bufferedReader.close();
										fileReader.close();
									} catch (IOException ex) {
										ex.printStackTrace();
									}
								}
								bf.close();
								fw.close();
							} catch (IOException ex) {
								ex.printStackTrace();
							}
						}
					} else {
						try {
							FileWriter fw = new FileWriter(fitxer);
							BufferedWriter bf = new BufferedWriter(fw);
							for (String arxiu : arxiusSeleccionats) {
								File archivoSeleccionado = new File(rutaDirectori, arxiu);
								try {
									FileReader fileReader = new FileReader(archivoSeleccionado);
									BufferedReader bufferedReader = new BufferedReader(fileReader);
									String linea;
									while ((linea = bufferedReader.readLine()) != null) {
										bf.write(linea);
										bf.newLine();
									}
									bufferedReader.close();
									fileReader.close();
								} catch (IOException ex) {
									ex.printStackTrace();
								}
							}
							bf.close();
							fw.close();
						} catch (IOException ex) {
							ex.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,
								"L'arxiu " + fitxerNou + " s'ha creat i s'ha fusionat correctament", "INFORMACIÓ",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(1048, 260, 116, 88);
		lblContingut.add(editorPane);

		JLabel lblTitolProjecte = DefaultComponentFactory.getInstance().createTitle("FITXERS DE TEXT ");
		lblTitolProjecte.setBackground(new Color(128, 128, 128));
		lblTitolProjecte.setForeground(new Color(64, 0, 128));
		lblTitolProjecte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitolProjecte.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitolProjecte.setBounds(307, 27, 290, 13);
		lblContingut.add(lblTitolProjecte);
		btnLlistarFitxers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String directori = txtdirectori.getText();
				if (directori.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Has d'introduir un nom de directori.", "ADVERTÈNCIA",
							JOptionPane.WARNING_MESSAGE);
				} else {
					File carpetaDirectori = new File(directori);
					if (carpetaDirectori.exists()) {
						if (carpetaDirectori.isDirectory()) {
							txaFitxers.setText("");
							String extension = ".txt";
							FiltreExtensio filtre = new FiltreExtensio(extension);
							String[] archivos = carpetaDirectori.list(filtre);
							String lineaDirectori = "DIRECTORI: " + directori + "\n";
							txaFitxers.setText("");
							txaFitxers.append(lineaDirectori);
							for (int i = 0; i < archivos.length; i++) {
								File arxiu = new File(directori, archivos[i]);
								int grandaria = (int) arxiu.length();
								String extensioArxiu = extension;
								Date dataModificacioAmbHora = new Date(arxiu.lastModified());
								SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
								String dataModificacio = formatData.format(dataModificacioAmbHora);
								String numFitxer = "\nFitxer " + (i + 1) + ":";
								txaFitxers.append(numFitxer);
								String linea = String.format("\r\nNom Arxiu: " + arxiu.getName() + " | Grandaria: "
										+ grandaria + " | Extensió: " + extensioArxiu
										+ " | Última data de modificació: " + dataModificacio + "\n");
								txaFitxers.append(linea);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "El directori " + directori + " no existeix", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
