package cn.dhu.service.impl;

import cn.dhu.bean.Clothes;
import cn.dhu.service.ClothesService;
import cn.dhu.utils.BusinessException;
import cn.dhu.utils.ProductsXmlUtils;

import java.util.List;

public class CLothesServiceImpl implements ClothesService {
    @Override
    public List<Clothes> list() throws BusinessException {
        List<Clothes> clothes= ProductsXmlUtils.parserProductsXml();
        return clothes;
    }
}
