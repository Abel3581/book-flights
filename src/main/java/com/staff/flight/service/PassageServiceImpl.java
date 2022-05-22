package com.staff.flight.service;


import com.staff.flight.mapper.PassageMapper;
import com.staff.flight.model.entity.Passage;
import com.staff.flight.model.response.PassageResponse;
import com.staff.flight.repository.PassageRepository;
import com.staff.flight.service.abstraction.PassageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class PassageServiceImpl implements PassageService {

    private final PassageMapper passageMapper;
    private final PassageRepository passageRepository;

    //Obtiene los pasajes por el id del pasajero
    //Get the tickets by the passenger id
    @Override
    public List<PassageResponse> getPassageByIdPassenger(Long idPassenger) {
        List<Passage> passages = passageRepository.findByIdPassenger(idPassenger);
        return passageMapper.passageEntityList2DtoList(passages);
    }
}
