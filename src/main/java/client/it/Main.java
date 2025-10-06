package client.it;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        String ip = "";
        int port = 0;

        System.out.println("Hello world!");
        System.out.println("Inserisci l'indirizzo ip:");
        ip = scanner.nextLine();
        System.out.println("Inserisci porta:");
        port = Integer.parseInt(scanner.nextLine());

        Socket socket = new Socket(ip, port);
        System.out.println("Connessione effettuata");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String version = in.readLine();
        System.out.println("Versione del server: " + version);

        String input;
        do {
            System.out.println("Inserisci una stringa (o 'esci' per uscire):");
            input = scanner.nextLine();
            
            out.println(input); 
            
            if (!input.equals("esci")) {
                String transformedString = in.readLine();
                System.out.println("Stringa trasformata: " + transformedString);
            }
        } while (!input.equals("esci"));

        scanner.close();
        
    
    }
}
