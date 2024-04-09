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
    private String reason;
    private NurseExam nurseExam;
    private DoctorExam docExam;


    public Appointment(Patient patient, String date, String reason) {
        this.patient = patient;
        this.date = date;
        this.reason = reason;
        createAppointmentFile();
    }

    public Appointment(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) { 
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.startsWith("Name: ")){
                    String name = line.substring(line.indexOf(':') + 2);
                    this.patient.setFullName(name);
                    this.patient.setUid(Integer.parseInt(fileName.substring(0, 4)));
                }
                else if(line.startsWith(("Date: "))){
                    String date = line.substring(line.indexOf(':') + 2);
                    this.date = date;
                }else if(line.startsWith(("Reason: "))){
                    String reason = line.substring(line.indexOf(':') + 2);
                    this.reason = reason;
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
                    Double weight = Double.parseDouble(line.trim().substring("Weight:".length()));
                    line = reader.readLine();
                    Double height = Double.parseDouble(line.trim().substring("Height:".length()));
                    line = reader.readLine();
                    Double bodyTemp = Double.parseDouble(line.trim().substring("BodyTemp:".length()));
                    line = reader.readLine();
                    Double bloodPressure = Double.parseDouble(line.trim().substring("BloodPressure:".length()));
                    nurseExam = new NurseExam(allergies, healthConcerns, weight, height, bodyTemp, bloodPressure);           
                }else if(line.startsWith(("NurseExam(Under12): "))){
                    line = reader.readLine();
                    String allergies12 = line.trim().substring("Allergies:".length());
                    line = reader.readLine();
                    String healthConcerns12 = line.trim().substring("Health Concerns:".length());
                    nurseExam = new NurseExam(allergies12, healthConcerns12);
                }else if(line.startsWith(("DoctoreExam: "))){
                    line = reader.readLine();
                    String notes = line.trim().substring("Notes:".length());
                    line = reader.readLine();
                    String prescription = line.trim().substring("Prescription:".length());
                    line = reader.readLine();
                    String prescriptionQuantity = line.trim().substring("Quantity:".length());
                    docExam = new DoctorExam(notes, prescription, prescriptionQuantity);

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
            String directoryName = "./" ;
            File directory = new File(directoryName);
            directory.mkdirs();

            String fileName = patient.getUid() + date + "_appointMent.txt";
            File staffFile = new File(directory, fileName);
            staffFile.createNewFile();

            FileWriter writer = new FileWriter(staffFile, false);

            writer.write("Name: " +  patient.getFullName() + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("Reason: " + reason + "\n");
            if(!(nurseExam == null)){
                writer.write("Nurse: " + nurse.getFullName() + "\n");
                writer.write(nurseExam.toString());
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