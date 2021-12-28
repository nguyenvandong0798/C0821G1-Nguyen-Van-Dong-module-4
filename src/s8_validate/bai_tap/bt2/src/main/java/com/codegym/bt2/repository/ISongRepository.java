package com.codegym.bt2.repository;

import com.codegym.bt2.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {

}
