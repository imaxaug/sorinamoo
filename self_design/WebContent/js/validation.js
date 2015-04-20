var isEmpty = function (target) {
	return target.val().replace(/^(\s*)|(\s*$)/gi, "") == "";
}
var isEmptyTextarea = function (target) {
    return $(target).val().replace(/^(\s*)|(\s*$)/gi, "") == "";
}
var isEmptyForContent = function (editor) {
	var regText = nicEditors.findEditor(editor).getContent();
	return regText.replace(/^(\s*)|(\s*$)/gi, "") == "";
}
var isPassword = function (target) {
	var pattern1 = /[0-9]{1,}/g;
	var pattern2 = /[a-zA-Z]{1,}/g;
	var pattern3 = /^[\w]{4,16}$/g;
	var result = false;

	if (pattern1.test(target.val())) { result = true; }
    else { return false; }

	if (pattern2.test(target.val())) { result = true; }
    else { return false; }

	if (pattern3.test(target.val())) { result = true; }
    else { return false; }

	return result;
}
var isOnlyCharacter = function (target) {
    var regEmail = /^[a-zA-Z가-힣]+$/gi;
    return regEmail.test(target.val());
}
var isTags = function (target) {
    var regEmail = /^[0-9a-zA-Z가-힣,\s]+$/gi;
    return regEmail.test(target.val());
}
var isCharacter = function (target) {
    var regEmail = /^[0-9a-zA-Z가-힣]+$/gi;
    return regEmail.test(target.val());
}
var isDomainCharacter = function (target) {
    var regEmail = /^[0-9a-zA-Z]+$/gi;
    return regEmail.test(target.val());
}
var isEmail = function (target) {
	var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*[@][0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[.][a-zA-Z]{2,3}$/gi;
	return regEmail.test(target.val());
}
var isEmailString = function (target) {
	var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*[@][0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[.][a-zA-Z]{2,3}$/gi;
	return regEmail.test(target);
}
var isBirthday = function (target) {
	var regBirthday = /^[0-9]{4}([-_.\/]?)[0-9]{2}([-_.\/]?)[0-9]{2}$/;
	return regBirthday.test(target.val());
}
var isMobile = function (target) {
	var regMobile = /[01](0|1|6|7|8|9)[-_.]?(\d{4}|\d{3})[-_.]?\d{4}$/g;
	return regMobile.test(target);
}
var isCode = function (target) {
	var Code = /^[A-Za-z0-9]{2,6}$/g;
	return Code.test(target.val());
}
var isNumber = function (target) {
	var regSort = /^\d+$/g;
	return regSort.test(target.val());
}
var stringIsNumber = function (target) {
	var regSort = /^\d+$/g;
	return regSort.test(target);
}
var isNotSel = function (target) {
	return target.val() == "";
}
var isDate = function (year, month, date) {
    var thisYear = new Date().getFullYear()
    ,   thirtyOne = [1,3,5,7,8,10,12]
    ,   thirty = [4,6,9,11]
    ,   fab = 28
    ,   year = parseInt(year.val(),10)
    ,   month = parseInt(month.val(),10)
    ,   date = parseInt(date.val(),10);

    if ((year%4 == 0 && year%100 != 0) || year%400 == 0) {
        fab = 29;
    }

    if (!(year > 1900 && year <= thisYear)) return false;
    if (!(month > 0 && month <= 12)) return false;

    if (thirtyOne.indexOf(month) >= 0 && (0 < date && date <= 31)) return true;
    else if (thirty.indexOf(month) >= 0 && (0 < date && date <= 30)) return true;
    else if (month == '2' && (0 < date && date <= fab)) return true;

    return false;
}