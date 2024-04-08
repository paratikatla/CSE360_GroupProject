package BackEnd;
public class NurseExam {
    private String allergies;
    private String healthConcerns;
    private Double weight;
    private Double height;
    private Double bodyTemp;
    private Double bloodPressure;

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
    public String getHealthConcerns() {
        return healthConcerns;
    }
    public void setHealthConcerns(String healthConcerns) {
        this.healthConcerns = healthConcerns;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getBodyTemp() {
        return bodyTemp;
    }
    public void setBodyTemp(Double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }
    public Double getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    public NurseExam(String allergies, String healthConcerns, Double weight, Double height, Double bodyTemp,
            Double bloodPressure) {
        this.allergies = allergies;
        this.healthConcerns = healthConcerns;
        this.weight = weight;
        this.height = height;
        this.bodyTemp = bodyTemp;
        this.bloodPressure = bloodPressure;
    }

    public NurseExam(String allergies, String healthConcerns) {
        this.allergies = allergies;
        this.healthConcerns = healthConcerns;
    }

    @Override
    public String toString() {
        //add if patient under12 check

        return "Nurse Exam: \nAllergies:" + allergies + "\n Health Concerns:" + healthConcerns + "\n Weight:" + weight
                + "\nHeight=" + height + "\n BodyTemp=" + bodyTemp + "\n BloodPressure=" + bloodPressure  +  "\n";
    }

    public String toStringUnderTwelveString (){
        return "Nurse Exam (Under 12):  \nAllergies=" + allergies + "\n HealthConcerns=" + healthConcerns +  "\n";
    }
}
