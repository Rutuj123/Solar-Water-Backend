package com.solar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solar.entity.Installation;

@Repository
public interface InstallationRepository extends JpaRepository<Installation, Long>{

}
