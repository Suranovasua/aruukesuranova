import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of devices you want to create (between 1 and 20): ");
        int numberOfDevices = scanner.nextInt();

        if (numberOfDevices < 1 || numberOfDevices > 20) {
            System.out.println("Please enter a valid number between 1 and 20.");
            return;
        }

        ArrayList<Device> devices = new ArrayList<>();
        ArrayList<String> distinctTypes = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < numberOfDevices; i++) {
            String[] possibleTypes = { "Smartphone", "Laptop", "Tablet" };
            String randomType = possibleTypes[rand.nextInt(possibleTypes.length)];
            double randomPrice = Math.round(rand.nextDouble() * 1000.0);
            double randomWeight = rand.nextDouble() * 5.0;
            String randomModel = generateRandomModel(randomType, rand);
            double randomStorage = Math.round(rand.nextDouble() * 1000.0);

            if (randomType.equals("Smartphone")) {
                devices.add(new Smartphone(randomType, randomPrice, randomWeight, randomModel, randomStorage));
            } else if (randomType.equals("Laptop")) {
                devices.add(new Laptop(randomType, randomPrice, randomWeight, randomModel, randomStorage));
            } else if (randomType.equals("Tablet")) {
                devices.add(new Tablet(randomType, randomPrice, randomWeight, randomModel, randomStorage));
            }

            if (!distinctTypes.contains(randomType)) {
                distinctTypes.add(randomType);
            }
        }

        double totalWeight = 0;

        for (Device device : devices) {
            totalWeight += device.getWeight();
        }

        System.out.println("Number of distinct device types created: " + distinctTypes.size());
        System.out.println("Total weight of all devices: " + totalWeight + " kg");

        for (Device device : devices) {
            System.out.println("Device Type: " + device.getType());
            System.out.println("Device Price: $" + device.getPrice());
            System.out.println("Device Weight: " + device.getWeight() + " kg");
            System.out.println("Device Model: " + device.getModel());
            System.out.println("Device Storage: " + device.getStorage() + " GB");
            System.out.println();
        }

        scanner.close();
    }


    private static String generateRandomModel(String deviceType, Random rand) {
        StringBuilder model = new StringBuilder(deviceType);

        for (int i = 0; i < 4; i++) {
            model.append((char) (rand.nextInt(26) + 'A'));
        }

        return model.toString();
    }
}
