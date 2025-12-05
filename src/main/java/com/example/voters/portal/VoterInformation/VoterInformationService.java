package com.example.voters.portal.VoterInformation;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VoterInformationService {
    private final VoterInformationRepository voterInformationRepository;

    @Autowired
    public VoterInformationService(VoterInformationRepository voterInformationRepository) {
        this.voterInformationRepository = voterInformationRepository;
    }

    public List<VoterInformation> getVoterInformation() {
        return voterInformationRepository.findAll();
    }

    @Transactional
    public void updateVoterInformation(Long votersId, String votersName, String votersEmail) {
        VoterInformation voters = voterInformationRepository.
                findById(votersId).orElseThrow(() ->
                        new IllegalStateException("voter with id" + votersId + "does not exist"));

        if (votersName != null && !Objects.equals(voters.getVotersName(), votersName)) {
            voters.setVotersName(votersName);
        }
        if (votersEmail != null && !Objects.equals(voters.getVotersEmail(), votersEmail)) {
            Optional<VoterInformation> voter = voterInformationRepository
                    .findVoterInformationByEmail(votersEmail);
            if (voter.isPresent()) {
                throw new IllegalStateException("Email is taken");
            }
            voters.setVotersEmail(votersEmail);
        }
    }

    public void deleteVoterInformation(Long votersId) {
        boolean exist = voterInformationRepository.existsById(votersId);
        if(!exist) {
            throw new IllegalStateException("voter with id" + votersId + "does not exist");
        }
        voterInformationRepository.deleteById(votersId);
    }

    public void addNewVoter(VoterInformation voterInformation) {
        Optional<VoterInformation> optional = voterInformationRepository
                .findVoterInformationByEmail(voterInformation.getVotersEmail());
        if(optional.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        voterInformationRepository.save(voterInformation);
    }
}

