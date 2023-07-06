function currentTime(){
    const now = new Date();

    let year = now.getFullYear();
    let month = (now.getMonth()+1);
    let date = now.getDate();
    let weekArr = ['일', '월', '화', '수', '목', '금', '토'];
    let day = now.getDay();
    return year + " / " + month + " / " + date + " / " + weekArr[day] + "요일";
}
const watch = document.getElementById("watch");
watch.innerHTML = currentTime();
//-------------------시계-----------------------------------

function time(){
    const now = new Date();

    let month=(now.getMonth()+1);
    let date = now.getDate();
    return month + "월 " + date + "일 ";
}
//------------------월 / 일 ---------------------------------
const inputBtn = document.getElementById("inputBtn"); // 리스트 추가버튼
const inputText = document.getElementById("input");// 입력 창
const todolist = document.getElementById("todolist");
const lists = todolist.childNodes;
const checkedlist = todolist.childNodes.checked
const allcheck = document.getElementById("complete-all-btn");

console.log(checkedlist)
function list(){
    console.log("리스트 불러오기 실행.");
    
    $.ajax({
        url: "selectAll",
        dataType: "JSON",

        success: function(todoList){
            console.log(todoList)
            
            todolist.innerHTML="";

            $(todoList).each(function(){
                console.log(this);
                
                if(this != null){
                    const list = document.createElement('li');
                    list.classList.add("licontainer");

                    const checkbox = document.createElement('input');
                    checkbox.classList.add("checkbox");
                    checkbox.setAttribute("type", "checkbox");

                    const span = document.createElement("span");
                    span.classList.add("lispan");
                    
                    const span2 = document.createElement("span");
                    span2.innerText = this.listDate;

                    const button = document.createElement("button");
                    button.classList.add("delBtn");
                    button.classList.add("fa-solid");
                    button.classList.add("fa-trash");

                    span.innerText = this.listTitle
                    list.append(checkbox, span, span2, button);
                    todolist.append(list);

                    
                   
                    if(this.complete == 'Y '){
                        console.log("체크박스 true");
                        checkbox.checked = true;
                        span.style.textDecoration = "line-through";
                        span.style.color = "gray";
                        
                    }
                    
                    allcheck.addEventListener("click", function(){
                        if((todolist.innerText != null) && checkbox.checked==false){
                            checkbox.checked = true;
                                if(checkbox.checked)
                                span.style.textDecoration="line-through";
                                span.style.color="darkgray";
                                $.ajax({
                                        url: "checked",
                                        data: {"span" : span.innerText},

                                        success : function(){
                                        console.log("complete Y")
                                        },
                                        error : function(){
                                        console.log("체크 저장 실패");
                                        }
                                })
                                updateTodoCount();
                            }else{
                                if((todolist.innerText != null) && checkbox.checked){
                                    checkbox.checked = false;
                                    span.style.textDecoration="none";
                                    span.style.color="black";
                                    updateTodoCount();
                                    $.ajax({
                                        url: "checked2",
                                        data: {"span" : span.innerText},
        
                                        success :function(){
                                            console.log("complete N")
                                        },
                                        error : function(){
                                            console.log("체크 저장 실패")
                                        }
                                    })
                                }
                            }

                        
                    });

                    
                    // $.ajax({
                    //     url: "selectComplete",
                    //     data : {"span" : span.innerText},
                    //     success : function(result){
                    //         console.log(result);
                    //         if(result == 'Y'){
                    //         checkbox.checked = true;
                    //         checkbox.classList.add();
                    //         } else{
                    //             checkbox.checked = false;
                    //             span.style.textDecoration="none";
                    //             span.style.color="black";
                    //         }
                    //     },
                    //     error(){
                    //         console.log("체크 불러오기 실패");
                    //     }
                    // })

                    updateTodoCount();

                    


                    button.addEventListener("click", function(){
                        $.ajax({
                            url: "delete",
                            data: {"listTitle" : span.innerText},

                            success : function(result){
                                console.log("삭제 성공");
                                console.log(result);
                                updateTodoCount();
                            },
                            error : function(){
                                console.log("삭제실패");
                            }
                        });
                        this.parentElement.remove();
                        if(checkbox.checked){
                            console.log("체크 안함");
                        }else{
                           
                        }
                    })
                    checkbox.addEventListener("click", function check(){
                        if(checkbox.checked){
                            span.style.textDecoration="line-through";
                            span.style.color="darkgray";
                            updateTodoCount();

                            $.ajax({
                                url: "checked",
                                data: {"span" : span.innerText},

                                success : function(){
                                    console.log("complete Y")
                                },
                                error : function(){
                                    console.log("체크 저장 실패");
                                }
                            })
                        }else{
                            span.style.textDecoration="none";
                            span.style.color="black";
                            updateTodoCount();
                            $.ajax({
                                url: "checked2",
                                data: {"span" : span.innerText},

                                success :function(){
                                    console.log("complete N")
                                },
                                error : function(){
                                    console.log("체크 저장 실패")
                                }
                            })
                        }
                    })

                }else{
                    console.log("리스트 null");
                }
               
            })

        },
        error: function(request){
            console.log("AJAX 에러 발생")
            console.log("상태 코드 : " + request.status);
        }
    })
}
window.onload = list;
if(todolist.innerText == null){
    list();
}
//-------------------------------------------------------------------리스트 가져오기 펑션(ajax)


function updateTodoCount(){
    const todoCountElement = document.getElementById("left-items");
    const uncheckedLists = [...lists].filter(node => node.nodeName === "LI" && !node.querySelector(".checkbox").checked);
    todoCountElement.innerHTML = "남은 할일 " + uncheckedLists.length + "개";
}


inputBtn.addEventListener("click", function(){
    if(!inputText.value){
        alert("오늘의 할 일을 입력해주세요.");
        inputText.focus();

    } else{

            if(inputText.value.length > 0){
            $.ajax({
            url: "addList",
            data: {"listTitle" : inputText.value},
            
            success : function(result){
                console.log("리스트 저장 성공");
                console.log(result);
                inputText.value="";
                inputText.focus();
                list();
                },
            error: function(){
                console.log("리스트 저장 실패");
                console.log("상태 : " + request.status);
                }
            });
            const checkedItems = todolist.querySelectorAll("input[type=checkbox]:checked");
            checkedItems.forEach(function(item){
            item.parentNode.remove();
            
        })

        }
    }
});


// 리스트 불러오는 함수

//---------
const all = document.getElementById("all");
const active = document.getElementById("active");
const complete = document.getElementById("complete");
const alldelete = document.getElementById("clear-completed-btn");
//----------------- bottom buttons -------------------------------
complete.addEventListener("click", function(){
            complete.classList.add("selected");
            all.classList.remove("selected");
            active.classList.remove("selected");
    const todoItems = todolist.querySelectorAll(".licontainer");
    todoItems.forEach(function(item){
        const checkbox = item.querySelector(".checkbox");
        if(checkbox.checked){
            item.style.display = "flex"
           
        }else{
            item.style.display = "none";
            
        }
    });
});

all.addEventListener("click", function(){
        all.classList.add("selected");
        complete.classList.remove("selected");
        active.classList.remove("selected");
    const todoItems = todolist.querySelectorAll(".licontainer");
    todoItems.forEach(function(item){
        item.style.display= "flex";
       
    });
});

active.addEventListener("click", function(){
            active.classList.add("selected");
            all.classList.remove("selected");
            complete.classList.remove("selected");
    const todoItems = todolist.querySelectorAll(".licontainer");
    todoItems.forEach(function(item){
        const checkbox = item.querySelector(".checkbox");
        if(!checkbox.checked){
            item.style.display = "flex";
            
        }else{
            item.style.display="none";
        }
    })
});
alldelete.addEventListener("click", function(){
    if(todolist.innerText == ""){
        alert("일정이 비어있습니다.")
    }else{
        $.ajax({
            url: "alldelete",

            success: function(result){
                console.log(result);
                
            },
            error : function(){
                console.log("완료된 목록 삭제 실패")
            }
        })
        list();
    }
})





