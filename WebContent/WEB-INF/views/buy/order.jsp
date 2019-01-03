 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="../common/head.jsp" %>
</head>
<body>
 <%@ include file="../common/nav.jsp" %>
 
 

<div style=" min-height:600px; background: #fff;box-shadow: 0 0 6px 0 rgba(0,0,0,0.04);">
  <div class="comfirm w clearfix">
    <div class="w315 fr comfirm-aside">
      <div class="comfirm-aside-inner">
        <div id="comfirm-show-container" concert_id = '${concert.concertId}' ticket_type_id = '${ticketTypeId}'>
    <div class="ticket-main">
        <a href="/content?concertId=${concert.concertId}" target="_blank"><img src="${concert.concertImg}" alt="${concert.concertName}" width="85" height="109"></a>
        <div class="ticket-show-desc">
            <span style="color: #323232;">${concert.concertName}</span>
            
            <br><br><span style="color: #A5A4A5;">本票品由票务销售提供</span>
            
        <div class="certi_icon_box"><div class="ok_icon">&nbsp;</div><i></i> <div class="text" id="show-certificate">资质认证</div></div></div>
    </div>
    <div class="ticket-show-detail" style="position:relative;">
        <div>票面：<span>${ticketMoney} 元</span></div>
        <div>地点：<span>${concert.concertAddr}</span></div>
        <div>时间：<span>${concert.concertTime}</span></div>
        <div>数量：<span>1&nbsp;&nbsp;张</span></div>
        <div class="ticket-circle-left"></div>
        <div class="ticket-circle-right"></div>
    </div>
</div>
        <div class="ticket-price-detail">
          <div id="comfirm-moneyList-container" style="padding-bottom:10px;border-bottom: 1px dashed #eee;">

    
    <div>订单总额：<span class="money-item">${totalMoney} 元</span></div>
    <!--<div>保障费开关<span class="money-item">开</span></div>-->
</div>
          <div id="comfirm-moneyTotal-container" style="padding-top:10px">
 <div>实付款：<span class="total-money">${totalMoney} 元</span></div>
</div>
        </div>
      </div>
    </div>
    <div class="w820 fl" style="margin-bottom: 20px;">
      <div class="box-container">
        <div class="box-item">
          <ul id="comfirm-qpfs-container" class="box-item-body qpfs">
    <li class="active " data-disabled="false" data-model="express"><i class="icon-c  icon-c-express-active"></i>&nbsp;&nbsp;电子票</li>
<!--     <li class=" disabled" data-disabled="true" data-model="venue"><i class="icon-c  icon-c-venue"></i>&nbsp;&nbsp;现场取票</li>
<li class=" " data-disabled="false" data-model="onsite"><i class="icon-c  icon-c-onsite"></i>&nbsp;&nbsp;上门自取</li> -->
</ul>
        </div>
        <div id="comfirm-qpfsList-container">   

   
    <div id="onsite" class="taketicket dom_show">
        <div class="box-item clearfix">
            <ul class="box-item-left">
                取票人：<input class="shipment-name placeholder" type="text" placeholder="姓名" name="confirm.shipment.name">
            </ul>
            <ul class="box-item-right">
                手  机：&nbsp;&nbsp;<input class="shipment-telphone placeholder" type="text" placeholder="联系方式" name="confirm.shipment.telphone">
            </ul>
            <ul class="box-item-right">
                身份证：<input class="shipment-idCardNum placeholder" type="text" placeholder="演出需凭身份证购买" name="confirm.idCardNum">
            </ul>
<!--             <ul class="box-item-right">
      <form id='form_upload'>照  片：&nbsp;&nbsp;<input id="photoPath" type="file"  name="confirm.photo"  accept="image/png, image/jpeg, image/jpg"><a class="order_btn_detail" id="js_uploadPhoto" style="display: inline">上传</a></form>
  </ul>   
             
      <div style="position: absolute;right:0;top:0"><img id='show_photo' src=" ${userInfo.photoPath}" width="210px" height = "290px"></div>  
      <div><input value="${userInfo.photoPath}" id="photo_url" style="display:none;"></div> -->  
            
    
        </div>       
        <div id="comfirm-qpfsListOnsite-container" class="box-item mt-20">

</div>
    </div>
</div>
        <div id="comfirm-coupons-container" style="padding-left:57px;">
    
    

    
</div>
        
        <div id="comfirm-comments-container">
    
</div>

        <div id="comfirm-comments-agreement" style="text-align:left;padding-left:58px;position:relative;">
            <div style="position:absolute;top:49px;"><span id="agree_check"><i class="icon icon-checkbox-checked"></i></span><span style="padding-left:5px;" id="user_orderAgreement_link">我同意《<a style="text-decoration:underline">第三方商品平台交易服务协议</a>》</span></div>
        </div>
        <div class="box-item">
          <ul class="toPay">
            <li id="comfirm-moneyTotal-buy"> <a class="">小计:<span class="ml-10">${totalMoney} 元</span>  去结算</a></li>
          </ul>
          
        </div>

      </div>      
    </div>

    <!-- <div class="w820 fl" style="margin-top:20px;"> -->

    </div>
 
  </div>
</div>
 <%@ include file="../common/login.jsp" %>
<script>

    $('.navbar-list').css('display','none');
</script>

<script type="text/javascript" src="js/common/page.js"></script>
</body>
</html>
