package com.ff.service.confessionViewWall.confessionViewWallImpl;

import com.ff.entity.ConfessionViewWallEntity;
import com.ff.repository.innerFeeling.ConfessionViewWallDao;
import com.ff.service.confessionViewWall.ConfessionViewWallService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ConfessionViewWallServiceImpl
 * @Description TODO
 * @Author ff
 * @Date 2020/2/17 13:13
 * @ModifyDate 2020/2/17 13:13
 * @Version 1.0
 */

@Service
public class ConfessionViewWallServiceImpl implements ConfessionViewWallService {

    @Resource
    private ConfessionViewWallDao confessionViewWallDao;


    @Override
    public Boolean insertOne(Integer totalPage,ConfessionViewWallEntity confessionViewWallEntity) {

        Boolean flage=true;
        try {
            confessionViewWallDao.insertOne(confessionViewWallEntity);
        }catch (Exception e){
            flage=false;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }finally {
            return flage;
        }

    }

    @Override
    public Boolean deleteOneEarliest() {

        Boolean flage=true;
        try {
            confessionViewWallDao.deleteOneEarliest();
        }catch (Exception e){
            flage=false;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }finally {
            return flage;
        }
    }

    @Override
    public List<ConfessionViewWallEntity> findForPage(Integer index,Integer size) {
        return confessionViewWallDao.findForPage(index,size);
    }

    @Override
    public Integer countAll() {
        return confessionViewWallDao.countAll();
    }
}
