package com.example.controller.admin;

import com.example.constant.SystemConstant;
import com.example.dto.NewDTO;
import com.example.service.ICategoryService;
import com.example.service.INewService;
import com.example.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller (value = "newControllerOfAdmin")
public class NewController {

    @Autowired
    private INewService newService;

    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView getNews(@ModelAttribute(SystemConstant.MODEL)NewDTO model,
                                HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/new/list");
        DisplayTagUtils.initSearchBean(request,model);
        Pageable pageable = (Pageable) new PageRequest(model.getPage() - 1,model.getMaxPageItems());
        List<NewDTO> news = newService.getNews(model.getSearchValue(),pageable);
        model.setListResult(news);
        model.setTotalItems(newService.getTotalItems(model.getSearchValue()));
        mav.addObject(SystemConstant.MODEL,model);
        return mav;
    }

    @RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
    public ModelAndView editNewsPage(){
        ModelAndView mav = new ModelAndView("admin/new/edit");
        NewDTO news = new NewDTO();
        news.setCategories(categoryService.getCategories());
        mav.addObject(SystemConstant.MODEL, news);
        return mav;
    }
}
