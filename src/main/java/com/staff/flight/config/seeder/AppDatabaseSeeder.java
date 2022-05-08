package com.staff.flight.config.seeder;

import com.staff.flight.entity.Role;
import com.staff.flight.entity.model.enums.ApplicationRole;
import com.staff.flight.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppDatabaseSeeder {

    private final RoleRepository roleRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event){
        List<Role> roles = roleRepository.findAll();
        if(roles.isEmpty()){
            createRoles();
        }
    }

    private void createRoles() {
        createRole(1L, ApplicationRole.ADMIN);
        createRole(2L, ApplicationRole.USER);
        createRole(3L, ApplicationRole.STAFF);
    }

    private void createRole(Long id, ApplicationRole applicationRole) {
        Role role = new Role();
        role.setRoleId(id);
        role.setName(applicationRole.getFullRoleName());
        role.setDescription(applicationRole.getName());
        roleRepository.save(role);
    }
}
