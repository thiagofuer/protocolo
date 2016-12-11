protocoloFormValidation.factory('httpInterceptor', function ($q, $rootScope, $log) {
    var numLoadings = 0;
    return {
        request: function (config) {
            numLoadings++;
            $('#mydiv').show();
            return config || $q.when(config)

        },
        response: function (response) {

            if ((--numLoadings) === 0) {
            	$('#mydiv').hide();
            }
            return response || $q.when(response);

        },
        responseError: function (response) {
            if (!(--numLoadings)) {
            	$('#mydiv').hide();
            }
            return $q.reject(response);
        }
    };
})

protocoloFormValidation.factory("serviceForm", function(config, $http) {

    var _listarTodasComarcas = function() {
        return $http.get("ws/protocolo/listarTodasComarcas");
    };
    
    var _listarTodasClassesProcessuais = function() {
        return $http.get("ws/protocolo/listarTodasClassesProcessuais");
    };    
    
    var _protocolarProcesso = function(classe, comarca) {
        return $http.post("ws/protocolo/protocolar/"+classe.id+"/"+comarca.id);
    };
    
    return {
        listarTodasComarcas: _listarTodasComarcas,
        listarTodasClassesProcessuais: _listarTodasClassesProcessuais,
        protocolarProcesso: _protocolarProcesso
    };
 
});


