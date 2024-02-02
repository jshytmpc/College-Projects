import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    static Scanner keyboard = new Scanner(System.in);
    
    public static void getAllIps(String hostname) {
        ArrayList<String> allIpAddresses = new ArrayList<>();
        try {
            // Call method that gives the IP addresses from the host
            InetAddress[] ipAddress = InetAddress.getAllByName(hostname); 
            for (InetAddress ipAddresses: ipAddress) {
                // Only prints out IPv4 Adresses 
                if(ipAddresses instanceof Inet4Address) {
                    allIpAddresses.add(ipAddresses.getHostAddress());
                }
            }
            System.out.printf("%5s %-15s \n", "", "Number of Hosts/IPs: " + allIpAddresses.size());
            System.out.printf("%5s %-15s %-15s \n", "", "Hostname", "IP Address");
            for(String allIPs: allIpAddresses) {
                System.out.printf("%5s %-15s %-15s \n", "", hostname, allIPs);
            }
        } catch (UnknownHostException e) {
            System.out.println("Error: Hostname provided is unknown");
        }
    }

    public static void showIntroduction() {
        System.out.println("|---------------------------------|");
        System.out.println("|           IT222 9472            |");
        System.out.println("|     Integrative Technologies    |");
        System.out.println("|                                 |");
        System.out.println("|             Exercise 1          |");
        System.out.println("|  Internet Addressing with JAVA  |");
        System.out.println("|                                 |");
        System.out.println("|              Author             |");
        System.out.println("|           Joshua Timpac         |");
        System.out.println("|---------------------------------|");
        
        try {
            System.out.println();
            System.out.println("Press the ENTER key to start...");
            keyboard.nextLine();
        }  
        catch(Exception e) {
            System.out.println(e);
        }  
    }
}
