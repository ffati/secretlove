package com.ff.service.administration;

import com.ff.entity.GlobalParameterEntity;
import com.ff.entity.SystemPictureManagementEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @ClassName AdministrationService
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 18:32
 * @ModifyDate 2020/4/17 18:32
 * @Version 1.0
 */

public interface AdministrationService {

    @CacheEvict(cacheNames = "GlobalParameterFindForPage",allEntries=true)
    void addOneGlobalParameter(/*int totalPage,*/GlobalParameterEntity globalParameterEntity);

    @CacheEvict(cacheNames = "GlobalParameterFindForPage",allEntries=true)

    void updateParameterByParamterName(GlobalParameterEntity globalParameterEntity);

    @Cacheable(cacheNames = "GlobalParameterFindForPage",key = "#key +'_'+ #size")
    List<GlobalParameterEntity > findGlobalParameterForPage(int key,int size, int index);

    int numberOfGlobalParameterColumn();


    @CacheEvict(cacheNames = "systemPictureManagementFindForPage",allEntries=true)
    void addSystemPictureManagement(/*int totalPage, */SystemPictureManagementEntity systemPictureManagementEntity);

    @CacheEvict(cacheNames = "systemPictureManagementFindForPage",allEntries=true)
    void updateSystemPictureManagement(SystemPictureManagementEntity systemPictureManagementEntity);

    @Cacheable(cacheNames = "systemPictureManagementFindForPage",key = "#key +'_'+ #size")
    List<SystemPictureManagementEntity > findSystemPictureManagementForPage(int key,int size, int index);

    int numberOfSystemPictureManagementColumn();

}
