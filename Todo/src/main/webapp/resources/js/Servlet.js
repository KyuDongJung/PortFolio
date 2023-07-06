console.log("servlet js loaded")

// const inputBtn1 = document.getElementById("inputBtn");
// const input1 = document.getElementById("input");
inputBtn.addEventListener("click", function(){
    if(inputText.value.length > 0){
        
        $.ajax({
            url: "addList",
            data: {"input" : inputText.value},
            success : function(result){
                console.log("리스트 저장 성공");
                console.log(result);
            },

            error: function(){
                console.log("리스트 저장 실패");
                console.log("상태 : " + request.status);
            }
        });

    }
});