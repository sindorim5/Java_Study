document.addEventListener("DOMContentLoaded", function () {
  sendRequest2("programming.jsp", null, "GET", getXML, error, "xml");

  sendRequest2("essayjson.jsp", null, "GET", getJSON, error, "json");

});

function getXML(data) {
  let prg = document.getElementsByClassName("programming");
  let books = data.getElementsByTagName("book");
  
  for(i = 0 ; i < books.length ; i++){
    let book = [];
    book[0] = books[i].getElementsByTagName("title")[0].childNodes[0].nodeValue;
    book[1] = books[i].getElementsByTagName("price")[0].childNodes[0].nodeValue;

    prg[i].innerHTML = book[0] +  "<br />(" + book[1]+"원)";
  }
}

function getJSON(data) {
  let books = JSON.parse(data);

  for (i = 0; i < books.length; i++) {
    let book = [];
    book[0] = books[i].title;
    book[1] = books[i].price;
    
    let essay = document.getElementsByClassName("essay");
    essay[i].innerHTML = book[0] + "<br />(" + book[1]+"원)";
  }
}

function error(status, msg) {
  console.log("상태값:" + status + " http에러메시지 :" + msg);
}
