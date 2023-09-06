package ClientGUI;


import AdminGUI.AdminGUI;
import Connector.DatabaseConnector;
import Constructors.Id;
import Constructors.Registration;
import Constructors.Subscriber;
import Crud.IdCRUD;
import Crud.RegistrationCRUD;
import Crud.SubscriberCRUD;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Objects;
import java.util.Properties;

public class SimGUI implements ActionListener {
    static DatabaseConnector db = new DatabaseConnector();
    static Connection connection = db.createConnection();
    RegistrationCRUD regCrud = new RegistrationCRUD();
    SubscriberCRUD subCrud = new SubscriberCRUD();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");



    private final JLayeredPane layeredPane;

    /**
     *START UP ELEMENTS
     */
    private final JPanel panel1;
    private final JButton yes;
    private final JButton no;

    /**
     * REGISTER ENTITIES
     */

    String [] simTypeList = {"","Smart","Globe","TNT","DITTO","GOMO","TM"};
    String [] suffixList = {"","I","II","III","IV","Jr.","Sr."};
    String [] sexList = {"","Male","Female"};
    String [] nationalityList = {"","Afghan","Albanian","Algerian","American","Andorran","Angolan","Anguillan","Argentine","Armenian","Australian","Austrian","Azerbaijani","Bahamian","Bahraini","Bangladeshi","Barbadian","Belarusian","Belgian","Belizean","Beninese","Bermudian","Bhutanese","Bolivian","Botswanan","Brazilian","British","British Virgin Islander","Bruneian","Bulgarian","Burkinan","Burmese","Burundian","Cambodian","Cameroonian","Canadian","Cape Verdean","Cayman Islander","Central African","Chadian","Chilean","Chinese","Citizen of Antigua and Barbuda","Citizen of Bosnia and Herzegovina","Citizen of Guinea-Bissau","Citizen of Kiribati","Citizen of Seychelles","Citizen of the Dominican Republic","Citizen of Vanuatu","Colombian","Comoran","Congolese (Congo)","Congolese (DRC)","Cook Islander","Costa Rican","Croatian","Cuban","Cymraes","Cymro","Cypriot","Czech","Danish","Djiboutian","Dominican","Dutch","East Timorese","Ecuadorean","Egyptian","Emirati","English","Equatorial Guinean","Eritrean","Estonian","Ethiopian","Faroese","Fijian","Filipino","Finnish","French","Gabonese","Gambian","Georgian","German","Ghanaian","Gibraltarian","Greek","Greenlandic","Grenadian","Guamanian","Guatemalan","Guinean","Guyanese","Haitian","Honduran","Hong Konger","Hungarian","Icelandic","Indian","Indonesian","Iranian","Iraqi","Irish","Israeli","Italian","Ivorian","Jamaican","Japanese","Jordanian","Kazakh","Kenyan","Kittitian","Kosovan","Kuwaiti","Kyrgyz","Lao","Latvian","Lebanese","Liberian","Libyan","Liechtenstein citizen","Lithuanian","Luxembourger","Macanese","Macedonian","Malagasy","Malawian","Malaysian","Maldivian","Malian","Maltese","Marshallese","Martiniquais","Mauritanian","Mauritian","Mexican","Micronesian","Moldovan","Monegasque","Mongolian","Montenegrin","Montserratian","Moroccan","Mosotho","Mozambican","Namibian","Nauruan","Nepalese","New Zealander","Nicaraguan","Nigerian","Nigerien","Niuean","North Korean","Northern Irish","Norwegian","Omani","Pakistani","Palauan","Palestinian","Panamanian","Papua New Guinean","Paraguayan","Peruvian","Pitcairn Islander","Polish","Portuguese","Prydeinig","Puerto Rican","Qatari","Romanian","Russian","Rwandan","Salvadorean","Sammarinese","Samoan","Sao Tomean","Saudi Arabian","Scottish","Senegalese","Serbian","Sierra Leonean","Singaporean","Slovak","Slovenian","Solomon Islander","Somali","South African","South Korean","South Sudanese","Spanish","Sri Lankan","St Helenian","St Lucian","Stateless","Sudanese","Surinamese","Swazi","Swedish","Swiss","Syrian","Taiwanese","Tajik","Tanzanian","Thai","Togolese","Tongan","Trinidadian","Tristanian","Tunisian","Turkish","Turkmen","Turks and Caicos Islander","Tuvaluan","Ugandan","Ukrainian","Uruguayan","Uzbek","Vatican citizen","Venezuelan","Vietnamese","Vincentian","Wallisian","Welsh","Yemeni","Zambian","Zimbabwean"};
    String [] registrationTypeList = {"","Owner","Guardian","Parent"};
    String [] provinceList = {"","ABRA","AGUSAN DEL NORTE","AGUSAN DEL SUR","AKLAN","ALBAY","ANTIQUE","APAYAO","AURORA","BASILAN","BATAAN","BATANES","BATANGAS","BENGUET","BILIRAN","BOHOL","BUKIDNON","BULACAN","CAGAYAN","CAMARINES NORTE","CAMARINES SUR","CAMIGUIN","CAPIZ","CATANDUANES","CAVITE","CEBU","CITY OF ISABELA","CITY OF MANILA","COMPOSTELA VALLEY","COTABATO (NORTH COTABATO)","COTABATO CITY","DAVAO DEL NORTE","DAVAO DEL SUR","DAVAO OCCIDENTAL","DAVAO ORIENTAL","DINAGAT ISLANDS","EASTERN SAMAR","GUIMARAS","IFUGAO","ILOCOS NORTE","ILOCOS SUR","ILOILO","ISABELA","KALINGA","LA UNION","LAGUNA","LANAO DEL NORTE","LANAO DEL SUR","LEYTE","MAGUINDANAO","MARINDUQUE","MASBATE","MISAMIS OCCIDENTAL","MISAMIS ORIENTAL","MOUNTAIN PROVINCE","NCR, CITY OF MANILA, FIRST DISTRICT","NCR, FOURTH DISTRICT","NCR, SECOND DISTRICT","NCR, THIRD DISTRICT","NEGROS OCCIDENTAL","NEGROS ORIENTAL","NORTHERN SAMAR","NUEVA ECIJA","NUEVA VIZCAYA","OCCIDENTAL MINDORO","ORIENTAL MINDORO","PALAWAN","PAMPANGA","PANGASINAN","QUEZON","QUIRINO","RIZAL","ROMBLON","SAMAR (WESTERN SAMAR)","SARANGANI","SIQUIJOR","SORSOGON","SOUTH COTABATO","SOUTHERN LEYTE","SULTAN KUDARAT","SULU","SURIGAO DEL NORTE","SURIGAO DEL SUR","TARLAC","TAWI-TAWI","ZAMBALES","ZAMBOANGA DEL NORTE","ZAMBOANGA DEL SUR","ZAMBOANGA SIBUGAY"};
    private final JFrame frame;
    private final JPanel panel2;
    private final JTextField fName;
    private final JTextField mName;
    private final JTextField lName;
    private final JComboBox<String> suf;
    private final JComboBox<String> s;
    private final JComboBox<String> nat;
    private final JComboBox<String> regBox;
    private final JTextField u;
    private final JTextField st;
    private final JComboBox<String> prov;
    private final JComboBox ct;
    private final JComboBox bar;
    private final JTextField zp;
    private final JButton back;
    private final JButton signUp;
    private final JDatePickerImpl datePicker;
    JDatePanelImpl datePanel;
    java.util.Date selectedDate;


    /**
     * REGISTER NUMBER
     */

    private final JPanel panel3;
    private final JTextField mNumber;
    private final JButton next;
   /* private final JButton back2;*/
    private final JButton regSim;

    /**
     *  REGISTER NEW SIM
     */

    private final JPanel panel4;
    private final JTextField mNumber2;
    private final JComboBox<String> ownership2;
    private final JComboBox<String> simType;
    private final JComboBox<String> simType2;
    private JButton back3;

    /**
     * UserID CHECKER
     */

    private final JPanel panel5;
    private final JTextField userId;
    private final JButton next2;

    /**
     * ADD ID
     */

    IdCRUD idCRUD = new IdCRUD();
    private JFrame prevPhoto;
    private JButton upload2;
    private JButton browse;
    private JLabel photo;
    private JPanel photoPanel;
    private JFileChooser file;
    private FileNameExtensionFilter filter;
    private String path;
    private String path2;
    private JTextField pPic;
    private JTextField gPic;
    private JTextField idField;
    private JComboBox idCombo;
    private JButton browse2;
    private JButton preview;
    private JButton preview2;
    private JButton back4;
    InputStream in;
    InputStream in2;

    private String [] validId = {"","Philippines Passport", "Driver's License", "SSS Card", "GSIS Card"
            ,"UMID Card", "PRC ID", "OWWA ID", "IBP ID", "BIR Taxpayer's ID", "Diplomat ID", "Voter's ID", "Digitized Postal ID", "OFW ID"};


    SimGUI() {
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,450,700);

        /**
         * STARTUP PANE
         */

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 450, 700);
        panel1.setBackground(Color.decode("#FAFFF9"));
        panel1.setOpaque(true);
        panel1.setLayout(null);

        JLabel simReg = new JLabel("Are you an existing user?");
        simReg.setFont(new Font("SansSerif", Font.BOLD, 16));
        simReg.setOpaque(true);
        simReg.setForeground(Color.WHITE);
        simReg.setBackground(Color.decode("#003049"));
        simReg.setBounds(0, 0, 450, 100);
        simReg.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(simReg);

        yes = new JButton("Yes");
        yes.setBounds(100,150,100,40);
        yes.setFont(new Font("SansSerif", Font.BOLD,13));
        yes.addActionListener(this);
        panel1.add(yes);

        no = new JButton("No");
        no.setBounds(250,150,100,40);
        no.setFont(new Font("SansSerif", Font.BOLD,13));
        no.addActionListener(this);
        panel1.add(no);

        /**
         * REGISTER PANE
         */

        panel2 = new JPanel();
        panel2.setBounds(0,0,450,700);
        panel2.setOpaque(true);
        panel2.setBackground(Color.decode("#FAFFF9"));
        panel2.setLayout(null);

        JLabel simReg2 = new JLabel("Fill Up this Form");
        simReg2.setFont(new Font("SansSerif", Font.BOLD, 16));
        simReg2.setOpaque(true);
        simReg2.setForeground(Color.WHITE);
        simReg2.setBackground(Color.decode("#003049"));
        simReg2.setBounds(0, 0, 450, 70);
        simReg2.setHorizontalAlignment(JLabel.CENTER);
        panel2.add(simReg2);

        JLabel fill = new JLabel("Tell us about you.");
        fill.setFont(new Font("Verdana", Font.BOLD, 14));
        fill.setForeground(Color.decode("#457B9D"));
        fill.setBounds(30,80,300,30);
        panel2.add(fill);

        JLabel firstName = new JLabel("First Name");
        firstName.setFont(new Font("Verdana", Font.PLAIN, 11));
        firstName.setBounds(30, 110, 100, 30);
        panel2.add(firstName);
        fName = new JTextField(15);
        fName.setFont(new Font("Verdana", Font.PLAIN, 12));
        fName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                fName.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        fName.setBounds(28, 135, 180, 30);

        panel2.add(fName);

        JLabel middleName = new JLabel("Middle Name");
        middleName.setFont(new Font("Verdana", Font.PLAIN, 11));
        middleName.setBounds(230, 110, 100, 30);
        panel2.add(middleName);
        mName = new JTextField(15);
        mName.setFont(new Font("Verdana", Font.PLAIN, 12));
        mName.setBounds(228, 135, 180, 30);
        mName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                mName.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel2.add(mName);

        JLabel lastName = new JLabel("Last Name");
        lastName.setFont(new Font("Verdana", Font.PLAIN, 11));
        lastName.setBounds(30, 165, 100, 30);
        panel2.add(lastName);
        lName = new JTextField(15);
        lName.setFont(new Font("Verdana", Font.PLAIN, 12));
        lName.setBounds(28, 190, 180, 30);
        lName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                lName.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel2.add(lName);

        JLabel suffix = new JLabel("Suffix (Optional)");
        suffix.setFont(new Font("Verdana", Font.PLAIN, 11));
        suffix.setBounds(230, 165, 150, 30);
        panel2.add(suffix);
        suf = new JComboBox<>(suffixList);
        suf.setSelectedIndex(0);
        suf.addActionListener(this);
        suf.setFont(new Font("Verdana", Font.PLAIN, 12));
        suf.setBounds(228, 190, 180, 30);
        panel2.add(suf);

        /*
         * DATE PICKER IMPLEMENTATION
         */
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        model.setDate(1990, 8, 24);

        JLabel birthdate = new JLabel("Birthdate");
        birthdate.setFont(new Font("Verdana", Font.PLAIN, 11));
        birthdate.setBounds(30, 220, 100, 30);
        panel2.add(birthdate);
        datePicker.setBounds(28,245,180,30);
        panel2.add(datePicker);

        JLabel sex = new JLabel("Sex");
        sex.setFont(new Font("Verdana", Font.PLAIN, 11));
        sex.setBounds(230, 220, 100, 30);
        panel2.add(sex);
        s = new JComboBox<>(sexList);
        s.setSelectedIndex(0);
        s.addActionListener(this);
        s.setFont(new Font("Verdana", Font.PLAIN, 12));
        s.setBounds(228, 245, 180, 30);
        panel2.add(s);

        JLabel nationality = new JLabel("Nationality");
        nationality.setFont(new Font("Verdana", Font.PLAIN, 11));
        nationality.setBounds(30, 275, 100, 30);
        panel2.add(nationality);
        nat = new JComboBox<>(nationalityList);
        nat.setSelectedIndex(0);
        nat.addActionListener(this);
        nat.setFont(new Font("Verdana", Font.PLAIN, 12));
        nat.setBounds(28, 300, 180, 30);
        panel2.add(nat);

        JLabel registrationType = new JLabel("Ownership");
        registrationType.setFont(new Font("Verdana", Font.PLAIN, 11));
        registrationType.setBounds(230, 275, 100, 30);
        panel2.add(registrationType);
        regBox = new JComboBox<>(registrationTypeList);
        regBox.setSelectedIndex(0);
        regBox.addActionListener(this);
        regBox.setFont(new Font("Verdana", Font.PLAIN, 12));
        regBox.setBounds(228, 300, 180, 30);
        panel2.add(regBox);


        JLabel fill2 = new JLabel("Where do you live?");
        fill2.setFont(new Font("Verdana", Font.BOLD, 14));
        fill2.setForeground(Color.decode("#457B9D"));
        fill2.setBounds(30,380,300,30);
        panel2.add(fill2);

        JLabel unit = new JLabel("Unit no./House no./");
        unit.setFont(new Font("Verdana", Font.PLAIN, 11));
        unit.setBounds(30, 410, 100, 30);
        panel2.add(unit);
        u = new JTextField(15);
        u.setFont(new Font("Verdana", Font.PLAIN, 12));
        u.setBounds(28, 435, 180, 30);
        u.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                u.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel2.add(u);

        JLabel street = new JLabel("Street");
        street.setFont(new Font("Verdana", Font.PLAIN, 11));
        street.setBounds(230, 410, 100, 30);
        panel2.add(street);
        st = new JTextField(15);
        st.setFont(new Font("Verdana", Font.PLAIN, 12));
        st.setBounds(228, 435, 180, 30);
        st.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char ch = e.getKeyChar();
                st.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel2.add(st);

        JLabel province = new JLabel("Province");
        province.setFont(new Font("Verdana", Font.PLAIN, 11));
        province.setBounds(30, 465, 100, 30);
        panel2.add(province);
        prov = new JComboBox<>(provinceList);
        prov.addActionListener(this);
        prov.setFont(new Font("Verdana", Font.PLAIN, 12));
        prov.setBounds(28, 490, 180, 30);
        panel2.add(prov);

        JLabel city = new JLabel("City/Municipality");
        city.setFont(new Font("Verdana", Font.PLAIN, 11));
        city.setBounds(230, 465, 100, 30);
        panel2.add(city);
        ct = new JComboBox<>();
        ct.addActionListener(this);
        ct.setFont(new Font("Verdana", Font.PLAIN, 12));
        ct.setBounds(228, 490, 180, 30);
        panel2.add(ct);

        JLabel barangay = new JLabel("Barangay");
        barangay.setFont(new Font("Verdana", Font.PLAIN, 11));
        barangay.setBounds(30, 520, 100, 30);
        panel2.add(barangay);
        bar = new JComboBox<>();
        bar.addActionListener(this);
        bar.setFont(new Font("Verdana", Font.PLAIN, 12));
        bar.setBounds(28, 545, 180, 30);
        panel2.add(bar);

        JLabel zipcode = new JLabel("Zipcode");
        zipcode.setFont(new Font("Verdana", Font.PLAIN, 11));
        zipcode.setBounds(230, 520, 100, 30);
        panel2.add(zipcode);
        zp = new JTextField();
        zp.setDocument(new JTextFieldLimit(4));
        zp.setFont(new Font("Verdana", Font.PLAIN, 12));
        zp.setBounds(228, 545, 180, 30);
        zp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {zp.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel2.add(zp);

        signUp = new JButton("Next");
        signUp.setForeground(Color.decode("#003049"));
        signUp.setBackground(Color.WHITE);
        signUp.setOpaque(true);
        signUp.setBounds(315,600,90,35);
        signUp.setFont(new Font("SansSerif", Font.BOLD,13));
        signUp.addActionListener(this);
        panel2.add(signUp);

        back = new JButton("Back");
        back.setForeground(Color.decode("#003049"));
        back.setBackground(Color.WHITE);
        back.setOpaque(true);
        back.setBounds(30,600,90,35);
        back.setFont(new Font("SansSerif", Font.BOLD,13));
        back.addActionListener(this);
        panel2.add(back);

        /**
         * REGISTER NUMBER
         */

        panel3 = new JPanel();
        panel3.setBounds(0,0,450,280);
        panel3.setOpaque(true);
        panel3.setBackground(Color.decode("#FAFFF9"));
        panel3.setLayout(null);

        JLabel simReg3 = new JLabel("SIM Fill Up");
        simReg3.setFont(new Font("SansSerif", Font.BOLD, 16));
        simReg3.setOpaque(true);
        simReg3.setForeground(Color.WHITE);
        simReg3.setBackground(Color.decode("#003049"));
        simReg3.setBounds(0, 0, 450, 70);
        simReg3.setHorizontalAlignment(JLabel.CENTER);
        panel3.add(simReg3);

        JLabel mobileNumber = new JLabel("Mobile Number");
        mobileNumber.setFont(new Font("Verdana", Font.PLAIN, 11));
        mobileNumber.setBounds(0, 160, 450, 30);
        mobileNumber.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(mobileNumber);

        JLabel fill3 = new JLabel("Enter your number.");
        fill3.setFont(new Font("Verdana", Font.BOLD, 14));
        fill3.setForeground(Color.decode("#457B9D"));
        fill3.setBounds(0,80,450,30);
        fill3.setHorizontalAlignment(JLabel.CENTER);
        panel3.add(fill3);

        JLabel mobileCode = new JLabel("+63");
        mobileCode.setFont(new Font("Verdana", Font.PLAIN, 18));
        mobileCode.setBounds(80, 115, 200, 45);
        panel3.add(mobileCode);

        mNumber = new JTextField();
        mNumber.setDocument(new JTextFieldLimit(10));
        mNumber.setFont(new Font("Verdana", Font.BOLD, 18));
        mNumber.setBounds(130, 115, 200, 45);
        mNumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                mNumber.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel3.add(mNumber);

        JLabel net = new JLabel("Network");
        net.setFont(new Font("Verdana", Font.PLAIN, 11));
        net.setBounds(355, 105, 450, 30);
        panel3.add(net);

        simType2 = new JComboBox<>(simTypeList);
        simType2.setBounds(335, 130, 100, 30);
        panel3.add(simType2);

        next = new JButton("Next");
        next.setForeground(Color.decode("#003049"));
        next.setBackground(Color.WHITE);
        next.setOpaque(true);
        next.setBounds(315,200,90,35);
        next.setFont(new Font("SansSerif", Font.BOLD,13));
        next.addActionListener(this);
        panel3.add(next);

        /**
         * SIM ADD ANOTHER
         */

        panel4 = new JPanel();
        panel4.setBounds(0,0,450,700);
        panel4.setOpaque(true);
        panel4.setBackground(Color.decode("#FAFFF9"));
        panel4.setLayout(null);


        JLabel simReg4 = new JLabel("NEW SIM Fill Up Form");
        simReg4.setFont(new Font("SansSerif", Font.BOLD, 16));
        simReg4.setOpaque(true);
        simReg4.setForeground(Color.WHITE);
        simReg4.setBackground(Color.decode("#003049"));
        simReg4.setBounds(0, 0, 450, 70);
        simReg4.setHorizontalAlignment(JLabel.CENTER);
        panel4.add(simReg4);

        JLabel fill4 = new JLabel("Enter your number.");
        fill4.setFont(new Font("Verdana", Font.BOLD, 14));
        fill4.setForeground(Color.decode("#457B9D"));
        fill4.setBounds(0,80,450,30);
        fill4.setHorizontalAlignment(JLabel.CENTER);
        panel4.add(fill4);

        JLabel mobileCode2 = new JLabel("+63");
        mobileCode2.setFont(new Font("Verdana", Font.PLAIN, 18));
        mobileCode2.setBounds(80, 115, 200, 45);
        panel4.add(mobileCode2);

        mNumber2 = new JTextField();
        mNumber2.setDocument(new JTextFieldLimit(10));
        mNumber2.setFont(new Font("Verdana", Font.BOLD, 18));
        mNumber2.setBounds(130, 115, 200, 45);
        mNumber2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                mNumber2.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel4.add(mNumber2);


        ownership2 = new JComboBox<>(registrationTypeList);
        ownership2.setBounds(180, 200, 100, 30);
        panel4.add(ownership2);

        simType = new JComboBox<>(simTypeList);
        simType.setBounds(335, 130, 100, 30);
        panel4.add(simType);

        fill4 = new JLabel("Ownership");
        fill4.setFont(new Font("Verdana", Font.PLAIN, 11));
        fill4.setBounds(0, 175, 450, 30);
        fill4.setHorizontalAlignment(SwingConstants.CENTER);
        panel4.add(fill4);

        JLabel fill5 = new JLabel("Network");
        fill5.setFont(new Font("Verdana", Font.PLAIN, 11));
        fill5.setBounds(355, 105, 450, 30);
        panel4.add(fill5);

        regSim = new JButton("Register");
        regSim.setForeground(Color.decode("#003049"));
        regSim.setBackground(Color.WHITE);
        regSim.setOpaque(true);
        regSim.setBounds(315,200,90,35);
        regSim.setFont(new Font("SansSerif", Font.BOLD,13));
        regSim.addActionListener(this);
        panel4.add(regSim);

        back3 = new JButton("Back");
        back3.setForeground(Color.decode("#003049"));
        back3.setBackground(Color.WHITE);
        back3.setOpaque(true);
        back3.setBounds(30,200,90,35);
        back3.setFont(new Font("SansSerif", Font.BOLD,13));
        back3.addActionListener(this);
        panel4.add(back3);

        /**
         * CHECK ID
         */

        panel5 = new JPanel();
        panel5.setBounds(0,0,450,700);
        panel5.setOpaque(true);
        panel5.setBackground(Color.decode("#FAFFF9"));
        panel5.setLayout(null);


        JLabel uIdCheck = new JLabel("UserID CHECK");
        uIdCheck.setFont(new Font("SansSerif", Font.BOLD, 16));
        uIdCheck.setOpaque(true);
        uIdCheck.setForeground(Color.WHITE);
        uIdCheck.setBackground(Color.decode("#003049"));
        uIdCheck.setBounds(0, 0, 450, 70);
        uIdCheck.setHorizontalAlignment(JLabel.CENTER);
        panel5.add(uIdCheck);

        JLabel fill6 = new JLabel("Enter your UserID.");
        fill6.setFont(new Font("Verdana", Font.BOLD, 14));
        fill6.setForeground(Color.decode("#457B9D"));
        fill6.setBounds(0,80,450,30);
        fill6.setHorizontalAlignment(JLabel.CENTER);
        panel5.add(fill6);

        userId = new JTextField();
        userId.setDocument(new JTextFieldLimit(8));
        userId.setFont(new Font("Verdana", Font.BOLD, 18));
        userId.setBounds(130, 115, 200, 45);
        userId.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                userId.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        panel5.add(userId);

        next2 = new JButton("Next");
        next2.setForeground(Color.decode("#003049"));
        next2.setBackground(Color.WHITE);
        next2.setOpaque(true);
        next2.setBounds(315,200,90,35);
        next2.setFont(new Font("SansSerif", Font.BOLD,13));
        next2.addActionListener(this);
        panel5.add(next2);

        /**
         * ID REG
         */

        photoPanel = new JPanel();
        photoPanel.setBounds(0,0,450,420);
        photoPanel.setOpaque(true);
        photoPanel.setBackground(Color.decode("#FAFFF9"));
        photoPanel.setLayout(null);

        JLabel simReg5 = new JLabel("Verify Identification");
        simReg5.setFont(new Font("SansSerif", Font.BOLD, 16));
        simReg5.setOpaque(true);
        simReg5.setForeground(Color.WHITE);
        simReg5.setBackground(Color.decode("#003049"));
        simReg5.setBounds(0, 0, 450, 70);
        simReg5.setHorizontalAlignment(JLabel.CENTER);
        photoPanel.add(simReg5);

        JLabel fill7 = new JLabel("Upload your photo.");
        fill7.setFont(new Font("Verdana", Font.BOLD, 14));
        fill7.setForeground(Color.decode("#457B9D"));
        fill7.setBounds(30,80,300,30);
        photoPanel.add(fill7);

        JLabel portrait = new JLabel("Portrait/Selfie picture");
        portrait.setFont(new Font("Verdana", Font.PLAIN, 11));
        portrait.setBounds(30, 110, 130, 30);
        photoPanel.add(portrait);
        pPic = new JTextField(15);
        pPic.setEditable(false);
        pPic.setFont(new Font("Verdana", Font.PLAIN, 9));
        pPic.setBounds(28, 135, 145, 30);
        photoPanel.add(pPic);

        browse = new JButton("...");
        browse.setBounds(170,138,25,25);
        browse.setFocusPainted(false);
        browse.addActionListener(this);
        photoPanel.add(browse);

        preview = new JButton("Preview");
        preview.setBounds(27,160,60,30);
        preview.setFont(new Font("Verdana", Font.PLAIN, 9));
        preview.setFocusPainted(false);
        preview.addActionListener(this);
        photoPanel.add(preview);

        JLabel idType = new JLabel("ID Type");
        idType.setFont(new Font("Verdana", Font.PLAIN, 11));
        idType.setBounds(230, 110, 100, 30);
        photoPanel.add(idType);
        idCombo = new JComboBox<>(validId);
        idCombo.setSelectedIndex(0);
        idCombo.addActionListener(this);
        idCombo.setFont(new Font("Verdana", Font.PLAIN, 12));
        idCombo.setBounds(228, 135, 180, 30);
        photoPanel.add(idCombo);

        /**
         * LOWER PANEL
         */

        JLabel fill8 = new JLabel("Upload your ID.");
        fill8.setFont(new Font("Verdana", Font.BOLD, 14));
        fill8.setForeground(Color.decode("#457B9D"));
        fill8.setBounds(30,195,300,30);
        photoPanel.add(fill8);

        JLabel id = new JLabel("ID picture");
        id.setFont(new Font("Verdana", Font.PLAIN, 11));
        id.setBounds(30, 225, 100, 30);
        photoPanel.add(id);
        gPic = new JTextField(15);
        gPic.setEditable(false);
        gPic.setFont(new Font("Verdana", Font.PLAIN, 9));
        gPic.setBounds(28, 250, 145, 30);
        photoPanel.add(gPic);

        JLabel idNum = new JLabel("ID Number");
        idNum.setFont(new Font("Verdana", Font.PLAIN, 11));
        idNum.setBounds(230, 225, 100, 30);
        photoPanel.add(idNum);
        idField = new JTextField(15);
        idField.setFont(new Font("Verdana", Font.PLAIN, 12));
        idField.setBounds(228, 250, 180, 30);
        photoPanel.add(idField);

        browse2 = new JButton("...");
        browse2.setBounds(170,252,25,25);
        browse2.addActionListener(this);
        browse2.setFocusPainted(false);
        photoPanel.add(browse2);

        preview2 = new JButton("Preview");
        preview2.setBounds(27,275,60,30);
        preview2.setFont(new Font("Verdana", Font.PLAIN, 9));
        preview2.setFocusPainted(false);
        preview2.addActionListener(this);
        photoPanel.add(preview2);

        upload2 = new JButton("Register");
        upload2.setForeground(Color.decode("#003049"));
        upload2.setBackground(Color.WHITE);
        upload2.setOpaque(true);
        upload2.setBounds(315,325,90,35);
        upload2.setFont(new Font("SansSerif", Font.BOLD,13));
        upload2.addActionListener(this);
        photoPanel.add(upload2);

        back4 = new JButton("Back");
        back4.setForeground(Color.decode("#003049"));
        back4.setBackground(Color.WHITE);
        back4.setOpaque(true);
        back4.setBounds(30,325,90,35);
        back4.setFont(new Font("SansSerif", Font.BOLD,13));
        back4.addActionListener(this);
        photoPanel.add(back4);


        layeredPane.add(panel1  ,0);

        /**
         * SIM REG CHECK
         */

        frame = new JFrame("Sim Registration System");
        frame.setLayout(null);
        frame.setSize(450, 280);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(layeredPane);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == yes) {
            frame.setSize(450, 280);
            frame.setLocationRelativeTo(null);
            layeredPane.removeAll();
            layeredPane.add(panel5);
            /*panel5.add(back2);*/
            layeredPane.revalidate();
        }

        if(e.getSource() == next2) {
            try {
                if (subCrud.checkUserId(Integer.parseInt(userId.getText()))) {
                    throw new SQLException("Error: UserID does not exist");
                }
                JOptionPane.showMessageDialog(null,"UserID Exists!");
                frame.setSize(450, 280);
                frame.setLocationRelativeTo(null);
                layeredPane.removeAll();
                layeredPane.add(panel4);
                layeredPane.revalidate();
            }catch (NumberFormatException ex4) {
                JOptionPane.showMessageDialog(null,"Error: No input. Please enter a value");
            }catch (SQLException ex5) {
                JOptionPane.showMessageDialog(null,ex5);
            }
        }

        if(e.getSource() == regSim) {
            try {
                if(Integer.parseInt(String.valueOf(mNumber2.getText().charAt(0)))!=9) {
                    throw new SQLException("Error: First number must be 9");
                }
                if(mNumber2.getDocument().getLength() < 10) {
                    throw new SQLException("Error: Input must be 10 digits");
                }
                if (!regCrud.checkPhoneNumber(Long.parseLong(mNumber2.getText()))) {
                    throw new SQLException("Error: Number exists");
                }
                Registration registration = new Registration(Long.parseLong(mNumber2.getText()), Objects.requireNonNull(ownership2.getSelectedItem()).toString(), Objects.requireNonNull(simType.getSelectedItem().toString()));
                if (ownership2.getSelectedItem().equals("")) {
                    throw new SQLException("Error: Please select registration type");
                }
                if (simType.getSelectedItem().equals("")) {
                    throw new SQLException("Error: Please select network type");
                }
                regCrud.createPhoneNo(registration, Integer.parseInt(userId.getText()));
                JOptionPane.showMessageDialog(null,"Successfully Registered new Sim!");
                System.exit(0);
            } catch (IndexOutOfBoundsException ex7) {
                JOptionPane.showMessageDialog(null,"Error: No inputs. Please enter a value");
            } catch (SQLException ex8) {
                JOptionPane.showMessageDialog(null,ex8);
            } catch (NullPointerException ex9) {
                JOptionPane.showMessageDialog(null,"Error: Make sure answer all the fields");
            }
        }

        if(e.getSource() == back4) {
            System.out.println("YES");
            frame.setSize(450, 700);
            frame.setLocationRelativeTo(null);
            layeredPane.removeAll();
            layeredPane.add(panel2);
            layeredPane.revalidate();
        }

        if(e.getSource() == back3) {
            frame.setSize(450, 280);
            frame.setLocationRelativeTo(null);
            layeredPane.removeAll();
            layeredPane.add(panel5);
            layeredPane.revalidate();
        }


        if (e.getSource() == no) {
            frame.setSize(450, 280);
            frame.setLocationRelativeTo(null);
            layeredPane.removeAll();
            layeredPane.add(panel3);
            /*panel3.add(back2);*/
            layeredPane.revalidate();
        }

        if (e.getSource() == back) {
            frame.setSize(450, 280);
            frame.setLocationRelativeTo(null);
            layeredPane.removeAll();
            layeredPane.add(panel3);
            layeredPane.revalidate();
        }

        if (e.getSource() == next) {
            try {
                if (Integer.parseInt(String.valueOf(mNumber.getText().charAt(0))) != 9) {
                    System.out.println(mNumber.getText());
                    throw new SQLException("Error: First number must be 9");
                }
                if (mNumber.getDocument().getLength() < 10) {
                    throw new SQLException("Error: Input must be 10 digits");
                }
                if (!regCrud.checkPhoneNumber(Long.parseLong(mNumber.getText()))) {
                    throw new SQLException("Error: Number exists");
                }
                if (simType2.getSelectedItem().equals("")) {
                    throw new SQLException("Error: Please select network type");
                }
                frame.setSize(450, 700);
                frame.setLocationRelativeTo(null);
                layeredPane.removeAll();
                layeredPane.add(panel2);
                layeredPane.revalidate();

            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null, ex2);
            } catch (IndexOutOfBoundsException ex3) {
                JOptionPane.showMessageDialog(null, "Error: No inputs. Please enter a value");
            }
        }


        if(e.getSource() == preview) {
            try {
                if (path == null) {
                    throw new SQLException("There is nothing to preview");
                }
                photo = new JLabel(imageResize(path));
                photo.setSize(imageResize(path).getIconWidth(), imageResize(path).getIconHeight());
                prevPhoto = new JFrame("Upload Preview");
                prevPhoto.setLayout(null);
                prevPhoto.setLocationRelativeTo(null);
                prevPhoto.setSize(imageResize(path).getIconWidth(), imageResize(path).getIconHeight());
                prevPhoto.add(photo);
                prevPhoto.setVisible(true);
            }  catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
        }

        if(e.getSource() == preview2) {
            try {
                if(path2==null) {
                    throw new SQLException("There is nothing to preview");
                }
                photo = new JLabel(imageResize(path2));
                photo.setSize(imageResize(path2).getIconWidth(), imageResize(path2).getIconHeight());
                prevPhoto = new JFrame("Upload Preview");
                prevPhoto.setLayout(null);
                prevPhoto.setLocationRelativeTo(null);
                prevPhoto.setSize(imageResize(path2).getIconWidth(), imageResize(path2).getIconHeight());
                prevPhoto.add(photo);
                prevPhoto.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
        }

        if(e.getSource() == browse) {
            file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            filter = new FileNameExtensionFilter("*.Images","gif","jpg","png");
            file.setFileFilter(filter);
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            try {
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    if (!filter.accept(selectedFile)) {
                        throw new SQLException("Wrong File extension");
                    }
                    path = selectedFile.getAbsolutePath();
                    pPic.setText(path);
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Selected");
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null,exception);
            }
        }

        if(e.getSource() == browse2) {
            file = new JFileChooser();
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
            filter = new FileNameExtensionFilter("*.Images","gif","jpg","png");
            file.setFileFilter(filter);
            file.addChoosableFileFilter(filter);
            int result = file.showSaveDialog(null);
            try {
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    if (!filter.accept(selectedFile)) {
                        throw new SQLException("Wrong File extension");
                    }
                    path2 = selectedFile.getAbsolutePath();
                    gPic.setText(path2);
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    System.out.println("No File Selected");
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null,exception);
            }
        }

        if(e.getSource() == upload2) {
            try {
                if (!idCRUD.checkGovId(idField.getText())) {
                    throw new SQLException("Government ID Number already exist");
                }
                if (Objects.equals(idCombo.getSelectedItem(), "")) {
                    throw new SQLException("Please fill up the ID Type");
                }
                if (idField.getText().equals("")) {
                    throw new SQLException("Please fill up the ID Number");
                }
                in = new FileInputStream(path);
                in2 = new FileInputStream(path2);
                Id id = new Id(in,idField.getText(), in2, Objects.requireNonNull(idCombo.getSelectedItem()).toString());

                selectedDate = (java.util.Date) datePicker.getModel().getValue();

                Subscriber subscriber = new Subscriber(fName.getText(), lName.getText(), mName.getText(), Objects.requireNonNull(suf.getSelectedItem()).toString()
                        , dateFormat.format(selectedDate), Objects.requireNonNull(s.getSelectedItem()).toString(), Objects.requireNonNull(nat.getSelectedItem()).toString(), Objects.requireNonNull(prov.getSelectedItem()).toString()
                        , Objects.requireNonNull(ct.getSelectedItem()).toString(), Integer.parseInt(u.getText()), st.getText(), Objects.requireNonNull(bar.getSelectedItem()).toString(), Integer.parseInt(zp.getText()));


                Registration registration = new Registration(Long.parseLong(mNumber.getText()), Objects.requireNonNull(regBox.getSelectedItem()).toString(), Objects.requireNonNull(simType2.getSelectedItem().toString()));

                subCrud.createSubscriberInfo(subscriber);
                regCrud.createPhoneNo(registration, subCrud.get());
                idCRUD.creatId(id, subCrud.get());

                JOptionPane.showMessageDialog(null,"Successfully Registered new Sim!");
                System.exit(0);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (SQLException ex2) {
                JOptionPane.showMessageDialog(null,ex2);
            } catch (NullPointerException ex3) {
                JOptionPane.showMessageDialog(null,"Error: No inputs. Please fill in the blanks");
            }
        }

        if(e.getSource() == prov) {
            int i = getProvCode(Objects.requireNonNull(prov.getSelectedItem()).toString());
            ArrayList<String> city = getCity(String.valueOf(i));
            ArrayListComboBoxModel model = new ArrayListComboBoxModel(city);

            JComboBox<String> comboBox = new JComboBox<>(model);

            // setting model with new data
            ct.setModel(comboBox.getModel());
            // adding combobox to panel
            panel2.add(ct);
        }

        if(e.getSource() == ct) {
            int k = getCityCode(Objects.requireNonNull(ct.getSelectedItem()).toString());
            ArrayList<String> barangay = getBarangay(String.valueOf(k));
            ArrayListComboBoxModel model = new ArrayListComboBoxModel(barangay);

            JComboBox<String> comboBox = new JComboBox<>(model);

            // setting model with new data
            bar.setModel(comboBox.getModel());
            // adding combobox to panel
            panel2.add(bar);
        }

        if(e.getSource() == signUp) {
            try {
                if (fName.getText().equals("")) {
                    throw new SQLException("Error: Please fill up First name");
                }
                if (mName.getText().equals("")) {
                    throw new SQLException("Error: Please fill up Middle Name");
                }
                if (lName.getText().equals("")) {
                    throw new SQLException("Error: Please fill up Last name");
                }
                if (st.getText().equals("")) {
                    throw new SQLException("Error: Please fill up street");
                }
                if (nat.getSelectedItem().equals("")) {
                    throw new SQLException("Error: Please select nationality");
                }
                if (regBox.getSelectedItem().equals("")) {
                    throw new SQLException("Error: Please select registration type");
                }
                if (s.getSelectedItem().equals("")) {
                    throw new SQLException("Error: Please select gender");
                }
                frame.setSize(450, 420);
                frame.setLocationRelativeTo(null);
                layeredPane.removeAll();
                layeredPane.add(photoPanel);
                layeredPane.revalidate();
            } catch (NullPointerException ex1) {
                JOptionPane.showMessageDialog(null, "Error: Please fill up the whole form");
            } catch (NumberFormatException ex2) {
                JOptionPane.showMessageDialog(null,"Error: Blanks not allowed");
            } catch (SQLException ex3) {
                JOptionPane.showMessageDialog(null,ex3);
            }

        }

    }

    public class ArrayListComboBoxModel extends AbstractListModel implements
            ComboBoxModel {

        private Object selectedItem;
        private ArrayList anArrayList;

        public ArrayListComboBoxModel(ArrayList arrayList) {
            anArrayList = arrayList;
        }

        public ArrayListComboBoxModel(List list) {

        }

        public Object getSelectedItem() {
            return selectedItem;
        }

        public void setSelectedItem(Object newValue) {
            selectedItem = newValue;
        }

        public int getSize() {
            return anArrayList.size();
        }

        public Object getElementAt(int i) {
            return anArrayList.get(i);
        }


    }

    private ImageIcon imageResize(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        Image imgFinal = img.getScaledInstance(img.getWidth(null),img.getHeight(null),Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(imgFinal);
        return image;
    }

    public static int getProvCode(String province) {
        String q = "\"";
        String quoted = q+province+q;
        int provCode = 0;
        try {
            String query = "Select provCode FROM refprovince WHERE provDesc =" + quoted;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                provCode = resultSet.getInt(1);
            }
            System.out.println(provCode);
        } catch (SQLException e) {
            System.out.println("Not found");
        }
        return provCode;
    }

    public static ArrayList<String> getCity(String pCode) {
        ArrayList city = new ArrayList<>();
        try {
            String query= "SELECT citymunDesc FROM refcitymun WHERE provcode=" + pCode;
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();

            while(resultSet.next()) {
                city.add(resultSet.getString(1));
            }
            System.out.println(city);
        } catch (SQLException e) {
            System.out.println("Can't Read Data");
        }
        return city;
    }

    public static int getCityCode(String city) {
        String q = "\"";
        String quoted = q+city+q;
        int cityCode = 0;
        try {
            String query = "Select citymunCode FROM refcitymun WHERE citymunDesc =" + quoted;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                cityCode = resultSet.getInt(1);
            }
            System.out.println(cityCode);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cityCode;
    }

    public static ArrayList<String> getBarangay(String cCode) {
        ArrayList brgy = new ArrayList<>();
        try {
            String query= "SELECT brgyDesc FROM refbrgy WHERE citymunCode=" + cCode;
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();

            while(resultSet.next()) {
                brgy.add(resultSet.getString(1));
            }
            System.out.println(brgy);
        } catch (SQLException e) {
            System.out.println("Can't Read Data");
        }
        return brgy;
    }


}
