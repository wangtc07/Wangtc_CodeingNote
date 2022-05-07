package com.fubon.rpms.dao.repo;

import com.fubon.rpms.domain.substantive_interested_party.model.SearchCurSipBean;
import com.fubon.rpms.entity.CurSip;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CurSipRepo extends JpaRepository<CurSip, Integer> {

  @Query(
      value =
          "SELECT DISTINCT  cs.SIP_ID as 'sipId' , cs.APPLY_NO as 'applyNo' , "
              + "(SELECT cf.FHC_NAME_SHORT from CFG_FHC cf WHERE cf.FHC_ID = cs.ANNO_FHC) as 'fhcNameShort' , "
              + "(SELECT cf.FHC_NAME_SHORT_ENG from CFG_FHC cf WHERE cf.FHC_ID = cs.ANNO_FHC) as 'fhcNameShortEng' , "
              + "cs.CERT_ID as 'certId' , cs.SIP_NAME as 'name' , cs.SIP_NAME_ENG as 'nameEng' , cs.SIP_RULES as 'sipRules' , cs.CONTROL_FHCS as 'controlFhcs' , cs.TRADE_TYPES as 'tradeTypes', cs.SIP_DESC as 'sipDesc', cs.EFF_DATE as 'effDate' "
              + "FROM CUR_SIP cs "
              + "cross apply openjson(CONTROL_FHCS, '$.controlFhcs') with (cf int '$.val') "
              + "cross apply openjson(trade_types, '$.tradeTypes') with ( tt int '$.val') "
              + "cross apply openjson(sip_rules, '$.sipRules') with ( sr int '$.val') "
              + "WHERE (( :#{#bean.hasControlFhcs} = '' and  1 = 1 ) or ( :#{#bean.hasControlFhcs} != '' and cf in :#{#bean.controlFhcs} )) " // 受控公司
              + "AND (( :#{#bean.hasTradeTypes} = '' and  1 = 1 ) or ( :#{#bean.hasTradeTypes} != '' and tt in :#{#bean.tradeTypes} )) " // 控管交易別
              + "AND (( :#{#bean.hasSipRule} = '' and  1 = 1 ) or ( :#{#bean.hasSipRule} != '' and sr in :#{#bean.sipRules} )) " // 判定依據
              + "AND (( :#{#bean.hasAnnoFhc} = '' and  1 = 1 ) or ( :#{#bean.hasAnnoFhc} != '' and cs.ANNO_FHC = :#{#bean.annoFhc} ))  "
              + "AND (( :#{#bean.hasAnnoDept} = '' and  1 = 1 ) or ( :#{#bean.hasAnnoDept} != '' and cs.ANNO_DEPT = :#{#bean.annoDept} )) "
              + "AND (( :#{#bean.hasAannoEmp} = '' and  1 = 1 ) or ( :#{#bean.hasAannoEmp} != '' and cs.ANNO_EMP = :#{#bean.annoEmp} )) "
              + "AND (( :#{#bean.personType} = '' and  1 = 1 ) or ( :#{#bean.personType} != '' and cs.PERSON_TYPE = :#{#bean.personType} )) "
              + "AND (( :#{#bean.certId} = '' and  1 = 1 ) or ( :#{#bean.certId} != '' and cs.CERT_ID LIKE :#{#bean.certId} )) "
              + "AND (( :#{#bean.name} = '' and  1 = 1 ) or ( :#{#bean.name} != '' and cs.SIP_NAME LIKE :#{#bean.name} or cs.SIP_NAME_ENG LIKE :#{#bean.name})) "
              + "AND cs.EFF_DATE BETWEEN :#{#bean.startDay} and :#{#bean.endDay} "
              + "ORDER BY cs.EFF_DATE DESC ",
      nativeQuery = true)
  List<Map<String, Object>> searchCurSipList(@Param("bean") SearchCurSipBean bean);
}
