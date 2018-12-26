package javaplus.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plates")
public class Plate {
    @Id
    private Long id;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "state")
    public String state;


    public Plate() {

    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }
}

