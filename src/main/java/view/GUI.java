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
import controller.Monograph;
import controller.CollectedEdition;
import controller.CompleteWorks;
import controller.AcademicPaper;
import controller.Magazine;
import view.SWTResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Group;

public class GUI {
  Display display;
  protected Shell bibliographyShell;
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
    bibliographyShell.open();
    bibliographyShell.layout();
    while (!bibliographyShell.isDisposed()) {
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

    bibliographyShell = new Shell();
    bibliographyShell.setMinimumSize(new Point(655, 497));
    bibliographyShell.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_BACKGROUND));
    bibliographyShell.setSize(733, 713);
    bibliographyShell.setText("HarvardRef - Literaturverzeichnisangaben nach Harvard");
    bibliographyShell.setImage(SWTResourceManager.getImage(GUI.class, "/view/hicon.png"));

    Label labelCopyright = new Label(bibliographyShell, SWT.NONE);
    labelCopyright.setAlignment(SWT.CENTER);
    labelCopyright.setBounds(0, 656, 733, 25);
    labelCopyright.setText("Copyright " + cal.get(Calendar.YEAR) + " Pascal Reitermann - 1.0.0-SNAPSHOT");

    Label labelLogo = new Label(bibliographyShell, SWT.NONE);
    labelLogo.setImage(SWTResourceManager.getImage(GUI.class, "/view/hlogo.png"));
    labelLogo.setBounds(0, 23, 733, 83);

    Group groupOutput = new Group(bibliographyShell, SWT.NONE);
    groupOutput.setText("Ausgabe");
    groupOutput.setBounds(10, 426, 713, 223);

    Button buttonExportOutput = new Button(groupOutput, SWT.CHECK);
    buttonExportOutput.setEnabled(false);
    buttonExportOutput.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
      }
    });
    buttonExportOutput.setBounds(10, 10, 160, 18);
    buttonExportOutput.setText("exportieren nach:");

    textFields[10] = new Text(groupOutput, SWT.BORDER);
    textFields[59] = new Text(groupOutput, SWT.MULTI | SWT.WRAP);

    textFields[10].setEnabled(false);
    textFields[10].setEditable(false);
    textFields[10].setBounds(180, 10, 390, 19);
    textFields[59].setBounds(10, 86, 679, 60);

    Button buttonSearch = new Button(groupOutput, SWT.NONE);
    buttonSearch.setEnabled(false);
    buttonSearch.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
      }
    });
    buttonSearch.setBounds(576, 6, 113, 28);
    buttonSearch.setText("Durchsuchen");

    Button buttonCopyOutputToClipboard = new Button(groupOutput, SWT.CHECK);
    buttonCopyOutputToClipboard.setSelection(true);
    buttonCopyOutputToClipboard.setText("kopiere Bibliografische Angabe in die Zwischenablage");
    buttonCopyOutputToClipboard.setBounds(10, 34, 362, 18);

    Label labelHarvardStyle = new Label(groupOutput, SWT.NONE);
    labelHarvardStyle.setBounds(10, 66, 205, 28);
    labelHarvardStyle.setText("Bibliografische Angabe:");

    Label labelReferenceInText = new Label(groupOutput, SWT.NONE);
    labelReferenceInText.setText("Quellenangabe im Text:");
    labelReferenceInText.setBounds(10, 152, 205, 34);

    textFields[9] = new Text(groupOutput, SWT.BORDER);
    textFields[9].setBounds(10, 172, 679, 19);

    Group groupInput = new Group(bibliographyShell, SWT.NONE);
    groupInput.setText("Eingabe");
    groupInput.setBounds(10, 112, 713, 311);

    TabFolder tabFolder = new TabFolder(groupInput, SWT.NONE);
    tabFolder.setLocation(10, 0);
    tabFolder.setSize(689, 278);

    @SuppressWarnings("unused")
    Composite compositeMain = new Composite(tabFolder, SWT.NONE);

    TabItem tabMonograph = new TabItem(tabFolder, SWT.NONE);
    tabMonograph.setText("Monographie");

    Composite compositeMonograph = new Composite(tabFolder, SWT.NONE);
    tabMonograph.setControl(compositeMonograph);

    Label labelName = new Label(compositeMonograph, SWT.NONE);
    labelName.setBounds(10, 10, 59, 14);
    labelName.setText("Name");

    Label labelForename = new Label(compositeMonograph, SWT.NONE);
    labelForename.setBounds(10, 30, 59, 14);
    labelForename.setText("Vorname");

    Label labelYear = new Label(compositeMonograph, SWT.NONE);
    labelYear.setBounds(10, 50, 59, 14);
    labelYear.setText("Jahr");

    Label labelTitle = new Label(compositeMonograph, SWT.NONE);
    labelTitle.setBounds(10, 70, 59, 14);
    labelTitle.setText("Titel");

    Label labelPublisher = new Label(compositeMonograph, SWT.NONE);
    labelPublisher.setBounds(10, 110, 207, 20);
    labelPublisher.setText("ggf. Vorname Name (Hrsg.)");

    Label labelBinding = new Label(compositeMonograph, SWT.NONE);
    labelBinding.setBounds(10, 130, 107, 20);
    labelBinding.setText("ggf. Bindung");

    Label labelEdition = new Label(compositeMonograph, SWT.NONE);
    labelEdition.setBounds(10, 150, 107, 20);
    labelEdition.setText("ggf. Auflage");

    Label labelPlace = new Label(compositeMonograph, SWT.NONE);
    labelPlace.setBounds(10, 170, 59, 14);
    labelPlace.setText("Ort");

    Label labelPress = new Label(compositeMonograph, SWT.NONE);
    labelPress.setBounds(10, 190, 59, 20);
    labelPress.setText("Verlag");

    textFields[0] = new Text(compositeMonograph, SWT.BORDER);
    textFields[1] = new Text(compositeMonograph, SWT.BORDER);
    textFields[2] = new Text(compositeMonograph, SWT.BORDER);
    textFields[3] = new Text(compositeMonograph, SWT.MULTI | SWT.WRAP);
    textFields[4] = new Text(compositeMonograph, SWT.BORDER);
    textFields[5] = new Text(compositeMonograph, SWT.BORDER);
    textFields[6] = new Text(compositeMonograph, SWT.BORDER);
    textFields[7] = new Text(compositeMonograph, SWT.BORDER);
    textFields[8] = new Text(compositeMonograph, SWT.BORDER);

    textFields[0].setBounds(180, 5, 470, 19);
    textFields[1].setBounds(180, 25, 470, 19);
    textFields[2].setBounds(180, 45, 470, 19);
    textFields[3].setBounds(181, 66, 468, 37);
    textFields[4].setBounds(180, 105, 470, 19);
    textFields[5].setBounds(180, 125, 470, 19);
    textFields[6].setBounds(180, 145, 470, 19);
    textFields[7].setBounds(180, 165, 470, 19);
    textFields[8].setBounds(180, 185, 470, 19);

    Button buttonCreate = new Button(compositeMonograph, SWT.NONE);
    buttonCreate.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
      }
    });
    buttonCreate.setBounds(539, 205, 113, 28);
    buttonCreate.setText("Erzeugen");

    Button buttonDeleteRecords = new Button(compositeMonograph, SWT.NONE);
    buttonDeleteRecords.setEnabled(false);
    buttonDeleteRecords.setText("Löschen");
    buttonDeleteRecords.setBounds(420, 205, 113, 28);
    buttonCreate.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        switch (e.type) {
        case SWT.Selection:
          if (textFields[0].getText().equals("") || textFields[1].getText().equals("")
              || textFields[2].getText().equals("") || textFields[3].getText().equals("")
              || textFields[7].getText().equals("") || textFields[8].getText().equals("")) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          if (!textFields[2].getText().equals("")) {
            try {
              Integer.parseInt(textFields[2].getText());
            } catch (NumberFormatException ex) {
              MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
              messageBox.setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
              messageBox.open();
              break;
            }
          }
          if (!textFields[6].getText().equals("")) {
            try {
              Integer.parseInt(textFields[6].getText());
            } catch (NumberFormatException ex) {
              MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
              messageBox.setMessage("Bitte geben Sie die Auflage in Form einer Ganzzahl an.");
              messageBox.open();
              break;
            }
          }

          Monograph lit = new Monograph(textFields[0].getText(), textFields[1].getText(),
              textFields[2].getText(), textFields[3].getText(), textFields[4].getText(),
              textFields[5].getText(), textFields[6].getText(), textFields[7].getText(),
              textFields[8].getText());

          String res = lit.toString();
          setText(buttonCopyOutputToClipboard, res);
          break;
        }
      }
    });

    TabItem tabCollectedEdition = new TabItem(tabFolder, SWT.NONE);
    tabCollectedEdition.setText("Sammelwerk");

    Composite compositeCollectedEdition = new Composite(tabFolder, SWT.NONE);
    tabCollectedEdition.setControl(compositeCollectedEdition);

    Label label = new Label(compositeCollectedEdition, SWT.NONE);
    label.setText("Name");
    label.setBounds(10, 10, 59, 14);

    Label label_11 = new Label(compositeCollectedEdition, SWT.NONE);
    label_11.setText("Vorname");
    label_11.setBounds(10, 30, 59, 14);

    Label label_12 = new Label(compositeCollectedEdition, SWT.NONE);
    label_12.setText("Jahr");
    label_12.setBounds(10, 50, 59, 14);

    Label contributionTitle = new Label(compositeCollectedEdition, SWT.NONE);
    contributionTitle.setText("Titel des Beitrags");
    contributionTitle.setBounds(10, 70, 114, 20);

    Label labelNameOfPublisher = new Label(compositeCollectedEdition, SWT.NONE);
    labelNameOfPublisher.setText("Vorname Name (Hrsg.)");
    labelNameOfPublisher.setBounds(10, 90, 207, 20);

    Label labelTitle_1 = new Label(compositeCollectedEdition, SWT.NONE);
    labelTitle_1.setText("Titel");
    labelTitle_1.setBounds(10, 110, 59, 14);

    Label labelBinding_1 = new Label(compositeCollectedEdition, SWT.NONE);
    labelBinding_1.setText("ggf. Bindung");
    labelBinding_1.setBounds(10, 130, 107, 20);

    Label labelEdition_2 = new Label(compositeCollectedEdition, SWT.NONE);
    labelEdition_2.setText("ggf. Auflage");
    labelEdition_2.setBounds(10, 150, 137, 20);

    Label labelPlace_1 = new Label(compositeCollectedEdition, SWT.NONE);
    labelPlace_1.setText("Ort");
    labelPlace_1.setBounds(10, 170, 59, 14);

    textFields[36] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[38] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[39] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[40] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[41] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[42] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[43] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[44] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[45] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[47] = new Text(compositeCollectedEdition, SWT.BORDER);
    textFields[48] = new Text(compositeCollectedEdition, SWT.BORDER);

    textFields[36].setBounds(180, 5, 470, 19);
    textFields[38].setBounds(180, 25, 470, 19);
    textFields[39].setBounds(180, 45, 470, 19);
    textFields[40].setBounds(180, 65, 470, 19);
    textFields[41].setBounds(180, 85, 470, 19);
    textFields[42].setBounds(180, 105, 470, 19);
    textFields[43].setBounds(180, 125, 470, 19);
    textFields[44].setBounds(180, 145, 470, 19);
    textFields[45].setBounds(180, 165, 470, 19);
    textFields[47].setBounds(180, 185, 470, 19);
    textFields[48].setBounds(180, 205, 351, 19);

    Button button_3 = new Button(compositeCollectedEdition, SWT.NONE);
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
          if (textFields[36].getText().equals("") || textFields[38].getText().equals("")
              || textFields[39].getText().equals("") || textFields[40].getText().equals("")
              || textFields[41].getText().equals("") || textFields[42].getText().equals("")
              || textFields[45].getText().equals("") || textFields[47].getText().equals("")
              || textFields[48].getText().equals("")) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[39].getText());
            if (!textFields[44].getText().endsWith(""))
              Integer.parseInt(textFields[44].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte geben Sie eine gültige Zahl als Jahr und ggf. als Auflage an.");
            messageBox.open();
            break;
          }
          CollectedEdition lit = new CollectedEdition(textFields[36].getText(), textFields[38].getText(),
              textFields[39].getText(), textFields[40].getText(), textFields[41].getText(),
              textFields[42].getText(), textFields[43].getText(), textFields[44].getText(),
              textFields[45].getText(), textFields[47].getText(), textFields[48].getText());

          String res = lit.toString();
          setText(buttonCopyOutputToClipboard, res);
        }
      }
    });

    Label labelPress_1 = new Label(compositeCollectedEdition, SWT.NONE);
    labelPress_1.setText("Verlag");
    labelPress_1.setBounds(10, 190, 59, 20);

    Label labelPageSector_1 = new Label(compositeCollectedEdition, SWT.NONE);
    labelPageSector_1.setText("Seitenbereich");
    labelPageSector_1.setBounds(10, 210, 99, 14);

    TabItem tabCompleteWorks = new TabItem(tabFolder, SWT.NONE);
    tabCompleteWorks.setText("Gesamtausgabe");

    Composite compositeCompleteWorks = new Composite(tabFolder, SWT.NONE);
    tabCompleteWorks.setControl(compositeCompleteWorks);

    Label label_13 = new Label(compositeCompleteWorks, SWT.NONE);
    label_13.setText("Name");
    label_13.setBounds(10, 10, 59, 14);

    Label label_14 = new Label(compositeCompleteWorks, SWT.NONE);
    label_14.setText("Vorname");
    label_14.setBounds(10, 30, 59, 14);

    Label label_15 = new Label(compositeCompleteWorks, SWT.NONE);
    label_15.setText("Jahr");
    label_15.setBounds(10, 50, 59, 14);

    Label labelTitleOfVolume = new Label(compositeCompleteWorks, SWT.NONE);
    labelTitleOfVolume.setText("Titel des Bandes");
    labelTitleOfVolume.setBounds(10, 70, 145, 14);

    Label label_17 = new Label(compositeCompleteWorks, SWT.NONE);
    label_17.setText("ggf. Vorname Name (Hrsg.)");
    label_17.setBounds(10, 90, 207, 20);

    Label labelBinding_2 = new Label(compositeCompleteWorks, SWT.NONE);
    labelBinding_2.setText("Bindung");
    labelBinding_2.setBounds(10, 110, 107, 20);

    Label label_19 = new Label(compositeCompleteWorks, SWT.NONE);
    label_19.setText("ggf. Auflage");
    label_19.setBounds(10, 130, 107, 20);

    Label label_20 = new Label(compositeCompleteWorks, SWT.NONE);
    label_20.setText("Ort");
    label_20.setBounds(10, 150, 59, 14);

    Label label_21 = new Label(compositeCompleteWorks, SWT.NONE);
    label_21.setText("Verlag");
    label_21.setBounds(10, 170, 59, 20);

    textFields[49] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[50] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[51] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[52] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[53] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[54] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[55] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[56] = new Text(compositeCompleteWorks, SWT.BORDER);
    textFields[57] = new Text(compositeCompleteWorks, SWT.BORDER);

    textFields[49].setBounds(180, 5, 470, 19);
    textFields[50].setBounds(180, 25, 470, 19);
    textFields[51].setBounds(180, 45, 470, 19);
    textFields[52].setBounds(180, 65, 470, 19);
    textFields[53].setBounds(180, 85, 470, 19);
    textFields[54].setBounds(180, 105, 470, 19);
    textFields[55].setBounds(180, 125, 470, 19);
    textFields[56].setBounds(180, 145, 470, 19);
    textFields[57].setBounds(180, 165, 351, 19);

    Button button_4 = new Button(compositeCompleteWorks, SWT.NONE);
    button_4.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
      }
    });
    button_4.setText("Erzeugen");
    button_4.setBounds(537, 163, 113, 28);
    
    button_4.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        switch (e.type) {
        case SWT.Selection:
          if (textFields[49].getText().equals("") || textFields[50].getText().equals("")
              || textFields[51].getText().equals("") || textFields[52].getText().equals("")
              || textFields[53].getText().equals("") || textFields[54].getText().equals("")
              || textFields[55].getText().equals("") || textFields[56].getText().equals("")
              || textFields[57].getText().equals("")) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[51].getText());
            if (!textFields[55].getText().endsWith(""))
              Integer.parseInt(textFields[55].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte geben Sie eine gültige Zahl als Jahr und ggf. als Auflage an.");
            messageBox.open();
            break;
          }
          CompleteWorks lit = new CompleteWorks(textFields[49].getText(), textFields[50].getText(), textFields[51].getText(), textFields[52].getText(), textFields[53].getText(), textFields[54].getText(), textFields[55].getText(), textFields[56].getText(), textFields[57].getText());
  
          String res = lit.toString();
          setText(buttonCopyOutputToClipboard, res);
        }
      }
    });

    TabItem tabInternet = new TabItem(tabFolder, SWT.NONE);
    tabInternet.setText("Internet");

    Composite compositeInternet = new Composite(tabFolder, SWT.NONE);
    tabInternet.setControl(compositeInternet);

    Label labelNameOrCompany = new Label(compositeInternet, SWT.NONE);
    labelNameOrCompany.setText("Name oder Firma");
    labelNameOrCompany.setBounds(10, 10, 156, 14);

    Label label_1 = new Label(compositeInternet, SWT.NONE);
    label_1.setText("Vorname");
    label_1.setBounds(10, 30, 59, 14);

    Label label_2 = new Label(compositeInternet, SWT.NONE);
    label_2.setText("Jahr");
    label_2.setBounds(10, 50, 59, 14);

    Label label_3 = new Label(compositeInternet, SWT.NONE);
    label_3.setText("Titel");
    label_3.setBounds(10, 70, 59, 14);

    textFields[11] = new Text(compositeInternet, SWT.BORDER);
    textFields[12] = new Text(compositeInternet, SWT.BORDER);
    textFields[13] = new Text(compositeInternet, SWT.BORDER);
    textFields[14] = new Text(compositeInternet, SWT.BORDER);
    textFields[15] = new Text(compositeInternet, SWT.BORDER);
    textFields[17] = new Text(compositeInternet, SWT.BORDER);
    textFields[18] = new Text(compositeInternet, SWT.BORDER);
    textFields[19] = new Text(compositeInternet, SWT.BORDER);

    textFields[11].setBounds(180, 5, 470, 19);
    textFields[12].setBounds(180, 25, 470, 19);
    textFields[13].setBounds(180, 45, 470, 19);
    textFields[14].setBounds(180, 65, 470, 39);
    textFields[15].setBounds(180, 125, 59, 19);
    textFields[15].setText("" + cal.get(Calendar.DAY_OF_MONTH));
    textFields[17].setBounds(180, 105, 470, 19);
    textFields[18].setBounds(245, 125, 59, 19);
    textFields[18].setText("" + (cal.get(Calendar.MONTH) + 1));
    textFields[19].setBounds(310, 125, 59, 19);
    textFields[19].setText("" + cal.get(Calendar.YEAR));

    Button button = new Button(compositeInternet, SWT.NONE);
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
          if (textFields[14].getText().equals("") || textFields[17].getText().equals("")) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Die Felder 'Titel', 'Link' und 'Datum' dürfen nicht leer sein.");
            messageBox.open();
            break;
          }
          if (!textFields[13].getText().equals("")) {
            try {
              Integer.parseInt(textFields[13].getText());
            } catch (NumberFormatException ex) {
              MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
              messageBox.setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
              messageBox.open();
              break;
            }
          }
          if (textFields[15].getText().equals("") || textFields[15].getText().length() > 2
              || textFields[18].getText().equals("") || textFields[18].getText().length() > 2
              || textFields[19].getText().equals("") || textFields[19].getText().length() > 4) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte geben Sie das Datum korrekt an: TT MM JJJJ.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[15].getText());
            Integer.parseInt(textFields[18].getText());
            Integer.parseInt(textFields[19].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte geben Sie das Datum korrekt an: TT MM JJJJ.");
            messageBox.open();
            break;
          }

          Internet lit = new Internet(textFields[11].getText(), textFields[12].getText(),
              textFields[13].getText(), textFields[14].getText(), textFields[17].getText(),
              textFields[15].getText(), textFields[18].getText(), textFields[19].getText());

          String res = lit.toString();

          setText(buttonCopyOutputToClipboard, res);
          break;
        }
      }
    });

    Label labelDate = new Label(compositeInternet, SWT.NONE);
    labelDate.setText("TT.MM.JJJJ d. Abrufs");
    labelDate.setBounds(10, 130, 135, 14);

    Label labelLink = new Label(compositeInternet, SWT.NONE);
    labelLink.setText("Link");
    labelLink.setBounds(10, 110, 207, 14);

    Label label_16 = new Label(compositeInternet, SWT.NONE);
    label_16.setBounds(238, 130, 59, 14);
    label_16.setText(".");

    Label label_18 = new Label(compositeInternet, SWT.NONE);
    label_18.setText(".");
    label_18.setBounds(303, 130, 59, 14);

    TabItem tabMagazine = new TabItem(tabFolder, SWT.NONE);
    tabMagazine.setText("Zeitschrift");

    Composite compositeMagazine = new Composite(tabFolder, SWT.NONE);
    tabMagazine.setControl(compositeMagazine);

    Label label_8 = new Label(compositeMagazine, SWT.NONE);
    label_8.setText("Name");
    label_8.setBounds(10, 10, 59, 14);

    Label label_9 = new Label(compositeMagazine, SWT.NONE);
    label_9.setText("Vorname");
    label_9.setBounds(10, 30, 59, 14);

    Label label_10 = new Label(compositeMagazine, SWT.NONE);
    label_10.setText("Jahr");
    label_10.setBounds(10, 50, 59, 14);

    Label labelTitleOfArticle = new Label(compositeMagazine, SWT.NONE);
    labelTitleOfArticle.setText("Titel des Artikels");
    labelTitleOfArticle.setBounds(10, 70, 164, 14);

    Label labelTitleOfMagazine = new Label(compositeMagazine, SWT.NONE);
    labelTitleOfMagazine.setText("Titel der Zeitschrift");
    labelTitleOfMagazine.setBounds(10, 90, 207, 14);

    Label labelYear_2 = new Label(compositeMagazine, SWT.NONE);
    labelYear_2.setText("Jahrgang");
    labelYear_2.setBounds(10, 110, 59, 20);

    Label labelNumber = new Label(compositeMagazine, SWT.NONE);
    labelNumber.setText("Nummer");
    labelNumber.setBounds(10, 130, 107, 14);

    Label labelPageSector = new Label(compositeMagazine, SWT.NONE);
    labelPageSector.setText("Seitenbereich");
    labelPageSector.setBounds(10, 150, 164, 14);

    textFields[27] = new Text(compositeMagazine, SWT.BORDER);
    textFields[28] = new Text(compositeMagazine, SWT.BORDER);
    textFields[30] = new Text(compositeMagazine, SWT.BORDER);
    textFields[31] = new Text(compositeMagazine, SWT.BORDER);
    textFields[32] = new Text(compositeMagazine, SWT.BORDER);
    textFields[33] = new Text(compositeMagazine, SWT.BORDER);
    textFields[34] = new Text(compositeMagazine, SWT.BORDER);
    textFields[35] = new Text(compositeMagazine, SWT.BORDER);

    textFields[27].setBounds(180, 5, 470, 19);
    textFields[28].setBounds(180, 25, 470, 19);
    textFields[30].setBounds(180, 45, 470, 19);
    textFields[31].setBounds(180, 65, 470, 19);
    textFields[32].setBounds(180, 85, 470, 19);
    textFields[33].setBounds(180, 105, 470, 19);
    textFields[34].setBounds(180, 125, 470, 19);
    textFields[35].setBounds(180, 145, 351, 19);

    Button button_2 = new Button(compositeMagazine, SWT.NONE);
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
          if (textFields[27].getText().equals("") || textFields[28].getText().equals("")
              || textFields[30].getText().equals("") || textFields[31].getText().equals("")
              || textFields[32].getText().equals("") || textFields[33].getText().equals("")
              || textFields[34].getText().equals("") || textFields[35].getText().equals("")) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[33].getText());
            Integer.parseInt(textFields[34].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte geben Sie gültige Zahlen als Jahr und Nummer an.");
            messageBox.open();
            break;
          }
          Magazine lit = new Magazine(textFields[27].getText(), textFields[28].getText(),
              textFields[30].getText(), textFields[31].getText(), textFields[32].getText(),
              textFields[33].getText(), textFields[34].getText(), textFields[35].getText());

          String res = lit.toString();

          setText(buttonCopyOutputToClipboard, res);
          break;
        }
      }
    });

    TabItem tabAcademicPaper = new TabItem(tabFolder, SWT.NONE);
    tabAcademicPaper.setText("wiss. Arbeit");

    Composite compositeAcademicPaper = new Composite(tabFolder, SWT.NONE);
    tabAcademicPaper.setControl(compositeAcademicPaper);

    Label label_4 = new Label(compositeAcademicPaper, SWT.NONE);
    label_4.setText("Name");
    label_4.setBounds(10, 10, 59, 14);

    Label label_5 = new Label(compositeAcademicPaper, SWT.NONE);
    label_5.setText("Vorname");
    label_5.setBounds(10, 30, 59, 14);

    Label label_6 = new Label(compositeAcademicPaper, SWT.NONE);
    label_6.setText("Jahr");
    label_6.setBounds(10, 50, 59, 14);

    Label label_7 = new Label(compositeAcademicPaper, SWT.NONE);
    label_7.setText("Titel");
    label_7.setBounds(10, 70, 59, 14);

    Label labelFormOfPaper = new Label(compositeAcademicPaper, SWT.NONE);
    labelFormOfPaper.setText("Form der Arbeit");
    labelFormOfPaper.setBounds(10, 90, 207, 14);

    Label labelSubject = new Label(compositeAcademicPaper, SWT.NONE);
    labelSubject.setText("Fach");
    labelSubject.setBounds(10, 110, 59, 14);

    Label labelInstitution = new Label(compositeAcademicPaper, SWT.NONE);
    labelInstitution.setText("Bildungseinrichtung");
    labelInstitution.setBounds(10, 130, 155, 20);

    textFields[16] = new Text(compositeAcademicPaper, SWT.BORDER);
    textFields[21] = new Text(compositeAcademicPaper, SWT.BORDER);
    textFields[22] = new Text(compositeAcademicPaper, SWT.BORDER);
    textFields[23] = new Text(compositeAcademicPaper, SWT.BORDER);
    textFields[24] = new Text(compositeAcademicPaper, SWT.BORDER);
    textFields[25] = new Text(compositeAcademicPaper, SWT.BORDER);
    textFields[26] = new Text(compositeAcademicPaper, SWT.BORDER);

    textFields[16].setBounds(180, 5, 470, 19);
    textFields[21].setBounds(180, 25, 470, 19);
    textFields[22].setBounds(180, 45, 470, 19);
    textFields[23].setBounds(180, 65, 470, 19);
    textFields[24].setBounds(180, 85, 470, 19);
    textFields[25].setBounds(180, 105, 470, 19);
    textFields[26].setBounds(180, 125, 351, 19);

    Button button_1 = new Button(compositeAcademicPaper, SWT.NONE);
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
          if (textFields[16].getText().equals("") || textFields[21].getText().equals("")
              || textFields[22].getText().equals("") || textFields[23].getText().equals("")
              || textFields[24].getText().equals("") || textFields[25].getText().equals("")
              || textFields[26].getText().equals("")) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte machen Sie alle notwendigen Angaben.");
            messageBox.open();
            break;
          }
          try {
            Integer.parseInt(textFields[22].getText());
          } catch (NumberFormatException ex) {
            MessageBox messageBox = new MessageBox(bibliographyShell, SWT.ICON_INFORMATION | SWT.OK);
            messageBox.setMessage("Bitte geben Sie eine gültige Zahl als Jahr an.");
            messageBox.open();
            break;
          }
          AcademicPaper lit = new AcademicPaper(textFields[16].getText(), textFields[21].getText(),
              textFields[22].getText(), textFields[23].getText(), textFields[24].getText(),
              textFields[25].getText(), textFields[26].getText(), "");

          String res = lit.toString();

          setText(buttonCopyOutputToClipboard, res);
          break;
        }
      }
    });

    TabItem tabMovie = new TabItem(tabFolder, SWT.NONE);
    tabMovie.setText("Film");
    buttonSearch.addListener(SWT.Selection, new Listener() {
      public void handleEvent(Event e) {
        switch (e.type) {
        case SWT.Selection:

          FileDialog dialog = new FileDialog(bibliographyShell, SWT.SAVE);
          dialog.setFilterNames(new String[] { "Textdatei", "All Files (*.txt)" });
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
      java.awt.datatransfer.Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      clipboard.setContents(select, select);
    }
  }
}
