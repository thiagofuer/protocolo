var protocoloFormValidation = angular.module("moduloProtocolo", []);

protocoloFormValidation.config(function ($httpProvider) {
    $httpProvider.interceptors.push('httpInterceptor');
});


protocoloFormValidation.constant("config", {});