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
	
	$("#genreList li").mouseenter(function(){
		$("#parentsGenreName").val($(this).find("a.genre span").text());
		createCustomSelect($(this), "left");
	}).mouseleave(function(){
		$(".hyperSelect").remove();
	});
	
	$("#genreList_2 li").click(function(){
		event.stopPropagation();
		createCustomSelect($(this), "left");
	}).mouseleave(function(){
//		$(".hyperSelect").remove();
	});
	
	$(document).on("click", ".genreSelectList li.option", function(){
		$("#selectedGenreId").val($(this).attr("data-value"));
		$("#selectedGenreName").val($(this).text());

		ajaxSearch(1);
	});
	
	$(document).on("click", "#sel-config li.option", function(){
		var value = $(this).attr("data-value");
		if(value == 1){
			$(".genreArea").show();
			$(".genreArea_2").hide();
		}else{
			$(".genreArea").hide();
			$(".genreArea_2").show();
		}
	});
	
	$(document).on("click", "#sel-config2 li.option", function(){
		var value = $(this).attr("data-value");
		if(value == 1){
			$(".genreArea").show();
			$(".genreArea_2").hide();
		}else{
			$(".genreArea").hide();
			$(".genreArea_2").show();
		}
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
});

function ajaxSearch(page){
	
	$('.loader-inner').show();
	
	$.ajax({
		type: 'post',
		url: $("#contextPath").val() + 'productSearch',
		data: { 'keyword' : $("input[name=keyword]").val(), 
				'genreId' : $("#selectedGenreId").val(),
				'genreName' : $("#selectedGenreName").val(),
				'parentsGenreName' : $("#parentsGenreName").val(),
				'page' : page
		},
		success: function(data){
			$("#productListArea ul").remove();
			$("#pageValue").remove();
			$("#productListArea").prepend(data);
		},
		complete: function(){
			$('.loader-inner').hide();
			
			$(".productListArea").show();
			
			$(".productInfo").each(function(){
				
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
		
		if(currentPage <= 9){
			if(i < 18){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}else if(i == 18){
				li = "<li class='ellipsis'>…</li>";
			}else{
				if(i == pageCount){
					li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
				}
			}
		}else if(currentPage > 9 && currentPage < pageCount - 8){
			if(i == 1){
				li = "<li class='pageButton'><a href='javascript:void(0)'>" + i + "</a><input type='hidden' value='" + i + "'/></li>";
			}else if(i == 2){
				li = "<li class='ellipsis'>…</li>";
			}else if(i > currentPage-8 && i < currentPage+8){
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
			}else if(i > currentPage -(17-(pageCount - currentPage))){
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

function createCustomSelect($obj, type){
	
	$(".hyperSelect").remove();
	
	// ターゲットの位置座標を取得
	var position = $obj.position();
	// 作成するセレクトリストにつけるidを作成
	var id = "sel-" + $obj.attr("id");
	var className = $obj.find("select").attr("class");
	// 親オブジェクトを作成
	var $select = $("<div class='hyperSelect " + className + "' id='" + id + "'>");
	// リストを格納するオブジェクトを生成
	var $ul = $("<ul class='hyperSelectList'></ul>");
	
	// ターゲットのオプションからリストの各要素を作成し、ulにアペンド
	$obj.find("option").each(function(){
		var li = "<li class='option' data-value='" + $(this).val() + "'><a href='javascript:void(0);'>" + $(this).text() + "</a></li>";
		$ul.append(li);
	});
	
	// セレクトリストを出す位置により、座標・三角形の場所を決める
	if(type == "bottom"){
		var paddingBottom = Number($obj.css("padding-bottom").replace("px", ""));
		$select.append("<div class='triangleTop'></div>");
		$select.append($ul);
		$select.css({'top':position.top + $obj.height + 2 +paddingBottom + px, 'left' : position.left});
	}else{
		var paddingRight = Number($obj.css("padding-right").replace("px", ""));
		$select.append("<div class='triangleLeft'></div>");
		$select.append($ul);
		$select.css({'top': '5px', 'left' : position.left + $obj.width() + "px" });
	}
	
	$obj.append($select);
	
	// セレクトボックスを削除するイベントをバインドする
	$('div:not(.hyperSelect)').bind("click", function(){
		$(".hyperSelect").remove();
	});
}

