package com.staff.flight.service.abstraction;

import com.staff.flight.entity.model.request.BookingRequest;
import com.staff.flight.entity.model.response.BookingResponse;

public interface BookingService {
    BookingResponse save(BookingRequest request);
}
