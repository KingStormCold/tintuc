package com.example.service;

import com.example.dto.NewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface INewService {
    List<NewDTO> getAll();
    List<NewDTO> getNews(String searchValue ,Pageable pageable);
    int getTotalItems(String searchValue);
}
