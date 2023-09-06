package AdminGUI;

import ClientGUI.DateLabelFormatter;
import ClientGUI.JTextFieldLimit;
import Connector.DatabaseConnector;
import Constructors.Subscriber;
import Crud.RegistrationCRUD;
import Crud.SubscriberCRUD;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


public class AdminGUI extends JFrame implements ActionListener {


    private final JFrame input;
    private final JTextArea display;
    private final JTextArea display2;
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JButton b4;
    private final JButton b5;
    private final JButton clear;
    private final JButton update;
    private final JTextField id;
    private final JTextField id2;
    private final JLayeredPane layeredPane;
    private final JPanel inputPanel;
    private final JPanel inputPanel2;

    /**
     *  REGISTER PANEL VARIABLES
     */



    String [] suffixList = {"","I","II","III","IV","Jr.","Sr."};
    String [] sexList = {"","Male","Female"};
    String [] nationalityList = {"","Afghan","Albanian","Algerian","American","Andorran","Angolan","Anguillan","Argentine","Armenian","Australian","Austrian","Azerbaijani","Bahamian","Bahraini","Bangladeshi","Barbadian","Belarusian","Belgian","Belizean","Beninese","Bermudian","Bhutanese","Bolivian","Botswanan","Brazilian","British","British Virgin Islander","Bruneian","Bulgarian","Burkinan","Burmese","Burundian","Cambodian","Cameroonian","Canadian","Cape Verdean","Cayman Islander","Central African","Chadian","Chilean","Chinese","Citizen of Antigua and Barbuda","Citizen of Bosnia and Herzegovina","Citizen of Guinea-Bissau","Citizen of Kiribati","Citizen of Seychelles","Citizen of the Dominican Republic","Citizen of Vanuatu","Colombian","Comoran","Congolese (Congo)","Congolese (DRC)","Cook Islander","Costa Rican","Croatian","Cuban","Cymraes","Cymro","Cypriot","Czech","Danish","Djiboutian","Dominican","Dutch","East Timorese","Ecuadorean","Egyptian","Emirati","English","Equatorial Guinean","Eritrean","Estonian","Ethiopian","Faroese","Fijian","Filipino","Finnish","French","Gabonese","Gambian","Georgian","German","Ghanaian","Gibraltarian","Greek","Greenlandic","Grenadian","Guamanian","Guatemalan","Guinean","Guyanese","Haitian","Honduran","Hong Konger","Hungarian","Icelandic","Indian","Indonesian","Iranian","Iraqi","Irish","Israeli","Italian","Ivorian","Jamaican","Japanese","Jordanian","Kazakh","Kenyan","Kittitian","Kosovan","Kuwaiti","Kyrgyz","Lao","Latvian","Lebanese","Liberian","Libyan","Liechtenstein citizen","Lithuanian","Luxembourger","Macanese","Macedonian","Malagasy","Malawian","Malaysian","Maldivian","Malian","Maltese","Marshallese","Martiniquais","Mauritanian","Mauritian","Mexican","Micronesian","Moldovan","Monegasque","Mongolian","Montenegrin","Montserratian","Moroccan","Mosotho","Mozambican","Namibian","Nauruan","Nepalese","New Zealander","Nicaraguan","Nigerian","Nigerien","Niuean","North Korean","Northern Irish","Norwegian","Omani","Pakistani","Palauan","Palestinian","Panamanian","Papua New Guinean","Paraguayan","Peruvian","Pitcairn Islander","Polish","Portuguese","Prydeinig","Puerto Rican","Qatari","Romanian","Russian","Rwandan","Salvadorean","Sammarinese","Samoan","Sao Tomean","Saudi Arabian","Scottish","Senegalese","Serbian","Sierra Leonean","Singaporean","Slovak","Slovenian","Solomon Islander","Somali","South African","South Korean","South Sudanese","Spanish","Sri Lankan","St Helenian","St Lucian","Stateless","Sudanese","Surinamese","Swazi","Swedish","Swiss","Syrian","Taiwanese","Tajik","Tanzanian","Thai","Togolese","Tongan","Trinidadian","Tristanian","Tunisian","Turkish","Turkmen","Turks and Caicos Islander","Tuvaluan","Ugandan","Ukrainian","Uruguayan","Uzbek","Vatican citizen","Venezuelan","Vietnamese","Vincentian","Wallisian","Welsh","Yemeni","Zambian","Zimbabwean"};
    String [] registrationTypeList = {"","Owner","Guardian","Parent"};
    String [] provinceList = {"","ABRA","AGUSAN DEL NORTE","AGUSAN DEL SUR","AKLAN","ALBAY","ANTIQUE","APAYAO","AURORA","BASILAN","BATAAN","BATANES","BATANGAS","BENGUET","BILIRAN","BOHOL","BUKIDNON","BULACAN","CAGAYAN","CAMARINES NORTE","CAMARINES SUR","CAMIGUIN","CAPIZ","CATANDUANES","CAVITE","CEBU","CITY OF ISABELA","CITY OF MANILA","COMPOSTELA VALLEY","COTABATO (NORTH COTABATO)","COTABATO CITY","DAVAO DEL NORTE","DAVAO DEL SUR","DAVAO OCCIDENTAL","DAVAO ORIENTAL","DINAGAT ISLANDS","EASTERN SAMAR","GUIMARAS","IFUGAO","ILOCOS NORTE","ILOCOS SUR","ILOILO","ISABELA","KALINGA","LA UNION","LAGUNA","LANAO DEL NORTE","LANAO DEL SUR","LEYTE","MAGUINDANAO","MARINDUQUE","MASBATE","MISAMIS OCCIDENTAL","MISAMIS ORIENTAL","MOUNTAIN PROVINCE","NCR, CITY OF MANILA, FIRST DISTRICT","NCR, FOURTH DISTRICT","NCR, SECOND DISTRICT","NCR, THIRD DISTRICT","NEGROS OCCIDENTAL","NEGROS ORIENTAL","NORTHERN SAMAR","NUEVA ECIJA","NUEVA VIZCAYA","OCCIDENTAL MINDORO","ORIENTAL MINDORO","PALAWAN","PAMPANGA","PANGASINAN","QUEZON","QUIRINO","RIZAL","ROMBLON","SAMAR (WESTERN SAMAR)","SARANGANI","SIQUIJOR","SORSOGON","SOUTH COTABATO","SOUTHERN LEYTE","SULTAN KUDARAT","SULU","SURIGAO DEL NORTE","SURIGAO DEL SUR","TARLAC","TAWI-TAWI","ZAMBALES","ZAMBOANGA DEL NORTE","ZAMBOANGA DEL SUR","ZAMBOANGA SIBUGAY"};
    private final JPanel fillUpPanel;
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
    private final JButton update2;
    private final JDatePickerImpl datePicker;
    JDatePanelImpl datePanel;
    java.util.Date selectedDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private final JButton delete;
        AdminGUI() {
            TitledBorder queries;
            queries = BorderFactory.createTitledBorder("Queries");

            TitledBorder tools;
            tools = BorderFactory.createTitledBorder("Tools");

            JPanel panel = new JPanel();
            panel.setBounds(0, 0, 1000, 520);
            panel.setLayout(null);

            JPanel filterPanel = new JPanel();
            filterPanel.setBounds(40, 90, 125, 170);
            filterPanel.setBorder(queries);
            filterPanel.setLayout(null);

            JPanel toolsPanel = new JPanel();
            toolsPanel.setBounds(40, 270, 125, 130);
            toolsPanel.setBorder(tools);
            toolsPanel.setLayout(null);

            display = new JTextArea();
            display.setFont(new Font("Monospaced", Font.PLAIN, 15));
            display.setEditable(false);
            JScrollPane scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scroll.setBounds(190, 95, 770, 360);
            panel.add(scroll);

            display2 = new JTextArea();
            display2.setBounds(190, 25, 700, 23);
            display2.setEditable(false);
            display2.setFont(new Font("Sans Serif", Font.BOLD, 18));
            display2.setLayout(null);
            panel.add(display2);

            JLabel query = new JLabel("       ADMIN");
            query.setFont(new Font("Sans Serif", Font.BOLD, 25));
            query.setBounds(0, 0, 1000, 70);
            query.setForeground(Color.WHITE);
            query.setBackground(Color.decode("#003049"));
            query.setOpaque(true);
            panel.add(query);

            /**
             * FILTERS
             */

            b1 = new JButton("Subscriber");
            b1.setBounds(10, 20, 100, 40);
            b1.addActionListener(this);
            filterPanel.add(b1);

            b2 = new JButton("Registrations");
            b2.setBounds(10, 70, 100, 40);
            b2.addActionListener(this);
            filterPanel.add(b2);

            b3 = new JButton("User Data");
            b3.setBounds(10, 120, 100, 40);
            b3.addActionListener(this);
            filterPanel.add(b3);

            /**
             * TOOLS
             */

            b4 = new JButton("Update Info");
            b4.setBounds(10, 20, 100, 40);
            b4.addActionListener(this);
            toolsPanel.add(b4);

            b5 = new JButton("Delete User");
            b5.setBounds(10, 70, 100, 40);
            b5.addActionListener(this);
            toolsPanel.add(b5);

            clear = new JButton("Clear");
            clear.setBounds(50, 410, 100, 40);
            clear.addActionListener(this);
            panel.add(clear);


            JFrame menu = new JFrame("Admin Sim System");
            menu.setLayout(null);
            menu.setSize(1000, 520);
            menu.setResizable(false);
            menu.setLocationRelativeTo(null);
            menu.add(filterPanel);
            menu.add(toolsPanel);
            menu.add(panel);
            menu.setVisible(true);

            /**
             * Age Search
             */

            layeredPane = new JLayeredPane();
            layeredPane.setBounds(0,0,250,140);

            inputPanel = new JPanel();
            inputPanel.setBounds(0, 0, 250, 140);
            inputPanel.setLayout(null);

            JLabel userId = new JLabel("Enter the ID of the User");
            userId.setBounds(0,10,250,30);
            userId.setHorizontalAlignment(JLabel.CENTER);
            inputPanel.add(userId);

            delete = new JButton("Delete");
            delete.setBounds(85, 70, 80, 30);
            delete.addActionListener(this);
            inputPanel.add(delete);

            id = new JTextField();
            id.setDocument(new JTextFieldLimit(9));
            id.setBounds(25,40,200,30);
            id.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    id.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            inputPanel.add(id);

            /**
             * REGISTER PANEL
             */

            fillUpPanel = new JPanel();
            fillUpPanel.setBounds(0,0,450,620);
            fillUpPanel.setOpaque(true);
            fillUpPanel.setLayout(null);

            JLabel simReg2 = new JLabel("User Details Editable");
            simReg2.setFont(new Font("SansSerif", Font.BOLD, 16));
            simReg2.setOpaque(true);
            simReg2.setForeground(Color.WHITE);
            simReg2.setBackground(Color.decode("#003049"));
            simReg2.setBounds(0, 0, 450, 70);
            simReg2.setHorizontalAlignment(JLabel.CENTER);
            fillUpPanel.add(simReg2);

            JLabel firstName = new JLabel("First Name");
            firstName.setFont(new Font("Monospaced", Font.PLAIN, 11));
            firstName.setBounds(30, 110, 100, 30);
            fillUpPanel.add(firstName);
            fName = new JTextField(15);
            fName.setFont(new Font("Monospaced", Font.PLAIN, 12));
            fName.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    char ch = e.getKeyChar();
                    fName.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            fName.setBounds(28, 135, 180, 30);

            fillUpPanel.add(fName);

            JLabel middleName = new JLabel("Middle Name");
            middleName.setFont(new Font("Monospaced", Font.PLAIN, 11));
            middleName.setBounds(230, 110, 100, 30);
            fillUpPanel.add(middleName);
            mName = new JTextField(15);
            mName.setFont(new Font("Monospaced", Font.PLAIN, 12));
            mName.setBounds(228, 135, 180, 30);
            mName.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    char ch = e.getKeyChar();
                    mName.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            fillUpPanel.add(mName);

            JLabel lastName = new JLabel("Last Name");
            lastName.setFont(new Font("Monospaced", Font.PLAIN, 11));
            lastName.setBounds(30, 165, 100, 30);
            fillUpPanel.add(lastName);
            lName = new JTextField(15);
            lName.setFont(new Font("Monospaced", Font.PLAIN, 12));
            lName.setBounds(28, 190, 180, 30);
            lName.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    char ch = e.getKeyChar();
                    lName.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            fillUpPanel.add(lName);

            JLabel suffix = new JLabel("Suffix (Optional)");
            suffix.setFont(new Font("Monospaced", Font.PLAIN, 11));
            suffix.setBounds(230, 165, 150, 30);
            fillUpPanel.add(suffix);
            suf = new JComboBox<>(suffixList);
            suf.setSelectedIndex(0);
            suf.addActionListener(this);
            suf.setFont(new Font("Monospaced", Font.PLAIN, 12));
            suf.setBounds(228, 190, 180, 30);
            fillUpPanel.add(suf);

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
            birthdate.setFont(new Font("Monospaced", Font.PLAIN, 11));
            birthdate.setBounds(30, 220, 100, 30);
            fillUpPanel.add(birthdate);
            datePicker.setBounds(28,245,180,30);
            fillUpPanel.add(datePicker);

            JLabel sex = new JLabel("Sex");
            sex.setFont(new Font("Monospaced", Font.PLAIN, 11));
            sex.setBounds(230, 220, 100, 30);
            fillUpPanel.add(sex);
            s = new JComboBox<>(sexList);
            s.setSelectedIndex(0);
            s.addActionListener(this);
            s.setFont(new Font("Monospaced", Font.PLAIN, 12));
            s.setBounds(228, 245, 180, 30);
            fillUpPanel.add(s);


            JLabel nationality = new JLabel("Nationality");
            nationality.setFont(new Font("Monospaced", Font.PLAIN, 11));
            nationality.setBounds(30, 275, 100, 30);
            fillUpPanel.add(nationality);
            nat = new JComboBox<>(nationalityList);
            nat.setSelectedIndex(0);
            nat.addActionListener(this);
            nat.setFont(new Font("Monospaced", Font.PLAIN, 12));
            nat.setBounds(28, 300, 180, 30);
            fillUpPanel.add(nat);

            JLabel registrationType = new JLabel("Ownership");
            registrationType.setFont(new Font("Monospaced", Font.PLAIN, 11));
            registrationType.setBounds(230, 275, 100, 30);
            fillUpPanel.add(registrationType);
            regBox = new JComboBox<>(registrationTypeList);
            regBox.setSelectedIndex(0);
            regBox.addActionListener(this);
            regBox.setFont(new Font("Monospaced", Font.PLAIN, 12));
            regBox.setBounds(228, 300, 180, 30);
            fillUpPanel.add(regBox);


            JLabel unit = new JLabel("Unit no./House no./");
            unit.setFont(new Font("Monospaced", Font.PLAIN, 11));
            unit.setBounds(30, 330, 150, 30);
            fillUpPanel.add(unit);
            u = new JTextField(15);
            u.setFont(new Font("Monospaced", Font.PLAIN, 12));
            u.setBounds(28, 355, 180, 30);
            u.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    u.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            fillUpPanel.add(u);

            JLabel street = new JLabel("Street");
            street.setFont(new Font("Monospaced", Font.PLAIN, 11));
            street.setBounds(230, 330, 100, 30);
            fillUpPanel.add(street);
            st = new JTextField(15);
            st.setFont(new Font("Monospaced", Font.PLAIN, 12));
            st.setBounds(228, 355, 180, 30);
            st.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    char ch = e.getKeyChar();
                    st.setEditable(!Character.isDigit(ch) || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            fillUpPanel.add(st);

            JLabel province = new JLabel("Province");
            province.setFont(new Font("Monospaced", Font.PLAIN, 11));
            province.setBounds(30, 385, 100, 30);
            fillUpPanel.add(province);
            prov = new JComboBox<>(provinceList);
            prov.addActionListener(this);
            prov.setFont(new Font("Monospaced", Font.PLAIN, 12));
            prov.setBounds(28, 410, 180, 30);
            fillUpPanel.add(prov);

            JLabel city = new JLabel("City/Municipality");
            city.setFont(new Font("Monospaced", Font.PLAIN, 11));
            city.setBounds(230, 385, 150, 30);
            fillUpPanel.add(city);
            ct = new JComboBox<>();
            ct.addActionListener(this);
            ct.setFont(new Font("Monospaced", Font.PLAIN, 12));
            ct.setBounds(228, 410, 180, 30);
            fillUpPanel.add(ct);

            JLabel barangay = new JLabel("Barangay");
            barangay.setFont(new Font("Monospaced", Font.PLAIN, 11));
            barangay.setBounds(30, 440, 100, 30);
            fillUpPanel.add(barangay);
            bar = new JComboBox<>();
            bar.addActionListener(this);
            bar.setFont(new Font("Monospaced", Font.PLAIN, 12));
            bar.setBounds(28, 465, 180, 30);
            fillUpPanel.add(bar);

            JLabel zipcode = new JLabel("Zipcode");
            zipcode.setFont(new Font("Monospaced", Font.PLAIN, 11));
            zipcode.setBounds(230, 440, 100, 30);
            fillUpPanel.add(zipcode);
            zp = new JTextField();
            zp.setDocument(new JTextFieldLimit(4));
            zp.setFont(new Font("Monospaced", Font.PLAIN, 12));
            zp.setBounds(228, 465, 180, 30);
            zp.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {zp.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            fillUpPanel.add(zp);

            update2 = new JButton("Update");
            update2.setForeground(Color.decode("#003049"));
            update2.setBackground(Color.WHITE);
            update2.setBounds(315,520,90,35);
            update2.setFont(new Font("SansSerif", Font.BOLD,13));
            update2.addActionListener(this);
            fillUpPanel.add(update2);

            /**
             *  GET ID DETAILS FOR UPDATE
             */

            /**
             * District Search
             */

            inputPanel2 = new JPanel();
            inputPanel2.setBounds(0, 0, 250, 140);
            inputPanel2.setLayout(null);

            JLabel findDistrict = new JLabel("Enter ID of User");
            findDistrict.setBounds(0,10,250,30);
            findDistrict.setHorizontalAlignment(JLabel.CENTER);
            inputPanel2.add(findDistrict);

            update = new JButton("Find");
            update.setBounds(85, 70, 80, 30);
            update.addActionListener(this);
            inputPanel2.add(update);

            id2 = new JTextField();
            id2.setDocument(new JTextFieldLimit(9));
            id2.setBounds(25,40,200,30);
            id2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    id2.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
                }
            });
            inputPanel2.add(id2);


            input = new JFrame();
            input.add(layeredPane);
            input.setLayout(null);
            input.setSize(450, 620);
            input.setResizable(false);
            input.setLocationRelativeTo(null);
            input.setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                display2.setText("Displays all Subscribers");
                display.setText("");
                DatabaseConnector db = new DatabaseConnector();
                Connection connection = db.createConnection();

                try {
                    String line= "-";
                    String query = "SELECT * FROM subscriber ORDER BY userid";
                    PreparedStatement prepStatement = connection.prepareStatement(query);
                    ResultSet resultSet = prepStatement.executeQuery();


                    display.append("+" + line.repeat(243)+"+"+"\n");
                    display.append(String.format("| %3s %-10s %-18s %-15s %-15s %-12s %-15s %-10s %-20s %-15s %-25s %-15s %-20s %-20s %-15s| \n",
                            "","Userid","Firstname","Lastname","Middlename","Suffix","Birthday","Sex","Nationality","Province","City","Unit","Street","Barangay","Zipcode"));
                    display.append("+" + line.repeat(243)+"+"+"\n");

                    while(resultSet.next()) {
                        display.append(String.format("| %3s %-10s %-18s %-15s %-15s %-12s %-15s %-10s %-20s %-15s %-25s %-15s %-20s %-20s %-15s| \n", "",resultSet.getString(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4),
                                resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),
                                resultSet.getString(13),resultSet.getString(14)));
                    }
                    display.append("+" + line.repeat(243)+"+");
                    connection.close();

                } catch (SQLException ex) {
                    System.out.println("Can't Read Data");
                }
            }

            if(e.getSource() == b2) {
                display2.setText("Displays all Registration");
                display.setText("");
                DatabaseConnector db = new DatabaseConnector();
                Connection connection = db.createConnection();

                try {
                    String line= "-";
                    String query = "SELECT * FROM registration ORDER BY registerid";
                    PreparedStatement prepStatement = connection.prepareStatement(query);
                    ResultSet resultSet = prepStatement.executeQuery();


                    display.append("+" + line.repeat(100)+"+"+"\n");
                    display.append(String.format("| %3s %-15s %-25s %-20s %-10s %-10s %-10s| \n",
                            "","RegisterID","Date       Timestamp","Phone Number","Owner","UserID","Network"));
                    display.append("+" + line.repeat(100)+"+"+"\n");

                    while(resultSet.next()) {
                        display.append(String.format("| %3s %-15s %-25s %-20s %-10s %-10s %-10s| \n", "",resultSet.getString(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4),
                                resultSet.getString(5),resultSet.getString(6)));
                    }
                    display.append("+" + line.repeat(100)+"+");
                    connection.close();

                } catch (SQLException ex) {
                    System.out.println("Can't Read Data");
                }
            }

            if (e.getSource() == b3) {
                display2.setText("Displays all data and registered sim of the User");
                display.setText("");
                DatabaseConnector db = new DatabaseConnector();
                Connection connection = db.createConnection();

                try {
                    String line= "-";
                    String query = "SELECT registration.dates, registration.userid, registration.phoneno, registration.ownership, firstname, lastname, middlename, suffix, birthday, sex, nationality, province, city, unit, street, barangay, zipcode FROM subscriber INNER JOIN registration ON registration.userid = subscriber.userid ORDER BY userid";
                    PreparedStatement prepStatement = connection.prepareStatement(query);
                    ResultSet resultSet = prepStatement.executeQuery();


                    display.append("+" + line.repeat(301)+"+"+"\n");
                    display.append(String.format("| %3s %-25s %-10s %-15s %-15s %-18s %-15s %-15s %-12s %-15s %-10s %-20s %-15s %-25s %-15s %-20s %-20s %-15s| \n",
                            "","Date       Timestamp","Userid","PhoneNumber","Ownership","Firstname","Lastname","Middlename","Suffix","Birthday","Sex","Nationality","Province","City","Unit","Street","Barangay","Zipcode"));
                    display.append("+" + line.repeat(301)+"+"+"\n");

                    while(resultSet.next()) {
                        display.append(String.format("| %3s %-25s %-10s %-15s %-15s %-18s %-15s %-15s %-12s %-15s %-10s %-20s %-15s %-25s %-15s %-20s %-20s %-15s| \n", "",resultSet.getString(1) , resultSet.getString(2) , resultSet.getString(3) , resultSet.getString(4),
                                resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11),resultSet.getString(12),
                                resultSet.getString(13),resultSet.getString(14),resultSet.getString(15),resultSet.getString(16),resultSet.getString(17)));
                    }
                    display.append("+" + line.repeat(301)+"+");
                    connection.close();

                } catch (SQLException ex) {
                    System.out.println("Can't Read Data");
                }
            }

            if (e.getSource() == b4) {
                input.setVisible(true);
                input.setSize(250, 140);
                layeredPane.removeAll();
                layeredPane.setSize(250,140);
                layeredPane.add(inputPanel2);
                layeredPane.revalidate();
            }
            

            if (e.getSource() == b5) {
                input.setVisible(true);
                input.setSize(250, 140);
                layeredPane.removeAll();
                layeredPane.setSize(250,140);
                layeredPane.add(inputPanel);
                layeredPane.revalidate();
            }

            
            if (e.getSource() == update) {
                DatabaseConnector db = new DatabaseConnector();
                Connection connection = db.createConnection();
                SubscriberCRUD subCrud = new SubscriberCRUD();
                try {
                    if (subCrud.checkUserId(Integer.parseInt(id2.getText()))) {
                        throw new SQLException("No Existing User");
                    }
                    String q = "\"";
                    String quoted = q+id2.getText()+q;
                    String query = "SELECT * FROM subscriber WHERE userid =" + quoted;
                    String query2 = "SELECT * FROM registration WHERE userid =" + quoted;
                    PreparedStatement prepStatement = connection.prepareStatement(query);
                    PreparedStatement prepStatement2 = connection.prepareStatement(query2);
                    ResultSet resultSet = prepStatement.executeQuery();
                    ResultSet resultSet2 = prepStatement2.executeQuery();
                    while(resultSet.next()) {
                        fName.setText(resultSet.getString(2));
                        lName.setText(resultSet.getString(3));
                        mName.setText(resultSet.getString(4));
                        suf.setSelectedItem(resultSet.getString(5));

                        Date d = resultSet.getDate(6);
                        Calendar c = Calendar.getInstance();
                        c.setTime(d);
                        int year = c.get(Calendar.YEAR);
                        int month = c.get(Calendar.MONTH);
                        int day = c.get(Calendar.DATE);
                        datePicker.getModel().setDate(year,month,day);
                        datePicker.getModel().setSelected(true);

                        s.setSelectedItem(resultSet.getString(7));
                        nat.setSelectedItem(resultSet.getString(8));
                        prov.setSelectedItem(resultSet.getString(9));
                        ct.setSelectedItem(resultSet.getString(10));
                        u.setText(resultSet.getString(11));
                        st.setText(resultSet.getString(12));
                        bar.setSelectedItem(resultSet.getString(13));
                        zp.setText(resultSet.getString(14));
                    }
                    while(resultSet2.next()) {
                        regBox.setSelectedItem(resultSet2.getString(4));
                    }

                    JOptionPane.showMessageDialog(null,"User has been Found");

                    input.setVisible(true);
                    input.setSize(450, 620);
                    layeredPane.removeAll();
                    layeredPane.setSize(450,620);
                    layeredPane.add(fillUpPanel);
                    layeredPane.revalidate();

                    connection.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Error: Input is blank");
                }
            }

            if(e.getSource() == update2) {
                SubscriberCRUD subCrud = new SubscriberCRUD();
                RegistrationCRUD regCrud = new RegistrationCRUD();
                selectedDate = (java.util.Date) datePicker.getModel().getValue();
                Subscriber subscriber = new Subscriber(fName.getText(), lName.getText(), mName.getText(), Objects.requireNonNull(suf.getSelectedItem()).toString()
                        , dateFormat.format(selectedDate), Objects.requireNonNull(s.getSelectedItem()).toString(), Objects.requireNonNull(nat.getSelectedItem()).toString(), Objects.requireNonNull(prov.getSelectedItem()).toString()
                        , Objects.requireNonNull(ct.getSelectedItem()).toString(), Integer.parseInt(u.getText()), st.getText(), Objects.requireNonNull(bar.getSelectedItem()).toString(), Integer.parseInt(zp.getText()));
                subCrud.update(subscriber,Integer.parseInt(id2.getText()));
                regCrud.updateOwner(String.valueOf(regBox.getSelectedItem()),Integer.parseInt(id2.getText()));
                JOptionPane.showMessageDialog(null,"Successfully updated user");
                input.setVisible(false);
            }

            if (e.getSource() == delete) {
                DatabaseConnector db = new DatabaseConnector();
                Connection connection = db.createConnection();
                try {
                    String query = "delete from subscriber WHERE userid = ?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(query);
                    preparedStatement2.setInt(1,Integer.parseInt(id.getText()));
                    int regUpdate = preparedStatement2.executeUpdate();
                    if(regUpdate > 0) {
                        display2.setText("Refresh Filter to see Updated Database");
                        display.setText("");
                        JOptionPane.showMessageDialog(null,"User " + id.getText() + " has been successfully deleted");
                        input.setVisible(false);
                    } else {
                        throw new SQLException("The ID " + id.getText() + " does not exist");
                    }
                    connection.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Error: Input is blank");
                }
            }


            if (e.getSource() == clear) {
                display.setText("");
                display2.setText("");
            }

            if(e.getSource() == prov) {
                int i = getProvCode(Objects.requireNonNull(prov.getSelectedItem()).toString());
                ArrayList<String> city = getCity(String.valueOf(i));
                ArrayListComboBoxModel model = new ArrayListComboBoxModel(city);

                JComboBox<String> comboBox = new JComboBox<>(model);

                // setting model with new data
                ct.setModel(comboBox.getModel());
                // adding combobox to panel
                fillUpPanel.add(ct);
            }

            if(e.getSource() == ct) {
                int k = getCityCode(Objects.requireNonNull(ct.getSelectedItem()).toString());
                ArrayList<String> barangay = getBarangay(String.valueOf(k));
                ArrayListComboBoxModel model = new ArrayListComboBoxModel(barangay);

                JComboBox<String> comboBox = new JComboBox<>(model);

                // setting model with new data
                bar.setModel(comboBox.getModel());
                // adding combobox to panel
                fillUpPanel.add(bar);
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

    public static int getProvCode(String province) {
        DatabaseConnector db = new DatabaseConnector();
        Connection connection = db.createConnection();
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
            connection.close();
        } catch (SQLException e) {
            System.out.println("Not found");
        }
        return provCode;
    }

    public static ArrayList<String> getCity(String pCode) {
        DatabaseConnector db = new DatabaseConnector();
        Connection connection = db.createConnection();
        ArrayList city = new ArrayList<>();
        try {
            String query= "SELECT citymunDesc FROM refcitymun WHERE provcode=" + pCode;
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();
            while(resultSet.next()) {
                city.add(resultSet.getString(1));
            }
            System.out.println(city);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't Read Data");
        }
        return city;
    }

    public static int getCityCode(String city) {
        DatabaseConnector db = new DatabaseConnector();
        Connection connection = db.createConnection();
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
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cityCode;
    }

    public static ArrayList<String> getBarangay(String cCode) {
        DatabaseConnector db = new DatabaseConnector();
        Connection connection = db.createConnection();
        ArrayList brgy = new ArrayList<>();
        try {
            String query= "SELECT brgyDesc FROM refbrgy WHERE citymunCode=" + cCode;
            PreparedStatement prepStatement = connection.prepareStatement(query);
            ResultSet resultSet = prepStatement.executeQuery();

            while(resultSet.next()) {
                brgy.add(resultSet.getString(1));
            }
            System.out.println(brgy);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Can't Read Data");
        }
        return brgy;
    }

}
