package cn.dhu.service;

import cn.dhu.bean.Clothes;
import cn.dhu.utils.BusinessException;

import java.util.List;

public interface ClothesService {
    public List<Clothes> list()throws BusinessException;
}
