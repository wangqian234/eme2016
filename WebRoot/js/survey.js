//显示图片
function showDel(obj) {
	$(obj).find("img").css('visibility', 'visible');
}
// 隐藏图片
function hideDel(obj) {
	$(obj).find("img").css('visibility', 'hidden');
}
// 创建问题
function addQuestion(obj) {
	var qType = null;
	if (obj.id == 1) {
		qType = "radio";
	} else if (obj.id == 2) {
		qType = "checkbox";
	} else if (obj.id == 3) {
		qType = "textarea";
	} else if (obj.id == 4) {
		qType = "matrix";
	}
	var ques = document.getElementsByClassName("ques").length; // 已有多少个问题
	var quesNum = ques + 1; // 当前问题的序号
	if (obj.id == 1 || obj.id == 2) {
		// 创建问题和前两个选项
		var div1 = document.createElement("div");
		div1.setAttribute("class", "control-group");
		div1.innerHTML += "<div class='ques' id='ques"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)'><span id='Q"
				+ quesNum
				+ "'>Q"
				+ quesNum
				+ ":</span><input type='text' id='quesname"
				+ quesNum
				+ "' class='input-long question-style' placeholder='问卷题目'><image id='"
				+ quesNum
				+ "' class='small_img'  src='img/delquest.gif'  alt='删除' onclick='delQuestion(this)' ><input type='button' id='1'  class='btn' style='margin-left:5px' value='单选' onclick='insertQues(this)'/><input type='button' id='2'  class='btn' style='margin-left:2px' value='多选' onclick='insertQues(this)'/></div><div id='sel"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)' class='selector"
				+ quesNum
				+ " selector-style'><input type='"
				+ qType
				+ "'  name='S"
				+ quesNum
				+ "'><input type='text'  placeholder='选项'  class='ST"
				+ quesNum
				+ " left_distance'><image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addSelector(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "'  src='img/delsel.gif'  alt='删除' onclick='delSelector(this)' ></div><div onmouseover='showDel(this)' onmouseout='hideDel(this)' class='selector"
				+ quesNum
				+ " selector-style'><input type='"
				+ qType
				+ "'  name='S"
				+ quesNum
				+ "'><input type='text'  placeholder='选项'   class='ST"
				+ quesNum
				+ " left_distance'><image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addSelector(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "'  src='img/delsel.gif' alt='删除' onclick='delSelector(this)'></div></div><div><input type='hidden' id='AST"
				+ quesNum + "'><input type='hidden' id='QT" + quesNum
				+ "'></div></div>";
	}
	if (obj.id == 3) {
		var div1 = document.createElement("div");
		div1.setAttribute("class", "control-group");
		div1.innerHTML += "<div class='ques' id='ques"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)'><span id='Q"
				+ quesNum
				+ "'>Q"
				+ quesNum
				+ ":</span><input type='text' id='quesname"
				+ quesNum
				+ "' class='input-long question-style' placeholder='问卷题目'><image id='"
				+ quesNum
				+ "' class='small_img'  src='img/delquest.gif'  alt='删除' onclick='delQuestion(this)' ><input type='button' id='3'  class='btn' style='margin-left:5px' value='文字题' onclick='insertQues(this)'/></div><div id='sel"
				+ quesNum
				+ "'></div><div class='selector"
				+ quesNum
				+ " selector-style'><textarea  placeholder='请填写内容'  class='ST"
				+ quesNum
				+ " left_distance' style='width:72%;height:100px' readonly></textarea><input type='hidden' id='AST"
				+ quesNum + "'><input type='hidden' id='QT" + quesNum
				+ "'></div></div>";
	}
	if (obj.id == 4) {
		var div1 = document.createElement("div");
		div1.setAttribute("class", "control-group");
		div1.innerHTML += "<div class='ques' id='ques"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)'><span id='Q"
				+ quesNum
				+ "'>Q"
				+ quesNum
				+ ":</span><input type='text' id='quesname"
				+ quesNum
				+ "' class='input-long question-style' placeholder='问卷题目'><image id='"
				+ quesNum
				+ "' class='small_img'  src='img/delquest.gif'  alt='删除' onclick='delQuestion(this)' ><input type='button' id='4'  class='btn' style='margin-left:5px' value='表格题' onclick='insertQues(this)'/></div><div id='sel"
				+ quesNum
				+ "'></div><div class='selector"
				+ quesNum
				+ " selector-style' onmouseover='showDel(this)' onmouseout='hideDel(this)'><table class='table table-bordered wjTable' id='table"
				+ quesNum
				+ "'><tr><td style='width:100px'>请设计</td><td><input type='text' placeholder='选项' id='bl1' class='STC"
				+ quesNum
				+ "'/></td><td><input type='text' placeholder='选项' class='STC"
				+ quesNum
				+ "' id='bl2'/></td></tr><tr><td style='width:100px'><input type='text' placeholder='行项' class='STR"
				+ quesNum
				+ "' id='bh1'/></td><td><input type='radio' name='bh1'/></td><td><input type='radio' name='bh1'/></td></tr><tr><td style='width:100px'><input type='text' placeholder='行项' class='STR"
				+ quesNum
				+ "' id='bh2'/></td><td><input type='radio' name='bh2'/></td><td><input type='radio' name='bh2'/></td></tr></table>列：<image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addTableCol(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "' id='"
				+ quesNum
				+ "' src='img/delsel.gif' alt='删除' onclick='delTableCol(this)'>&nbsp;&nbsp;&nbsp;&nbsp;行：<image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addTableRow(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "' id='"
				+ quesNum
				+ "' src='img/delsel.gif' alt='删除' onclick='delTableRow(this)'><input type='hidden' id='AST"
				+ quesNum + "'><input type='hidden' id='QT" + quesNum
				+ "'></div></div>";
	}

	var section = document.createElement("section");
	section.appendChild(div1);
	var div = document.getElementById("div-content");
	div.appendChild(section);
	// 创建问题和前两个选项结束
	document.getElementById("QT" + quesNum + "").value = obj.id;// 1代表单选，2代表多选，3代表文本问题4表示表格
}

// 添加单个选项
function addSelector(obj) {
	// 添加选项
	var qType = null;
	if (obj.name == 1) {
		qType = "radio";
	} else if (obj.name == 2) {
		qType = "checkbox";
	}
	var div = document.getElementById("sel" + obj.id);
	var div1 = document.createElement("div");
	div1.setAttribute("class", "selector" + obj.id + " selector-style");
	div1.setAttribute("onmouseover", "showDel(this)");
	div1.setAttribute("onmouseout", "hideDel(this)");
	div1.innerHTML = "<input type='"
			+ qType
			+ "' name='S"
			+ obj.id
			+ "'><input type='text'  placeholder='选项'  class='ST"
			+ obj.id
			+ " left_distance'><image id='"
			+ obj.id
			+ "' name='"
			+ obj.name
			+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addSelector(this)' ><image class='image"
			+ obj.id + " small_img' name='image" + obj.id
			+ "'  src='img/delsel.gif' alt='删除' onclick='delSelector(this)'>";
	div.appendChild(div1);
}
// 删除单个选项
function delSelector(obj) {
	var selectors = document.getElementsByClassName("" + obj.name + "");
	if (selectors.length > 2) {
		$(obj).parent().remove();
	} else {
		alert("至少有两个选项！");
	}
}

function delQuestion(obj) {
	$(obj).parent().parent().parent().parent().remove();
	var ques = document.getElementsByClassName("ques").length; // 已有多少个问题
	for (var j = parseInt(obj.id); j <= ques; j++) {
		var k = j + 1;
		$("#ques" + k + "").find("#Q" + k + "").html("Q" + j + "");
		$("#ques" + k + "").find("#Q" + k + "").attr("id", "Q" + j + "");// <span>修改问题的编号和编号标签的id(id的设置用于获取问题的编号)
		$("#ques" + k + "").find(":radio").attr("name", "S" + j + "");// <radio>修改radio的name属性，以便实现单选
		$("#ques" + k + "").find("#quesname" + k + "").attr("id",
				"quesname" + j + "");// <input
		// type='text'>修改问题题目的标签id，该id暂无用处
		$("#ques" + k + "").find("#sel" + k + "").attr("id", "sel" + j + "");// <div>该div包含了所有的选项，修改该div的id,该id的作用是在添加单个选项时找到添加的位置
		$("#ques" + k + "").find(".selector" + k + "").attr("class",
				"selector" + j + " selector-style");// <div>单个选项的div，修改该div的class，该class暂无用处
		$("#ques" + k + "").find(".ST" + k + "").attr("class",
				"ST" + j + " left_distance");// <input
		// type='text'>修改选项的文本的类，该类的作用时在最终组合选项内容时使用
		$("#ques" + k + "").find("img").attr("id", "" + j + "");// <img>修改图片的id,id的作用是，在点击添加图片时可以获得该题是第几道题
		$("#ques" + k + "").find(".image" + k + "").attr("name",
				"image" + j + "");// <img>修改name属性，name的作用是当查找有有多少个选项的查找条件
		$("#ques" + k + "").find(".image" + k + "").attr("class",
				"image" + j + " small_img");// <img>修改name属性，name的作用是当查找有有多少个选项
		$("#ques" + k + "").find("#AST" + k + "").attr("id", "AST" + j + "");// <input
		// type='text'>
		// 修改文本框的id,该id的作用是将组合好的选项内容放入到该文本框
		$("#ques" + k + "").find("#QT" + k + "").attr("id", "QT" + j + "");// <input
		// type='text'>
		// 修改文本框的id,该id的作用是将问题的类型放入到该文本框

		$("#ques" + k + "").find(".STC" + k + "").attr("class", "STC" + j + "");
		$("#ques" + k + "").find(".STR" + k + "").attr("class", "STR" + j + "");
		$("#ques" + k + "").attr("id", "ques" + j + "");// <div>问题的ID，再删除问题时，修改问题编号的基本div
		// 注：必须在最后一行
	}
}

// 最终提交时将每一个问题的选项内容组合起来
function linksel() {
	var ques = document.getElementsByClassName("ques").length; // 已有多少个问题

	for (var k = 0; k < ques; k++) {
		var c = k + 1;
		$("#ques" + c + "").find("#quesname" + c + "").attr("name",
				"qs[" + k + "].content");
		$("#ques" + c + "").find("#AST" + c + "").attr("name",
				"qs[" + k + "].selectors");
		$("#ques" + c + "").find("#QT" + c + "").attr("name",
				"qs[" + k + "].type");
	}

	// 将所有选项用连接符链接起来
	for (var j = 1; j <= ques; j++) {
		var type = document.getElementById("QT" + j + "").value;
		if (type != 4) {
			var selectors = document.getElementsByClassName("ST" + j);
			if (selectors.length != 0) {
				var selContent = "";
				for (var i = 0; i < selectors.length; i++) {
					if (i != selectors.length - 1) {
						selContent += selectors[i].value + "_";
					} else {
						selContent += selectors[i].value;
					}
				}
			}
			document.getElementById("AST" + j + "").value = selContent;
		} else {
			var selectors = document.getElementsByClassName("STC" + j);
			if (selectors.length != 0) {
				var selContent = "";
				for (var i = 0; i < selectors.length; i++) {
					if (i != selectors.length - 1) {
						selContent += selectors[i].value + "_";
					} else {
						selContent += selectors[i].value;
					}
				}
			}
			document.getElementById("AST" + j + "").value = selContent;
			var selectors = document.getElementsByClassName("STC" + j);// 获取所有选项
			var selectors1 = document.getElementsByClassName("STR" + j);// 获取所有行项
			if (selectors.length != 0) {
				var selContent = "";
				for (var i = 0; i < selectors.length; i++) {
					if (i != selectors.length - 1) {
						selContent += selectors[i].value + "_";
					} else {
						selContent += selectors[i].value;
					}
				}
			}
			if (selectors1.length != 0) {
				var selContent1 = "";
				for (var k = 0; k < selectors1.length; k++) {
					if (k != selectors1.length - 1) {
						selContent1 += selectors1[k].value + "_";
					} else {
						selContent1 += selectors1[k].value;
					}
				}
			}
			document.getElementById("AST" + j + "").value = selContent;
			document.getElementById("AST" + j + "").value += "#" + selContent1;

		}

	}

}

function isEmpty() {
	var ques = document.getElementsByClassName("ques").length; // 已有多少个问题
	if (ques == 0) {
		alert("请添加问题！");
		return false;
	} else {
		var list = document.getElementsByTagName("input");
		for (var i = 0; i < list.length; i++) {
			// 判断是否为文本框
			if (list[i].type == "text") {
				// 判断文本框是否为空
				if (list[i].value == "") {
					alert("请将问卷设计填写完整！");
					return false;
				}
			}
		}
	}
	var startTime = $("#startTime").val();
	var endTime = $("#endTime").val();
	if (startTime == "" || endTime == "") {
		alert("请选择开始和结束时间！");
		return false;
	} else {
		var date1 = new Date(startTime);
		var date2 = new Date(endTime);
		if (date1.getTime() > date2.getTime()) {
			alert("结束时间应大于开始时间！");
			return false;
		}
	}

	return true;
}
// zq添加表格的行添加函数
function addTableRow(obj) {
	var table = document.getElementById("table" + obj.id);
	var colums = table.rows[0].cells.length;
	var rows = table.rows.length;
	var newrow = table.insertRow();
	for (var i = 1; i <= colums; i++) {
		var newcol = newrow.insertCell();
		if (i == 1) {
			newcol.innerHTML = "<input type='text' placeholder='行项' class='STR"
					+ obj.id + "' id='bh" + rows + "'/>";
		} else {
			newcol.innerHTML = "<input type='radio' class=''  name='bh" + rows
					+ "'/>";
		}
	}
}
// 删除表格行的删除函数
function delTableRow(obj) {
	var quesNum = obj.id;
	var table = document.getElementById("table" + obj.id);
	if (table.rows.length > 3) {
		table.deleteRow(table.rows.length - 1);
	} else {
		alert("至少有两个选项！");
	}

}
// 添加表格列
function addTableCol(obj) {
	var table = document.getElementById("table" + obj.id);
	var colums = table.rows[0].cells.length;
	var rows = table.rows.length;
	for (var i = 0; i < rows; i++) {
		var newcol = table.rows[i].insertCell();
		if (i == 0) {
			newcol.innerHTML = "<input type='text' placeholder='选项' class='STC"
					+ obj.id + "' id='bl" + colums + "'/>";
		} else {
			newcol.innerHTML = "<input type='radio' class=''  name='bh" + i
					+ "'/>";
		}
	}
}
// 删除表格列
function delTableCol(obj) {
	var table = document.getElementById("table" + obj.id);
	var colums = table.rows[0].cells.length;
	var rows = table.rows.length;
	if (colums > 3) {
		for (var i = 0; i < rows; i++) {
			var newcol = table.rows[i].deleteCell(colums - 1);
		}
	} else {
		alert("至少保留两个选项！");
	}

}

// 插入问题
function insertQues(obj) {
	var order = $(obj).parent().parent().attr("id").substring(4);
	var ques = document.getElementsByClassName("ques").length; // 已有多少个问题
	if (ques > parseInt(order)) {
		for (var j = ques; j > parseInt(order); j--) {
			var k = j;
			var q = j + 1;
			$("#ques" + k + "").find("#Q" + k + "").html("Q" + q + "");
			$("#ques" + k + "").find("#Q" + k + "").attr("id", "Q" + q + "");// <span>修改问题的编号和编号标签的id(id的设置用于获取问题的编号)
			$("#ques" + k + "").find(":radio").attr("name", "S" + q + "");// <radio>修改radio的name属性，以便实现单选
			$("#ques" + k + "").find("#quesname" + k + "").attr("id",
					"quesname" + q + "");// <input
			// type='text'>修改问题题目的标签id，该id暂无用处
			$("#ques" + k + "").find("#sel" + k + "")
					.attr("id", "sel" + q + "");// <div>该div包含了所有的选项，修改该div的id,该id的作用是在添加单个选项时找到添加的位置
			$("#ques" + k + "").find(".selector" + k + "").attr("class",
					"selector" + q + " selector-style");// <div>单个选项的div，修改该div的class，该class暂无用处
			$("#ques" + k + "").find(".ST" + k + "").attr("class",
					"ST" + q + " left_distance");// <input
			// type='text'>修改选项的文本的类，该类的作用时在最终组合选项内容时使用
			$("#ques" + k + "").find("img").attr("id", "" + q + "");// <img>修改图片的id,id的作用是，在点击添加图片时可以获得该题是第几道题
			$("#ques" + k + "").find(".image" + k + "").attr("name",
					"image" + q + "");// <img>修改name属性，name的作用是当查找有有多少个选项的查找条件
			$("#ques" + k + "").find(".image" + k + "").attr("class",
					"image" + q + " small_img");// <img>修改name属性，name的作用是当查找有有多少个选项
			$("#ques" + k + "").find("#AST" + k + "")
					.attr("id", "AST" + q + "");// <input
			// type='text'>
			// 修改文本框的id,该id的作用是将组合好的选项内容放入到该文本框
			$("#ques" + k + "").find("#QT" + k + "").attr("id", "QT" + q + "");// <input
			// type='text'>
			// 修改文本框的id,该id的作用是将问题的类型放入到该文本框

			$("#ques" + k + "").find(".STC" + k + "").attr("class",
					"STC" + q + "");
			$("#ques" + k + "").find(".STR" + k + "").attr("class",
					"STR" + q + "");
			$("#ques" + k + "").attr("id", "ques" + q + "");// 注：必须在最后一行
			// <div>问题的ID，再删除问题时，修改问题编号的基本div
		}
	}

	var qType = null;
	if (obj.id == 1) {
		qType = "radio";
	} else if (obj.id == 2) {
		qType = "checkbox";
	} else if (obj.id == 3) {
		qType = "textarea";
	} else if (obj.id == 4) {
		qType = "matrix";
	}

	var quesNum = parseInt(order) + 1; // 当前问题的序号
	if (obj.id == 1 || obj.id == 2) {
		// 创建问题和前两个选项
		var div1 = document.createElement("div");
		div1.setAttribute("class", "control-group");
		div1.innerHTML += "<div class='ques' id='ques"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)'><span id='Q"
				+ quesNum
				+ "'>Q"
				+ quesNum
				+ ":</span><input type='text' id='quesname"
				+ quesNum
				+ "' class='input-long question-style' placeholder='问卷题目'><image id='"
				+ quesNum
				+ "' class='small_img'  src='img/delquest.gif'  alt='删除' onclick='delQuestion(this)' ><input type='button' id='1' class='btn' style='margin-left:5px' value='单选' onclick='insertQues(this)'/><input type='button' id='2' class='btn' style='margin-left:2px' value='多选' onclick='insertQues(this)'/></div><div id='sel"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)' class='selector"
				+ quesNum
				+ " selector-style'><input type='"
				+ qType
				+ "'  name='S"
				+ quesNum
				+ "'><input type='text'  placeholder='选项'  class='ST"
				+ quesNum
				+ " left_distance'><image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addSelector(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "'  src='img/delsel.gif'  alt='删除' onclick='delSelector(this)' ></div><div onmouseover='showDel(this)' onmouseout='hideDel(this)' class='selector"
				+ quesNum
				+ " selector-style'><input type='"
				+ qType
				+ "'  name='S"
				+ quesNum
				+ "'><input type='text'  placeholder='选项'   class='ST"
				+ quesNum
				+ " left_distance'><image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addSelector(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "'  src='img/delsel.gif' alt='删除' onclick='delSelector(this)'></div></div><div><input type='hidden' id='AST"
				+ quesNum + "'><input type='hidden' id='QT" + quesNum
				+ "'></div></div>";
	}
	if (obj.id == 3) {
		var div1 = document.createElement("div");
		div1.setAttribute("class", "control-group");
		div1.innerHTML += "<div class='ques' id='ques"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)'><span id='Q"
				+ quesNum
				+ "'>Q"
				+ quesNum
				+ ":</span><input type='text' id='quesname"
				+ quesNum
				+ "' class='input-long question-style' placeholder='问卷题目'><image id='"
				+ quesNum
				+ "' class='small_img'  src='img/delquest.gif'  alt='删除' onclick='delQuestion(this)' ><input type='button' id='3'  class='btn' style='margin-left:5px' value='文字题' onclick='insertQues(this)'/></div><div id='sel"
				+ quesNum
				+ "'></div><div class='selector"
				+ quesNum
				+ " selector-style'><textarea  placeholder='请填写内容'  class='ST"
				+ quesNum
				+ " left_distance' style='width:72%;height:100px' readonly></textarea><input type='hidden' id='AST"
				+ quesNum + "'><input type='hidden' id='QT" + quesNum
				+ "'></div></div>";
	}
	if (obj.id == 4) {
		var div1 = document.createElement("div");
		div1.setAttribute("class", "control-group");
		div1.innerHTML += "<div class='ques' id='ques"
				+ quesNum
				+ "'><div onmouseover='showDel(this)' onmouseout='hideDel(this)'><span id='Q"
				+ quesNum
				+ "'>Q"
				+ quesNum
				+ ":</span><input type='text' id='quesname"
				+ quesNum
				+ "' class='input-long question-style' placeholder='问卷题目'><image id='"
				+ quesNum
				+ "' class='small_img'  src='img/delquest.gif'  alt='删除' onclick='delQuestion(this)' ><input type='button' id='4'  class='btn' style='margin-left:5px' value='表格题' onclick='insertQues(this)'/></div><div id='sel"
				+ quesNum
				+ "'></div><div class='selector"
				+ quesNum
				+ " selector-style' onmouseover='showDel(this)' onmouseout='hideDel(this)'><table class='table table-bordered wjTable' id='table"
				+ quesNum
				+ "'><tr><td style='width:100px'>请设计</td><td><input type='text' placeholder='选项' id='bl1' class='STC"
				+ quesNum
				+ "'/></td><td><input type='text' placeholder='选项' class='STC"
				+ quesNum
				+ "' id='bl2'/></td></tr><tr><td style='width:100px'><input type='text' placeholder='行项' class='STR"
				+ quesNum
				+ "' id='bh1'/></td><td><input type='radio' name='bh1'/></td><td><input type='radio' name='bh1'/></td></tr><tr><td style='width:100px'><input type='text' placeholder='行项' class='STR"
				+ quesNum
				+ "' id='bh2'/></td><td><input type='radio' name='bh2'/></td><td><input type='radio' name='bh2'/></td></tr></table>列：<image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addTableCol(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "' id='"
				+ quesNum
				+ "' src='img/delsel.gif' alt='删除' onclick='delTableCol(this)'>&nbsp;&nbsp;&nbsp;&nbsp;行：<image id='"
				+ quesNum
				+ "' name='"
				+ obj.id
				+ "' class='small_img'  src='img/addsel.png'  alt='添加' onclick='addTableRow(this)' ><image class='image"
				+ quesNum
				+ " small_img' name='image"
				+ quesNum
				+ "' id='"
				+ quesNum
				+ "' src='img/delsel.gif' alt='删除' onclick='delTableRow(this)'><input type='hidden' id='AST"
				+ quesNum + "'><input type='hidden' id='QT" + quesNum
				+ "'></div></div>";
	}

	var section = document.createElement("section");
	section.appendChild(div1);

	var d = $(obj).parent().parent().parent().parent();
	$(section).insertAfter(d);

	// 创建问题和前两个选项结束
	document.getElementById("QT" + quesNum + "").value = obj.id;// 1代表单选，2代表多选，3代表文本问题4表示表格

}