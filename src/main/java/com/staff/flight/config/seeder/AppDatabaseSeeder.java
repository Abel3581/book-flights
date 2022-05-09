package com.staff.flight.config.seeder;

import com.staff.flight.entity.Passenger;
import com.staff.flight.entity.Role;
import com.staff.flight.entity.User;
import com.staff.flight.entity.model.enums.ApplicationRole;
import com.staff.flight.repository.PassengerRepository;
import com.staff.flight.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AppDatabaseSeeder {

    private static final String PASSWORD = "12345678";
    private static final String HOST_EMAIL = "@gmail.com";
    private static final String DEFAULT_FIRST_NAME = "Passenger";
    private final RoleRepository roleRepository;
    private final PassengerRepository passengerRepository;

    private final PasswordEncoder passwordEncoder;
    private static final String DNIS[] ={"12345674","55555555","98765432","45678902","12345678",
            "12345974","55585555","18765432","45638902","72345678"};

    @EventListener
    public void seed(ContextRefreshedEvent event){
        List<Role> roles = roleRepository.findAll();
        if(roles.isEmpty()){
            createRoles();
        }
    List<Passenger> users = passengerRepository.findAll();
        if(users.isEmpty()){
            createUsers();
        }

    }

    private void createUsers() {
        createUser(ApplicationRole.ADMIN);
        createUser(ApplicationRole.USER);
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
    int cont = 0;
    private void createUser(ApplicationRole applicationRole){

        for(int i = 0; i < 5; i++){
            Passenger p = new Passenger();
            p.setFirstName(DEFAULT_FIRST_NAME);
            p.setLastName(applicationRole.getName() + i);
            p.setEmail(applicationRole.getName() + i + HOST_EMAIL);
            p.setTimestamp(new Timestamp(System.currentTimeMillis()));
            p.setPassword(passwordEncoder.encode(PASSWORD));
            p.setDni(DNIS[cont]);
            p.setCountry("Argentina");
            List<Role> roles = new ArrayList<>();
            roles.add(roleRepository.findByName(applicationRole.getFullRoleName()));
            p.setRoles(roles);
            passengerRepository.save(p);
            cont++;
        }
    }
}
