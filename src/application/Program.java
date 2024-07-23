package application;

import service.BinaryEncoder;
import service.CypherEncoder;
import service.Encoder;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try{
            System.out.print("Enter message: ");
            String msg = sc.nextLine();

            System.out.print("Select encode or decode (e/d): ");
            String serviceChoice = sc.nextLine();
            Encoder encoder;

            if ( 0 == serviceChoice.compareToIgnoreCase("e")){

                System.out.println("Select encode type: ");
                System.out.print("Cypher(c) Binary(b): ");
                String serviceType = sc.nextLine();

                switch (serviceType) {
                    case "b":
                        encoder = new BinaryEncoder();
                        System.out.println(encoder.encodeMsg(msg, 2));
                    break;
                    case "c":
                        System.out.print("Shift: ");
                        int shiftKey = sc.nextInt();
                        encoder = new CypherEncoder();
                        System.out.println(encoder.encodeMsg(msg, shiftKey));
                    break;
                    default:
                        throw new InvalidParameterException("Invalid encode type");
                }

            } else if (0 == serviceChoice.compareToIgnoreCase("d")){

                System.out.println("Select encode type: ");
                System.out.print("Cypher(c) Binary(b): ");
                String serviceType = sc.nextLine();

                switch (serviceType) {
                    case "b":
                        encoder = new BinaryEncoder();
                        System.out.println(encoder.decodeMsg(msg, 2));
                        break;
                    case "c":
                        encoder = new CypherEncoder();
                        System.out.print("Shift: ");
                        int shiftKey = sc.nextInt();
                        System.out.println(encoder.decodeMsg(msg, shiftKey));
                        break;
                    default:
                        throw new InvalidParameterException("Invalid decode type");
                }
            }
            else {
                throw new InvalidParameterException("Invalid operation");
            }
        }
        catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
