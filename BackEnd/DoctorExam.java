package BackEnd;
public class DoctorExam {
    private String notes;
    private String prescription;
    private String prescriptionQuantity;
    
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getPrescriptionQuantity() {
        return prescriptionQuantity;
    }

    public void setPrescriptionQuantity(String prescriptionQuantity) {
        this.prescriptionQuantity = prescriptionQuantity;
    }

    public DoctorExam(String notes, String prescription, String prescriptionQuantity) {
        this.notes = notes;
        this.prescription = prescription;
        this.prescriptionQuantity = prescriptionQuantity;
    }

    @Override
    public String toString() {
        return "DoctorExam: \n Notes:" + notes + "\nPrescription:" + prescription + "\nQuantity: "
                + prescriptionQuantity + "\n";
    }










}
