package com.example.voters.portal.VoterInformation;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class VoterInformation {
    @Id
    @SequenceGenerator(
            name = "voter_information_sequence",
            sequenceName = "voter_information_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "voter_information_sequence"
    )
    private Long id;
    private String votersName;
    private LocalDate dob;
    @Transient
    private int votersAge;
    private String votersEmail;
    private String stateOfOrigin;


    public VoterInformation(){}

    public VoterInformation(Long id, String votersName,
                            LocalDate dob, String votersEmail, String stateOfOrigin) {
        this.id = id;
        this.votersName = votersName;
        this.dob = dob;
        this.votersEmail = votersEmail;
        this.stateOfOrigin = stateOfOrigin;
    }

    public VoterInformation(String votersName, String votersEmail, String stateOfOrigin) {
        this.votersName = votersName;
        this.votersEmail = votersEmail;
        this.stateOfOrigin = stateOfOrigin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVotersName() {
        return votersName;
    }

    public void setVotersName(String votersName) {
        this.votersName = votersName;
    }

    public int getVotersAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setVotersAge(int votersAge) {
        this.votersAge = votersAge;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public String getVotersEmail() {
        return votersEmail;
    }

    public void setVotersEmail(String votersEmail) {
        this.votersEmail = votersEmail;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "VoterInformation{" +
                "id=" + id +
                ", votersName='" + votersName + '\'' +
                ", votersDob='" + dob + '\'' +
                ", votersAge=" + votersAge +
                ", votersEmail='" + votersEmail + '\'' +
                ", stateOfOrigin='" + stateOfOrigin + '\'' +
                '}';
    }
}
