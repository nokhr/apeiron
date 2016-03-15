/**
 * Created by Daria on 04.05.2015.
 */
var req;
var isIE;
var completeField;
var completeTable;
var autoRow;

function init() {
    completeField = document.getElementById("search");
    completeTable = document.getElementById("complete-table");
    autoRow = document.getElementById("auto-row");
    completeTable.style.top = getElementY(autoRow) + "px";
}

function doCompletion() {
    var url = "/autocomplete?action=complete&id=" + escape(completeField.value);
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callback;
    req.send(null);
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function callback() {
    clearTable();
    if (req.readyState == 4) {
        if (req.status == 200) {
            if (req.response){
                //alert(req.getAllResponseHeaders());
                //alert(req.response);
                //alert(req.responseXML);
                parseMessages(req.response);
            }

        } else{
            alert(req.status)
        }
    } else{
        //alert("Wait")
    }
}
function parseMessages(respons) {
    var responseXML;
    // no matches returned
    if (respons == null) {
        //alert("No param!")
        return false;
    } else {
        //alert("get param!")
        //alert(respons)
        //var str="<users><user><firstname>firstname</firstname><lastname>lastname</lastname><email>email@mail.com</email></user></users>"
        var parseXml;
        if (window.DOMParser) {
            parseXml = function(xmlStr) {
                return ( new window.DOMParser() ).parseFromString(xmlStr, "text/xml");
            };
        } else if (typeof window.ActiveXObject != "undefined" && new window.ActiveXObject("Microsoft.XMLDOM")) {
            parseXml = function(xmlStr) {
                var xmlDoc = new window.ActiveXObject("Microsoft.XMLDOM");
                xmlDoc.async = "false";
                xmlDoc.loadXML(xmlStr);
                return xmlDoc;
            };
        } else {
            parseXml = function() { return null; }
        }
        responseXML=parseXml(respons);
        //alert(responseXML);
        var users = responseXML.getElementsByTagName("users")[0];

        if (users.childNodes.length > 0) {
            completeTable.setAttribute("bordercolor", "black");
            completeTable.setAttribute("border", "1");

            for (loop = 0; loop < users.childNodes.length; loop++) {
                var user = users.childNodes[loop];
                var firstName = user.getElementsByTagName("firstname")[0];
                var lastName = user.getElementsByTagName("lastname")[0];
                var eMail = user.getElementsByTagName("email")[0];
                appendUser(firstName.childNodes[0].nodeValue,
                    lastName.childNodes[0].nodeValue,
                    eMail.childNodes[0].nodeValue);
            }
        }
    }
}

function appendUser(firstName,lastName,eMail) {

    var row;
    var cell;
    var linkElement;

    if (isIE) {
        completeTable.style.display = 'block';
        row = completeTable.insertRow(completeTable.rows.length);
        cell = row.insertCell(0);
    } else {
        completeTable.style.display = 'table';
        row = document.createElement("tr");
        cell = document.createElement("td");
        row.appendChild(cell);
        completeTable.appendChild(row);
    }

    cell.className = "popupCell";

    linkElement = document.createElement("a");
    linkElement.className = "popupItem";
    linkElement.setAttribute("href", "/page/user_info.html");
    linkElement.appendChild(document.createTextNode(firstName + " " + lastName));
    cell.appendChild(linkElement);
}

function getElementY(element){

    var targetTop = 0;

    if (element.offsetParent) {
        while (element.offsetParent) {
            targetTop += element.offsetTop;
            element = element.offsetParent;
        }
    } else if (element.y) {
        targetTop += element.y;
    }
    return targetTop;
}

function clearTable() {
    if (completeTable.getElementsByTagName("tr").length > 0) {
        completeTable.style.display = 'none';
        for (loop = completeTable.childNodes.length -1; loop >= 0 ; loop--) {
            completeTable.removeChild(completeTable.childNodes[loop]);
        }
    }
}