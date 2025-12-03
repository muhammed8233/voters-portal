package com.example.voters.portal.VoterInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/voters")
public class VoterInformationController {
    private final VoterInformationService voterInformationService;

    @Autowired
    public VoterInformationController(VoterInformationService voterInformationService) {
        this.voterInformationService = voterInformationService;
    }

    @GetMapping
    public List<VoterInformation> getVoterInformation(){
        return voterInformationService.getVoterInformation();
    }
}
