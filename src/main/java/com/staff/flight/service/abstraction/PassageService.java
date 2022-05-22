package com.staff.flight.service.abstraction;

import com.staff.flight.model.response.PassageResponse;

import java.util.List;

public interface PassageService {

    List<PassageResponse> getPassageByIdPassenger(Long idPassenger);
}
