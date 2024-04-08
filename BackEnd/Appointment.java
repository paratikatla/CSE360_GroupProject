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
                }
                else if(line.startsWith(("Date: "))){
                    String date = line.substring(line.indexOf(':') + 2);
                    this.date = date;
                }else if(line.startsWith(("Reason: "))){
                    String reason = line.substring(line.indexOf(':') + 2);
                    this.reason = reason;
                }else if(line.startsWith(("Doctor: "))){
                    
                }else if(line.startsWith(("Nurse: "))){
                   
                }else if(line.startsWith(("NurseExam: "))){
                    String[] nurseExamParts = value.split("\n");
                    String allergies = nurseExamParts[1].trim().substring("Allergies:".length());
                    String healthConcerns = nurseExamParts[2].trim().substring("Health Concerns:".length());
                    Double weight = Double.parseDouble(nurseExamParts[3].trim().substring("Weight:".length()));
                    Double height = Double.parseDouble(nurseExamParts[4].trim().substring("Height:".length()));
                    Double bodyTemp = Double.parseDouble(nurseExamParts[5].trim().substring("BodyTemp:".length()));
                    Double bloodPressure = Double.parseDouble(nurseExamParts[6].trim().substring("BloodPressure:".length()));
                    nurseExam = new NurseExam(allergies, healthConcerns, weight, height, bodyTemp, bloodPressure);

                   
                }else if(line.startsWith(("NurseExam(Under12): "))){
                    String[] nurseExamParts12 = value.split("\n");
                    String allergies12 = nurseExamParts12[1].trim().substring("Allergies:".length());
                    String healthConcerns12 = nurseExamParts12[2].trim().substring("Health Concerns:".length());
                    nurseExam = new NurseExam(allergies12, healthConcerns12);


                }else if(line.startsWith(("DoctoreExam: "))){
                    String[] docExamParts = value.split("\n");
                    String notes = docExamParts[1].trim().substring("Notes:".length());
                    String prescription = docExamParts[2].trim().substring("Prescription:".length());
                    String prescriptionQuantity = docExamParts[3].trim().substring("Quantity:".length());
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

            String fileName = patient.getID() + date + "_appointMent.txt";
            File staffFile = new File(directory, fileName);
            staffFile.createNewFile();

            FileWriter writer = new FileWriter(staffFile, false);

            writer.write("Name: " +  patient.getName() + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("Reason: " + reason + "\n");
            if(!(nurseExam == null)){
                writer.write(nurseExam.toString());
            }
            if(!( docExam == null)){
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