package com.staff.flight.service.abstraction;

import com.staff.flight.model.entity.Role;

public interface RoleService {

    Role findBy(String name);
}
