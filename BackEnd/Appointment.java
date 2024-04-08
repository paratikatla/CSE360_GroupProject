package BackEnd;

import java.io.File;
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
    }

    public void setDoctor(Staff doctor, DoctorExam exam) {
        this.doctor = doctor;
        this.docExam = exam;
    }

    public void setNurse(Staff nurse, NurseExam exam) {
        this.nurse = nurse;
        this.nurseExam = exam;
    }

    public void createAppointmentFIle(){
        try{
            String directoryName = "./" + employeeID;
            File directory = new File(directoryName);
            directory.mkdirs();

            String fileName = "" + date + "_appointMent.txt";
            File staffFile = new File(directory, fileName);
            staffFile.createNewFile();

            FileWriter writer = new FileWriter(staffFile, false);

            //writer.write("Name : " +  + " " +  + "\n");
            //writer.write("Employee ID : " + employeeID + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("Reason: " + reason + "\n");
            writer.write(nurseExam.toString());
            writer.write(docExam.toString());


            writer.close();
			
			System.out.println("Staff Created");
        }
        catch(IOException e)
		{
			e.printStackTrace();
		}
    }

    public void createFromFile(){

        
    }
}