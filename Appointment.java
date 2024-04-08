package CSE360_GroupProject;


public class Appointment {
    private Doctor doctor;
    private Nurse nurse;
    private Patient patient;
    private String date;
    private String reason;
    private NurseExam nurseExam;
    private DoctorExam docExam;
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Nurse getNurse() {
        return nurse;
    }
    public void setNurse(Nurse nurse) {
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
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
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
    public Appointment(Patient patient, String date, String reason) {
        this.patient = patient;
        this.date = date;
        this.reason = reason;
    }
    public Appointment(Doctor doctor, Nurse nurse, Patient patient, String date, String reason, NurseExam nurseExam,
            DoctorExam docExam) {
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
        this.date = date;
        this.reason = reason;
        this.nurseExam = nurseExam;
        this.docExam = docExam;
    }

    public Appointment(String fileName){

    }
}