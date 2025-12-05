package com.example.voters.portal.VoterInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(path =  "{votersId}")
    public void deleteVoterInformation(@PathVariable("votersId")Long votersId){
        voterInformationService.deleteVoterInformation(votersId);

    }

    @PostMapping
    public void registerNewVoters(@RequestBody VoterInformation voterInformation){
        voterInformationService.addNewVoter(voterInformation);
    }

    @PutMapping(path = "{votersId}")
    public void updateVoterInformation(@PathVariable("votersId") Long id,
                                       @RequestParam("votersName")String votersName,
                                       @RequestParam("votersEmail")String votersEmail){
        voterInformationService.updateVoterInformation(id, votersName, votersEmail);
    }
}
