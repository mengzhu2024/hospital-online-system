package com.wk.hc.common.mapper;

import com.wk.hc.common.entity.Medicine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wk.hc.common.vo.EditMedicineVO;
import com.wk.hc.common.vo.IndexMedicineVO;
import com.wk.hc.common.vo.MedicineVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 */
public interface MedicineMapper extends BaseMapper<Medicine> {
    List<MedicineVO> list(@Param("name") String name, @Param("status") String status);

    void doDelete(String[] split);

    @Select("SELECT medicine.*,category.parent_id topCategory FROM `medicine`\n" +
            "INNER JOIN category ON medicine.category_id = category.id\n" +
            "where medicine.id = #{id}")
    EditMedicineVO doGetInfoById(Integer id);

    @Select("select medicine.*,category.name category from medicine inner join category on medicine.category_id = category.id ")
    List<IndexMedicineVO> selectAll();

    void updateStatus(@Param("status") String status, @Param("ids") String[] split);

    @Select("select * from medicine where instr(name,#{name})>0 and status = '1'")
    List<Medicine> listByName(String name);
}
