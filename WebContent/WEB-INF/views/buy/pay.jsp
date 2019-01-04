 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ include file="../common/head.jsp" %>
</head>
<body>
 <%@ include file="../common/nav.jsp" %>




<div style="min-height: 600px;background-color: #F4F5F9 ;padding-top:30px">
  <div class="page_pay container">
    <div class="pay-order box">
      <div class="box-left fl">
        <div class="pic">
          <i class="icon icon-order-success"></i>
        </div>
      </div>
      <div class="box-main">
        <div class="box-main-top" id="pay-top-container">
    <div class="box-main-top-right fr">
        <p class="money">应付总金额：<span class="num">${order.amount}</span><span>元</span></p>
    </div>
    <div class="box-main-top-left ">
        <h3>订单提交成功！去付款咯~</h3>
        <p class="mt-30"><span>收货信息：</span><span class="mr-10">${order.realname}</span>
            <span class="mr-10">${order.tel}</span>&nbsp;
            <span class="mr-10"></span>
            <span class="mr-10"></span>
        </p>
    </div>
</div>
        <div class="box-main-bot" id="pay-middle-container">
    

    <div class="box-main-bot-left">
        <h3>订单详情</h3>
        <p class="box-content-text mt-10">订单号：<span>${order.orderId}</span></p>
        <p class="box-content-text">票品信息： <span>${ticketType.concertName}</span></p>
        <p class="box-content-text">演出场次：<span>${ticketType.concertTime}</span></p>
        <p class="box-content-text">票面价格：<span>${ticketType.unitPrice}</span></p>
        <p class="box-content-text">数量：<span>1</span>&nbsp;张</p>
    </div>
</div>
      </div>
    </div>

    <div class="pay-money">
      <div class="title">请选择支付方式</div>
      <div class="box-main">
        <ul class="clearfix">
          <li class="pay-money-img" id="js_zfblink"><a class="icon icon-pay-alibaba" target="_blank"  href="${pay_url} "></a></li>
        </ul>
      </div>
    </div>


 
  </div>
</div>

 <%@ include file="../common/login.jsp" %>
<script>

    $('.navbar-list').css('display','none');
</script>

<script type="text/javascript" src="js/common/page.js"></script>
  <body>
</body>
</html>
