# EL 屬性物件與對應的識別字串

- `pageContext`
  - 特殊的屬性物件(的識別字串)，透過它 可以取出容器內，符合 JavaBean 性質命名的資訊。
  - `pageContext.request.contextPath`
  - `pageContext.servletContext.contextPath`
- `pageScope`
- `requestScope`
- `sessionScope`
- `applicationScope`
- `param`
  - 對應一個 Map 物件, 內含請求參數與對應的參數值
- `paramValues`
  - 對應一個 Map 物件, 內含請求參數與對應的參數值 (字串陣列)
- `header`
- `headerValues`
- `cookie`

# 標準動作(Standard Action)

## <jsp:useBean>

- <jsp:useBean : 標準動作的標籤名稱，表示要使用一個 Bean 物件

- id="person" : bean 物件的名稱(即識別字串)，此名稱對應到 Servlet 程式中的 request.setAttribute("person", p); 內的 person。

- class="foo.Person" 宣告 bean 物件的型別名稱，必須是 Fully-Qualified Class Name 完全合格名稱(註:就是含套件的類別名稱啦)

- scope="request" : 說明 bean 物件放置在哪一個範圍內(有四種可能的範圍 page, request, session, application，預設為 page)。

## <jsp:getProperty>

- `<jsp:getProperty name="person" property="address" />`
- <jsp:getProperty:標準動作的標籤名稱，表示要取出 Bean 物件的 某個性質的內含值，取出的值會放在網頁上本標籤的所在位置
- name="person":指定 bean 物件的名稱，此名稱對應到 <jsp:useBean 中的 id 值
- property="address":要取出 bean 物件之性質的名稱
- 對應的 EL: **${person.address}**
  **address 會自動對應到 foo.Person 的 getAddress()方法**
  ![](https://i.imgur.com/Pw04QyO.png)
