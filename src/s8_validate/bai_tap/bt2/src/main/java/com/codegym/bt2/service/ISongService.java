package com.codegym.bt2.service;


import com.codegym.bt2.dto.SongDTO;
import com.codegym.bt2.model.Song;

import java.util.List;

public interface ISongService {

    List<SongDTO> getAll();

    SongDTO findById(Integer id);

    void save(SongDTO songDTO);

    List<Song> findByName(String name);

    void remove(Integer id);
}
