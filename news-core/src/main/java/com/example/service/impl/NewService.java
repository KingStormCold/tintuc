package com.example.service.impl;

import com.example.converter.NewConverter;
import com.example.dto.NewDTO;
import com.example.entity.NewEntity;
import com.example.repository.INewRepository;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService implements INewService {
    @Autowired
    private INewRepository newRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public List<NewDTO> getAll() {
        List<NewDTO> newDTOS = new ArrayList<>();
        List<NewEntity> newEntities = newRepository.findAll();
        for (NewEntity item : newEntities) {
            NewDTO newDTO = new NewDTO();
            newDTO.setTitle(item.getTitle());
            newDTO.setContent(item.getContent());
            newDTOS.add(newDTO);
        }
        return newDTOS;
    }

    @Override
    public List<NewDTO> getNews(String searchValue,Pageable pageable) {
        List<NewDTO> result = new ArrayList<>();
        Page<NewEntity> newsPage = null;
        if (searchValue != null) {
            newsPage = newRepository.findByTitleContainingIgnoreCase(searchValue, pageable);
        } else {
            newsPage = newRepository.findAll(pageable);
        }
        for (NewEntity item : newsPage.getContent()) {
            NewDTO newDTO = newConverter.convertToDto(item);
            result.add(newDTO);
        }
        return result;
    }

    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
        if (searchValue != null) {
            totalItem = (int) newRepository.countByTitleContainingIgnoreCase(searchValue);
        } else {
            totalItem = (int) newRepository.count();
        }
        return totalItem;
    }

    @Override
    public NewDTO insert(NewDTO newDTO) {

        return null;
    }
}
