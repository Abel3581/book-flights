package com.staff.flight.service;

import com.staff.flight.model.entity.Role;
import com.staff.flight.repository.RoleRepository;
import com.staff.flight.service.abstraction.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role findBy(String name) {
        return roleRepository.findByName(name);
    }
}
