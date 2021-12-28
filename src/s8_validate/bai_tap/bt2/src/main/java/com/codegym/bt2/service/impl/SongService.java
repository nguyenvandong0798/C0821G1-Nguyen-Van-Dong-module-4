package com.codegym.bt2.service.impl;

import com.codegym.bt2.dto.SongDTO;
import com.codegym.bt2.model.Song;
import com.codegym.bt2.repository.ISongRepository;
import com.codegym.bt2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    @Override
    public List<SongDTO> getAll() {
        List<Song> songList = iSongRepository.findAll();
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song song : songList) {
            SongDTO songDTO = new SongDTO(song.getId(), song.getName(), song.getSinger(), song.getKindOfMusic());
            songDTOList.add(songDTO);
        }
        return songDTOList;
    }

    @Override
    public SongDTO findById(Integer id) {
        Song song = iSongRepository.findById(id).orElse(null);
        SongDTO songDTO = new SongDTO(song.getId(), song.getName(), song.getSinger(), song.getKindOfMusic());
        return songDTO;
    }

    @Override
    public void save(SongDTO songDTO) {
        Song song = new Song(songDTO.getId(), songDTO.getName(), songDTO.getSinger(), songDTO.getKindOfMusic());
        iSongRepository.save(song);
    }

    @Override
    public List<Song> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iSongRepository.deleteById(id);
    }
}