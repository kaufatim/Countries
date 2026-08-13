package com.springboot.springbootcallingexternalapi.Repository;

import org.springframework.stereotype.Repository;

import com.springboot.springbootcallingexternalapi.Service.callingExternalSerrvice;
import com.springboot.springbootcallingexternalapi.model.CallingExternalModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface callingExternalRepository extends JpaRepository<CallingExternalModel,String>{}{
  
}
