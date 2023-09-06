package prog2.finalgroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class MyProgram extends JFrame implements ActionListener {
    static MyProgramUtility myProgramUtility = new MyProgramUtility();
    static List<Citizen> citizens = myProgramUtility.readDataFileIntoList("B9408BerlangaGorioLeztatTimpac/res/data.csv");

    private final JFrame menu;
    private final JFrame input;
    private final JPanel panel;
    private final JTextArea display;
    private final JTextArea display2;
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JButton b4;
    private final JButton b5;
    private final JButton b6;
    private final JButton clear;
    private final JScrollPane scroll;
    private final JTextField age;
    private final JTextField district;
    private final JLayeredPane layeredPane;
    private final JPanel inputPanel;
    private final JPanel inputPanel2;
    private final JPanel inputPanel3;
    private final JButton enter;
    private final JButton enter2;
    private final JButton enter3;
    private final JComboBox genderSelect;
    Character[] gender = {'M','F'};

    String line = "-";
    MyProgram() {
        panel = new JPanel();
        panel.setBounds(0, 0, 800, 580);
        panel.setLayout(null);

        JLabel query = new JLabel("Query:");
        query.setFont(new Font("Sans Serif", Font.BOLD, 22));
        query.setBounds(65, 30, 560, 30);
        panel.add(query);

        display = new JTextArea();
        display.setFont(new Font("Monospaced", Font.PLAIN, 8));
        display.setEditable(false);
        scroll = new JScrollPane(display, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(190, 90, 560, 405);
        panel.add(scroll);

        display2 = new JTextArea();
        display2.setBounds(190, 35, 560, 23);
        display2.setEditable(false);
        display2.setFont(new Font("Sans Serif", Font.BOLD, 18));
        display2.setLayout(null);
        panel.add(display2);


        b1 = new JButton("Filter 1");
        b1.setBounds(50, 90, 100, 40);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Filter 2");
        b2.setBounds(50, 140, 100, 40);
        b2.addActionListener(this);
        panel.add(b2);

        b3 = new JButton("Filter 3");
        b3.setBounds(50, 190, 100, 40);
        b3.addActionListener(this);
        panel.add(b3);

        b4 = new JButton("Filter 4");
        b4.setBounds(50, 240, 100, 40);
        b4.addActionListener(this);
        panel.add(b4);

        b5 = new JButton("Filter 5");
        b5.setBounds(50, 290, 100, 40);
        b5.addActionListener(this);
        panel.add(b5);

        b6 = new JButton("Show All");
        b6.setBounds(50, 340, 100, 40);
        b6.addActionListener(this);
        panel.add(b6);


        clear = new JButton("Clear");
        clear.setBounds(50, 460, 100, 40);
        clear.addActionListener(this);
        panel.add(clear);

        menu = new JFrame("Citizen Sorting and Filter");
        menu.setLayout(null);
        menu.setSize(800, 580);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
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

        JLabel findAge = new JLabel("Filter citizen by Age");
        findAge.setBounds(0,10,250,30);
        findAge.setHorizontalAlignment(JLabel.CENTER);
        inputPanel.add(findAge);

        enter = new JButton("Enter");
        enter.setBounds(85, 70, 80, 30);
        enter.addActionListener(this);
        inputPanel.add(enter);

        age = new JTextField();
        age.setBounds(25,40,200,30);
        age.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                age.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        inputPanel.add(age);

        /**
         * District Search
         */

        inputPanel2 = new JPanel();
        inputPanel2.setBounds(0, 0, 250, 140);
        inputPanel2.setLayout(null);

        JLabel findDistrict = new JLabel("Filter citizen by District");
        findDistrict.setBounds(0,10,250,30);
        findDistrict.setHorizontalAlignment(JLabel.CENTER);
        inputPanel2.add(findDistrict);

        enter2 = new JButton("Enter");
        enter2.setBounds(85, 70, 80, 30);
        enter2.addActionListener(this);
        inputPanel2.add(enter2);

        district = new JTextField();
        district.setBounds(25,40,200,30);
        district.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                district.setEditable(e.getKeyChar() >= '0' && e.getKeyChar() <= '9' || e.getKeyChar() == KeyEvent.VK_BACK_SPACE);
            }
        });
        inputPanel2.add(district);

        /**
         * District Search
         */

        inputPanel3 = new JPanel();
        inputPanel3.setBounds(0, 0, 250, 140);
        inputPanel3.setLayout(null);

        JLabel findGender = new JLabel("Filter citizen by Gender");
        findGender.setBounds(0,10,250,30);
        findGender.setHorizontalAlignment(JLabel.CENTER);
        inputPanel3.add(findGender);

        enter3 = new JButton("Enter");
        enter3.setBounds(85, 70, 80, 30);
        enter3.addActionListener(this);
        inputPanel3.add(enter3);

        genderSelect = new JComboBox<>(gender);
        genderSelect.setBounds(25,40,200,30);
        inputPanel3.add(genderSelect);

        layeredPane.add(inputPanel,0);

        input = new JFrame();
        input.add(layeredPane);
        input.setLayout(null);
        input.setSize(250, 140);
        input.setResizable(false);
        input.setLocationRelativeTo(null);
        input.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            display.setText("");
            input.setVisible(true);
            layeredPane.removeAll();
            layeredPane.add(inputPanel);
            layeredPane.revalidate();
        }

        if(e.getSource() == b2) {
            display.setText("");
            input.setVisible(true);
            layeredPane.removeAll();
            layeredPane.add(inputPanel2);
            layeredPane.revalidate();
        }

        if (e.getSource() == b3) {
            display.setText("");
            input.setVisible(true);
            layeredPane.removeAll();
            layeredPane.add(inputPanel3);
            layeredPane.revalidate();
        }

        if (e.getSource() == b4) {
            display.setText("");
            display2.setText("List of population per district");
            int total = 0;
            Map<Integer,List<Citizen>>  distInfo = citizens.stream().collect(Collectors.groupingBy(Citizen::getDistrict));
            Set<Integer> districts = distInfo.keySet();
            String line = "-";
            display.append(line.repeat(35) + "\n");
            display.append(String.format("|%5s %-10s\t%s| \n","","District","Population"));
            display.append(line.repeat(35) + "\n");
            for (int dist : districts) {
                List<Citizen> citz = distInfo.get(dist);
                total = citz.size();
                display.append(String.format("|%5s %-10s\t%s | \n","",dist,total+" People"));
            }
            display.append(line.repeat(35) + "\n");
        }

        if (e.getSource() == b5) {
            display.setText("");
            display2.setText("All Citizen Contact Information");
            System.out.println("Citizen email address: ");
            String line = "-";
            display.append(line.repeat(100) + "\n");
            display.append(String.format("|%5s %-20s\t%-55s %-10s | \n","","Full Name","Email","Address"));
            display.append(line.repeat(100) + "\n");
            for (Citizen citizen : citizens) {
                display.append(String.format("|%5s %-20s\t%-55s %-10s | \n","",citizen.getFullName(),citizen.getEmail(),citizen.getDistrict()));
            }
            display.append(line.repeat(100) + "\n");
        }


        if (e.getSource() == b6) {
            display.setText("");
            display2.setText("All Citizen Data");
            String line = "-";
            display.append(line.repeat(181) + "\n");
            display.append(String.format("|%5s %-20s\t%s\t%s\t%-50s\t%-20s\t%-40s %-10s | \n",
                    "","Full Name", "Gender", "Age", "Email", "Resident Status", "Address", "District"));
            display.append(line.repeat(181) + "\n");
            for (Citizen citizen : citizens) {
                display.append(String.valueOf(citizen));
            }
            display.append(line.repeat(181) + "\n");
        }

        if (e.getSource() == enter) {
            boolean success = false;
            display2.setText("All Citizens that are " + age.getText() + " years old");
            display.append(line.repeat(181) + "\n");
            display.append(String.format("|%5s %-20s\t%s\t%s\t%-50s\t%-20s\t%-40s %-10s | \n",
                    "","Full Name", "Gender", "Age", "Email", "Resident Status", "Address", "District"));
            display.append(line.repeat(181) + "\n");
            try {
                if(age.getText() == null) {
                    throw new NumberFormatException("No input");
                }
                for (Citizen citizen : citizens) {
                    if (citizen.getAge() == Integer.parseInt(age.getText())) {
                        display.append(String.valueOf(citizen));
                        success = true;
                    }
                }
                if (!success) {
                    throw new SQLException("No such citizen aged " + age.getText() + " years old");
                }
                display.append(line.repeat(181) + "\n");
            }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }catch (NumberFormatException ex2) {
                JOptionPane.showMessageDialog(null,"Number Exception: Either too long or blank");
            }

            input.setVisible(false);
        }

        if (e.getSource() == enter2) {
            boolean success = false;


            display.setText("");
            display2.setText("List of citizens by resident status per district");
            Map<Integer, Map<Boolean, Set<Citizen>>> allCitizens = new TreeMap<>();

            for (Citizen cit : citizens) {
                int dist = cit.getDistrict();
                boolean citStats = cit.isResident();
                allCitizens
                        .computeIfAbsent(dist, k -> new TreeMap<>())
                        .computeIfAbsent(citStats, k -> new TreeSet<>())
                        .add(cit);
            }

            // Display the grouped citizens
                try {
                    if(Integer.parseInt(district.getText()) == 0) {
                        throw new SQLException("No such district");
                    }
                    for (Map.Entry<Integer, Map<Boolean, Set<Citizen>>> districtEntry : allCitizens.entrySet()) {
                        int district1 = districtEntry.getKey();
                        if (Integer.parseInt(district.getText()) > 0 && district1 != Integer.parseInt(district.getText())) {
                            continue; // Skip districts that don't match the selected district
                        }
                        System.out.println(district1);
                        Map<Boolean, Set<Citizen>> citStatusList = districtEntry.getValue();

                        for (Map.Entry<Boolean, Set<Citizen>> statusEntry : citStatusList.entrySet()) {
                            boolean citStat = statusEntry.getKey();
                            display.append(String.format("\t%s%n", citStat ? "Resident" : "Non-Resident"));
                            Set<Citizen> citStatList = statusEntry.getValue();

                            display.append(line.repeat(181) + "\n");
                            display.append(String.format("|%5s %-20s\t%s\t%s\t%-50s\t%-20s\t%-40s %-10s | \n",
                                    "", "Full Name", "Gender", "Age", "Email", "Resident Status", "Address", "District"));
                            display.append(line.repeat(181) + "\n");


                            for (Citizen cit : citStatList) {
                                display.append(String.valueOf(cit));
                                success = true;
                            }
                            display.append(line.repeat(181) + "\n");
                        }
                    }

                    if (!success) {
                        throw new SQLException("No such district");
                    }


                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex);
                } catch (NumberFormatException ex2) {
                    JOptionPane.showMessageDialog(null,"Number Exception: Either too long or blank");
                }
            input.setVisible(false);
        }

        if(e.getSource() == enter3) {
            if ((Character) genderSelect.getSelectedItem() == 'M') {
                display2.setText("All Citizens that are Male");
            }
            if ((Character) genderSelect.getSelectedItem() == 'F') {
                display2.setText("All Citizens that are Female");
            }
            display.append(line.repeat(181) + "\n");
            display.append(String.format("|%5s %-20s\t%s\t%s\t%-50s\t%-20s\t%-40s %-10s | \n",
                    "","Full Name", "Gender", "Age", "Email", "Resident Status", "Address", "District"));
            display.append(line.repeat(181) + "\n");
                for (Citizen citizen : citizens) {
                    if (citizen.getGender() == (Character) genderSelect.getSelectedItem()) {
                        display.append(String.valueOf(citizen));
                    }
                }
                display.append(line.repeat(181) + "\n");

            input.setVisible(false);
        }

        if (e.getSource() == clear) {
            display.setText("");
        }

    }

    public static void main(String[] args) {
        MyProgramUtility myProgramUtility = new MyProgramUtility();
        System.out.println();
        /*myProgramUtility.findCitizensByAge(citizens, 30);*/
        //System.out.println();
        myProgramUtility.showCitizenListByResidentStatusPerDistrict(citizens,1);
        //System.out.println();
        //prog.showPopulationPerDistrict(citizens);
        //System.out.println();
        //prog.contactCitizen(citizens);
        //myProgramUtility.showMaleOrFemale(citizens);
        new MyProgram();

    }
}
