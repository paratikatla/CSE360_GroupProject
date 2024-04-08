package BackEnd;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

public class PatientAppointmentHistory {
    private ArrayList<Appointment> history;

    public PatientAppointmentHistory(String patientID){
        history = new ArrayList<>();
        File directory = new File("./"); 
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().startsWith(patientID) && file.getName().endsWith("_appointment.txt")) {
                Appointment appointment = new Appointment(file.getAbsolutePath());
                history.add(appointment);
            }
        }

    }

    public ArrayList<Appointment> getHistory() {
        return history;
    } 
}
