package com.example.voters.portal.VoterInformation;

import jakarta.persistence.*;

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
    private int votersAge;
    private String stateOfOrigin;


    public VoterInformation(){}

    public VoterInformation(Long id, int votersAge, String votersName, String stateOfOrigin) {
        this.id = id;
        this.votersAge = votersAge;
        this.votersName = votersName;
        this.stateOfOrigin = stateOfOrigin;
    }

    public VoterInformation(String votersName, int votersAge, String stateOfOrigin) {
        this.votersName = votersName;
        this.votersAge = votersAge;
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
        return votersAge;
    }

    public void setVotersAge(int votersAge) {
        this.votersAge = votersAge;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    @Override
    public String toString() {
        return "VoterInformation{" +
                "id=" + id +
                ", votersName='" + votersName + '\'' +
                ", votersAge=" + votersAge +
                ", stateOfOrigin='" + stateOfOrigin + '\'' +
                '}';
    }
}
