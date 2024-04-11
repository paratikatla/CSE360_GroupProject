package BackEnd;
public class NurseExam {
    private String allergies;
    private String healthConcerns;
    private double weight;
    private double height;
    private double bodyTemp;
    private double bloodPressure;
    private boolean u12;

    public boolean isU12() {
        return u12;
    }

    public void setU12(boolean u12) {
        this.u12 = u12;
    }

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
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getBodyTemp() {
        return bodyTemp;
    }
    public void setBodyTemp(double bodyTemp) {
        this.bodyTemp = bodyTemp;
    }
    public double getBloodPressure() {
        return bloodPressure;
    }
    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
    
    public NurseExam(String allergies, String healthConcerns, double weight, double height, double bodyTemp,double bloodPressure) {
        this.allergies = allergies;
        this.healthConcerns = healthConcerns;
        this.weight = weight;
        this.height = height;
        this.bodyTemp = bodyTemp;
        this.bloodPressure = bloodPressure;

        if(allergies.isEmpty())
        {
            this.allergies = "None";
        }
        this.healthConcerns = healthConcerns;
        if(healthConcerns.isEmpty())
        {
            this.healthConcerns = "None";
        }
        
        this.u12 = false;
    }

    public NurseExam(String allergies, String healthConcerns) {
        this.allergies = allergies;
        if(allergies.isEmpty())
        {
            this.allergies = "None";
        }
        this.healthConcerns = healthConcerns;
        if(healthConcerns.isEmpty())
        {
            this.healthConcerns = "None";
        }
        this.u12 = true;
    }

    @Override
    public String toString() {
        //add if patient under12 check

        return "NurseExam: \nAllergies:" + allergies + "\n Health Concerns:" + healthConcerns + "\n Weight:" + weight
                + "\nHeight:" + height + "\n BodyTemp:" + bodyTemp + "\n BloodPressure:" + bloodPressure  +  "\n";
    }

    public String toStringUnderTwelveString (){
        return "NurseExam(Under12):  \n Allergies:" + allergies + "\n HealthConcerns:" + healthConcerns +  "\n";
    }
}
