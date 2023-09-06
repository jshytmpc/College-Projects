package prog2.finalgroup;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MyProgramUtility {
    /**
     *
     * @param filename
     * @return
     */
    public List<Citizen> readDataFileIntoList(String filename) {
        try (BufferedReader rdr = new BufferedReader(new FileReader(filename))) {
            List<Citizen> citizens = new ArrayList<>();
            String line;
            while ((line = rdr.readLine()) != null) {
                String[] data = splitCSVLine(line);
                boolean resident = data[5].equalsIgnoreCase("resident");
                String fullName = data[0] + " " + data[1];
                int age = Integer.parseInt(data[4]);
                int district = Integer.parseInt(data[6]);
                char gender = data[7].charAt(0);
                Citizen cit = new Citizen(fullName, data[2], data[3], age, resident, district, gender);
                citizens.add(cit);
            }
            return citizens;
        } catch (IOException e) {
            throw new RuntimeException("Data file read error.", e);
        }
    }

    /**
     * This method deals with data that contain comma and is enclosed in double quotes.
     *
     * @param line
     * @return
     */
    private String[] splitCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder field = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(field.toString());
                field.setLength(0);
            } else {
                field.append(c);
            }
        }

        fields.add(field.toString());

        return fields.toArray(new String[0]);
    }

    /**
     * @param citizens
     * @param targetAge
     * @return
     */
    public void findCitizensByAge(List<Citizen> citizens, int targetAge) {
        String line = "-";
        System.out.println("Citizens aged " + targetAge + ": ");
        System.out.println(line.repeat(181));
        System.out.printf("|%5s %-20s\t%s\t%s\t%-50s\t%-20s\t%-40s %-10s | \n",
                "","Full Name", "Gender", "Age", "Email", "Resident Status", "Address", "District");
        System.out.println(line.repeat(181));
        for (Citizen citizen : citizens) {
            if (citizen.getAge() == targetAge) {
                System.out.println(citizen);
            }
        }
        System.out.println(line.repeat(181));
    }

    public String showAllCitizens(List<Citizen> citizens) {
        for (Citizen citizen : citizens) {
            System.out.println(citizen);
        }
        return citizens.toString();
    }

    /**
     *
     * @param citizens
     */
    public void showPopulationPerDistrict (List<Citizen> citizens) {
        System.out.println("Population Per District");
        int total = 0;
        Map<Integer,List<Citizen>>  distInfo = citizens.stream().collect(Collectors.groupingBy(Citizen::getDistrict));
        Set<Integer> districts = distInfo.keySet();
        System.out.printf("%s: %d%n", "District|Population");
        for (int dist : districts) {
            List<Citizen> citz = distInfo.get(dist);
            total = citz.size();
            System.out.printf("%s: %d%n", dist,total);
        }
        System.out.println("-");
    }

    /**
     *
     * @param citizens
     */
    public void showCitizenListByResidentStatusPerDistrict(List<Citizen> citizens, int selectDistrict) {
        System.out.println("List of citizens by resident status per district:");
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
        for (Map.Entry<Integer, Map<Boolean, Set<Citizen>>> districtEntry : allCitizens.entrySet()) {
            int district = districtEntry.getKey();
            if (selectDistrict > 0 && district != selectDistrict) {
                continue; // Skip districts that don't match the selected district
            }
            System.out.println(district);
            Map<Boolean, Set<Citizen>> citStatusList = districtEntry.getValue();

            for (Map.Entry<Boolean, Set<Citizen>> statusEntry : citStatusList.entrySet()) {
                boolean citStat = statusEntry.getKey();
                System.out.printf("\t%s%n", citStat ? "Resident" : "Non-Resident");
                Set<Citizen> citStatList = statusEntry.getValue();

                for (Citizen cit : citStatList) {
                    System.out.println(cit);
                }
            }
        }
    }

    public void contactCitizen(List<Citizen> citizens) {
        System.out.println("Citizen email address: ");
        for (Citizen citizen : citizens) {
            System.out.println("\tCitizen: " + citizen.getFullName());
            System.out.println("\tEmail: " + citizen.getEmail());
            System.out.println("-------------------------------------------------");
        }
    }

    public void showMaleOrFemale(List<Citizen> citizens) {
        Scanner kbd = new Scanner(System.in);
        int choice = 0;
        System.out.println("Choices: 1-Males | 2-Females");
        choice = kbd.nextInt();

        switch (choice) {
            case 1:
                citizens
                        .stream()
                        .filter(peep -> peep.isGender())
                        .sorted(Comparator.comparing(Citizen::getFullName))
                        .forEach(System.out::println);
                break;
            case 2:
                citizens
                        .stream()
                        .filter(peep -> !peep.isGender())
                        .sorted(Comparator.comparing(Citizen::getFullName))
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }


    }
}
