app.factory('profileService', ['ajaxService', function(ajaxService) {
	var _pageUrl = "/edit-profile"
	
	var _initialData = function() {
		return ajaxService.get(_pageUrl+"/initial-data");
	}
 	
	return {
		initialData : _initialData
	}
	
}]);