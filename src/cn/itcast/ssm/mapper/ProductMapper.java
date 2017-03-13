package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Categorysecond;
import cn.itcast.ssm.po.Product;
import cn.itcast.ssm.po.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer pid);
    
    List<Product> selectHot(Integer hotNumber);
    
    List<Product> selectNew(Integer newNumber);
    
    List<Product> selectByCid(Integer cid);
    
    List<Product> selectByCsid(Integer csid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}