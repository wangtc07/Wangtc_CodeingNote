##### select option for each

```html
<div>
    <label for="coachId" th:text="#{team.coach}"></label>
    <div>
        <select th:field="*{coachId}">
            <option th:each="user : ${users}"
                    th:text="${user.name}"
                    th:value="${user.id}">
        </select>
    </div>
</div>
```

##### list table

[ThymeleafでList型のオブジェクトを受け渡すサンプルコード](https://learning-collection.com/springboot-thymeleaf%E3%81%A7list%E5%9E%8B%E3%81%AE%E3%82%AA%E3%83%96%E3%82%B8%E3%82%A7%E3%82%AF%E3%83%88%E3%82%92%E5%8F%97%E3%81%91%E6%B8%A1%E3%81%99%E3%82%B5%E3%83%B3%E3%83%97%E3%83%AB%E3%82%B3/)

[Binding a List in Thymeleaf | Baeldung](https://www.baeldung.com/thymeleaf-list)

```html
<form th:action="@{/update}" th:object="${customerListDto}" method="post">
  <table>
    <tr>
      <td>
        ID
      </td>
      <td>
        名前
      </td>
      <td>
        作成日
      </td>
    </tr>
    <!--* 「${customerListFormDto}」の「*{customers}」の要素数ぶん、繰り返す *-->
    <tr th:each="customer, st : *{customers}">
      <td>
        <!--* 「th:each」のステータス変数「${st.index}」で0から順に「customerListFormDto」の値を取得 プリプロセッシングで事前評価  *-->
        <input type="text" 
               th:name="${st.count}" 
               th:field="*{customers[__${st.index}__].id}">
      </td>
      <td>
        <input type="text" 
               th:name="${st.count}" 
               th:field="*{customers[__${st.index}__].name}">
      </td>
      <td>
        <input type="text" 
               th:name="${st.count}" 
               th:field="*{customers[__${st.index}__].createDay}">
      </td>
    </tr>
  </table>
  <input type="submit" value="更新">
</form>
```

##### form input 帶參數

```html
<form
      th:action="@{/user/modify(id=@{session.user.getUid()})}"
      method="get"
      >
  <input type="submit" class="modify" value="更新" />
</form>
```

##### input disable 沒被帶入 後端取不到值

`disable` 改為 `readonly`



