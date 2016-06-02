/**
 * 
 */

$(document).ready(function(){
	$('.loader-inner').loaders();
	$('.loader-inner').hide();
	//ratringStar
	$(function() {
		$('select[name=ratingStar]').barrating({
			theme: 'fontawesome-stars',
			readonly: true,
			showSelectedRating: true
		});
	});
	
	$("#productSearch").on("click", function(){
		ajaxSearch(1);
	});
	
	$("#prevButton").click(function(){
		var page = Number($("#currentPage").val());
		
		if(page < 2){
			return false;
		}
		ajaxSearch(page-1);
	});
	
	$(document).on("click", ".pageButton", function(){
		var page = Number($(this).find(":hidden").val());
		ajaxSearch(page);
	});
	
	$("#nextButton").click(function(){
		
		var page = Number($("#currentPage").val());
		
		ajaxSearch(page+1);
	});
	
	$(document).on("mouseenter", ".mainInfo", function(){
		$(this).addClass("emphasis");
	});
	
	$(document).on("mouseleave", ".mainInfo", function(){
		$(this).removeClass("emphasis");
	});
});

function ajaxSearch(page){
	
	$('.loader-inner').show();
	
	$.ajax({
		type: 'post',
		url: $("#contextPath").val() + 'productSearch',
		data: { 'keyword' : $("input[name=keyword]").val(), 
				'page' : page
		},
		success: function(data){
			$("#productListArea ul").remove();
			$("#pageValue").remove();
			$("#productListArea").append(data);
		},
		complete: function(){
			$('.loader-inner').hide();
			
			$(".productInfo").each(function(){
//				var index = $(this).attr("data-value");
//				switch(index % 4){
//				case 0:
//					$(this).addClass("panelBlue");
//					break;
//				case 1:
//					$(this).addClass("panelGreen");
//					break;
//				case 2:
//					$(this).addClass("panelYellow");
//					break;
//				case 3:
//					$(this).addClass("panelRed");
//					break;
//				default:
//					$(this).addClass("panelBlue");
//				break;
//				}
				
				$(this).fadeIn("slow");
				
				//ratringStar
				$(function() {
						$('select[name=ratingStar]').barrating({
							theme: 'fontawesome-stars',
							readonly: true,
							showSelectedRating: true
						});
				 });
			});
			setPagenation();
		},
		error: function(err){
			alert("検索条件を確認して下さい");
		}
	});
}

function enterSearch(code){
	//エンターキー押下なら
	if(13 === code){
		$("#productSearch").trigger("click");
	}
}


function setPagenation(){
	var currentPage = Number($("#currentPage").val());
	var pageCount = Number($("#pageCount").val());
	
	$(".pagerArea").show();

	$(".pageCount").text("page " + currentPage + " of " + pageCount);
	
	if($("#currentPage").val() == 1){
		$("#prevButton").addClass("uiDisable");
	}
	
	if(currentPage == pageCount){
		$("#nextButton").addClass("uiDisable");
	}
	
	var $pageButtonArea = $(".pageButtonArea").empty();
	var li = "";
	
	for(var i = 1; i < pageCount + 1; i++){
		
		if(currentPage <= 10){
			if(i < 21){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}else if(i == 21){
				li = "<li class='ellipsis'>…</li>";
			}else{
				if(i == pageCount){
					li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
				}
			}
		}else if(currentPage > 10 && currentPage < pageCount - 9){
			if(i == 1){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}else if(i == 2){
				li = "<li class='ellipsis'>…</li>";
			}else if(i > currentPage-9 && i < currentPage+10){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}else if(i == pageCount-1){
				li = "<li class='ellipsis'>…</li>";
			}else{
				if(i == pageCount){
					li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
				}
			}
		}else{
			if(i == 1){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}else if(i == 2){
				li = "<li class='ellipsis'>…</li>";
			}else if(i > currentPage -(20-(pageCount - currentPage))){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}
		}
		
		$pageButtonArea.append(li);
		
		if(i == currentPage){
			$pageButtonArea.find("li:last-child").addClass("uiActive");
		}
		
		li="";
	}
}

