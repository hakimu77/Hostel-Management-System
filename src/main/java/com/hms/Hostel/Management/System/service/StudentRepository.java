package com.hms.Hostel.Management.System.service;

import com.hms.Hostel.Management.System.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, String> {
}
