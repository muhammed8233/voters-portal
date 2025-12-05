package com.example.voters.portal.VoterInformation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoterInformationRepository
        extends JpaRepository<VoterInformation, Long> {
    @Query("SELECT s FROM Voter-information s WHERE s.votersEmail = ?1")
    Optional<VoterInformation> findVoterInformationByEmail(String votersEmail);
}
