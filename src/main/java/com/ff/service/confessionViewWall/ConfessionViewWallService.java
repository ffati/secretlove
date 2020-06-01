package com.ff.service.confessionViewWall;

import com.ff.entity.ConfessionViewWallEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ConfessionViewWallService
 * @Description TODO
 * @Author ff
 * @Date 2020/2/17 13:12
 * @ModifyDate 2020/2/17 13:12
 * @Version 1.0
 */

@Service
public interface ConfessionViewWallService {

    @CacheEvict(cacheNames = "ConfessionViewWallForPage",key = "#totalPage")
    Boolean insertOne(Integer totalPage,ConfessionViewWallEntity confessionViewWallEntity);

    Boolean deleteOneEarliest();

    @Cacheable(cacheNames = "ConfessionViewWallForPage",key = "#index")
    List<ConfessionViewWallEntity> findForPage(Integer index,Integer size);

    Integer countAll();
}
