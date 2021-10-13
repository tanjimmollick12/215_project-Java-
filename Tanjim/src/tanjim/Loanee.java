
package tanjim;


import java.io.Serializable;


public class Loanee implements Serializable{
    private static final long serialVersionUID = 1L;
    private String tOloan;
    private String name;
    private int age;
    private String gender;
    private String occupation;
    private String phone;
    private double amount; // actual amount
    private double rate;
    private String registeredOn;
    
    private String admin;


    private int time;
    private double EMI; //per month
    private int i;
    private int EMIPaidIndex ;
    private int dueListIndex;
    
    private double[] DueList = new double[120];

    private double[] EMIPaid = new double[120];
    private String[] EMIPaidDate = new String[120];
    
    private double compoundInterest; // total payable

    public double getCompoundInterest() {
        return compoundInterest;
    }

    public void setCompoundInterest(double compoundInterest) {
        this.compoundInterest = compoundInterest;
    }

    public double getEMI() {
        return EMI;
    }

    public void setEMI(double EMI) {
        this.EMI = EMI;
    }
     
    Loanee(String tOloan,String name, String admin, int age,String gender,String occupation,
            String phone,double amount,double rate,int time)
    {
        
        this.i = 0;
        this.EMIPaidIndex = 0;
        this.dueListIndex = 0;
        this.tOloan = tOloan;
        this.name = name;
        this.age  =age;
        this.gender = gender;
        this.occupation = occupation;
        this.phone = phone;
        this.amount = amount;
        this.rate = rate;
        this.time=time;
        
        this.DueList[0] = amount;
        this.admin = admin;
       
                    
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
    public double getDueList(int i) {
        return DueList[i];
    }

    public void setDueList(double due) {
        this.DueList[dueListIndex++] = due;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double[] getEMIPaid() {
        return EMIPaid;
    }

    public void setEMIPaid(double amount) {
        this.EMIPaid[this.i++] = amount;
    }

    public String gettOloan() {
        return tOloan;
    }

    public void settOloan(String tOloan) {
        this.tOloan = tOloan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public String getEMIPaidDate(int i) {
        return EMIPaidDate[i];
    }

    public void setEMIPaidDate(String date) {
        this.EMIPaidDate[EMIPaidIndex++] = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    
}
 
