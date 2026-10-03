package com.example.restApi.Repository;

import com.example.restApi.Entity.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<student,Long> {
}
