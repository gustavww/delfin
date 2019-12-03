
package Model;

public class Medlem {
    
    String name;
    int age;
    int tlf;
    String address;
    int debt;
    int status;
    
    public Medlem(String name, int age, int tlf, String address, int status){
        this.name = name;
        this.age = age;
        this.tlf = tlf;
        this.address = address;
        this.status = status;
        this.debt = 0;
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

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
