package BackEnd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PatientAppointmentHistory {
    private ArrayList<Appointment> history;

    public PatientAppointmentHistory(String patientID){

        history = new ArrayList<>();
        String patientDirectoryPath = "./" + patientID + "/";
        File patientDirectory = new File(patientDirectoryPath);
        File[] files = patientDirectory.listFiles();

        System.out.println(files[0].getName());


        for (File file : files) {
            if (file.isFile() && file.getName().startsWith(patientID) && file.getName().endsWith("_appointMent.txt")) {
                Appointment appointment = new Appointment(file.getAbsolutePath(), patientID);
                history.add(appointment);
            }
        }

    }

    public ArrayList<Appointment> getHistory() {
        return history;
    } 
}
