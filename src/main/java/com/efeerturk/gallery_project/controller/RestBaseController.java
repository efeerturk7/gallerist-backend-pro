package com.efeerturk.gallery_project.controller;

import com.efeerturk.gallery_project.utils.PagerUtil;
import com.efeerturk.gallery_project.utils.RestPageableEntity;
import com.efeerturk.gallery_project.utils.RestPageableRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RestBaseController {
    public <T> RootEntity<T> ok(T payload) {
        return RootEntity.ok(payload);
    }

    public <T> RootEntity<T> error(String errorMessage){
        return RootEntity.error(errorMessage);
    }
    public Pageable toPageable(RestPageableRequest request) {
        return PagerUtil.toPageable(request);
    }

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page , List<T> content) {
        return PagerUtil.toPageableResponse(page, content);
    }
}
