import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }
}

class Appointment {
    int patientId;
    int doctorId;
    String date;

    Appointment(int patientId, int doctorId, String date) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }
}

class Hospital {
    ArrayList<Patient> patients = new ArrayList<>();
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Appointment> appointments = new ArrayList<>();

    void addPatient(Patient p) {
        patients.add(p);
        System.out.println("Patient added successfully.");
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
        System.out.println("Doctor added successfully.");
    }

    void showPatients() {
        System.out.println("\n--- Patients List ---");
        for (Patient p : patients) {
            System.out.println(p.id + " | " + p.name + " | Age: " + p.age + " | " + p.disease);
        }
    }

    void showDoctors() {
        System.out.println("\n--- Doctors List ---");
        for (Doctor d : doctors) {
            System.out.println(d.id + " | " + d.name + " | " + d.specialization);
        }
    }

    void bookAppointment(int pid, int did, String date) {
        appointments.add(new Appointment(pid, did, date));
        System.out.println("Appointment booked successfully.");
    }

    void showAppointments() {
        System.out.println("\n--- Appointments ---");
        for (Appointment a : appointments) {
            System.out.println("Patient ID: " + a.patientId +
                    " | Doctor ID: " + a.doctorId +
                    " | Date: " + a.date);
        }
    }
}

public class HospitalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital h = new Hospital();

        // Sample doctors
        h.addDoctor(new Doctor(1, "Dr. Arun", "Cardiologist"));
        h.addDoctor(new Doctor(2, "Dr. Meena", "Neurologist"));

        while (true) {
            System.out.println("\n===== Hospital Menu =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Show Patients");
            System.out.println("3. Show Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Show Appointments");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Patient ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    h.addPatient(new Patient(pid, pname, age, disease));
                    break;

                case 2:
                    h.showPatients();
                    break;

                case 3:
                    h.showDoctors();
                    break;

                case 4:
                    System.out.print("Patient ID: ");
                    int apid = sc.nextInt();
                    System.out.print("Doctor ID: ");
                    int adid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Date (DD/MM/YYYY): ");
                    String date = sc.nextLine();

                    h.bookAppointment(apid, adid, date);
                    break;

                case 5:
                    h.showAppointments();
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
