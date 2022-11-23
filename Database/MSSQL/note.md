format date
[Date and Time Conversions Using SQL Server](https://www.mssqltips.com/sqlservertip/1145/date-and-time-conversions-using-sql-server/)
```sql
select convert(varchar, getdate(), 23)
```

int to string varchar
```sql
select convert(varchar, 1)
```

sql replace 替換
```sql
SELECT REPLACE ('a', 'a', 'b')
-- b
```

datetime add one day
```sql
SELECT DATEADD(year, 1, '2017/08/25');
```

檢查是否是json字串
```sql
-- 不是 json 字串
SELECT [STR] FROM [TABLE] WHERE ISJSON(STR) = 0
```