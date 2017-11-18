/**
 * Created by letrain on 2017/11/13.
 */
var fjSecond = 0;
var fjRandom = 0;

window.setInterval(function () {
    fjSecond ++;
},1000);
//随机数
fjRandom = (new Date()).valueOf();
//用户第一次访问页面记录部分数据
window.onload = function () {
  var fjArr = localStorage.getItem("jsArr") ? localStorage.getItem("jsArr"):'[]';
  var dataArr = {
      'fjRd' : fjRandom,
      'url' : location.href,
      'refer' : getReferrer()
  };
  fjArr = eval('('+fjArr +')');
  fjArr.push(dataArr);
  var fjArr1 = JSON.stringify(fjArr);
  localStorage.setItem("jsArr",fjArr1);
};

//用户继续访问根据上面提供的Key补充数据
window.onbeforeunload = function () {
    var fjArrRd = eval('('+localStorage.getItem("fjArr")+')');
    var fjI = fjArrRd.length -1;
    if(fjArrRd[fjI].fjRd == fjRandom){
        fjArrRd[fjI].time = fjSecond;
        fjArrRd[fjI].timeIn =Date.parse(new Date() -fjSecond*1000 );
        fjArrRd[fjI].timeOut = Date.parse(new Date());
        var fjArr1 = JSON.stringify(fjArrRd);
        localStorage.setItem("fjArr",fjArr1);
    }
}

function getReferrer() {
    var referrer = '';
    try {
        referrer = window.top.document.referrer;
    }catch (e){
        if(window.parent){
            try {
                referrer=window.parent.document.referrer;
            }catch (e2){
                referrer = '';
            }
        }
    }
    if(referrer = ''){
        referrer = document.referrer;
    }
    return referrer;
}

