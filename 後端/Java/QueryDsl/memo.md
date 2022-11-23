查詢 dao

```java
factory
    .select(Projections.constructor(SipApplyConfirmDto.class, qCurApply, qCurSip))
    .from(qCurSip)
    .fetch();
```

子查詢

```java
 JPAExpressions.select(qCfgFhc.fhcNameShort)
                    .from(qCfgFhc)
                    .where(qCfgFhc.id.eq(qCurSip.annoFhc))
```

