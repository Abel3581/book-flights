package com.staff.flight.service;

import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;
import com.staff.flight.mapper.BookingMapper;
import com.staff.flight.repository.BookingRepository;
import com.staff.flight.service.abstraction.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    @Override
    public BookingResponse save(BookingRequest request) {

        return null;
    }
}
