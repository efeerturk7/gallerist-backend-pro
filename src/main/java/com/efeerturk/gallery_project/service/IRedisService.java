package com.efeerturk.gallery_project.service;

import tools.jackson.core.type.TypeReference;

public interface IRedisService {
    void setValue(String key, Object value, long timeoutCache);

    <T> T getValue(String key, TypeReference<T> typeReference);

    void deleteValue(String key);
}
