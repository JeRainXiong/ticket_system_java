 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="common/head.jsp" %>
    <script src="/js/html2canvas.min.js"></script>
    <script src="/js/jquery.qrcode.min.js"></script>
    <style type="text/css">
    div{
        width: 100%;
        height: 500px;
        text-align:left;    
    }
  .showticket{
    width:1000px;
    height: 300px;
    margin:auto;
    padding: 20px ;
    text-align:center;
  }
  .ticket_right{
    width:256px;
    float: left;
   
  }
    .ticket_mid{
        width:550px;
        float: left;
       
  }
    .ticket_left{
        width:175px;
        height: 256px;
    float: left;
  }
    .order_detailinfo_color {
	    color: #202020;
	    font-size: 30px;
	    margin: 10px 0px;
	    line-height:140%;
	    
	}
    .order_detailinfo_fontSize{
	    font-size: 24px;
	    margin: 8px 0px;
	   
	}
	.high{
	    margin: 8px 0px;
        padding: 5px 0px
	}
  
</style>
</head>

<body>
    <div>
        <div class='showticket' id = 'capture'>
            <div class = "ticket_left">
                <img src="${concert.concertImg }" alt="票" width="170px" height="256px">
            </div>  
            <div class = "ticket_mid">
                <ul class="order_show_info">
                <li class="high" style="padding:0px"><span class="order_detailinfo_color">演唱会：${ticket.concertName}</span></li>

                <li class="high"><span class="order_detailinfo_fontSize">时间：${ticket.concertTime}</span></li>
                <li class="high"><span class="order_detailinfo_fontSize">场馆：${ticket.concertAddr}</span></li>
                <li class="high"><span class="order_detailinfo_fontSize">座位:第${seatStatic.row }排 第${seatStatic.column }号 </span></li>
                <li class="high"><span class="order_detailinfo_fontSize">入口：${seatStatic.entrance }</span></li>
                </ul>
            </div>                      
            <div id = "qrimg" class = "ticket_right">
            
            </div>
        </div>
        <a id='print' class="btn" href="javascript:;">打印电子票</a>
    </div>
 <div id = "qrString" style="display: none">
      ${qrString}
  </div>      
    
</body>
<script type="text/javascript">
 $(function() {
     $("#print").click(function() {
         html2canvas(document.querySelector("#capture")).then(canvas => {
             // document.body.appendChild(canvas)
             //var imgUri = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream"); // 获取生成的图片的url  
             let imgUri = canvas.toDataURL("image/png");
             saveFile('电子票.png', imgUri);
             //window.open(imgUri); // 下载图片  
         });
     });

     function saveFile(filename, data) {
         var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
         save_link.href = data;
         save_link.download = filename;

         var event = document.createEvent('MouseEvents');
         event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0 );
         save_link.dispatchEvent(event);
     };
     $('#qrimg').qrcode($("#qrString").text()); 

 });
</script>
</html>