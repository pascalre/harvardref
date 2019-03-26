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

import view.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Group;

public class GUI {
  Display display;
  protected Shell shlLiteraturverzeichnis;
  private Text[] textFields = new Text[60];

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
        + " Pascal Reitermann - 1.0-SNAPSHOT");

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

    textFields[10] = new Text(grpAusgabe, SWT.BORDER);
    textFields[10].setEnabled(false);
    textFields[10].setEditable(false);
    textFields[10].setBounds(180, 10, 390, 19);

    textFields[59] = new Text(grpAusgabe, SWT.MULTI | SWT.WRAP);
    textFields[59].setBounds(10, 86, 679, 60);

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
    
    textFields[9] = new Text(grpAusgabe, SWT.BORDER);
    textFields[9].setBounds(10, 172, 679, 19);

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

    textFields[0] = new Text(composite, SWT.BORDER);
    textFields[0].setBounds(180, 5, 470, 19);

    textFields[1] = new Text(composite, SWT.BORDER);
    textFields[1].setBounds(180, 25, 470, 19);

    textFields[2] = new Text(composite, SWT.BORDER);
    textFields[2].setBounds(180, 45, 470, 19);

    textFields[3] = new Text(composite, SWT.MULTI | SWT.WRAP);
    textFields[3].setBounds(181, 66, 468, 37);

    textFields[4] = new Text(composite, SWT.BORDER);
    textFields[4].setBounds(180, 105, 470, 19);

    textFields[5] = new Text(composite, SWT.BORDER);
    textFields[5].setBounds(180, 125, 470, 19);

    textFields[6] = new Text(composite, SWT.BORDER);
    textFields[6].setBounds(180, 145, 470, 19);

    textFields[7] = new Text(composite, SWT.BORDER);
    textFields[7].setBounds(180, 165, 470, 19);

    textFields[8] = new Text(composite, SWT.BORDER);
    textFields[8].setBounds(180, 185, 470, 19);

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
          if (textFields[0].getText().equals("")
              || textFields[1].getText().equals("")
              || textFields[2].getText().equals("")
              || textFields[3].getText().equals("")
              || textFields[7].getText().equals("")
              || textFields[8].getText().equals("")) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          if (!textFields[2].getText().equals("")) {
            try {
              Integer.parseInt(textFields[2].getText());
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
          if (!textFields[6].getText().equals("")) {
            try {
              Integer.parseInt(textFields[6].getText());
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

          Monographie lit = new Monographie(textFields[0].getText(), textFields[1]
              .getText(), textFields[2].getText(), textFields[3].getText(),
              textFields[4].getText(), textFields[5].getText(), textFields[6]
                  .getText(), textFields[7].getText(), textFields[8]
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

    textFields[36] = new Text(composite_2, SWT.BORDER);
    textFields[36].setBounds(180, 5, 470, 19);

    textFields[38] = new Text(composite_2, SWT.BORDER);
    textFields[38].setBounds(180, 25, 470, 19);

    textFields[39] = new Text(composite_2, SWT.BORDER);
    textFields[39].setBounds(180, 45, 470, 19);

    textFields[40] = new Text(composite_2, SWT.BORDER);
    textFields[40].setBounds(180, 65, 470, 19);

    textFields[41] = new Text(composite_2, SWT.BORDER);
    textFields[41].setBounds(180, 85, 470, 19);

    textFields[42] = new Text(composite_2, SWT.BORDER);
    textFields[42].setBounds(180, 105, 470, 19);

    textFields[43] = new Text(composite_2, SWT.BORDER);
    textFields[43].setBounds(180, 125, 470, 19);

    textFields[44] = new Text(composite_2, SWT.BORDER);
    textFields[44].setBounds(180, 145, 470, 19);

    textFields[45] = new Text(composite_2, SWT.BORDER);
    textFields[45].setBounds(180, 165, 470, 19);

    textFields[47] = new Text(composite_2, SWT.BORDER);
    textFields[47].setBounds(180, 185, 470, 19);

    textFields[48] = new Text(composite_2, SWT.BORDER);
    textFields[48].setBounds(180, 205, 351, 19);

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
          if (textFields[36].getText().equals("")
              || textFields[38].getText().equals("")
              || textFields[39].getText().equals("")
              || textFields[40].getText().equals("")
              || textFields[41].getText().equals("")
              || textFields[42].getText().equals("")
              || textFields[45].getText().equals("")
              || textFields[47].getText().equals("")
              || textFields[48].getText().equals("")) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[39].getText());
            if (!textFields[44].getText().endsWith(""))
              Integer.parseInt(textFields[44].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte geben Sie eine gültige Zahl als Jahr und ggf. als Auflage an.");
            messageBox.open();
            break;
          }
          Sammelwerk lit = new Sammelwerk(textFields[36].getText(), textFields[38]
              .getText(), textFields[39].getText(), textFields[40].getText(),
              textFields[41].getText(), textFields[42].getText(), textFields[43]
                  .getText(), textFields[44].getText(), textFields[45]
                  .getText(), textFields[47].getText(), textFields[48]
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

    textFields[49] = new Text(composite_6, SWT.BORDER);
    textFields[49].setBounds(180, 5, 470, 19);

    textFields[50] = new Text(composite_6, SWT.BORDER);
    textFields[50].setBounds(180, 25, 470, 19);

    textFields[51] = new Text(composite_6, SWT.BORDER);
    textFields[51].setBounds(180, 45, 470, 19);

    textFields[52] = new Text(composite_6, SWT.BORDER);
    textFields[52].setBounds(180, 65, 470, 19);

    textFields[53] = new Text(composite_6, SWT.BORDER);
    textFields[53].setBounds(180, 85, 470, 19);

    textFields[54] = new Text(composite_6, SWT.BORDER);
    textFields[54].setBounds(180, 105, 470, 19);

    textFields[55] = new Text(composite_6, SWT.BORDER);
    textFields[55].setBounds(180, 125, 470, 19);

    textFields[56] = new Text(composite_6, SWT.BORDER);
    textFields[56].setBounds(180, 145, 470, 19);

    textFields[57] = new Text(composite_6, SWT.BORDER);
    textFields[57].setBounds(180, 165, 351, 19);

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

    textFields[11] = new Text(composite_3, SWT.BORDER);
    textFields[11].setBounds(180, 5, 470, 19);

    textFields[12] = new Text(composite_3, SWT.BORDER);
    textFields[12].setBounds(180, 25, 470, 19);

    textFields[13] = new Text(composite_3, SWT.BORDER);
    textFields[13].setBounds(180, 45, 470, 19);

    textFields[14] = new Text(composite_3, SWT.BORDER);
    textFields[14].setBounds(180, 65, 470, 39);

    textFields[17] = new Text(composite_3, SWT.BORDER);
    textFields[17].setBounds(180, 105, 470, 19);

    textFields[15] = new Text(composite_3, SWT.BORDER);
    textFields[15].setBounds(180, 125, 59, 19);
    textFields[15].setText("" + cal.get(Calendar.DAY_OF_MONTH));

    textFields[18] = new Text(composite_3, SWT.BORDER);
    textFields[18].setBounds(245, 125, 59, 19);
    textFields[18].setText("" + (cal.get(Calendar.MONTH) + 1));

    textFields[19] = new Text(composite_3, SWT.BORDER);
    textFields[19].setBounds(310, 125, 59, 19);
    textFields[19].setText("" + cal.get(Calendar.YEAR));

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
          if (textFields[14].getText().equals("")
              || textFields[17].getText().equals("")) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Die Felder 'Titel', 'Link' und 'Datum' dürfen nicht leer sein.");
            messageBox.open();
            break;
          }
          if (!textFields[13].getText().equals("")) {
            try {
              Integer.parseInt(textFields[13].getText());
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
          if (textFields[15].getText().equals("")
              || textFields[15].getText().length() > 2
              || textFields[18].getText().equals("")
              || textFields[18].getText().length() > 2
              || textFields[19].getText().equals("")
              || textFields[19].getText().length() > 4) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte geben Sie das Datum korrekt an: TT MM JJJJ.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[15].getText());
            Integer.parseInt(textFields[18].getText());
            Integer.parseInt(textFields[19].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte geben Sie das Datum korrekt an: TT MM JJJJ.");
            messageBox.open();
            break;
          }

          Internet lit = new Internet(textFields[11].getText(), textFields[12]
              .getText(), textFields[13].getText(), textFields[14].getText(),
              textFields[17].getText(), textFields[15].getText(), textFields[18]
                  .getText(), textFields[19].getText());

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

    textFields[27] = new Text(composite_5, SWT.BORDER);
    textFields[27].setBounds(180, 5, 470, 19);

    textFields[28] = new Text(composite_5, SWT.BORDER);
    textFields[28].setBounds(180, 25, 470, 19);

    textFields[30] = new Text(composite_5, SWT.BORDER);
    textFields[30].setBounds(180, 45, 470, 19);

    textFields[31] = new Text(composite_5, SWT.BORDER);
    textFields[31].setBounds(180, 65, 470, 19);

    textFields[32] = new Text(composite_5, SWT.BORDER);
    textFields[32].setBounds(180, 85, 470, 19);

    textFields[33] = new Text(composite_5, SWT.BORDER);
    textFields[33].setBounds(180, 105, 470, 19);

    textFields[34] = new Text(composite_5, SWT.BORDER);
    textFields[34].setBounds(180, 125, 470, 19);

    textFields[35] = new Text(composite_5, SWT.BORDER);
    textFields[35].setBounds(180, 145, 351, 19);

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
          if (textFields[27].getText().equals("")
              || textFields[28].getText().equals("")
              || textFields[30].getText().equals("")
              || textFields[31].getText().equals("")
              || textFields[32].getText().equals("")
              || textFields[33].getText().equals("")
              || textFields[34].getText().equals("")
              || textFields[35].getText().equals("")) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[33].getText());
            Integer.parseInt(textFields[34].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte geben Sie gültige Zahlen als Jahr und Nummer an.");
            messageBox.open();
            break;
          }
          Zeitschrift lit = new Zeitschrift(textFields[27].getText(),
              textFields[28].getText(), textFields[30].getText(), textFields[31]
                  .getText(), textFields[32].getText(), textFields[33]
                  .getText(), textFields[34].getText(), textFields[35]
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

    textFields[16] = new Text(composite_4, SWT.BORDER);
    textFields[16].setBounds(180, 5, 470, 19);

    textFields[21] = new Text(composite_4, SWT.BORDER);
    textFields[21].setBounds(180, 25, 470, 19);

    textFields[22] = new Text(composite_4, SWT.BORDER);
    textFields[22].setBounds(180, 45, 470, 19);

    textFields[23] = new Text(composite_4, SWT.BORDER);
    textFields[23].setBounds(180, 65, 470, 19);

    textFields[24] = new Text(composite_4, SWT.BORDER);
    textFields[24].setBounds(180, 85, 470, 19);

    textFields[25] = new Text(composite_4, SWT.BORDER);
    textFields[25].setBounds(180, 105, 470, 19);

    textFields[26] = new Text(composite_4, SWT.BORDER);
    textFields[26].setBounds(180, 125, 351, 19);

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
          if (textFields[16].getText().equals("")
              || textFields[21].getText().equals("")
              || textFields[22].getText().equals("")
              || textFields[23].getText().equals("")
              || textFields[24].getText().equals("")
              || textFields[25].getText().equals("")
              || textFields[26].getText().equals("")) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[22].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(
                shlLiteraturverzeichnis, SWT.ICON_INFORMATION
                    | SWT.OK);
            messageBox
                .setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
            messageBox.open();
            break;
          }
          WissArbeit lit = new WissArbeit(textFields[16].getText(), textFields[21]
              .getText(), textFields[22].getText(), textFields[23].getText(),
              textFields[24].getText(), textFields[25].getText(), textFields[26]
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
    textFields[59].setText(res);
    if (b.getSelection()) {
      StringSelection select = new StringSelection(res);
      java.awt.datatransfer.Clipboard clipboard = Toolkit
          .getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(select, select);
    }
  }
}
