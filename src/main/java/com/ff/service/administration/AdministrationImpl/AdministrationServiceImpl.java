package com.ff.service.administration.AdministrationImpl;

import com.ff.entity.GlobalParameterEntity;
import com.ff.entity.SystemPictureManagementEntity;
import com.ff.repository.globalParameter.GlobalParameterDao;
import com.ff.repository.systemPictureManagement.SystemPictureManagementDao;
import com.ff.service.administration.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName AdministrationServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/4/17 18:32
 * @ModifyDate 2020/4/17 18:32
 * @Version 1.0
 */

@Service
@Transactional
public class AdministrationServiceImpl implements AdministrationService {

    @Autowired
    private GlobalParameterDao globalParameterDao;

    @Autowired
    private SystemPictureManagementDao systemPictureManagementDao;



    /*========GlobalParameter系统参数管理========*/
    @Override
    public void addOneGlobalParameter(/*int totalPage,*/GlobalParameterEntity globalParameterEntity) {
        globalParameterDao.addOneGlobalParameter(globalParameterEntity);
    }

    @Override
    public void updateParameterByParamterName(GlobalParameterEntity globalParameterEntity) {
        globalParameterDao.updateParameterByParamterName(globalParameterEntity);
    }

    @Override
    public List<GlobalParameterEntity> findGlobalParameterForPage(int key,int size, int index) {
        return globalParameterDao.findForPage(size,index);
    }

    @Override
    public int numberOfGlobalParameterColumn() {
        return globalParameterDao.numberOfColumn();
    }


    /*========SystemPictureManagement系统图片管理========*/

    @Override
    public void addSystemPictureManagement(/*int totalPage,*/ SystemPictureManagementEntity systemPictureManagementEntity) {
        systemPictureManagementDao.addSystemPictureManagement(systemPictureManagementEntity);
    }

    @Override
    public void updateSystemPictureManagement(SystemPictureManagementEntity systemPictureManagementEntity) {
        systemPictureManagementDao.updateSystemPictureManagement(systemPictureManagementEntity);
    }

    @Override
    public List<SystemPictureManagementEntity> findSystemPictureManagementForPage(int key, int size, int index) {
        return systemPictureManagementDao.findSystemPictureManagementForPage(size,index);
    }

    @Override
    public int numberOfSystemPictureManagementColumn() {
        return systemPictureManagementDao.numberOfSystemPictureManagementColumn();
    }
}
