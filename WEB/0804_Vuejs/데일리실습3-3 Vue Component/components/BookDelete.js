export default {
    template: `
        <div>
            <h1>SSAFY 도서 삭제</h1>
            <div>삭제중...</div>
        </div>
            `
    ,
    created() {
        // url에서 파라미터정보 얻어서 삭제. 이후 list로 이동.
        const params = new URL(document.location).searchParams;
        localStorage.removeItem(params.get("isbn"));
        alert("삭제가 완료되었습니다.");
        // list.html 페이지로 이동.
        location.href = "./list.html";
      },
}

