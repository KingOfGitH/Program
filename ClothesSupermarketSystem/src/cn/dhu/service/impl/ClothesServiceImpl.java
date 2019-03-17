package cn.dhu.service.impl;

import cn.dhu.bean.Clothes;
import cn.dhu.service.ClothesService;
import cn.dhu.utils.BusinessException;
import cn.dhu.utils.ClothesIO;


import java.util.List;

public class ClothesServiceImpl implements ClothesService {

    private ClothesIO clothesIO=new ClothesIO();
    @Override
    public List<Clothes> list() throws BusinessException {
        return clothesIO.list();
    }

    @Override
    public Clothes findClothesById(String  cid) throws BusinessException {
        return clothesIO.findClothesById(cid);
    }

    @Override
    public void update() throws BusinessException {
        clothesIO.update();
    }
}
