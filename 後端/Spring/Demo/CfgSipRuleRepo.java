package com.fubon.rpms.dao.repo;

import com.fubon.rpms.domain.rule_mgmt.model.SearchCfgSipRoleSelectBean;
import com.fubon.rpms.entity.CfgSipRule;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CfgSipRuleRepo extends JpaRepository<CfgSipRule, Integer> {

  @Query(
      value =
          "SELECT DISTINCT SIP_RULE_ID, APPLY_NO, DATA_ID, PERSON_TYPE, TRADE_TYPE_JSON, NAME, TEXT, NAME_ENG, TEXT_ENG, STATUS, EFF_DATE, EXPY_DATE, TRACE_ID, UPDATE_TIME, UPDATE_USER "
              + "from CFG_SIP_RULE csr "
              + "cross apply openjson(TRADE_TYPE_JSON, '$.tradeTypes') with (ts int '$.val') "
              + "WHERE (( :#{#bean.hasTradeTypes} = '' and  1 = 1 ) or ( :#{#bean.hasTradeTypes} != '' and ts in :#{#bean.tradeTypes} )) "
              + "AND STATUS = :#{#bean.status} AND PERSON_TYPE = :#{#bean.personType} ",
      nativeQuery = true)
  List<CfgSipRule> searchCfgSipRoleSelect(@Param("bean") SearchCfgSipRoleSelectBean bean);
}
