//nav
var $show3 = $(".show-3");
var $navHold = $(".nav");
var $navInfo = $(".info-up")
$show3.hover(function() {
    $(".nav-3").hide();
    var $nextNav = $(this).children('ul');
    $nextNav.slideDown(150);
    var y = $(this).position().top;
    var x = $(this).position().left;
    $nextNav.css({ "top": y, "left": x + $(".nav").width() });
}, function() {
    $(".nav-3").stop();
    $(".nav-3").slideUp(100);
});
$navHold.hover(function() {
    $(this).children('ul').stop();
    $(this).children('ul').slideToggle(150);
});
$navHold.click(function() {
        var $that = $(this);
        $navInfo.each(function() {
            if ($(this).data('num') == $that.data('num')) {
                $(this).removeClass("hide");
                $(this).siblings(".info-up").addClass("hide")
            }
        })
    })
    //拖动条
function change() {
    var num = document.getElementById("range");
    setzhezhao(num.value / 100);
}

//显示框
var $stuffShow = $(".stuff-show");
var $stuffHide = $(".stuff-hide");
var stuffWidth = $stuffShow.width();

function stuffHide() {
    $stuffShow.animate({ right: -stuffWidth + 'px' }, 500)
}

function stuffShow() {
    $stuffShow.animate({ right: '0px' }, 500)
}
$stuffHide.click(function(argument) {
    if ($stuffShow.css('right') == "0px") {
        stuffHide();
    } else {
        stuffShow();
    }
});

$(".close-info").click(function() {
    $(".info").toggle(400);
});

$(".clo-charts").click(function() {
    if ($(this).parent().hasClass('chart-small')) {
        $(this).parent().removeClass('chart-small')
    } else {
        $(this).parent().addClass('chart-small')
    }

});

$(".close-chart").click(function() {
    $that = $(this);
    $(this).addClass("charted");
    $(this).siblings('.close-chart').removeClass('charted')
    $(".charts .chart").each(function() {
        if ($(this).data('num') == $that.data('num')) {
            $(this).removeClass('hide');
            $(this).siblings('.chart').addClass('hide');
        }
    })
})

var $range1 = $("#range-1");
var $startR = $("#start");
var start;
$startR.click(function() {

    var rangeNum = 0;
    $range1.val("0");
    clearInterval(start);
    start = setInterval(function() {
        if (rangeNum < 100) {
            rangeNum = $range1.val();
            rangeNum = Number(rangeNum) + 20;
            changrange(rangeNum / 20);
            $range1.val(rangeNum);
        } else {
            clearInterval(start);
            setTimeout(function() {
                otherlayer.clear();
            }, 1000);
        }
    }, 3000);
});

function showChange() {
    var num = document.getElementById("range-1");
    changrange(num.value / 20);
}
$(".out i").click(function(event) {
    $(this).parent().fadeOut('400');
});

//表情拖动
var $biaoqin = $(".biaoqin");

$biaoqin.mousedown(function(e) {
    var old_left = e.pageX; //鼠标相对于文档边缘的距离
    var old_top = e.pageY;
    var old_position_left = $(this).position().left; //此时的div位置
    var old_position_top = $(this).position().top;
    $(document).mousemove(function(e) {
        var new_left = e.pageX; //新的鼠标位置
        var new_top = e.pageY;
        var change_x = new_left - old_left; //偏移量
        var change_y = new_top - old_top;
        var new_position_left = old_position_left + change_x; //偏移位置
        var new_position_top = old_position_top + change_y;
        if (new_position_left < 0) new_position_left = 0;
        if (new_position_top < 0) new_position_top = 0;
        if (new_position_left > $(window).width() - $biaoqin.width()) {
            new_position_left = $(window).width() - $biaoqin.width();
        };
        if (new_position_top > $(window).height() - $biaoqin.height()) {
            new_position_top = $(window).height() - $biaoqin.height();
        };
        $biaoqin.css({
            left: new_position_left + 'px',
            top: new_position_top + 'px'
        })
    })
    return false;
})
$biaoqin.mouseup(function() {
    $(document).off("mousemove");
})
$(".jcxx #info").mousedown(function(event) {
    return false;
});
$(".clo-picture").click(function(event) {
    $(this).parent().hide();
});
$(".jcxx #pic").mousedown(function(event) {
    $(".picture").show();
    return false;
});
$(".clo-chart").on('click',function(){
    $(this).parent().hide();
});
