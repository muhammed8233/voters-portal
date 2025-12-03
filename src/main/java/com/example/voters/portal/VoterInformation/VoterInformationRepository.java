package com.example.voters.portal.VoterInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterInformationRepository
        extends JpaRepository<VoterInformation, Long> {
}
