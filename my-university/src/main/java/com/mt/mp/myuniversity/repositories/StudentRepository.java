package com.mt.mp.myuniversity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.mp.myuniversity.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
