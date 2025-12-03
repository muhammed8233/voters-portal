package com.example.voters.portal.VoterInformation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class VoterInformationConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(VoterInformationRepository repository){
        return args -> {
            VoterInformation lami = new VoterInformation(
                    "lami",
                    21,
                    "Kaduna"
            );
            VoterInformation hamza = new VoterInformation(
                    "hamza",
                    25,
                    "Benue"
            );
            repository.saveAll(
                    List.of(lami,hamza)
            );
        };
    }
}
