package com.staff.flight.service.abstraction;

import com.staff.flight.model.request.BookingRequest;
import com.staff.flight.model.response.BookingResponse;

public interface BookingService {
    BookingResponse save(BookingRequest request);
}
