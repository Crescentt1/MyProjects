import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    // TextArea
    JFrame window = new JFrame();
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane;

    //TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    //FILE MENU
    Function_File functionFile = new Function_File(this);
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;


    //FORMAT MENU
    Function_Format functionFormat = new Function_Format(this);
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8,
              iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu menuFont, menuFontSize;
    Boolean wordWrapOn = false;

    // COLOR
    Function_Color functionColor = new Function_Color(this);
    JMenuItem iColor1, iColor2, iColor3, iColor4 ;

    // Edit
    Function_Edit funcEdit = new Function_Edit(this);
    JMenuItem iUndo, iRedo;
    UndoManager um = new UndoManager();

    KeyHandler kh = new KeyHandler(this);

    public GUI (){

        createWindow();
        createTextArea();
        createMenuBar();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        functionFormat.selectedFont = "Arial";
        functionFormat.createFont(16);
        functionFormat.wordWrap();

        functionColor.changeColor("White");
        window.setVisible(true);


    }

    public void createWindow()  {

        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void createTextArea(){

        textArea = new JTextArea();

        textArea.addKeyListener(kh);

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        window.add(scrollPane);

        //window.add(textArea);

    }

    public void createMenuBar(){

        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);


    }

    public void createEditMenu(){

        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);

    }

    public void createFormatMenu(){

        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);


        iFontCSMS = new JMenuItem("CSMS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("CSMS");
        menuFont.add(iFontCSMS);


        iFontTNR = new JMenuItem("TNR");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("TNR");
        menuFont.add(iFontTNR);


        menuFontSize = new JMenu("FontSize");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("Size8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("Size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("Size12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("Size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("Size16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("Size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("Size20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("Size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("Size24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("Size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("Size28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("Size28");
        menuFontSize.add(iFontSize28);


    }

    public void createColorMenu(){

        iColor4 = new JMenuItem("White");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("White");
        menuColor.add(iColor4);

        iColor1 = new JMenuItem("Blue");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("Blue");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Red");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Red");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Gold");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Gold");
        menuColor.add(iColor3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        switch(command){
            case "New":
                functionFile.newFile();
                break;

            case "Open":
                functionFile.open();
                break;

            case "Save":
                functionFile.save();
                break;

            case "SaveAs":
                functionFile.saveAs();
                break;

            case "Exit":
                functionFile.exit();
                break;

            case "Undo":
                funcEdit.undo();
                break;

            case "Redo":
                funcEdit.redo();
                break;

            case "Word Wrap":
                functionFormat.wordWrap();
                break;

            case "Arial":
                functionFormat.setFont(command);
                break;

            case "CSMS":
                functionFormat.setFont(command);
                break;

            case "TNR":
                functionFormat.setFont(command);
                break;

            case "Size8":
                functionFormat.createFont(8);
                break;

            case "Size12":
                functionFormat.createFont(12);
                break;

            case "Size16":
                functionFormat.createFont(16);
                break;

            case "Size20":
                functionFormat.createFont(20);
                break;

            case "Size24":
                functionFormat.createFont(24);
                break;

            case "Size28":
                functionFormat.createFont(28);
                break;

            case "White":
                functionColor.changeColor("White");
                break;

            case "Blue":
                functionColor.changeColor("Blue");
                break;

            case "Red":
                functionColor.changeColor("Red");
                break;

            case "Gold":
                functionColor.changeColor("Gold");
                break;
        }

    }
}
