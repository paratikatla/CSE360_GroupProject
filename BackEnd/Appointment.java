package BackEnd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Appointment {
    private Staff doctor;
    private Staff nurse;
    private Patient patient;
    private String date;
    private NurseExam nurseExam;
    private DoctorExam docExam;

    public Staff getDoctor() {
        return doctor;
    }

    public void setDoctor(Staff doctor) {
        this.doctor = doctor;
    }

    public Staff getNurse() {
        return nurse;
    }

    public void setNurse(Staff nurse) {
        this.nurse = nurse;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NurseExam getNurseExam() {
        return nurseExam;
    }

    public void setNurseExam(NurseExam nurseExam) {
        this.nurseExam = nurseExam;
    }

    public DoctorExam getDocExam() {
        return docExam;
    }

    public void setDocExam(DoctorExam docExam) {
        this.docExam = docExam;
    }

    public Appointment(Patient patient, String date) {
        this.patient = patient;
        this.date = date;
        createAppointmentFile();
    }

    public Appointment(String fileName, String uid){

        this.patient = Patient.grabPatient(uid);
        this.nurse = new Staff(null, null, null, null, null, null);
        this.doctor = new Staff(null, null, null, null, null, null);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { 
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("Name: ")){
                    String name = line.substring(line.indexOf(':') + 2);
                    this.patient.setFullName(name);
                    this.patient.setUid(Integer.parseInt(uid));
                }
                else if(line.startsWith(("Date: "))){
                    String date = line.substring(line.indexOf(':') + 2);
                    this.date = date;
                }else if(line.startsWith(("Doctor: "))){
                    String docName = line.substring(line.indexOf(':') + 2);
                    this.doctor.setFullName(docName);
                }else if(line.startsWith(("Nurse: "))){
                    String nurseName = line.substring(line.indexOf(':') + 2);
                    this.nurse.setFullName(nurseName);
                }else if(line.startsWith(("NurseExam: "))){
                    line = reader.readLine();
                    String allergies = line.trim().substring("Allergies:".length());
                    line = reader.readLine();
                    String healthConcerns = line.trim().substring("Health Concerns:".length());
                    line = reader.readLine();
                    double weight = Double.parseDouble(line.trim().substring("Weight:".length()));
                    line = reader.readLine();
                    double height = Double.parseDouble(line.trim().substring("Height:".length()));
                    line = reader.readLine();
                    double bodyTemp = Double.parseDouble(line.trim().substring("BodyTemp:".length()));
                    line = reader.readLine();
                    double bloodPressure = Double.parseDouble(line.trim().substring("BloodPressure:".length()));
                    this.nurseExam = new NurseExam(allergies, healthConcerns, weight, height, bodyTemp, bloodPressure);           
                }else if(line.startsWith(("NurseExam(Under12): "))){
                    line = reader.readLine();
                    String allergies12 = line.trim().substring("Allergies:".length());
                    line = reader.readLine();
                    String healthConcerns12 = line.trim().substring("Health Concerns:".length());
                    this.nurseExam = new NurseExam(allergies12, healthConcerns12);
                }else if(line.startsWith(("DoctorExam: "))){
                    line = reader.readLine();
                    String notes = line.trim().substring("Notes:".length());
                    line = reader.readLine();
                    String prescription = line.trim().substring("Prescription:".length());
                    line = reader.readLine();
                    String prescriptionQuantity = line.trim().substring("Quantity:".length());
                    this.docExam = new DoctorExam(notes, prescription, prescriptionQuantity);

                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }  
    }

    public void setDoctor(Staff doctor, DoctorExam exam) {
        this.doctor = doctor;
        this.docExam = exam;
        createAppointmentFile();
    }

    public void setNurse(Staff nurse, NurseExam exam) {
        this.nurse = nurse;
        this.nurseExam = exam;
        createAppointmentFile();
    }

    public void createAppointmentFile(){
        try{
            
            String patientDirectoryPath = "./" + patient.getUid() + "/";
            File patientDirectory = new File(patientDirectoryPath);
            if (!patientDirectory.exists()) {
                patientDirectory.mkdirs();
            }

            String formattedDate = date.replace("/", "_");

            String patientFilePath = patientDirectoryPath + patient.getUid() + "_" + formattedDate + "_appointMent.txt";
            File patientFile = new File(patientFilePath);

            try {
                if (patientFile.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.err.println("Error creating file: " + e.getMessage());
                e.printStackTrace();
            }

            

            FileWriter writer = new FileWriter(patientFile, false);

            writer.write("Name: " +  patient.getFullName() + "\n");
            writer.write("Date: " + date + "\n");
            if(!(nurseExam == null)){
                writer.write("Nurse: " + nurse.getFullName() + "\n");
                if(nurseExam.isU12())
                {
                    writer.write(nurseExam.toStringUnderTwelveString());
                }
                else
                {
                    writer.write(nurseExam.toString());
                }
                
            }
            if(!( docExam == null)){
                writer.write("Doctor: " + doctor.getFullName() + "\n");
                writer.write(docExam.toString());
            }

            writer.close();
			
			System.out.println("Appointment Created");
        }
        catch(IOException e)
		{
			e.printStackTrace();
		}
    }
}