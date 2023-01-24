package com.back_end_android.back_end.migration;

import com.back_end_android.back_end.models.ERole;
import com.back_end_android.back_end.models.Role;
import com.back_end_android.back_end.repository.RoleRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

@ChangeLog(order = "001")
public class MigrationRole {

    @ChangeSet(order = "001", id = "addRole", author = "aristide")
    public void initRole(RoleRepository roleRepository){
        Role role = new Role(ERole.ROLE_USER);
        roleRepository.save(role);
    }


}
