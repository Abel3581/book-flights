package com.staff.flight.mapper;


import com.staff.flight.model.entity.Passage;
import com.staff.flight.model.response.PassageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PassageMapper {

    private final BookingMapper bookingMapper;
    public List<PassageResponse> passageEntityList2DtoList(List<Passage> passages) {
        List<PassageResponse> dtos = new ArrayList<>();
        PassageResponse passageResponse;
        for (Passage p: passages){
            passageResponse = new PassageResponse();
            passageResponse.setId(p.getId());
            passageResponse.setIssue(p.getIssue());
            passageResponse.setIdPassenger(p.getIdPassenger());
            passageResponse.setPaymentInfo(p.isPaymentInfo());
            passageResponse.setBooking(bookingMapper.bookingEntity2DTO(p.getBooking()));
            dtos.add(passageResponse);
        }
        return dtos;

    }
}
