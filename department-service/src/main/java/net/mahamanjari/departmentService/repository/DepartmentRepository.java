package net.mahamanjari.departmentService.repository;

import net.mahamanjari.departmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Optional<Department> findByDepartmentCode(String departmentCode);
}
