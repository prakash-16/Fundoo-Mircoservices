package com.bridgelabz.fundoonotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundoonotes.entity.NoteEnity;

@Repository
public interface NoteRepository extends JpaRepository<NoteEnity, Long>{

}
