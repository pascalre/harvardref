package view;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import controller.Internet;
import controller.Monographie;
import controller.Sammelwerk;
import controller.WissArbeit;
import controller.Zeitschrift;

import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Group;

public class GUI {
	Display display;
	protected Shell shlLiteraturverzeichnis;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_11;
	private Text text_12;
	private Text text_13;
	private Text text_14;
	private Text text_15;
	private Text text_18;
	private Text text_19;
	private Text text_17;
	private Text text_16;
	private Text text_21;
	private Text text_22;
	private Text text_23;
	private Text text_24;
	private Text text_25;
	private Text text_26;
	private Text text_27;
	private Text text_28;
	private Text text_30;
	private Text text_31;
	private Text text_32;
	private Text text_33;
	private Text text_34;
	private Text text_35;
	private Text text_36;
	private Text text_38;
	private Text text_39;
	private Text text_40;
	private Text text_41;
	private Text text_42;
	private Text text_43;
	private Text text_44;
	private Text text_45;
	private Text text_47;
	private Text text_48;
	private Text text_49;
	private Text text_50;
	private Text text_51;
	private Text text_52;
	private Text text_53;
	private Text text_54;
	private Text text_55;
	private Text text_56;
	private Text text_57;
	private Text text_10;
	private Text text_59;
	private Text text_9;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlLiteraturverzeichnis.open();
		shlLiteraturverzeichnis.layout();
		while (!shlLiteraturverzeichnis.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		shlLiteraturverzeichnis = new Shell();
		shlLiteraturverzeichnis.setMinimumSize(new Point(655, 497));
		shlLiteraturverzeichnis.setBackground(SWTResourceManager
				.getColor(SWT.COLOR_LIST_BACKGROUND));
		shlLiteraturverzeichnis.setSize(733, 713);
		shlLiteraturverzeichnis
				.setText("HarvardRef - Literaturverzeichnisangaben nach Harvard");
		shlLiteraturverzeichnis.setImage(SWTResourceManager.getImage(GUI.class,
				"/view/hicon.png"));

		Label lblCopyright = new Label(shlLiteraturverzeichnis, SWT.NONE);
		lblCopyright.setAlignment(SWT.CENTER);
		lblCopyright.setBounds(0, 656, 733, 25);
		lblCopyright.setText("Copyright " + cal.get(Calendar.YEAR)
				+ " Pascal Reitermann - v0.1");

		Label lblNewLabel = new Label(shlLiteraturverzeichnis, SWT.NONE);
		lblNewLabel.setImage(SWTResourceManager.getImage(GUI.class,
				"/view/hlogo.png"));
		lblNewLabel.setBounds(0, 23, 733, 83);

		Group grpAusgabe = new Group(shlLiteraturverzeichnis, SWT.NONE);
		grpAusgabe.setText("Ausgabe");
		grpAusgabe.setBounds(10, 426, 713, 223);

		Button btnAusgabeExportierenIn = new Button(grpAusgabe, SWT.CHECK);
		btnAusgabeExportierenIn.setEnabled(false);
		btnAusgabeExportierenIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAusgabeExportierenIn.setBounds(10, 10, 160, 18);
		btnAusgabeExportierenIn.setText("exportieren nach:");

		text_10 = new Text(grpAusgabe, SWT.BORDER);
		text_10.setEnabled(false);
		text_10.setEditable(false);
		text_10.setBounds(180, 10, 390, 19);

		text_59 = new Text(grpAusgabe, SWT.MULTI | SWT.WRAP);
		text_59.setBounds(10, 86, 679, 60);

		Button btnDurchsuchen = new Button(grpAusgabe, SWT.NONE);
		btnDurchsuchen.setEnabled(false);
		btnDurchsuchen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnDurchsuchen.setBounds(576, 6, 113, 28);
		btnDurchsuchen.setText("Durchsuchen");

		Button btnKopiereEintragIn = new Button(grpAusgabe, SWT.CHECK);
		btnKopiereEintragIn.setSelection(true);
		btnKopiereEintragIn.setText("kopiere Bibliografische Angabe in die Zwischenablage");
		btnKopiereEintragIn.setBounds(10, 34, 362, 18);
		
		Label lblBibliografischeAngabe = new Label(grpAusgabe, SWT.NONE);
		lblBibliografischeAngabe.setBounds(10, 66, 205, 28);
		lblBibliografischeAngabe.setText("Bibliografische Angabe:");
		
		Label lblQuellenangabeImText = new Label(grpAusgabe, SWT.NONE);
		lblQuellenangabeImText.setText("Quellenangabe im Text:");
		lblQuellenangabeImText.setBounds(10, 152, 205, 34);
		
		text_9 = new Text(grpAusgabe, SWT.BORDER);
		text_9.setBounds(10, 172, 679, 19);

		Group grpEingabe = new Group(shlLiteraturverzeichnis, SWT.NONE);
		grpEingabe.setText("Eingabe");
		grpEingabe.setBounds(10, 112, 713, 311);

		TabFolder tabFolder = new TabFolder(grpEingabe, SWT.NONE);
		tabFolder.setLocation(10, 0);
		tabFolder.setSize(689, 278);

		@SuppressWarnings("unused")
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);

		TabItem tbtmMonographie = new TabItem(tabFolder, SWT.NONE);
		tbtmMonographie.setText("Monographie");

		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmMonographie.setControl(composite);

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setBounds(10, 10, 59, 14);
		lblName.setText("Name");

		Label lblVorname = new Label(composite, SWT.NONE);
		lblVorname.setBounds(10, 30, 59, 14);
		lblVorname.setText("Vorname");

		Label lblJahr = new Label(composite, SWT.NONE);
		lblJahr.setBounds(10, 50, 59, 14);
		lblJahr.setText("Jahr");

		Label lblTitel = new Label(composite, SWT.NONE);
		lblTitel.setBounds(10, 70, 59, 14);
		lblTitel.setText("Titel");

		Label lblHrsg = new Label(composite, SWT.NONE);
		lblHrsg.setBounds(10, 110, 207, 20);
		lblHrsg.setText("ggf. Vorname Name (Hrsg.)");

		Label lblBindung = new Label(composite, SWT.NONE);
		lblBindung.setBounds(10, 130, 107, 20);
		lblBindung.setText("ggf. Bindung");

		Label lblAuflage = new Label(composite, SWT.NONE);
		lblAuflage.setBounds(10, 150, 107, 20);
		lblAuflage.setText("ggf. Auflage");

		Label lblOrt = new Label(composite, SWT.NONE);
		lblOrt.setBounds(10, 170, 59, 14);
		lblOrt.setText("Ort");

		Label lblVerlag = new Label(composite, SWT.NONE);
		lblVerlag.setBounds(10, 190, 59, 20);
		lblVerlag.setText("Verlag");

		text = new Text(composite, SWT.BORDER);
		text.setBounds(180, 5, 470, 19);

		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(180, 25, 470, 19);

		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(180, 45, 470, 19);

		text_3 = new Text(composite, SWT.MULTI | SWT.WRAP);
		text_3.setBounds(181, 66, 468, 37);

		text_4 = new Text(composite, SWT.BORDER);
		text_4.setBounds(180, 105, 470, 19);

		text_5 = new Text(composite, SWT.BORDER);
		text_5.setBounds(180, 125, 470, 19);

		text_6 = new Text(composite, SWT.BORDER);
		text_6.setBounds(180, 145, 470, 19);

		text_7 = new Text(composite, SWT.BORDER);
		text_7.setBounds(180, 165, 470, 19);

		text_8 = new Text(composite, SWT.BORDER);
		text_8.setBounds(180, 185, 470, 19);

		Button btnErzeugen = new Button(composite, SWT.NONE);
		btnErzeugen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnErzeugen.setBounds(539, 205, 113, 28);
		btnErzeugen.setText("Erzeugen");
		
		Button btnEintrgeLschen = new Button(composite, SWT.NONE);
		btnEintrgeLschen.setEnabled(false);
		btnEintrgeLschen.setText("Löschen");
		btnEintrgeLschen.setBounds(420, 205, 113, 28);
		btnErzeugen.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					if (text.getText().equals("")
							|| text_1.getText().equals("")
							|| text_2.getText().equals("")
							|| text_3.getText().equals("")
							|| text_7.getText().equals("")
							|| text_8.getText().equals("")) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte machen Sie alle notwendigen Angaben.");
						messageBox.open();
						break;
					}
					if (!text_2.getText().equals("")) {
						try {
							Integer.parseInt(text_2.getText());
						} catch (NumberFormatException ex) {
							MessageBox messageBox = new MessageBox(
									shlLiteraturverzeichnis,
									SWT.ICON_INFORMATION | SWT.OK);
							messageBox
									.setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
							messageBox.open();
							break;
						}
					}
					if (!text_6.getText().equals("")) {
						try {
							Integer.parseInt(text_6.getText());
						} catch (NumberFormatException ex) {
							MessageBox messageBox = new MessageBox(
									shlLiteraturverzeichnis,
									SWT.ICON_INFORMATION | SWT.OK);
							messageBox
									.setMessage("Bitte geben Sie die Auflage in Form einer Ganzzahl an.");
							messageBox.open();
							break;
						}
					}

					Monographie lit = new Monographie(text.getText(), text_1
							.getText(), text_2.getText(), text_3.getText(),
							text_4.getText(), text_5.getText(), text_6
									.getText(), text_7.getText(), text_8
									.getText());

					String res = lit.toString();
					setText(btnKopiereEintragIn, res);
					break;
				}
			}
		});

		TabItem tbtmSammelwerk = new TabItem(tabFolder, SWT.NONE);
		tbtmSammelwerk.setText("Sammelwerk");

		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmSammelwerk.setControl(composite_2);

		Label label = new Label(composite_2, SWT.NONE);
		label.setText("Name");
		label.setBounds(10, 10, 59, 14);

		Label label_11 = new Label(composite_2, SWT.NONE);
		label_11.setText("Vorname");
		label_11.setBounds(10, 30, 59, 14);

		Label label_12 = new Label(composite_2, SWT.NONE);
		label_12.setText("Jahr");
		label_12.setBounds(10, 50, 59, 14);

		Label lblTitelDesBeitrags = new Label(composite_2, SWT.NONE);
		lblTitelDesBeitrags.setText("Titel des Beitrags");
		lblTitelDesBeitrags.setBounds(10, 70, 114, 20);

		Label lblNameVornamehrsg = new Label(composite_2, SWT.NONE);
		lblNameVornamehrsg.setText("Vorname Name (Hrsg.)");
		lblNameVornamehrsg.setBounds(10, 90, 207, 20);

		Label lblTitel_1 = new Label(composite_2, SWT.NONE);
		lblTitel_1.setText("Titel");
		lblTitel_1.setBounds(10, 110, 59, 14);

		Label lblBindung_1 = new Label(composite_2, SWT.NONE);
		lblBindung_1.setText("ggf. Bindung");
		lblBindung_1.setBounds(10, 130, 107, 20);

		Label lblGgfAuflage = new Label(composite_2, SWT.NONE);
		lblGgfAuflage.setText("ggf. Auflage");
		lblGgfAuflage.setBounds(10, 150, 137, 20);

		Label lblOrt_1 = new Label(composite_2, SWT.NONE);
		lblOrt_1.setText("Ort");
		lblOrt_1.setBounds(10, 170, 59, 14);

		text_36 = new Text(composite_2, SWT.BORDER);
		text_36.setBounds(180, 5, 470, 19);

		text_38 = new Text(composite_2, SWT.BORDER);
		text_38.setBounds(180, 25, 470, 19);

		text_39 = new Text(composite_2, SWT.BORDER);
		text_39.setBounds(180, 45, 470, 19);

		text_40 = new Text(composite_2, SWT.BORDER);
		text_40.setBounds(180, 65, 470, 19);

		text_41 = new Text(composite_2, SWT.BORDER);
		text_41.setBounds(180, 85, 470, 19);

		text_42 = new Text(composite_2, SWT.BORDER);
		text_42.setBounds(180, 105, 470, 19);

		text_43 = new Text(composite_2, SWT.BORDER);
		text_43.setBounds(180, 125, 470, 19);

		text_44 = new Text(composite_2, SWT.BORDER);
		text_44.setBounds(180, 145, 470, 19);

		text_45 = new Text(composite_2, SWT.BORDER);
		text_45.setBounds(180, 165, 470, 19);

		text_47 = new Text(composite_2, SWT.BORDER);
		text_47.setBounds(180, 185, 470, 19);

		text_48 = new Text(composite_2, SWT.BORDER);
		text_48.setBounds(180, 205, 351, 19);

		Button button_3 = new Button(composite_2, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_3.setText("Erzeugen");
		button_3.setBounds(537, 203, 113, 28);

		button_3.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					if (text_36.getText().equals("")
							|| text_38.getText().equals("")
							|| text_39.getText().equals("")
							|| text_40.getText().equals("")
							|| text_41.getText().equals("")
							|| text_42.getText().equals("")
							|| text_45.getText().equals("")
							|| text_47.getText().equals("")
							|| text_48.getText().equals("")) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte machen Sie alle notwendigen Angaben.");
						messageBox.open();
						break;
					}
					try {
						Integer.parseInt(text_39.getText());
						if (!text_44.getText().endsWith(""))
							Integer.parseInt(text_44.getText());
					} catch (NumberFormatException ex) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte geben Sie eine gültige Zahl als Jahr und ggf. als Auflage an.");
						messageBox.open();
						break;
					}
					Sammelwerk lit = new Sammelwerk(text_36.getText(), text_38
							.getText(), text_39.getText(), text_40.getText(),
							text_41.getText(), text_42.getText(), text_43
									.getText(), text_44.getText(), text_45
									.getText(), text_47.getText(), text_48
									.getText());

					String res = lit.toString();
					setText(btnKopiereEintragIn, res);
				}
			}
		});

		Label lblVerlag_1 = new Label(composite_2, SWT.NONE);
		lblVerlag_1.setText("Verlag");
		lblVerlag_1.setBounds(10, 190, 59, 20);

		Label lblSeitenbereich_1 = new Label(composite_2, SWT.NONE);
		lblSeitenbereich_1.setText("Seitenbereich");
		lblSeitenbereich_1.setBounds(10, 210, 99, 14);

		TabItem tbtmGesamtausgabe = new TabItem(tabFolder, SWT.NONE);
		tbtmGesamtausgabe.setText("Gesamtausgabe");

		Composite composite_6 = new Composite(tabFolder, SWT.NONE);
		tbtmGesamtausgabe.setControl(composite_6);

		Label label_13 = new Label(composite_6, SWT.NONE);
		label_13.setText("Name");
		label_13.setBounds(10, 10, 59, 14);

		Label label_14 = new Label(composite_6, SWT.NONE);
		label_14.setText("Vorname");
		label_14.setBounds(10, 30, 59, 14);

		Label label_15 = new Label(composite_6, SWT.NONE);
		label_15.setText("Jahr");
		label_15.setBounds(10, 50, 59, 14);

		Label lblTitelDesBandes = new Label(composite_6, SWT.NONE);
		lblTitelDesBandes.setText("Titel des Bandes");
		lblTitelDesBandes.setBounds(10, 70, 145, 14);

		Label label_17 = new Label(composite_6, SWT.NONE);
		label_17.setText("ggf. Vorname Name (Hrsg.)");
		label_17.setBounds(10, 90, 207, 20);

		Label lblBindung_2 = new Label(composite_6, SWT.NONE);
		lblBindung_2.setText("Bindung");
		lblBindung_2.setBounds(10, 110, 107, 20);

		Label label_19 = new Label(composite_6, SWT.NONE);
		label_19.setText("ggf. Auflage");
		label_19.setBounds(10, 130, 107, 20);

		Label label_20 = new Label(composite_6, SWT.NONE);
		label_20.setText("Ort");
		label_20.setBounds(10, 150, 59, 14);

		Label label_21 = new Label(composite_6, SWT.NONE);
		label_21.setText("Verlag");
		label_21.setBounds(10, 170, 59, 20);

		text_49 = new Text(composite_6, SWT.BORDER);
		text_49.setBounds(180, 5, 470, 19);

		text_50 = new Text(composite_6, SWT.BORDER);
		text_50.setBounds(180, 25, 470, 19);

		text_51 = new Text(composite_6, SWT.BORDER);
		text_51.setBounds(180, 45, 470, 19);

		text_52 = new Text(composite_6, SWT.BORDER);
		text_52.setBounds(180, 65, 470, 19);

		text_53 = new Text(composite_6, SWT.BORDER);
		text_53.setBounds(180, 85, 470, 19);

		text_54 = new Text(composite_6, SWT.BORDER);
		text_54.setBounds(180, 105, 470, 19);

		text_55 = new Text(composite_6, SWT.BORDER);
		text_55.setBounds(180, 125, 470, 19);

		text_56 = new Text(composite_6, SWT.BORDER);
		text_56.setBounds(180, 145, 470, 19);

		text_57 = new Text(composite_6, SWT.BORDER);
		text_57.setBounds(180, 165, 351, 19);

		Button button_4 = new Button(composite_6, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_4.setText("Erzeugen");
		button_4.setBounds(537, 163, 113, 28);

		TabItem tabInternet = new TabItem(tabFolder, SWT.NONE);
		tabInternet.setText("Internet");

		Composite composite_3 = new Composite(tabFolder, SWT.NONE);
		tabInternet.setControl(composite_3);

		Label lblNameOderFirma = new Label(composite_3, SWT.NONE);
		lblNameOderFirma.setText("Name oder Firma");
		lblNameOderFirma.setBounds(10, 10, 156, 14);

		Label label_1 = new Label(composite_3, SWT.NONE);
		label_1.setText("Vorname");
		label_1.setBounds(10, 30, 59, 14);

		Label label_2 = new Label(composite_3, SWT.NONE);
		label_2.setText("Jahr");
		label_2.setBounds(10, 50, 59, 14);

		Label label_3 = new Label(composite_3, SWT.NONE);
		label_3.setText("Titel");
		label_3.setBounds(10, 70, 59, 14);

		text_11 = new Text(composite_3, SWT.BORDER);
		text_11.setBounds(180, 5, 470, 19);

		text_12 = new Text(composite_3, SWT.BORDER);
		text_12.setBounds(180, 25, 470, 19);

		text_13 = new Text(composite_3, SWT.BORDER);
		text_13.setBounds(180, 45, 470, 19);

		text_14 = new Text(composite_3, SWT.BORDER);
		text_14.setBounds(180, 65, 470, 39);

		text_17 = new Text(composite_3, SWT.BORDER);
		text_17.setBounds(180, 105, 470, 19);

		text_15 = new Text(composite_3, SWT.BORDER);
		text_15.setBounds(180, 125, 59, 19);
		text_15.setText("" + cal.get(Calendar.DAY_OF_MONTH));

		text_18 = new Text(composite_3, SWT.BORDER);
		text_18.setBounds(245, 125, 59, 19);
		text_18.setText("" + (cal.get(Calendar.MONTH) + 1));

		text_19 = new Text(composite_3, SWT.BORDER);
		text_19.setBounds(310, 125, 59, 19);
		text_19.setText("" + cal.get(Calendar.YEAR));

		Button button = new Button(composite_3, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button.setText("Erzeugen");
		button.setBounds(537, 123, 113, 28);

		button.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					if (text_14.getText().equals("")
							|| text_17.getText().equals("")) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Die Felder 'Titel', 'Link' und 'Datum' dürfen nicht leer sein.");
						messageBox.open();
						break;
					}
					if (!text_13.getText().equals("")) {
						try {
							Integer.parseInt(text_13.getText());
						} catch (NumberFormatException ex) {
							MessageBox messageBox = new MessageBox(
									shlLiteraturverzeichnis,
									SWT.ICON_INFORMATION | SWT.OK);
							messageBox
									.setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
							messageBox.open();
							break;
						}
					}
					if (text_15.getText().equals("")
							|| text_15.getText().length() > 2
							|| text_18.getText().equals("")
							|| text_18.getText().length() > 2
							|| text_19.getText().equals("")
							|| text_19.getText().length() > 4) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte geben Sie das Datum korrekt an: TT MM JJJJ.");
						messageBox.open();
						break;
					}
					try {
						Integer.parseInt(text_15.getText());
						Integer.parseInt(text_18.getText());
						Integer.parseInt(text_19.getText());
					} catch (NumberFormatException ex) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte geben Sie das Datum korrekt an: TT MM JJJJ.");
						messageBox.open();
						break;
					}

					Internet lit = new Internet(text_11.getText(), text_12
							.getText(), text_13.getText(), text_14.getText(),
							text_17.getText(), text_15.getText(), text_18
									.getText(), text_19.getText());

					String res = lit.toString();

					setText(btnKopiereEintragIn, res);
					break;
				}
			}
		});

		Label lblTtMmJjjj = new Label(composite_3, SWT.NONE);
		lblTtMmJjjj.setText("TT.MM.JJJJ d. Abrufs");
		lblTtMmJjjj.setBounds(10, 130, 135, 14);

		Label lblLink = new Label(composite_3, SWT.NONE);
		lblLink.setText("Link");
		lblLink.setBounds(10, 110, 207, 14);

		Label label_16 = new Label(composite_3, SWT.NONE);
		label_16.setBounds(238, 130, 59, 14);
		label_16.setText(".");

		Label label_18 = new Label(composite_3, SWT.NONE);
		label_18.setText(".");
		label_18.setBounds(303, 130, 59, 14);

		TabItem tbtmZeitschrift = new TabItem(tabFolder, SWT.NONE);
		tbtmZeitschrift.setText("Zeitschrift");

		Composite composite_5 = new Composite(tabFolder, SWT.NONE);
		tbtmZeitschrift.setControl(composite_5);

		Label label_8 = new Label(composite_5, SWT.NONE);
		label_8.setText("Name");
		label_8.setBounds(10, 10, 59, 14);

		Label label_9 = new Label(composite_5, SWT.NONE);
		label_9.setText("Vorname");
		label_9.setBounds(10, 30, 59, 14);

		Label label_10 = new Label(composite_5, SWT.NONE);
		label_10.setText("Jahr");
		label_10.setBounds(10, 50, 59, 14);

		Label lblTitelDesArtikels = new Label(composite_5, SWT.NONE);
		lblTitelDesArtikels.setText("Titel des Artikels");
		lblTitelDesArtikels.setBounds(10, 70, 164, 14);

		Label lblTitelDerZeitschrift = new Label(composite_5, SWT.NONE);
		lblTitelDerZeitschrift.setText("Titel der Zeitschrift");
		lblTitelDerZeitschrift.setBounds(10, 90, 207, 14);

		Label lblJahrgang = new Label(composite_5, SWT.NONE);
		lblJahrgang.setText("Jahrgang");
		lblJahrgang.setBounds(10, 110, 59, 20);

		Label lblNummer = new Label(composite_5, SWT.NONE);
		lblNummer.setText("Nummer");
		lblNummer.setBounds(10, 130, 107, 14);

		Label lblSeitenbereich = new Label(composite_5, SWT.NONE);
		lblSeitenbereich.setText("Seitenbereich");
		lblSeitenbereich.setBounds(10, 150, 164, 14);

		text_27 = new Text(composite_5, SWT.BORDER);
		text_27.setBounds(180, 5, 470, 19);

		text_28 = new Text(composite_5, SWT.BORDER);
		text_28.setBounds(180, 25, 470, 19);

		text_30 = new Text(composite_5, SWT.BORDER);
		text_30.setBounds(180, 45, 470, 19);

		text_31 = new Text(composite_5, SWT.BORDER);
		text_31.setBounds(180, 65, 470, 19);

		text_32 = new Text(composite_5, SWT.BORDER);
		text_32.setBounds(180, 85, 470, 19);

		text_33 = new Text(composite_5, SWT.BORDER);
		text_33.setBounds(180, 105, 470, 19);

		text_34 = new Text(composite_5, SWT.BORDER);
		text_34.setBounds(180, 125, 470, 19);

		text_35 = new Text(composite_5, SWT.BORDER);
		text_35.setBounds(180, 145, 351, 19);

		Button button_2 = new Button(composite_5, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_2.setText("Erzeugen");
		button_2.setBounds(537, 143, 113, 28);

		button_2.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					if (text_27.getText().equals("")
							|| text_28.getText().equals("")
							|| text_30.getText().equals("")
							|| text_31.getText().equals("")
							|| text_32.getText().equals("")
							|| text_33.getText().equals("")
							|| text_34.getText().equals("")
							|| text_35.getText().equals("")) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte machen Sie alle notwendigen Angaben.");
						messageBox.open();
						break;
					}
					try {
						Integer.parseInt(text_33.getText());
						Integer.parseInt(text_34.getText());
					} catch (NumberFormatException ex) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte geben Sie gültige Zahlen als Jahr und Nummer an.");
						messageBox.open();
						break;
					}
					Zeitschrift lit = new Zeitschrift(text_27.getText(),
							text_28.getText(), text_30.getText(), text_31
									.getText(), text_32.getText(), text_33
									.getText(), text_34.getText(), text_35
									.getText());

					String res = lit.toString();

					setText(btnKopiereEintragIn, res);
					break;
				}
			}
		});

		TabItem tbtmWissArbeit = new TabItem(tabFolder, SWT.NONE);
		tbtmWissArbeit.setText("wiss. Arbeit");

		Composite composite_4 = new Composite(tabFolder, SWT.NONE);
		tbtmWissArbeit.setControl(composite_4);

		Label label_4 = new Label(composite_4, SWT.NONE);
		label_4.setText("Name");
		label_4.setBounds(10, 10, 59, 14);

		Label label_5 = new Label(composite_4, SWT.NONE);
		label_5.setText("Vorname");
		label_5.setBounds(10, 30, 59, 14);

		Label label_6 = new Label(composite_4, SWT.NONE);
		label_6.setText("Jahr");
		label_6.setBounds(10, 50, 59, 14);

		Label label_7 = new Label(composite_4, SWT.NONE);
		label_7.setText("Titel");
		label_7.setBounds(10, 70, 59, 14);

		Label lblFormDerArbeit = new Label(composite_4, SWT.NONE);
		lblFormDerArbeit.setText("Form der Arbeit");
		lblFormDerArbeit.setBounds(10, 90, 207, 14);

		Label lblFach = new Label(composite_4, SWT.NONE);
		lblFach.setText("Fach");
		lblFach.setBounds(10, 110, 59, 14);

		Label lblBildungseinrichtung = new Label(composite_4, SWT.NONE);
		lblBildungseinrichtung.setText("Bildungseinrichtung");
		lblBildungseinrichtung.setBounds(10, 130, 155, 20);

		text_16 = new Text(composite_4, SWT.BORDER);
		text_16.setBounds(180, 5, 470, 19);

		text_21 = new Text(composite_4, SWT.BORDER);
		text_21.setBounds(180, 25, 470, 19);

		text_22 = new Text(composite_4, SWT.BORDER);
		text_22.setBounds(180, 45, 470, 19);

		text_23 = new Text(composite_4, SWT.BORDER);
		text_23.setBounds(180, 65, 470, 19);

		text_24 = new Text(composite_4, SWT.BORDER);
		text_24.setBounds(180, 85, 470, 19);

		text_25 = new Text(composite_4, SWT.BORDER);
		text_25.setBounds(180, 105, 470, 19);

		text_26 = new Text(composite_4, SWT.BORDER);
		text_26.setBounds(180, 125, 351, 19);

		Button button_1 = new Button(composite_4, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1.setText("Erzeugen");
		button_1.setBounds(537, 123, 113, 28);

		button_1.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					if (text_16.getText().equals("")
							|| text_21.getText().equals("")
							|| text_22.getText().equals("")
							|| text_23.getText().equals("")
							|| text_24.getText().equals("")
							|| text_25.getText().equals("")
							|| text_26.getText().equals("")) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte machen Sie alle notwendigen Angaben.");
						messageBox.open();
						break;
					}
					try {
						Integer.parseInt(text_22.getText());
					} catch (NumberFormatException ex) {
						MessageBox messageBox = new MessageBox(
								shlLiteraturverzeichnis, SWT.ICON_INFORMATION
										| SWT.OK);
						messageBox
								.setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
						messageBox.open();
						break;
					}
					WissArbeit lit = new WissArbeit(text_16.getText(), text_21
							.getText(), text_22.getText(), text_23.getText(),
							text_24.getText(), text_25.getText(), text_26
									.getText(), "");

					String res = lit.toString();

					setText(btnKopiereEintragIn, res);
					break;
				}
			}
		});

		TabItem tbtmFilm = new TabItem(tabFolder, SWT.NONE);
		tbtmFilm.setText("Film");
		btnDurchsuchen.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:

					FileDialog dialog = new FileDialog(shlLiteraturverzeichnis,
							SWT.SAVE);
					dialog.setFilterNames(new String[] { "Textdatei",
							"All Files (*.txt)" });
					dialog.setFilterExtensions(new String[] { "*.txt", "*.*" });
					dialog.setFileName("harvard_references.txt");
				}
			}
		});
	}

	private void setText(Button b, String res) {
		text_59.setText(res);
		if (b.getSelection()) {
			StringSelection select = new StringSelection(res);
			java.awt.datatransfer.Clipboard clipboard = Toolkit
					.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(select, select);
		}
	}
}
