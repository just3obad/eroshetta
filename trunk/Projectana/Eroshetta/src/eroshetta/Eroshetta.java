/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eroshetta;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import javax.persistence.*;
import javax.swing.*;

/**
 *
 * @author Mouaz
 */
public class Eroshetta extends javax.swing.JFrame {

    /**
     * Creates new form Eroshetta
     */
    final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("EroshettaPU");
    static EntityManager em = emf.createEntityManager();
    public static  DefaultListModel modelallDiagnoses;
    public static DefaultListModel modelAllDrugs;
    public static String host = "jdbc:derby://localhost:1527/eroshetta";
    public static String usrN = "APP";
    public static String usrP = "APP";
    public static int counterDiagnosis = 0;
    public static int counterDrugs = 0;
    public static int counterBoth = 0;
    public static int counterBoth2=0;
    public static int counterPatients=0;

    public static List<Drugs> allDrugs = new ArrayList<Drugs>();
    public static List<Diagnoses> allDiagnoses = new ArrayList<Diagnoses>();
    public static int whichEdit = 0;
    static Eroshetta eroshetta = new Eroshetta();
    public static List<Patients> patientsBookList ;
    public static Patients currentPatient;
    public static List<Drugs> currentPatienMedications;
    public static List<Diagnoses> currentPatienDiagnoses;
    public static DefaultListModel modelAllPatients;
    public static boolean saveFlag;
    public static int dayHazard;
    public static boolean tanak;

    
    

    public Eroshetta() {
        
        saveFlag=true;
        
        Query q = em.createNamedQuery("Patients.findAll");
        patientsBookList = (List<Patients>) q.getResultList();
        
           
        Query q2 = em.createNamedQuery("Diagnoses.findAll");
        allDiagnoses = (List<Diagnoses>) q2.getResultList();
        
        Query q3 = em.createNamedQuery("Drugs.findAll");
        allDrugs = (List<Drugs>) q3.getResultList();
        
//        System.out.println(patientsBookList.size());
//        System.out.println(allDrugs.size());
//        System.out.println(allDiagnoses.size());
        
        Eroshetta.modelAllPatients = new DefaultListModel();
        Eroshetta.modelallDiagnoses = new DefaultListModel();
        Eroshetta.modelAllDrugs = new DefaultListModel();
        
        
        currentPatient=patientsBookList.get(0);
        dayHazard=currentPatient.getBirthDate().getDate();
        
        initComponents();
        
        
       
        this.disableProfilePatient();
        jListPatientsBook.setSelectedIndex(0);
        
        Eroshetta.checkBoxTrade.setSelected(true);
        Eroshetta.checkBoxClass.setSelected(true);
        Eroshetta.checkBoxGeneric.setSelected(true);
        this.setLocation(200, 30);
        
        
//        JScrollPane scrollBar = new JScrollPane(drugProfile);
//        this.add(scrollBar);
//        


        //run methode
        this.jTextFieldSearchDrags.setText("");
        String query = this.jTextFieldSearchDrags.getText();
        final ArrayList<Drugs> finos = Eroshetta.drug_search(query);
        final ArrayList<String> s = new ArrayList();
        for (int i = 0; i < finos.size(); i++) {
//                this.jArrayList_Drugs.(finos.get(i).getTradeName());
            if (finos.get(i).getTradeName() != null || finos.get(i).getClassName() != null) {
                s.add(finos.get(i).getTradeName() + "(" + finos.get(i).getClassName() + ")");
            }

        }
        jList_Drugs.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return finos.size();
            }

            public Object getElementAt(int i) {
                return finos.get(i);
            }
        });
        try {
             // doctor attributes malaksh da3wa beha for prescription
        Query qr = em.createNamedQuery("Doctor.findAll");
        List <Doctor> tmpList = qr.getResultList();
        Doctor d = tmpList.get(0);
//        this.DoctorName.setText("Dr."+ d.getName());
//        this.DoctorAddresse.setText("Addresse : "+d.getAddress());
//        this.DoctorMobileNo.setText("Mobile no : "+d.getMobileNo().toString());
//        this.DoctorOfficeNo.setText("Office no : "+d.getOfficeNo().toString());
        // a5erha
        //for prescription
        this.DrugsInPrescription.setLayout(new java.awt.BorderLayout(1,100));
        
//        final javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridLayout(0,1));
//        javax.swing.JScrollPane editorScroll = new javax.swing.JScrollPane(panel);
//        editorScroll.setPreferredSize(new java.awt.Dimension(30,100));
//                this.DrugsInPrescription.add(editorScroll, java.awt.BorderLayout.EAST);
//        editorScroll.setVisible(true);
//        this.jPanelPrescription.add(editorScroll);
//        javax.swing.JScrollPane sp = new javax.swing.JScrollPane(jt);
        } catch (Exception e) {
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPanelPatientsBook = new javax.swing.JPanel();
        jScrollPanePatientsBook = new javax.swing.JScrollPane();
        jListPatientsBook = new javax.swing.JList();
        jTextFieldPatientsBook = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanelPatientProfile = new javax.swing.JPanel();
        jLabelPatientProfileName = new javax.swing.JLabel();
        jLabelPatientProfileGender = new javax.swing.JLabel();
        jLabelPatientProfileBirthday = new javax.swing.JLabel();
        jLabelPatientProfileMaritalStatus = new javax.swing.JLabel();
        jLabelPatientProfileHeight = new javax.swing.JLabel();
        jLabelPatientProfileWeight = new javax.swing.JLabel();
        jLabelPatientProfileBMI = new javax.swing.JLabel();
        jLabelPatientProfileCurrentMedication = new javax.swing.JLabel();
        jLabelPatientProfileDiagnosis = new javax.swing.JLabel();
        jTextFieldPatientProfileName = new javax.swing.JTextField();
        jComboBoxPatientProfileGender = new javax.swing.JComboBox();
        jComboBoxPatientProfileDay = new javax.swing.JComboBox();
        jComboBoxPatientProfileMonth = new javax.swing.JComboBox();
        jComboBoxPatientProfileYear = new javax.swing.JComboBox();
        jComboBoxPatientProfileMarital = new javax.swing.JComboBox();
        jComboBoxPatientProfilePregnant = new javax.swing.JComboBox();
        jTextFieldPatientProfileBMI = new javax.swing.JTextField();
        jTextFieldPatientProfileWeight = new javax.swing.JTextField();
        jTextFieldPatientProfileHeight = new javax.swing.JTextField();
        jLabelPatientProfileWeiightKG = new javax.swing.JLabel();
        jLabelPatientProfileHeightCM = new javax.swing.JLabel();
        jScrollPanePPDiagnosis = new javax.swing.JScrollPane();
        jListPPDiagnosis = new javax.swing.JList();
        jScrollPanePPMedication = new javax.swing.JScrollPane();
        jListPPM3edication = new javax.swing.JList();
        jScrollPanePPDiagnosisMedication = new javax.swing.JScrollPane();
        jListPPDiagnosisMedication = new javax.swing.JList();
        jTextFieldPPMedication = new javax.swing.JTextField();
        jLabelPPMedication = new javax.swing.JLabel();
        jToggleButtonPPMedication = new javax.swing.JToggleButton();
        jToggleButtonDiagnosis = new javax.swing.JToggleButton();
        jLabelPatientProfilePregnant = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabelBMIDesc = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanelPatientOldPresc = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        Panel_Drugs = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSearchDrags = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Drugs = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        drugProfile = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        drugTradeName = new javax.swing.JLabel();
        drugGenericNames = new javax.swing.JLabel();
        drugDosage = new javax.swing.JLabel();
        dosageForm = new javax.swing.JLabel();
        drugRoute = new javax.swing.JLabel();
        drugPrecautions = new javax.swing.JLabel();
        drugHalfLife = new javax.swing.JLabel();
        drugMajor = new javax.swing.JLabel();
        drugMinor = new javax.swing.JLabel();
        drugFoods = new javax.swing.JLabel();
        drugClassName = new javax.swing.JLabel();
        addToPresc = new javax.swing.JButton();
        checkBoxTrade = new javax.swing.JCheckBox();
        checkBoxClass = new javax.swing.JCheckBox();
        checkBoxGeneric = new javax.swing.JCheckBox();
        jPanelPrescription = new javax.swing.JPanel();
        savePreview = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        DrugsInPrescription = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        editDoctorProfile = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eroshetta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanelPatientsBook.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patients Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12))); // NOI18N

        jListPatientsBook.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        jListPatientsBook.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jListPatientsBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListPatientsBookMouseClicked(evt);
            }
        });
        jListPatientsBook.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListPatientsBookValueChanged(evt);
            }
        });
        jListPatientsBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jListPatientsBookKeyReleased(evt);
            }
        });
        jScrollPanePatientsBook.setViewportView(jListPatientsBook);
        jListPatientsBook.setModel(modelAllPatients);
        for (int i = 0; i < patientsBookList.size(); i++) {
            Patients p = patientsBookList.get(i);
            modelAllPatients.add(i, p.getName());
        }

        jTextFieldPatientsBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPatientsBookActionPerformed(evt);
            }
        });
        jTextFieldPatientsBook.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPatientsBookKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanelPatientsBookLayout = new javax.swing.GroupLayout(jPanelPatientsBook);
        jPanelPatientsBook.setLayout(jPanelPatientsBookLayout);
        jPanelPatientsBookLayout.setHorizontalGroup(
            jPanelPatientsBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPanePatientsBook, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
            .addComponent(jTextFieldPatientsBook)
        );
        jPanelPatientsBookLayout.setVerticalGroup(
            jPanelPatientsBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPatientsBookLayout.createSequentialGroup()
                .addComponent(jTextFieldPatientsBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPanePatientsBook))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(747, 618));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanelPatientProfile.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPatientProfileName.setText("Name:");

        jLabelPatientProfileGender.setText("Gender:");

        jLabelPatientProfileBirthday.setText("Birthday:");

        jLabelPatientProfileMaritalStatus.setText("Marital Status:");

        jLabelPatientProfileHeight.setText("Height:");

        jLabelPatientProfileWeight.setText("Weight:");

        jLabelPatientProfileBMI.setText("BMI:");

        jLabelPatientProfileCurrentMedication.setText("Current Medications:");

        jLabelPatientProfileDiagnosis.setText("Current Conditions:");

        jTextFieldPatientProfileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPatientProfileNameActionPerformed(evt);
            }
        });

        jComboBoxPatientProfileGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        jComboBoxPatientProfileGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientProfileGenderActionPerformed(evt);
            }
        });

        DefaultComboBoxModel modelComboBoxDay = new DefaultComboBoxModel();
        jComboBoxPatientProfileDay.setModel(modelComboBoxDay
        );
        int year = Calendar.getInstance().get(Calendar.YEAR);
        for(int i=1; i<32; i++ ){
            modelComboBoxDay.addElement(i);
        }
        jComboBoxPatientProfileDay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxPatientProfileDayMouseClicked(evt);
            }
        });
        jComboBoxPatientProfileDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientProfileDayActionPerformed(evt);
            }
        });

        jComboBoxPatientProfileMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBoxPatientProfileMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientProfileMonthActionPerformed(evt);
            }
        });

        DefaultComboBoxModel modelComboBoxYear = new DefaultComboBoxModel();
        jComboBoxPatientProfileYear.setModel(modelComboBoxYear
        );
        for(int i=Calendar.getInstance().get(Calendar.YEAR); i>=1925; i--){
            modelComboBoxYear.addElement(i);
        }
        jComboBoxPatientProfileYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientProfileYearActionPerformed(evt);
            }
        });

        jComboBoxPatientProfileMarital.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Single", "Married" }));
        jComboBoxPatientProfileMarital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientProfileMaritalActionPerformed(evt);
            }
        });

        DefaultComboBoxModel pregnantComboModel = new DefaultComboBoxModel();
        jComboBoxPatientProfilePregnant.setModel(pregnantComboModel);
        pregnantComboModel.addElement("No");
        pregnantComboModel.addElement("Yes");
        jComboBoxPatientProfilePregnant.setVisible(false);
        jLabelPatientProfilePregnant.setVisible(false);
        jComboBoxPatientProfilePregnant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPatientProfilePregnantActionPerformed(evt);
            }
        });

        jTextFieldPatientProfileBMI.setEditable(false);
        jTextFieldPatientProfileBMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPatientProfileBMIActionPerformed(evt);
            }
        });

        jTextFieldPatientProfileWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPatientProfileWeightActionPerformed(evt);
            }
        });

        jTextFieldPatientProfileHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPatientProfileHeightActionPerformed(evt);
            }
        });

        jLabelPatientProfileWeiightKG.setText("Kg.");

        jLabelPatientProfileHeightCM.setText("cm.");

        jListPPDiagnosis.setEnabled(false);
        jListPPDiagnosis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jListPPDiagnosisMouseReleased(evt);
            }
        });
        jScrollPanePPDiagnosis.setViewportView(jListPPDiagnosis);

        jListPPM3edication.setEnabled(false);
        jListPPM3edication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jListPPM3edicationMouseReleased(evt);
            }
        });
        jScrollPanePPMedication.setViewportView(jListPPM3edication);

        jScrollPanePPDiagnosisMedication.setVisible(false);

        jListPPDiagnosisMedication.setVisible(false);
        jListPPDiagnosisMedication.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jListPPDiagnosisMedicationMouseReleased(evt);
            }
        });
        jScrollPanePPDiagnosisMedication.setViewportView(jListPPDiagnosisMedication);
        for(int i=0; i<allDiagnoses.size();i++){
            Diagnoses d = allDiagnoses.get(i);
            modelallDiagnoses.add(i, d.getName());
        }

        for(int i=0; i<allDrugs.size();i++){
            Drugs d = allDrugs.get(i);
            modelAllDrugs.add(i, d.getTradeName()+"("+d.getClassName()+")");
        }

        jTextFieldPPMedication.setVisible(false);
        jTextFieldPPMedication.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPPMedicationKeyReleased(evt);
            }
        });

        jLabelPPMedication.setVisible(false);
        jLabelPPMedication.setText("Search:");

        jToggleButtonPPMedication.setText("Edit");
        jToggleButtonPPMedication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonPPMedicationActionPerformed(evt);
            }
        });

        jToggleButtonDiagnosis.setText("Edit");
        jToggleButtonDiagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonDiagnosisActionPerformed(evt);
            }
        });

        jLabelPatientProfilePregnant.setText("Pregnant:");

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.setAutoscrolls(true);
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabelBMIDesc.setText("BMI");
        jLabelBMIDesc.setVisible(false);

        javax.swing.GroupLayout jPanelPatientProfileLayout = new javax.swing.GroupLayout(jPanelPatientProfile);
        jPanelPatientProfile.setLayout(jPanelPatientProfileLayout);
        jPanelPatientProfileLayout.setHorizontalGroup(
            jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                        .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelPatientProfileBMI)
                                .addComponent(jLabelPatientProfileWeight)
                                .addComponent(jLabelPatientProfileMaritalStatus)
                                .addComponent(jLabelPatientProfileGender)
                                .addComponent(jLabelPatientProfileCurrentMedication, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelPatientProfileName)
                                .addComponent(jLabelPatientProfileDiagnosis)
                                .addComponent(jLabelPatientProfileBirthday))
                            .addComponent(jScrollPanePPDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPanePPMedication, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addComponent(jToggleButtonPPMedication, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPPMedication))
                            .addComponent(jComboBoxPatientProfileGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addComponent(jComboBoxPatientProfileDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPatientProfileMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPatientProfileYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addComponent(jComboBoxPatientProfileMarital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPatientProfilePregnant)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPatientProfilePregnant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addComponent(jTextFieldPatientProfileWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPatientProfileWeiightKG)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPatientProfileHeight)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPatientProfileHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPatientProfileHeightCM))
                            .addComponent(jTextFieldPatientProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jToggleButtonDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPatientProfileBMI, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBMIDesc)
                                    .addComponent(jLabelPPMedication)
                                    .addComponent(jScrollPanePPDiagnosisMedication, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPatientProfileLayout.setVerticalGroup(
            jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatientProfileName)
                    .addComponent(jTextFieldPatientProfileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatientProfileGender)
                    .addComponent(jComboBoxPatientProfileGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatientProfileBirthday)
                    .addComponent(jComboBoxPatientProfileDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPatientProfileMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPatientProfileYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatientProfileMaritalStatus)
                    .addComponent(jComboBoxPatientProfileMarital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxPatientProfilePregnant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPatientProfilePregnant))
                .addGap(18, 18, 18)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPatientProfileWeight)
                    .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPatientProfileWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPatientProfileHeight)
                        .addComponent(jTextFieldPatientProfileHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPatientProfileWeiightKG)
                        .addComponent(jLabelPatientProfileHeightCM)))
                .addGap(6, 6, 6)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatientProfileBMI)
                    .addComponent(jTextFieldPatientProfileBMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBMIDesc))
                .addGap(18, 18, 18)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPatientProfileCurrentMedication)
                    .addComponent(jLabelPPMedication))
                .addGap(8, 8, 8)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                        .addComponent(jScrollPanePPMedication, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabelPatientProfileDiagnosis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPanePPDiagnosis, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                        .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButtonPPMedication)
                            .addComponent(jTextFieldPPMedication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jToggleButtonDiagnosis))
                            .addGroup(jPanelPatientProfileLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPanePPDiagnosisMedication)))))
                .addGap(18, 18, 18)
                .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanelPatientProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        jPanelPatientOldPresc.setBorder(javax.swing.BorderFactory.createTitledBorder("Old Prescriptions"));

        javax.swing.GroupLayout jPanelPatientOldPrescLayout = new javax.swing.GroupLayout(jPanelPatientOldPresc);
        jPanelPatientOldPresc.setLayout(jPanelPatientOldPrescLayout);
        jPanelPatientOldPrescLayout.setHorizontalGroup(
            jPanelPatientOldPrescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        jPanelPatientOldPrescLayout.setVerticalGroup(
            jPanelPatientOldPrescLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(jPanelPatientOldPresc);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPatientProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPatientProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Patient Profile", jPanel3);

        Panel_Drugs.setMaximumSize(new java.awt.Dimension(291, 586));
        Panel_Drugs.setMinimumSize(new java.awt.Dimension(291, 586));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Drugs");

        jTextFieldSearchDrags.setText("jTextField1");
        jTextFieldSearchDrags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchDragsActionPerformed(evt);
            }
        });
        jTextFieldSearchDrags.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchDragsKeyReleased(evt);
            }
        });

        jList_Drugs.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList_Drugs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_DrugsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList_Drugs);

        drugProfile.setBorder(javax.swing.BorderFactory.createTitledBorder("Drug profile"));
        drugProfile.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel2.setText("Class name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel3.setText("Trade name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel4.setText("Dosage:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel5.setText("Dosage form:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel6.setText("Route of elimination:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel7.setText("Precautions:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel8.setText("Half life:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel9.setText("Generic names:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel10.setText("Major side effects:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel11.setText("Minor side effects:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel12.setText("Food Interactions:");

        drugTradeName.setText("                       ");

        drugGenericNames.setText("                 ");

        drugDosage.setText("                    ");

        dosageForm.setText("                 ");

        drugRoute.setText("               ");

        drugPrecautions.setText("                  ");

        drugHalfLife.setText("                 ");

        drugMajor.setText("                 ");

        drugMinor.setText("               ");

        drugFoods.setText("                  ");

        drugClassName.setText("                                     ");

        addToPresc.setText("Add to Prescription");
        addToPresc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToPrescMouseClicked(evt);
            }
        });
        addToPresc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToPrescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout drugProfileLayout = new javax.swing.GroupLayout(drugProfile);
        drugProfile.setLayout(drugProfileLayout);
        drugProfileLayout.setHorizontalGroup(
            drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drugProfileLayout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(drugProfileLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drugTradeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(73, 73, 73))
            .addGroup(drugProfileLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(drugClassName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(45, 45, 45))
            .addGroup(drugProfileLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addToPresc, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(drugProfileLayout.createSequentialGroup()
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(drugProfileLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drugFoods, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugMinor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugMajor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugHalfLife, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugGenericNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugDosage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dosageForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(drugRoute, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(drugPrecautions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        drugProfileLayout.setVerticalGroup(
            drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drugProfileLayout.createSequentialGroup()
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13)
                    .addComponent(drugClassName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(drugTradeName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(drugGenericNames))
                .addGap(2, 2, 2)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(drugDosage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dosageForm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(drugRoute))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(drugPrecautions))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(drugHalfLife))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(drugMajor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(drugMinor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drugProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(drugFoods))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(addToPresc)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(drugProfile);

        checkBoxTrade.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        checkBoxTrade.setText("Trade Name");

        checkBoxClass.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        checkBoxClass.setText("Class Name");

        checkBoxGeneric.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        checkBoxGeneric.setText("Generic Name");

        javax.swing.GroupLayout Panel_DrugsLayout = new javax.swing.GroupLayout(Panel_Drugs);
        Panel_Drugs.setLayout(Panel_DrugsLayout);
        Panel_DrugsLayout.setHorizontalGroup(
            Panel_DrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DrugsLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1)
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addComponent(jTextFieldSearchDrags, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Panel_DrugsLayout.createSequentialGroup()
                .addComponent(checkBoxTrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxClass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxGeneric)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Panel_DrugsLayout.setVerticalGroup(
            Panel_DrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DrugsLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldSearchDrags, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_DrugsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxTrade)
                    .addComponent(checkBoxClass)
                    .addComponent(checkBoxGeneric))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanelPrescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelPrescription.setAutoscrolls(true);
        jPanelPrescription.setMaximumSize(new java.awt.Dimension(226, 114));
        jPanelPrescription.setMinimumSize(new java.awt.Dimension(226, 114));

        savePreview.setText("Preview for saving and printing");
        savePreview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savePreviewMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel14.setText("Notes : ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setDocument(new JTextFieldLimit(62));
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTextArea1);

        DrugsInPrescription.setBorder(javax.swing.BorderFactory.createTitledBorder("Drugs"));
        DrugsInPrescription.setAutoscrolls(true);
        DrugsInPrescription.setMaximumSize(new java.awt.Dimension(12, 27));
        DrugsInPrescription.setMinimumSize(new java.awt.Dimension(12, 27));
        DrugsInPrescription.setLayout(new java.awt.GridLayout(5, 0));
        jScrollPane4.setViewportView(DrugsInPrescription);

        javax.swing.GroupLayout jPanelPrescriptionLayout = new javax.swing.GroupLayout(jPanelPrescription);
        jPanelPrescription.setLayout(jPanelPrescriptionLayout);
        jPanelPrescriptionLayout.setHorizontalGroup(
            jPanelPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrescriptionLayout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(savePreview)
                .addGap(33, 33, 33))
            .addGroup(jPanelPrescriptionLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addContainerGap())
            .addComponent(jScrollPane3)
            .addComponent(jScrollPane4)
        );
        jPanelPrescriptionLayout.setVerticalGroup(
            jPanelPrescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrescriptionLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(savePreview))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel15.setText("New Prescription");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jLabel15)
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addGap(27, 27, 27)
                .addComponent(Panel_Drugs, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Drugs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("New Prescription", jPanel5);

        fileMenu.setText("File");
        jMenuBar2.add(fileMenu);

        editMenu.setText("Edit");

        editDoctorProfile.setText("Profile");
        editDoctorProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDoctorProfileActionPerformed(evt);
            }
        });
        editMenu.add(editDoctorProfile);

        jMenuBar2.add(editMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelPatientsBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPatientsBook, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Kareem
    public void oldPrescriptions()
    {
        
        try {
            //Sorry ya kemo 3al try wl catch di
            
              jPanelPatientOldPresc.removeAll();
        jPanelPatientOldPresc.repaint();
        jPanelPatientOldPresc.setLayout(new java.awt.GridLayout(10, 0));
        JButton  oldP;
        for(int i=0; i<currentPatient.getPrescriptionsCollection().size(); i++)
        {
            final Prescriptions p = (Prescriptions) currentPatient.getPrescriptionsCollection().toArray()[i];
            oldP = new JButton(p.getDate()+"");
            oldP.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e)
            {
              PrescriptionView prescView = new PrescriptionView(p);
              PrescriptionFrame prescFrame = new PrescriptionFrame(prescView);
              prescFrame.saveFlag = false;
              prescFrame.setVisible(true);
            }});
//            oldP.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY, i,true));
            jPanelPatientOldPresc.add(oldP);
           
        }
            
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
            
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jListPatientsBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jListPatientsBookKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jListPatientsBookKeyReleased

    private void jTextFieldPatientsBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPatientsBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPatientsBookActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public static ArrayList<Drugs> drug_search(String s) {

        //inserting all names in ArrayLists to search with piriority
//        em.getTransaction().begin();
//        Drugs example = new Drugs();
//        example.setClassName("class Name");
//        example.setClassName("trade Name");
//        example.setClassName("generic Name");
//        em.persist(example);
        ArrayList<String> tradeNames = new ArrayList();
        ArrayList<String> genericNames = new ArrayList();
        ArrayList<String> classNames = new ArrayList();
        Query q = em.createNamedQuery("Drugs.findAll");
        List<Drugs> allDrugsList = q.getResultList();
        ArrayList<Drugs> allDrugs = new ArrayList();
        allDrugs.addAll(allDrugsList);
        for (int i = 0; i < allDrugs.size(); i++) {
            tradeNames.add(allDrugs.get(i).getTradeName());
            classNames.add(allDrugs.get(i).getClassName());

            q = em.createNamedQuery("GenericNames.findByDrugId").setParameter("drugId", allDrugs.get(i).getId());
            List<GenericNames> tmpList = q.getResultList();
            ArrayList<GenericNames> tmp = new ArrayList();
            tmp.addAll(tmpList);
//        g = l.get(i).getGenericNames();
            for (int j = 0; j < tmp.size(); j++) {
                genericNames.add(tmp.get(j).getGenericNamesPK().getGenericName());
            }
        }
//        System.out.println("trade names : " + tradeNames);
//        System.out.println("class names : " + classNames);
//        System.out.println("generic names : " + genericNames);
        //stop ArrayListing
        ArrayList<String> tradeNamesTopResults = new <String>ArrayList();
        tradeNamesTopResults = Eroshetta.topResults(s, tradeNames);
        ArrayList<String> classNamesTopResults = new <String>ArrayList();
        classNamesTopResults = Eroshetta.topResults(s, classNames);
        ArrayList<String> genericNamesTopResults = new <String>ArrayList();
        genericNamesTopResults = Eroshetta.topResults(s, genericNames);
        ArrayList<Drugs> drugsTopWithTradeName = new <Drugs>ArrayList();
        ArrayList<Drugs> drugsTopWithClassName = new <Drugs>ArrayList();
        ArrayList<Drugs> drugsTopWithGenericNames = new <Drugs>ArrayList();
        ArrayList<GenericNames> drugsWithCertainGeneric = new <Drugs>ArrayList();

        if (tradeNamesTopResults != null && Eroshetta.checkBoxTrade.isSelected()) {
            for (int b = 0; b < tradeNamesTopResults.size(); b++) {
                q = em.createNamedQuery("Drugs.findByTradeName").setParameter("tradeName", tradeNamesTopResults.get(b));
//            ArrayList<Drugs> resultSet = q.getResultArrayList();
                drugsTopWithTradeName.addAll(q.getResultList());
            }
        }
        if (classNamesTopResults != null  && Eroshetta.checkBoxClass.isSelected()) {
            for (int b = 0; b < classNamesTopResults.size(); b++) {
                q = em.createNamedQuery("Drugs.findByClassName").setParameter("className", classNamesTopResults.get(b));
                drugsTopWithClassName.addAll(q.getResultList());
            }
        }
        if (genericNamesTopResults != null  && Eroshetta.checkBoxGeneric.isSelected()  ) {
            for (int b = 0; b < genericNamesTopResults.size(); b++) {
                q = em.createNamedQuery("GenericNames.findByGenericName").setParameter("genericName", genericNamesTopResults.get(b));
                List<GenericNames> drugsWithCertainGenericList = q.getResultList();
                drugsWithCertainGeneric.addAll(drugsWithCertainGenericList);
                for (int e = 0; e < drugsWithCertainGeneric.size(); e++) {
                    Drugs d = em.find(Drugs.class, drugsWithCertainGeneric.get(e).getGenericNamesPK().getDrugId());
                    drugsTopWithGenericNames.add(d);
                }
            }
        }

        ArrayList<Drugs> finalResult = new ArrayList();
        if (drugsTopWithGenericNames != null) {
            drugsTopWithClassName.addAll(drugsTopWithGenericNames);
        }
        if (drugsTopWithClassName != null) {
            drugsTopWithTradeName.addAll(drugsTopWithClassName);
        }
//            if(drugsTopWithTradeName != null){
        finalResult.addAll(drugsTopWithTradeName);
//            }
//            if(allDrugs != new ArrayList()){
//        finalResult.addAll(allDrugs);
//            }
        for (int o = 0; o < finalResult.size(); o++) {
            Drugs nowDrug = finalResult.get(o);
//             int existenceAndIndex = 0;
//           if(finalResult.size()!=allDrugs.size()){
//            System.out.println("nowDrug ID" + o);
            for (int i = finalResult.size() - 1; i > o; i--) {
                if (finalResult.get(i).getId() == nowDrug.getId()) {
                    finalResult.remove(i);
//                    System.out.println("the index wich" + i);
                }
            }
//            System.out.println(finalResult);
//                   if(finalResult.subList(o+1, finalResult.size()).contains(nowDrug)){
//                   finalResult.remove(nowDrug);
//                   
//               }

//               }

//           }
        }

//        }catch(NullPointerException e){
//            System.out.println("Searching>>")
//        }
//         System.out.println("trade names : "+tradeNamesTopResults);
//         System.out.println("class names : "+classNamesTopResults);
//         System.out.println("generic names : "+genericNamesTopResults);
        return finalResult;
    }

    public static ArrayList<String> topResults(String query, ArrayList<String> field) {
        ArrayList<String> match = new ArrayList();
//        System.out.println("fild is empty??" + field.isEmpty() + "with size" + field.size() + "and attributes" + field);
        if (field != null) {
//            System.out.println("ew3a ;)");
            for (int k = 0; k < field.size(); k++) {
                try {
                    if (query.equalsIgnoreCase(field.get(k).substring(0, query.length()))) {
//            if(field.get(k).contains(query)){
//                        System.out.print(query);
                        match.add(field.get(k));
                    }
                } catch (Exception e) {
                }

            }

//           if(match.size()<field.size()){
//               for(int a =0;a<field.size();a++){
//                   if(!match.contains(field.get(a))){
//                       match.add(field.get(a));
//                   }
//               }
//           }

        }
//        System.out.println("matched is " + match);
        return match;
    }
        private void jList_DrugsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                         
        // TODO add your handling code here:
         Drugs selectedDrug = (Drugs)this.jList_Drugs.getSelectedValue();
 
        javax.persistence.Query qGeneric =em.createNamedQuery("GenericNames.findByDrugId");
        qGeneric.setParameter("drugId",selectedDrug.getId());        
        List generics = qGeneric.getResultList();
        GenericNames generic;
        String genericNames = "";
        for(int i=0;i<generics.size();i++)
        {
            generic = (GenericNames) generics.get(i);
            genericNames = genericNames  + generic.getGenericNamesPK().getGenericName() + " " + generic.getConcentration() +", ";
        }
        
        Collection<SideEffects> sEffects = selectedDrug.getSideEffectsCollection();
        SideEffects sideEffect;
        String majorEffects = "";
        String minorEffects ="";
        for(int j=0; j<sEffects.size(); j++)
        {
            sideEffect = (SideEffects) sEffects.toArray()[j];
           if(sideEffect.getType() == 0)
           {
               minorEffects = minorEffects +sideEffect.getName()+ ", ";
           }
           else
           {
               majorEffects = majorEffects  +sideEffect.getName() + ", ";
           }    
        }
        
        
        drugClassName.setText(selectedDrug.getClassName());
        drugClassName.setToolTipText(selectedDrug.getClassName());
        

        drugTradeName.setText(selectedDrug.getTradeName());
        drugTradeName.setToolTipText(selectedDrug.getTradeName());
        
        drugGenericNames.setText(genericNames);
        drugGenericNames.setToolTipText(genericNames);
        
        drugDosage.setText(selectedDrug.getDosage());
        drugDosage.setToolTipText(selectedDrug.getDosage());
        
        
        dosageForm.setText(selectedDrug.getDosageForm());
        dosageForm.setToolTipText(selectedDrug.getDosageForm());
        
        drugRoute.setText(selectedDrug.getRouteOfElimination());
        drugRoute.setToolTipText(selectedDrug.getRouteOfElimination());
        

        drugPrecautions.setText(selectedDrug.getPrecautions());
        drugPrecautions.setToolTipText(selectedDrug.getPrecautions());

        drugHalfLife.setText(selectedDrug.getHalfLife() + " hours");
        drugHalfLife.setToolTipText(selectedDrug.getHalfLife() + " hours");
        
        drugMajor.setText(majorEffects);
        drugMajor.setToolTipText(majorEffects);
        
        drugMinor.setText(minorEffects);
        drugMinor.setToolTipText(minorEffects);

        drugFoods.setText(selectedDrug.getFoodInteractions());
        drugFoods.setToolTipText(selectedDrug.getFoodInteractions());

        drugProfile.revalidate();
       
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_formWindowOpened

    private void jTextFieldPatientsBookKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPatientsBookKeyReleased
        // TODO add your handling code here:
        try {
            Query q4 = em.createNamedQuery("Patients.findByName");
            q4.setParameter("pName", jTextFieldPatientsBook.getText() + "%");
            patientsBookList = (List<Patients>) q4.getResultList();
            
            
//            System.out.println(patientsBookList.size());
            
            if(patientsBookList.isEmpty()){
                DefaultListModel tempModel = new DefaultListModel();
                jListPatientsBook.setModel(tempModel);
                tempModel.addElement("Sorry, No match");
//                currentPatient=null;
                jListPatientsBook.clearSelection();
                disableProfilePatient();
                this.clearProfilePatient();
                jListPPDiagnosis.removeAll();
                jListPPM3edication.removeAll();
                jListPatientsBook.setEnabled(false);
                jButton2.setEnabled(false);
            }
            else{
                
//            jPanelPatientProfile.setVisible(true);
            jListPatientsBook.setEnabled(true);
            DefaultListModel modelPatientSearch = new DefaultListModel();
            jListPatientsBook.setModel(modelPatientSearch);
            for (int i = 0; i < patientsBookList.size(); i++) {
                modelPatientSearch.add(i, patientsBookList.get(i).getName());
            }
//            currentPatient=patientsBookList.get(0);
//            jListPatientsBook.setSelectedIndex(0);
            jListPatientsBook.clearSelection();
}
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jTextFieldPatientsBookKeyReleased

    
    public void clearProfilePatient(){
        try {
            jTextFieldPatientProfileName.setText("");
            jTextFieldPatientProfileHeight.setText("0");
            jTextFieldPatientProfileWeight.setText("0");
            jTextFieldPatientProfileBMI.setText("0");
//            jTextFieldPatientsBook.setText("");
            jComboBoxPatientProfileDay.setSelectedIndex(0);
            jComboBoxPatientProfileGender.setSelectedIndex(0);
            jComboBoxPatientProfileMarital.setSelectedIndex(0);
            jComboBoxPatientProfileMonth.setSelectedIndex(0);
            jComboBoxPatientProfilePregnant.setSelectedIndex(0);
            jComboBoxPatientProfileYear.setSelectedIndex(0);
            jListPPM3edication.removeAll();
            jListPPDiagnosis.removeAll();
            jListPPDiagnosis.setModel(new DefaultListModel());
            jListPPM3edication.setModel(new DefaultListModel());
            jListPatientsBook.clearSelection();
            jLabelBMIDesc.setVisible(false);
            

            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            System.out.println("Error clearing the components upon an empty search results");
        }
    }
    
    private void jTextFieldSearchDragsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchDragsKeyReleased
        String query = this.jTextFieldSearchDrags.getText();
        final ArrayList<Drugs> finos = Eroshetta.drug_search(query);
        final ArrayList<String> s = new ArrayList();
        for (int i = 0; i < finos.size(); i++) {
//                this.jArrayList_Drugs.(finos.get(i).getTradeName());
            if (finos.get(i).getTradeName() != null || finos.get(i).getClassName() != null) {
                s.add(finos.get(i).getTradeName() + "(" + finos.get(i).getClassName() + ")");
            }

        }
        jList_Drugs.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return finos.size();
            }

            public Object getElementAt(int i) {
                return finos.get(i);
            }
        }); // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchDragsKeyReleased

    //Kareem
    private void editDoctorProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDoctorProfileActionPerformed
        // TODO add your handling code here:
        DoctorInfo info = new DoctorInfo();
        info.setVisible(true);
    }//GEN-LAST:event_editDoctorProfileActionPerformed

    private void jTextFieldSearchDragsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchDragsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchDragsActionPerformed

/*
    private void jList_DrugsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_DrugsValueChanged
        // TODO add your handling code here:
        Drugs d = (Drugs) this.jList_Drugs.getSelectedValue();
        int drugId = d.getId();
//        System.out.println(drugId);
    }//GEN-LAST:event_jList_DrugsValueChanged
*/
    static int workingPatientIndex = -1;
    private void jListPatientsBookValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListPatientsBookValueChanged

        // TODO add your handling code here:
        this.disableProfilePatient();
        
        if(counterPatients%2==0){
//        System.out.println("The save flaag is "+ saveFlag);    
            
            
            
            
            try {
                int selctedID = jListPatientsBook.getSelectedIndex();
                currentPatient = patientsBookList.get(selctedID);
                currentPatienDiagnoses = (List<Diagnoses>) currentPatient.getDiagnosesCollection();
                currentPatienMedications = (List<Drugs>) currentPatient.getDrugsCollection();
                jLabelBMIDesc.setVisible(true);
              
//            System.out.println(currentPatient.getName());
//            System.out.println(currentPatient.getId());
//            System.out.println(currentPatient.getHeight());
//            System.out.println(currentPatient.getBmi());
//            System.out.println(currentPatient.getWeight());
//            System.out.println(currentPatient.getMaritalStatus());
//            System.out.println(currentPatient.getBirthDate());
//            System.out.println(currentPatient.getGender());
 
            } catch (Exception e) {
//                System.out.println("Error Intializing the current patient.");
                
            }
            
        
            
            try {
                 jTextFieldPatientProfileName.setText(currentPatient.getName());
            } catch (Exception e) {
                System.out.println("Error setting the name.");
            }
           
            try {
                int birhtyear = (currentPatient.getBirthDate().getYear()) + 1900;
                int currentYear = Calendar.getInstance().get(Calendar.YEAR);
                int birthDay = currentPatient.getBirthDate().getDate();
                jComboBoxPatientProfileMonth.setSelectedIndex(currentPatient.getBirthDate().getMonth());
                jComboBoxPatientProfileYear.setSelectedIndex(currentYear - birhtyear);
                jComboBoxPatientProfileDay.setSelectedIndex(birthDay - 1);
            } catch (Exception e) {
                System.out.println("Error setting birthday.");
            }
    
            
            try {
                
                 if (currentPatient.getGender()=='m') {
                    jComboBoxPatientProfileGender.setSelectedIndex(0);
                }
                 else {
                    jComboBoxPatientProfileGender.setSelectedIndex(1);
                }
            } catch (Exception e) {
                
                System.out.println("Error setting the gender.");
            }
                

            try {
               
                jComboBoxPatientProfileMarital.setSelectedIndex(currentPatient.getMaritalStatus());
               
            } catch (Exception e) {
                System.out.println("Error setting the marital status.");
            }
            
            
            try {
                
                jComboBoxPatientProfilePregnant.setSelectedIndex(currentPatient.getIsPregnant());
                
            } catch (Exception e) {
                
                System.out.println("Error setting the pregnancy.");
                
            }
            

            try {
                
                    String oldBmi = String.valueOf(currentPatient.getBmi());
                    jTextFieldPatientProfileBMI.setText(oldBmi);
                    
                    String tmp = String.valueOf(currentPatient.getBmi());
                    
             
                    
                   double tmp2 = Double.parseDouble(tmp);
                    

                    
                    if(tmp2<18.5){
                        jLabelBMIDesc.setText("Underweight");
                        jLabelBMIDesc.setForeground(Color.red);
                    }
                    else{
                        if(tmp2>=18.5&&tmp2<=24.9){
                            jLabelBMIDesc.setText("Normalweight");
                            jLabelBMIDesc.setForeground(Color.black);
                        }
                        else{
                            jLabelBMIDesc.setText("Overweight");
                            jLabelBMIDesc.setForeground(Color.red);
                        }
                    }
                    
                
         
                
            } catch (Exception e) {
                
                System.out.println("Error setting the BMI." + e.getMessage());
            }

            try {
                
                if(currentPatient.getWeight() != null || jTextFieldPatientProfileWeight.getText().isEmpty() ){
                    jTextFieldPatientProfileWeight.setText(String.valueOf(currentPatient.getWeight()));
                }
                else{
                    jTextFieldPatientProfileWeight.setText("0");
                }
                
            } catch (Exception e) {
                
                System.out.println("Error setting the Weight.");
            }
            
            
            try {
                
                if(currentPatient.getHeight()!=null || jTextFieldPatientProfileHeight.getText().isEmpty()){
                    jTextFieldPatientProfileHeight.setText(String.valueOf(currentPatient.getHeight()));
                }
                else{
                    jTextFieldPatientProfileHeight.setText("0");
                }
                
            } catch (Exception e) {
                
                System.out.println("Error setting the Height.");
            }
            
            
            
            
            
            

            if (this.workingOnPrescription) {
                this.jListPatientsBook.setSelectedIndex(Eroshetta.workingPatientIndex);
                return;
            }
            
            try {
                
                this.currentDiagnoses();
                
            } catch (Exception e) {
                
                System.out.println("Error gettign current patients Diagnosis.");
                
            }
            
            try {
                
                this.currentMedications();
                
            } catch (Exception e) {
                
                System.out.println("Error gettign current patients Drugs.");
                
            }
            
            this.oldPrescriptions();

        }
        
        counterPatients++;
    }//GEN-LAST:event_jListPatientsBookValueChanged


    public void currentDiagnoses() {
        DefaultListModel modelPPDiangnoses = new DefaultListModel();
        jListPPDiagnosis.setModel(modelPPDiangnoses);
        for (int i = 0; i < currentPatienDiagnoses.size(); i++) {
            Diagnoses d = (Diagnoses) currentPatienDiagnoses.get(i);
            modelPPDiangnoses.add(i, d.getName());
        }
    }

    public void currentMedications() {
        DefaultListModel modelPPMedicaion = new DefaultListModel();
        jListPPM3edication.setModel(modelPPMedicaion);
        for (int i = 0; i < currentPatienMedications.size(); i++) {
            Drugs d = (Drugs) currentPatienMedications.get(i);
            modelPPMedicaion.add(i, d.getTradeName()+"("+d.getClassName()+")");
        }
    }
    
    static ArrayList<DrugPresPanel> drugsPanels = new <DrugPresPanel>ArrayList();
    
    
    private void addToPrescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToPrescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addToPrescActionPerformed

    private void jToggleButtonPPMedicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonPPMedicationActionPerformed
        // TODO add your handling code here:

        whichEdit=1;
        //Was not selcted but just got selected
        if (jToggleButtonDiagnosis.isSelected() == false && jToggleButtonPPMedication.isSelected() == true) {
            jLabelPPMedication.setVisible(true);
            jTextFieldPPMedication.setVisible(true);
            jScrollPanePPDiagnosisMedication.setVisible(true);
            jListPPDiagnosisMedication.setVisible(true);
            jListPPM3edication.setEnabled(true);
            //change the modelList for the medication.
            jListPPDiagnosisMedication.setModel(modelAllDrugs);
            System.out.println("1st Condition");
            jTextFieldPPMedication.setText("");
        } else {
            if (jToggleButtonDiagnosis.isSelected() == true && jToggleButtonPPMedication.isSelected() == true) {
                jToggleButtonDiagnosis.setSelected(false);
                jListPPDiagnosis.setEnabled(false);
                jListPPM3edication.setEnabled(true);
                System.out.println("2nd Condition");
                //change the modelList for the medication.
                jListPPDiagnosisMedication.setModel(modelAllDrugs);
                jTextFieldPPMedication.setText("");
            } else {
                if (jToggleButtonDiagnosis.isSelected() == false && jToggleButtonPPMedication.isSelected() == false) {
                    jLabelPPMedication.setVisible(false);
                    jTextFieldPPMedication.setVisible(false);
                    jScrollPanePPDiagnosisMedication.setVisible(false);
                    jListPPDiagnosisMedication.setVisible(false);
                    jListPPM3edication.setEnabled(false);
                    System.out.println("3rd Condition");
                    whichEdit=0;
                    jTextFieldPPMedication.setText("");
                }
            }
        }
    }//GEN-LAST:event_jToggleButtonPPMedicationActionPerformed

    private void jTextFieldPatientProfileBMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPatientProfileBMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPatientProfileBMIActionPerformed

    private void jComboBoxPatientProfileMaritalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfileMaritalActionPerformed
        // TODO add your handling code here:
        
        this.profileGenderMaritalStatus();
//        saveFlag=5; Moshkila
    }//GEN-LAST:event_jComboBoxPatientProfileMaritalActionPerformed

    /*
     private void jList_DrugsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                         
     // TODO add your handling code here:
     Drugs d = (Drugs) this.jList_Drugs.getSelectedValue();
     int drugId = d.getId();
     //        System.out.println(drugId);
     }                                        
     */
    private void jComboBoxPatientProfileYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfileYearActionPerformed
        // TODO add your handling code here:
        this.leapYearModification();
//        saveFlag=7;
    }//GEN-LAST:event_jComboBoxPatientProfileYearActionPerformed

    private void jComboBoxPatientProfileMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfileMonthActionPerformed
        // TODO add your handling code here:
        this.leapYearModification();
//        saveFlag=8;
    }//GEN-LAST:event_jComboBoxPatientProfileMonthActionPerformed

    private void jComboBoxPatientProfileDayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfileDayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPatientProfileDayMouseClicked

    private void jComboBoxPatientProfileGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfileGenderActionPerformed
        // TODO add your handling code here:
        
        this.profileGenderMaritalStatus();
//        saveFlag=9; Moshkila
    }//GEN-LAST:event_jComboBoxPatientProfileGenderActionPerformed

    private void jTextFieldPatientProfileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPatientProfileNameActionPerformed
        // TODO add your handling code here:
//        saveFlag=6;
    }//GEN-LAST:event_jTextFieldPatientProfileNameActionPerformed

    private void jToggleButtonDiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonDiagnosisActionPerformed
        // TODO add your handling code here:
        //Was not selcted but just got selected
        whichEdit = 2;
        if (jToggleButtonDiagnosis.isSelected() == true && jToggleButtonPPMedication.isSelected() == false) {
            jLabelPPMedication.setVisible(true);
            jTextFieldPPMedication.setVisible(true);
            jScrollPanePPDiagnosisMedication.setVisible(true);
            jListPPDiagnosisMedication.setVisible(true);
            jListPPDiagnosis.setEnabled(true);
            jListPPDiagnosisMedication.setModel(modelallDiagnoses);
            //change the modelList for the diagnosis.
            jTextFieldPPMedication.setText("");

            System.out.println("1st Condition");
        } else {
            if (jToggleButtonDiagnosis.isSelected() == true && jToggleButtonPPMedication.isSelected() == true) {
                jToggleButtonPPMedication.setSelected(false);
                jListPPM3edication.setEnabled(false);
                jListPPDiagnosis.setEnabled(true);
                System.out.println("2nd Condition");
                //change the modelList for the diagnosis
                jListPPDiagnosisMedication.setModel(modelallDiagnoses);
                jTextFieldPPMedication.setText("");
            } else {
                if (jToggleButtonDiagnosis.isSelected() == false && jToggleButtonPPMedication.isSelected() == false) {
                    jLabelPPMedication.setVisible(false);
                    jTextFieldPPMedication.setVisible(false);
                    jScrollPanePPDiagnosisMedication.setVisible(false);
                    jListPPDiagnosisMedication.setVisible(false);
                    jListPPDiagnosis.setEnabled(false);
                    System.out.println("3rd Condition");
                    whichEdit=0;
                    jTextFieldPPMedication.setText("");
                }
            }
        }


    }//GEN-LAST:event_jToggleButtonDiagnosisActionPerformed

    public void removeDrug(Drugs dr, DrugPresPanel dpp) {
        Eroshetta.drugsCollectionInPrescription.remove(dr);
        Eroshetta.drugsPanels.remove(dpp);
        Eroshetta.drugsPanels.clear();
        int idPanel = dr.getId();
        System.out.println("tooooooo is 2 " + Eroshetta.drugsPanels.size());
        this.DrugsInPrescription.removeAll();
        this.DrugsInPrescription.repaint();
//    this.DrugsInPrescription.setLayout(new java.awt.BorderLayout());
//    Collection drugsCollectionInPrescription1 = this.drugsCollectionInPrescription;
//    this.drugsCollectionInPrescription.clear();
//    for (int i = 0; i < drugsCollectionInPrescription1.size(); i++) {
//        Drugs drugruga = (Drugs) drugsCollectionInPrescription1.toArray()[i];
//        if(idPanel != drugruga.getId()){
//        this.drugsCollectionInPrescription.add(drugruga);
//        }
//    }
        for (int i = 0; i < drugsCollectionInPrescription.size(); i++) {
            Drugs drugruga = (Drugs) drugsCollectionInPrescription.toArray()[i];
            DrugPresPanel drugPanel = new DrugPresPanel(drugruga, currentPrescription, this);
            if (idPanel != drugruga.getId()) {
                drugsPanels.add(drugPanel);
            }

        }
//            this.DrugsInPrescription.removeAll();
        if (drugsPanels.size() < 4) {
            this.DrugsInPrescription.setLayout(new java.awt.GridLayout(4, 0));
        } else {
            this.DrugsInPrescription.setLayout(new java.awt.GridLayout(drugsPanels.size(), 0));
        }
        for (int i = 0; i < drugsCollectionInPrescription.size(); i++) {
            Drugs drugrug = (Drugs) drugsCollectionInPrescription.toArray()[i];
            DrugPresPanel drugPanel = new DrugPresPanel(drugrug, currentPrescription, this);
            this.DrugsInPrescription.add(drugPanel);
        }

        this.DrugsInPrescription.revalidate();

    }
    static boolean workingOnPrescription = false;
    static Prescriptions currentPrescription = new Prescriptions();
//    static ArrayList<Prescriptions> currentPrescription= new <Prescriptions>ArrayList();
    static Collection<Drugs> drugsCollectionInPrescription = new ArrayList();

    private void addToPrescMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToPrescMouseClicked

        int o;
        if (this.jListPatientsBook.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Please select a patient", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (this.jList_Drugs.getSelectedIndex() != -1) {

            if (currentPrescription.getDrugsCollection() == null) {
                currentPrescription.setPatientId(currentPatient);
                this.workingOnPrescription = true;
            }
            Drugs d = (Drugs) this.jList_Drugs.getSelectedValue();
            //conditions checking a drug
            
             
            
            //DB Change kareem 
            /*
            int age = 0;
            try {

                age = Calendar.YEAR - currentPatient.getBirthDate().getYear();
                if (d.getContraAge() == 1 && age < 6) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for kids , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            try {
                if (d.getContraAge() == 2 && age < 15) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for teens , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            try {
                if (d.getContraAge() == 3 && age > 50) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for old people , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            try {
                if (d.getContraAge() == 4 && age < 15) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for kids and babies people , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            try {
                if (d.getContraAge() == 5 && age < 15 && age > 50) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for kids and babies people , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            * 
            */
            try {
                System.out.println("drug contra" +d.getContraPregnant() + "patient " +currentPatient.getIsPregnant());
                if (d.getContraPregnant() == 1 && currentPatient.getIsPregnant() == 1) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for pregnant women  , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("patien is null");
            }/*
            try {
                if (d.getContraBmi() == 1 && (currentPatient.getBmi().doubleValue() < 22.5)) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for under weight(BMI < 22.5) , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            try {
                if (d.getContraBmi() == 2 && (currentPatient.getBmi().doubleValue() < 29.5)) {
                    o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may be harmful for over weight people(25.5 < BMI < 29.5) , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                    if (o != 0) {
                        return;
                    }
                }
            } catch (NullPointerException e) {
            }
            * 
            */
            try {
                for (int j = 0; j < drugsCollectionInPrescription.size(); j++) {
                    Drugs a = (Drugs) drugsCollectionInPrescription.toArray()[j];
                    
                        if (this.anyInteract(a, d)) {
                            o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may interact with " + a.toString() + " , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                            if (o != 0) {
                                return;
                            }
                        }
                    
                }
            } catch (NullPointerException e) {
            }
            try {
                String s = "";
                boolean flag = false;
                Collection<Diagnoses> drugsContraAlreadyDiagnosis = d.getDiagnosesCollection();
                Query qr = em.createNamedQuery("Diagnoses.findAll");
                List<Diagnoses> tmpList = qr.getResultList();
                for (int j = 0; j < drugsContraAlreadyDiagnosis.size(); j++) {
                    Diagnoses a = (Diagnoses) drugsContraAlreadyDiagnosis.toArray()[j];
                    for (int k = 0; k < tmpList.size(); k++) {
                        Diagnoses b = (Diagnoses) tmpList.toArray()[k];
                        if (a.getId() == b.getId()) {
                            flag = true;
                            s= s +  a.getName() + " ,";
                        }
                    }
                }
                if(flag){
                o = JOptionPane.showConfirmDialog(new JButton("parent"), "The drug may contradict with " +s + "  Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
                            if (o != 0) {
                                return;
                            }
                }
            } catch (NullPointerException e) {
            }


            System.out.println("tooooooo is 1 " + this.drugsPanels.size());
//            currentPrescription.getDrugsCollection().add(d);
            for (int i = 0; i < drugsCollectionInPrescription.size(); i++) {
                Drugs drugruga = (Drugs) drugsCollectionInPrescription.toArray()[i];
                if (drugruga.getId() == d.getId()) {
                    JOptionPane.showMessageDialog(this, "you already added the drug", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            this.workingOnPrescription = true;
            this.workingPatientIndex = this.jListPatientsBook.getSelectedIndex();
            drugsCollectionInPrescription.add(d);
            drugsPanels.add(new DrugPresPanel(d, currentPrescription, this));
//            drugsPanels.clear();
//            drugsPanels.removeAll(drugsPanels);
//            for (int i = 0; i < drugsCollectionInPrescription.size(); i++) {
//                Drugs drugruga = (Drugs) drugsCollectionInPrescription.toArray()[i];
//                DrugPresPanel drugPanel = new DrugPresPanel(drugruga, currentPrescription, this);
//                drugsPanels.add(drugPanel);
//
//            }

            this.DrugsInPrescription.removeAll();
            if (drugsPanels.size() < 4) {
                this.DrugsInPrescription.setLayout(new java.awt.GridLayout(4, 0));
            } else {
                this.DrugsInPrescription.setLayout(new java.awt.GridLayout(drugsPanels.size(), 0));
            }
            for (int i = 0; i < drugsCollectionInPrescription.size(); i++) {
//                Drugs drugrug = (Drugs) drugsCollectionInPrescription.toArray()[i];
//                DrugPresPanel drugPanel = new DrugPresPanel(drugrug, currentPrescription, this);
                this.DrugsInPrescription.add(drugsPanels.get(i));
            }

            this.DrugsInPrescription.revalidate();

        } else {
            JOptionPane.showMessageDialog(this, "Please select a drug", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);

        }
        // TODO add your handling code here:
//        if(d.getPrice() != null){
//         DrugPanel = new DrugPresPanel();
//        DrugPanel.DrugPrice.setText(d.getPrice().toString());
//        }
//        if(d.getDosage() != null && d.getDosageForm() != null){
//        DrugPanel.DrugDosage.setText(d.getDosage() + " (" + d.getDosageForm() + ")");
//        }
//        drugPanel.setVisible(true);

//        this.DrugsInPrescription.add(DrugPanel);
//        this.DrugsInPrescription.revalidate();

        // TODO add your handling code here:
    }//GEN-LAST:event_addToPrescMouseClicked

    public static boolean anyInteract(Drugs a , Drugs b){
    Collection<Drugs> aDrugs = a.getDrugsCollection();
    Collection<Drugs> bDrugs = b.getDrugsCollection();
                for(int i =0;i<aDrugs.size();i++){
                    Drugs tmp  = (Drugs) aDrugs.toArray()[i];
                    if(tmp.getId()==b.getId()){
                        return true;
                    }
                }
                for(int i =0;i<bDrugs.size();i++){
                    Drugs tmp  = (Drugs) bDrugs.toArray()[i];
                    if(tmp.getId()==a.getId()){
                        return true;
                    }
                }
                return false;
}
    private void jListPatientsBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPatientsBookMouseClicked
if (this.workingOnPrescription) {
            int o = JOptionPane.showConfirmDialog(new JButton("parent"), "Prescription Progress will be lost , Proceed?", "Eroshetta", JOptionPane.YES_NO_OPTION);
            if (o != 0) {
                this.jListPatientsBook.setSelectedIndex(this.workingPatientIndex);
                return;
            } else {
                this.DrugsInPrescription.removeAll();
                this.DrugsInPrescription.revalidate();
                this.DrugsInPrescription.repaint();
                this.drugsPanels.clear();
                this.drugsCollectionInPrescription.clear();
                this.workingOnPrescription = false;
                this.jTextArea1.setText(null);
            }
        }        

        // TODO add your handling code here:
    }//GEN-LAST:event_jListPatientsBookMouseClicked

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        this.workingOnPrescription = true;        // TODO add your handling code here:
        this.workingPatientIndex = this.jListPatientsBook.getSelectedIndex();

    }//GEN-LAST:event_jTextArea1KeyPressed

    private void savePreviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savePreviewMouseClicked
        Calendar cal = Calendar.getInstance();//
        currentPrescription = new Prescriptions();
        System.out.println(currentPatient.getName());
        currentPrescription.setDate(cal.getTime());//
        currentPrescription.setNotes(jTextArea1.getText());
        currentPrescription.setPatientId(currentPatient);
       // currentPrescription.setDrugsCollection(drugsCollectionInPrescription);
        Collection<DrugTimes> times = new ArrayList();
        for (int i = 0; i < drugsCollectionInPrescription.size(); i++) {
                DrugTimes time = new DrugTimes(1,drugsPanels.get(i).panelDrug.getId());
                time.setDrugTime("");
            if (drugsPanels.get(i).jCheckBox1.isSelected()) {
                time.setDrugTime(drugsPanels.get(i).jCheckBox1.getText());
            }
            if (drugsPanels.get(i).jCheckBox2.isSelected()) {
                time.setDrugTime(time.getDrugTime() +"," +drugsPanels.get(i).jCheckBox2.getText());
            }
            if (drugsPanels.get(i).jCheckBox3.isSelected()) {
                time.setDrugTime(time.getDrugTime() +"," +drugsPanels.get(i).jCheckBox3.getText());
            }
            if (drugsPanels.get(i).jCheckBox4.isSelected()) {
                time.setDrugTime(time.getDrugTime() +"," +drugsPanels.get(i).jCheckBox4.getText());
            }
            if (drugsPanels.get(i).jCheckBox5.isSelected()) {
                time.setDrugTime(time.getDrugTime() +"," +drugsPanels.get(i).jCheckBox5.getText());
            }
            if (drugsPanels.get(i).jCheckBox6.isSelected()) {
                time.setDrugTime(time.getDrugTime() +"," +drugsPanels.get(i).jCheckBox6.getText());
            }
            time.setDrugTime(time.getDrugTime() +"," +drugsPanels.get(i).duration.getSelectedItem());
            times.add(time);
        }
        //currentPrescription.setDrugTimesCollection(times);
        
        //Kareem
        
        PrescriptionView prescView = new PrescriptionView(currentPrescription,times); 
        PrescriptionFrame prescFrame = new PrescriptionFrame(prescView);
        prescFrame.saveFlag = true;
        prescFrame.getPrintButton().setText("Save & Print");
        prescFrame.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_savePreviewMouseClicked

    public void addDiagnosisDB(int diagnosisID){
        try {
            Connection con = DriverManager.getConnection(host, usrN, usrP);
            Statement stmt = con.createStatement();
            String SQL = "INSERT INTO PATIENT_HAS_DIAGNOSIS VALUES ("+currentPatient.getId()+","+diagnosisID+")" ;
            int insert = stmt.executeUpdate(SQL);
            System.out.println(insert);
            if (insert == 1) {
                System.out.println("Row is inserted.");
            } else {
                System.out.println("Row is not inserted.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addDrugDB(int drugID){
         try {
            Connection con = DriverManager.getConnection(host, usrN, usrP);
            Statement stmt = con.createStatement();
            String SQL = "INSERT INTO PATIENT_CURRENT_MEDICATION VALUES ("+currentPatient.getId()+","+drugID+")" ;
            int insert = stmt.executeUpdate(SQL);
            System.out.println(insert);
            if (insert == 1) {
                System.out.println("Row is inserted.");
            } else {
                System.out.println("Row is not inserted.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:        
         try {
             
             
//             System.out.println("Weight is >>>" + jTextFieldPatientProfileWeight.getText());
//             System.out.println("Height is >>>" + jTextFieldPatientProfileHeight.getText());
            if (jTextFieldPatientProfileHeight.getText().isEmpty() && jTextFieldPatientProfileWeight.getText().isEmpty()) {
                 
                    jTextFieldPatientProfileHeight.setText("0");
                    jTextFieldPatientProfileWeight.setText("0");
//                    System.out.println("Both Empty");
             }
            
            if(jTextFieldPatientProfileHeight.getText().isEmpty() && !jTextFieldPatientProfileWeight.getText().isEmpty()){
                    jTextFieldPatientProfileHeight.setText("0");
//                    System.out.println("Height Empty " + jTextFieldPatientProfileWeight.getText() );
                
            }
            
            if(jTextFieldPatientProfileWeight.getText().isEmpty() && !jTextFieldPatientProfileHeight.getText().isEmpty()){
                jTextFieldPatientProfileWeight.setText("0");
//            System.out.println("Weight Empty " + jTextFieldPatientProfileHeight.getText() );
            }
             
            if(jTextFieldPatientProfileName.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter the patient`s name", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                
                if(!DoctorInfo.isNumeric(jTextFieldPatientProfileHeight.getText()) || !DoctorInfo.isNumeric(jTextFieldPatientProfileWeight.getText())){
                    JOptionPane.showMessageDialog(this, "Please enter a valid weight or height.", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);
                }else{
                   
                this.saveProfilePatient();     
            this.disableProfilePatient();
           
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
              jTextFieldPatientsBook.setText("");
              jListPatientsBook.setEnabled(true);
            int x = jListPatientsBook.getSelectedIndex();
            Query qRefresh = em.createNamedQuery("Patients.findAll"); 
            patientsBookList=qRefresh.getResultList(); 
            DefaultListModel refreshModel = new DefaultListModel();
            jListPatientsBook.setModel(refreshModel);
           
            for(int i=0; i<patientsBookList.size();i++){
                refreshModel.add(i, patientsBookList.get(i).getName());
            }
            
            jListPatientsBook.setSelectedIndex(x);
            currentPatient=patientsBookList.get(x);
            saveFlag=true;
          
                    
                    
                }
            
    
            }
            
            
            
        } catch (Exception e) {
        }
        
      
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        this.enableProfilePatient();
        saveFlag=false;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBoxPatientProfileDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfileDayActionPerformed
        // TODO add your handling code here:
        dayHazard=Integer.parseInt(String.valueOf(jComboBoxPatientProfileDay.getSelectedItem()));
//        saveFlag=1;
    }//GEN-LAST:event_jComboBoxPatientProfileDayActionPerformed

    private void jComboBoxPatientProfilePregnantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPatientProfilePregnantActionPerformed
        // TODO add your handling code here:
//        saveFlag=2; Moshkila
    }//GEN-LAST:event_jComboBoxPatientProfilePregnantActionPerformed

    private void jTextFieldPatientProfileWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPatientProfileWeightActionPerformed
        // TODO add your handling code here:
//        saveFlag=3;
    }//GEN-LAST:event_jTextFieldPatientProfileWeightActionPerformed

    private void jTextFieldPatientProfileHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPatientProfileHeightActionPerformed
        // TODO add your handling code here:
//        saveFlag=4;
    }//GEN-LAST:event_jTextFieldPatientProfileHeightActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        currentPatient = new Patients();
        currentPatienDiagnoses.clear();
        currentPatienMedications.clear();
        
        
        saveFlag=false;
        
        this.clearProfilePatient();
        jListPPDiagnosis.removeAll();
        jListPPM3edication.removeAll();
        this.enableProfilePatient();
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
//        jListPatientsBook.setSelectedIndex(patientsBookList.size()-1);
//        jToggleButtonDiagnosis.setEnabled(false);
//        jToggleButtonPPMedication.setEnabled(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        
    
        try {
            int selcted = jListPatientsBook.getSelectedIndex();
            this.disableProfilePatient();

            DefaultListModel temp = new DefaultListModel();
            jListPatientsBook.setModel(temp);
            for (int i = 0; i < patientsBookList.size(); i++) {
                temp.add(i, patientsBookList.get(i).getName());
            }
            currentPatient = patientsBookList.get(selcted);
            jListPatientsBook.setSelectedIndex(selcted);
            saveFlag = true;
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Caught the new patient exception");
            DefaultListModel temp = new DefaultListModel();
            jListPatientsBook.setModel(temp);
            for (int i = 0; i < patientsBookList.size(); i++) {
                temp.add(i, patientsBookList.get(i).getName());
            }
            currentPatient = patientsBookList.get(0);
            jListPatientsBook.setSelectedIndex(0);
            saveFlag = true;
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
             jButton1.setEnabled(true);
            jButton2.setEnabled(true);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextFieldPPMedicationKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPPMedicationKeyReleased
        // TODO add your handling code here:
        if(whichEdit==1){
            //Drugs Search
            
            
            
        String query = this.jTextFieldPPMedication.getText();
        allDrugs = Eroshetta.drug_search(query);
        final ArrayList<String> s = new ArrayList();
        for (int i = 0; i < allDrugs.size(); i++) {
//                this.jArrayList_Drugs.(finos.get(i).getTradeName());
            if (allDrugs.get(i).getTradeName() != null || allDrugs.get(i).getClassName() != null) {
                s.add(allDrugs.get(i).getTradeName() + "(" + allDrugs.get(i).getClassName() + ")");
            }

        }
        jListPPDiagnosisMedication.setModel(new javax.swing.AbstractListModel() {
            public int getSize() {
                return allDrugs.size();
            }

            public Object getElementAt(int i) {
                return allDrugs.get(i);
            }
        }); // TODO add your handling code here:
            
            
            
            
        }
        else{
            //Diagnosis Search
            Query q5 = em.createNamedQuery("Diagnoses.findByName");
            q5.setParameter("name", jTextFieldPPMedication.getText()+"%");

            allDiagnoses = (List<Diagnoses>) q5.getResultList();
            DefaultListModel modelDiagnosisSearch = new DefaultListModel();
            jListPPDiagnosisMedication.setModel(modelDiagnosisSearch);
            for (int i = 0; i < allDiagnoses.size(); i++) {
                modelDiagnosisSearch.add(i, allDiagnoses.get(i).getName());
            }
            
            
        }
    }//GEN-LAST:event_jTextFieldPPMedicationKeyReleased

    private void jListPPM3edicationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPPM3edicationMouseReleased
        // TODO add your handling code here:
        
        
                    this.deleteDrug();

    jListPPM3edication.clearSelection();        
        
    }//GEN-LAST:event_jListPPM3edicationMouseReleased

    private void jListPPDiagnosisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPPDiagnosisMouseReleased
        // TODO add your handling code here:
        
            this.deleteDiagnosis();
            

        jListPPDiagnosis.clearSelection();
        
        
    }//GEN-LAST:event_jListPPDiagnosisMouseReleased

    private void jListPPDiagnosisMedicationMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListPPDiagnosisMedicationMouseReleased
        // TODO add your handling code here:
        
                try {
            //whichEdit ==1
            if(whichEdit ==1){
                    //drugs added to the patient
                    
                    int selectedDrugIndex = jListPPDiagnosisMedication.getSelectedIndex();
//                    System.out.println("Selcted drug index is "+selectedDrugIndex);
//                    System.out.println("Selcted drug  is "+jListPPDiagnosisMedication.getSelectedValue());
                    Drugs selectedDrug = allDrugs.get(selectedDrugIndex);
//                    System.out.println("Slected drug name is "+ selectedDrug.getClassName());
//                    System.out.println(allDrugs.size());
//                    System.out.println(allDrugs.get(selectedDrugIndex).getClassName());
//                    System.out.println(allDrugs.get(selectedDrugIndex).getId());
                    
                    if(!this.checkExistDrug(selectedDrug)){
                        
                        DefaultListModel model = (DefaultListModel) jListPPM3edication.getModel();
                        model.addElement(selectedDrug.getTradeName()+"("+selectedDrug.getClassName()+")");
                        jListPPM3edication.setModel(model);
                        
//                        System.out.println("Hello");
                        
                        List newDrugsList = currentPatienMedications;
                        newDrugsList.add(selectedDrug);
                        currentPatient.setDrugsCollection(newDrugsList);
                        currentPatienMedications = (List<Drugs>) currentPatient.getDrugsCollection();
                        
//                        System.out.println("Hello Again");

                        this.addDrugDB(selectedDrug.getId());
                    }
                    else{
                       JOptionPane.showMessageDialog(this, "This Drug is already added", "Eroshetta", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }
        
            
            //
            else{
                        
                    //diagnosis added to the patient
                    int selectedDiagnosisIndex = jListPPDiagnosisMedication.getSelectedIndex();
//                    System.out.println("Selected diagnosis index is "+selectedDiagnosisIndex);
//                    System.out.println("Selcted diagnosis  is "+jListPPDiagnosisMedication.getSelectedValue());
                    
                    Diagnoses selectedDiagnosis = allDiagnoses.get(selectedDiagnosisIndex);
//                    System.out.println(selectedDiagnosis.getName());
//                    System.out.println(allDiagnoses.size());
//                    System.out.println(allDiagnoses.get(selectedDiagnosisIndex).getName());
//                    System.out.println(allDiagnoses.get(selectedDiagnosisIndex).getId());
                    
                   if(!this.checkExistDiagnosis(selectedDiagnosis)){
                       DefaultListModel model = (DefaultListModel) jListPPDiagnosis.getModel();
                       model.addElement(selectedDiagnosis.getName());
                       jListPPDiagnosis.setModel(model);
//                       
//                       
//                        System.out.println("Hello");

                        List newDiagnosisList = currentPatienDiagnoses;
                        newDiagnosisList.add(selectedDiagnosis);
                        currentPatient.setDiagnosesCollection(newDiagnosisList);
                        currentPatienDiagnoses = (List<Diagnoses>) currentPatient.getDiagnosesCollection();
                        
//                        System.out.println("Hello Again");

                        this.addDiagnosisDB(selectedDiagnosis.getId());
                        
                   }
                   else{
                       JOptionPane.showMessageDialog(this, "This Diagnosis is already added", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);
                   }
                
                  
                }
                
            
            jListPPDiagnosisMedication.clearSelection();
            
            
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_jListPPDiagnosisMedicationMouseReleased

    public void saveProfilePatient(){
        em.getTransaction().begin();
//        saveW=true;
        
        
        try {
           
                currentPatient.setName(jTextFieldPatientProfileName.getText());
            
        } catch (Exception e) {
            System.out.println("Error updating the name");
            System.out.println(e.getMessage());
        }
        
        try {
            
            if(jComboBoxPatientProfileGender.getSelectedIndex()==0){
                currentPatient.setGender('m');
            }
            else{
                currentPatient.setGender('f');
            }
            
        } catch (Exception e) {
            
            System.out.println("Error updating gender");
            
        }
        
        try {
            
            currentPatient.setMaritalStatus(jComboBoxPatientProfileMarital.getSelectedIndex());
            
        } catch (Exception e) {
            
            System.out.println("Error updating marital status");
            
        }
        
     
        
        try {
            currentPatient.setIsPregnant(jComboBoxPatientProfilePregnant.getSelectedIndex());
        } catch (Exception e) {
        }
        
        try {
            if(jComboBoxPatientProfileGender.getSelectedIndex()==0 || (jComboBoxPatientProfileGender.getSelectedIndex()==1 && jComboBoxPatientProfileMarital.getSelectedIndex()==0)){
                currentPatient.setIsPregnant(0);
            }
        } catch (Exception e) {
        }
        
        
        try {
           
       
            
            double weight = Double.parseDouble(jTextFieldPatientProfileWeight.getText());
            double height = Double.parseDouble(jTextFieldPatientProfileHeight.getText())/100; 
//            System.out.println("double Weight is " + weight);
//            System.out.println("double Heighsghft is " + height);
            
            Double calc;
            String tmp;

            
            if(weight==0 || height==0){
                tmp="0";
            }
            else{
               calc = (weight / (height * height));
               tmp = String.valueOf(calc);
               tmp = tmp.substring(0, 5);
               System.out.println("Weight "+weight);
               System.out.println("Height "+height);
               System.out.println("BMI"+tmp);
            }
            calc = Double.parseDouble(tmp);
            
            jTextFieldPatientProfileBMI.setText(String.valueOf(calc));
            currentPatient.setWeight(Integer.parseInt(jTextFieldPatientProfileWeight.getText()));
            currentPatient.setHeight(Integer.parseInt(jTextFieldPatientProfileHeight.getText()));
            
            if(calc>=100){
             tmp=tmp.substring(0, 2);
             calc = Double.parseDouble(tmp);
            }
            currentPatient.setBmi(BigDecimal.valueOf(calc));
        
         
        } catch (Exception e) {
            
            
            System.out.println("Error updating weight or height or bmi");
            System.out.println(e.getMessage());
//            JOptionPane.showMessageDialog(this, "Please enter a valid weight or height.", "Eroshetta", JOptionPane.INFORMATION_MESSAGE);
//            saveW=false;
        }
        

        try {
            
            Date d = new Date();
            d.setDate(Integer.parseInt(String.valueOf(jComboBoxPatientProfileDay.getSelectedItem())));
            d.setMonth(jComboBoxPatientProfileMonth.getSelectedIndex());
            d.setYear(Integer.parseInt(String.valueOf(jComboBoxPatientProfileYear.getSelectedItem()))-1900);
            currentPatient.setBirthDate(d);
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            System.out.println("Error updating birthday");
            
        }
        
        
            em.persist(currentPatient);
            em.getTransaction().commit();
        
    }
    
    public boolean checkExistDrug(Drugs test){
        for(int i=0; i<currentPatienMedications.size(); i++){
            if(test.getId()==currentPatienMedications.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkExistDiagnosis(Diagnoses test){
        for(int i=0; i<currentPatienDiagnoses.size();i++){
            if(test.getId()==currentPatienDiagnoses.get(i).getId()){
                return true;
            }
        }
        return false;
    }
    
    public void deleteDrug() {
        try {

        
//        System.out.println("The counter both "+counterDrugs);
            int selectedDrugIndex = jListPPM3edication.getSelectedIndex();
            Drugs deletedDrug = currentPatienMedications.get(selectedDrugIndex);
//            System.out.println(selectedDrugIndex);
//            System.out.println(deletedDrug.getClassName());
//            System.out.println("All drugs llist is "+ allDrugs.size());
//            System.out.println("The seleceted drug is "+ allDrugs.get(selectedDrugIndex).getClassName());

                DefaultListModel modelDeleteMedication = (DefaultListModel) jListPPM3edication.getModel();
//            System.out.println(modelDeleteMedication.get(selectedDrugIndex));
                modelDeleteMedication.remove(selectedDrugIndex);
                jListPPM3edication.setModel(modelDeleteMedication);
                jListPPM3edication.clearSelection();
//            System.out.println("COME HERE");

            List newDrugsList = currentPatienMedications;
            newDrugsList.remove(selectedDrugIndex);
            currentPatient.setDrugsCollection(newDrugsList);
            currentPatienMedications = (List<Drugs>) currentPatient.getDrugsCollection();
            
            
//            System.out.println("COME HERE AGAIN");

            this.deleteDrugDB(deletedDrug.getId());
 

        } catch (Exception e) {
        }
    }

    public void deleteDrugDB(int drugID) {

        try {
            Connection con = DriverManager.getConnection(host, usrN, usrP);
            Statement stmt = con.createStatement();
            String SQL = "DELETE FROM PATIENT_CURRENT_MEDICATION WHERE PATIENT_ID =" + currentPatient.getId() + "AND DRUG_ID =" + drugID + "";
            int delete = stmt.executeUpdate(SQL);
            System.out.println(delete);
            if (delete == 1) {
                System.out.println("Row is deleted.");
            } else {
                System.out.println("Row is not deleted.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteDiagnosis() {


        try {

            int selectedDiagnosisIndex = jListPPDiagnosis.getSelectedIndex();
            Diagnoses deletedDiagnoses = currentPatienDiagnoses.get(selectedDiagnosisIndex);

            DefaultListModel modelDeleteDiagnosis = (DefaultListModel) jListPPDiagnosis.getModel();
            modelDeleteDiagnosis.remove(selectedDiagnosisIndex);
            jListPPDiagnosis.setModel(modelDeleteDiagnosis);
            jListPPDiagnosis.clearSelection();

//            System.out.println("COME HERE");

            List newDiagnosisList = currentPatienDiagnoses;
            newDiagnosisList.remove(selectedDiagnosisIndex);
            currentPatient.setDiagnosesCollection(newDiagnosisList);
            currentPatienDiagnoses = (List<Diagnoses>) currentPatient.getDiagnosesCollection();

//            System.out.println("COME HERE AGAIN");
            
            this.deleteDiagnosisDB(deletedDiagnoses.getId());
            

        } catch (Exception e) {
        }

    }

    public void deleteDiagnosisDB(int diagnosisID) {
        try {
            Connection con = DriverManager.getConnection(host, usrN, usrP);
            Statement stmt = con.createStatement();
            String SQL = "DELETE FROM PATIENT_HAS_DIAGNOSIS WHERE PATIENT_ID =" + currentPatient.getId() + "AND DIAGNOSIS_ID =" + diagnosisID + "";
            int delete = stmt.executeUpdate(SQL);
            System.out.println(delete);
            if (delete == 1) {
                System.out.println("Row is deleted.");
            } else {
                System.out.println("Row is not deleted.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void profileGenderMaritalStatus() {
        if (jComboBoxPatientProfileGender.getSelectedIndex() == 0) {
            jComboBoxPatientProfilePregnant.setVisible(false);
            jLabelPatientProfilePregnant.setVisible(false);
        } else {
            if (jComboBoxPatientProfileGender.getSelectedIndex() == 1 && jComboBoxPatientProfileMarital.getSelectedIndex() == 1) {
                jComboBoxPatientProfilePregnant.setVisible(true);
                jLabelPatientProfilePregnant.setVisible(true);
            } else {
                jComboBoxPatientProfilePregnant.setVisible(false);
                jLabelPatientProfilePregnant.setVisible(false);
            }
        }
    }

    public void leapYearModification() {
        
        int x = dayHazard;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int selectedYear = (Integer) jComboBoxPatientProfileYear.getSelectedItem();
        int selectedMonth = (Integer) jComboBoxPatientProfileMonth.getSelectedIndex();
        boolean leapYearFlag;
        DefaultComboBoxModel dayModelLeapYead = new DefaultComboBoxModel();
        jComboBoxPatientProfileDay.setModel(dayModelLeapYead);

        if ((selectedYear % 4 == 0) && (selectedYear % 100 != 0) || (selectedYear % 400 == 0)) {
            leapYearFlag = true;
        } else {
            leapYearFlag = false;
        }
        if (selectedMonth == 1 || selectedMonth == 3 || selectedMonth == 5 || selectedMonth == 7 || selectedMonth == 8 || selectedMonth == 10 || selectedMonth == 12) {
            for (int i = 1; i < 32; i++) {
                dayModelLeapYead.addElement(i);
                
            }
            jComboBoxPatientProfileDay.setSelectedIndex(x-1);
        } else {
            if (selectedMonth == 4 || selectedMonth == 6 || selectedMonth == 9 || selectedMonth == 11) {
                for (int i = 1; i < 31; i++) {
                    dayModelLeapYead.addElement(i);
                }
                jComboBoxPatientProfileDay.setSelectedIndex(x-1);
            } else {
                if (selectedMonth == 2 && leapYearFlag) {
                    for (int i = 1; i < 30; i++) {
                        dayModelLeapYead.addElement(i);
                    }
                    jComboBoxPatientProfileDay.setSelectedIndex(x-1);
                } else {
                    for (int i = 1; i < 29; i++) {
                        dayModelLeapYead.addElement(i);
                    }
                    jComboBoxPatientProfileDay.setSelectedIndex(x-1);
                }
            }
        }
    }

    public void disableProfilePatient(){
        jTextFieldPatientProfileName.setEnabled(false);
        jTextFieldPatientProfileHeight.setEnabled(false);
        jTextFieldPatientProfileWeight.setEnabled(false);
        jTextFieldPPMedication.setEnabled(false);
        jTextFieldPatientProfileName.setEnabled(false);
        
        jComboBoxPatientProfileDay.setEnabled(false);
        jComboBoxPatientProfileGender.setEnabled(false);
        jComboBoxPatientProfileMarital.setEnabled(false);
        jComboBoxPatientProfileMonth.setEnabled(false);
        jComboBoxPatientProfilePregnant.setEnabled(false);
        jComboBoxPatientProfileYear.setEnabled(false);
        jListPPDiagnosis.setEnabled(false);
        jListPPM3edication.setEnabled(false);
        jListPPDiagnosisMedication.setEnabled(false);
        
        jToggleButtonDiagnosis.setEnabled(false);
        jToggleButtonPPMedication.setEnabled(false);
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
//        jToggleButtonDiagnosis.setEnabled(true);
        jToggleButtonDiagnosis.setSelected(false);
//        jToggleButtonPPMedication.setEnabled(true);
        jToggleButtonPPMedication.setSelected(false);
//        jTextFieldPPMedication.setEnabled(false);
//        jListPPDiagnosisMedication.setEnabled(false);
//        jLabelPPMedication.setEnabled(false);
        jTextFieldPPMedication.setVisible(false);
        jListPPDiagnosisMedication.setVisible(false);
        jLabelPPMedication.setVisible(false);
//        jScrollPanePPDiagnosisMedication.setEnabled(false);
        jScrollPanePPDiagnosisMedication.setVisible(false);
        
    }
    
    public void enableProfilePatient(){
        jTextFieldPatientProfileName.setEnabled(true);
        jTextFieldPatientProfileHeight.setEnabled(true);
        jTextFieldPatientProfileWeight.setEnabled(true);
        jTextFieldPPMedication.setEnabled(true);
        jTextFieldPatientProfileName.setEnabled(true);
        
        jComboBoxPatientProfileDay.setEnabled(true);
        jComboBoxPatientProfileGender.setEnabled(true);
        jComboBoxPatientProfileMarital.setEnabled(true);
        jComboBoxPatientProfileMonth.setEnabled(true);
        jComboBoxPatientProfilePregnant.setEnabled(true);
        jComboBoxPatientProfileYear.setEnabled(true);
        
        jToggleButtonDiagnosis.setEnabled(true);
        jToggleButtonPPMedication.setEnabled(true);
        jListPPDiagnosis.setEnabled(true);
        jListPPDiagnosisMedication.setEnabled(true);
        jListPPM3edication.setEnabled(true);
    }
    
    
    
    
//    public static void createPatients() {
//        em.getTransaction().begin();
//        for (int i = 0; i < 25; i++) {
//
//            Patients p = new Patients();
//            p.setName("Patient" + i);
//
//            if (i % 2 == 0) {
//                p.setGender('m');
//                p.setHeight(i * 100);
//                int h = i * 100;
//                p.setWeight(((i * 100) + (i * 2)));
//                double w = (i * 100) + (i * 2);
//                double b = h / (w * w);
//                p.setBmi(BigDecimal.valueOf(i));
//                if ((1 + i) % 4 == 0) {
//                    p.setMaritalStatus(0);
//                } else {
//                    p.setMaritalStatus(1);
//
//                }
//            } else {
//                p.setGender('f');
//                p.setHeight(i * 100);
//                int h = i * 100;
//                p.setWeight(((i * 100) + (i * 2)));
//                double w = (i * 100) + (i * 2);
//                double b = h / (w * w);
//                p.setBmi(BigDecimal.valueOf(i));
//
//                if ((i + 1) % 3 == 0) {
//                    p.setMaritalStatus(0);
//                } else {
//                    p.setMaritalStatus(1);
//                    if ((i + 1) % 4 == 0) {
//                        p.setIsPregnant(0);
//                    } else {
//                        p.setIsPregnant(1);
//                    }
//                }
//
//
//            }
//
//
//            Date d = new Date(102, 5, 23);
//            p.setBirthDate(d);
//            em.persist(p);
//
//        }
//
//        em.getTransaction().commit();
//
//    }
//
//    public static void diagnosis() {
//        em.getTransaction().begin();
//        for (int i = 0; i < 25; i++) {
//            Diagnoses d = new Diagnoses();
//            d.setId(i);
//            d.setName("Diagnosis" + i);
//            em.persist(d);
//        }
//        em.getTransaction().commit();
//    }

    public static void findAllPatients() {

        Query q = em.createNamedQuery("Patients.findByName");
        q.setParameter("pName", "%");

        patientsBookList = (List<Patients>) q.getResultList();
//         System.out.println();
//         Patients p = l.get(0);
//         System.out.println(p.getName());
//         System.out.println(l.get(0));
//         System.out.println(patientsBookList.toString());

    }

    public static void getAllDiagnosis() {
//        Query q = em.createNamedQuery("Diagnoses.findAll");
//        List allDiagnosis = (List<Diagnoses>) q.getResultList();
//        System.out.println(allDiagnosis.size());
    }

//    public static void setOne() {
//        Query q = em.createNamedQuery("Patients.findAll");
//        List patientsList = (List<Patients>) q.getResultList();
//        Patients p = (Patients) patientsList.get(0);
//        System.out.println(p.getName());
//
//        Query q2 = em.createNamedQuery("Diagnoses.findAll");
//        List allDiagnosis = (List<Diagnoses>) q2.getResultList();
////        p.setDiagnosesCollection(allDiagnosis);
//        List pDiagnosis = (List<Diagnoses>) p.getDiagnosesCollection();
//        pDiagnosis.addAll(allDiagnosis);
//        p.setDiagnosesCollection(pDiagnosis);
////        System.out.println(pDiagnosis.addAll(allDiagnosis));
//
//    }

//    public static void patientsDiagnosis() {
//        Query q = em.createNamedQuery("Patients.findAll");
//        List patientsList = (List<Patients>) q.getResultList();
//
//        Query q2 = em.createNamedQuery("Diagnoses.findAll");
//        Collection allDiagnosis = q2.getResultList();
//
////        System.out.println(allDiagnosis.size());
////        System.out.println("All Diagnosis wa 7raaaaaaaaaaam ");
//
////        for(int i=0; i<allDiagnosis.size(); i++){
////            Diagnoses d = (Diagnoses) allDiagnosis.get(i);
////            System.out.println(d.getName());
////        }
////        
//
//        for (int i = 0; i < patientsList.size(); i++) {
////            System.out.println(i);
//            Patients p = (Patients) patientsList.get(i);
////            List diagnosisList = (List <Diagnoses>) p.getDiagnosesCollection();
//            p.setDiagnosesCollection(allDiagnosis);
//
////            Query q2 = em.createNamedQuery("Diagnoses.findAll");
////            List allDiagnosis = (List <Diagnoses>) q.getResultList();   
////            
////            System.out.println(p.getName());
//
////            System.out.println("Now importing to " +i);
////            System.out.println("Now getting to " +i);
////            for(int j=0; j<diagnosisList.size(); j++){
////                System.out.println(j);
////                Diagnoses diag = (Diagnoses) diagnosisList.get(j);
////                System.out.println(diag.getName());
////            }
//
//        }
//
//    }
//
//    public static void getCurrentMedications() {
//        Query q = em.createNamedQuery("Patients.findById");
//        q.setParameter("id", 1);
//        List l = (List<Patients>) q.getResultList();
//        Patients p = (Patients) l.get(0);
//        List patientDrugList = (List) p.getDrugsCollection();
//        Drugs d = (Drugs) patientDrugList.get(0);
//
//        System.out.println(d.getTradeName());
//
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Eroshetta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Eroshetta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Eroshetta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Eroshetta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        
        
 try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                boolean flag = true;
                try {
                    javax.persistence.Query q = em.createNamedQuery("Doctor.findAll");
                    Doctor doc = (Doctor) q.getSingleResult();
                } catch (NoResultException e) {
                    flag = false;
                }


                if (flag) {
                    eroshetta.setVisible(true);
                } else {
                    DoctorInfo docInfo = new DoctorInfo();
                    docInfo.setVisible(true);
                }





//                e.setExtendedState(Frame.MAXIMIZED_BOTH);

            }
        });






//     createPatients();
//     diagnosis();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

//em.getTransaction().begin();
//
//Patients p =new Patients();
//p.setName("mohsin");
//em.persist(p);
//em.getTransaction().commit();







    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel DrugsInPrescription;
    private javax.swing.JPanel Panel_Drugs;
    private javax.swing.JButton addToPresc;
    private static javax.swing.JCheckBox checkBoxClass;
    private static javax.swing.JCheckBox checkBoxGeneric;
    private static javax.swing.JCheckBox checkBoxTrade;
    private javax.swing.JLabel dosageForm;
    private javax.swing.JLabel drugClassName;
    private javax.swing.JLabel drugDosage;
    private javax.swing.JLabel drugFoods;
    private javax.swing.JLabel drugGenericNames;
    private javax.swing.JLabel drugHalfLife;
    private javax.swing.JLabel drugMajor;
    private javax.swing.JLabel drugMinor;
    private javax.swing.JLabel drugPrecautions;
    private javax.swing.JPanel drugProfile;
    private javax.swing.JLabel drugRoute;
    private javax.swing.JLabel drugTradeName;
    private javax.swing.JMenuItem editDoctorProfile;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBoxPatientProfileDay;
    private javax.swing.JComboBox jComboBoxPatientProfileGender;
    private javax.swing.JComboBox jComboBoxPatientProfileMarital;
    private javax.swing.JComboBox jComboBoxPatientProfileMonth;
    private javax.swing.JComboBox jComboBoxPatientProfilePregnant;
    private javax.swing.JComboBox jComboBoxPatientProfileYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBMIDesc;
    private javax.swing.JLabel jLabelPPMedication;
    private javax.swing.JLabel jLabelPatientProfileBMI;
    private javax.swing.JLabel jLabelPatientProfileBirthday;
    private javax.swing.JLabel jLabelPatientProfileCurrentMedication;
    private javax.swing.JLabel jLabelPatientProfileDiagnosis;
    private javax.swing.JLabel jLabelPatientProfileGender;
    private javax.swing.JLabel jLabelPatientProfileHeight;
    private javax.swing.JLabel jLabelPatientProfileHeightCM;
    private javax.swing.JLabel jLabelPatientProfileMaritalStatus;
    private javax.swing.JLabel jLabelPatientProfileName;
    private javax.swing.JLabel jLabelPatientProfilePregnant;
    private javax.swing.JLabel jLabelPatientProfileWeight;
    private javax.swing.JLabel jLabelPatientProfileWeiightKG;
    private javax.swing.JList jListPPDiagnosis;
    private javax.swing.JList jListPPDiagnosisMedication;
    private javax.swing.JList jListPPM3edication;
    private javax.swing.JList jListPatientsBook;
    private javax.swing.JList jList_Drugs;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelPatientOldPresc;
    private javax.swing.JPanel jPanelPatientProfile;
    private javax.swing.JPanel jPanelPatientsBook;
    private javax.swing.JPanel jPanelPrescription;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPanePPDiagnosis;
    private javax.swing.JScrollPane jScrollPanePPDiagnosisMedication;
    private javax.swing.JScrollPane jScrollPanePPMedication;
    private javax.swing.JScrollPane jScrollPanePatientsBook;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldPPMedication;
    private javax.swing.JTextField jTextFieldPatientProfileBMI;
    private javax.swing.JTextField jTextFieldPatientProfileHeight;
    private javax.swing.JTextField jTextFieldPatientProfileName;
    private javax.swing.JTextField jTextFieldPatientProfileWeight;
    private javax.swing.JTextField jTextFieldPatientsBook;
    private javax.swing.JTextField jTextFieldSearchDrags;
    private javax.swing.JToggleButton jToggleButtonDiagnosis;
    private javax.swing.JToggleButton jToggleButtonPPMedication;
    private javax.swing.JButton savePreview;
    // End of variables declaration//GEN-END:variables
}
