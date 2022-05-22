package com.staff.flight.controller;


import com.staff.flight.model.response.PassageResponse;
import com.staff.flight.service.abstraction.PassageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/passage")
public class PassageController {

    private final PassageService passageService;
    @GetMapping("/idPassenger")
    private ResponseEntity<List<PassageResponse>> getPassageByIdPassenger(@RequestParam Long idPassenger){
        List<PassageResponse> passageResponses = passageService.getPassageByIdPassenger(idPassenger);
        return ResponseEntity.status(HttpStatus.OK).body(passageResponses);
    }
}
