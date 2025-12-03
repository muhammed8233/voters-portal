package com.example.voters.portal.VoterInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoterInformationService {
    private final VoterInformationRepository voterInformationRepository;

    @Autowired
    public VoterInformationService(VoterInformationRepository voterInformationRepository) {
        this.voterInformationRepository = voterInformationRepository;
    }

    public List<VoterInformation> getVoterInformation(){
        return voterInformationRepository.findAll();
    }

}
