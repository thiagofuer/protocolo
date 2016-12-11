protocoloFormValidation.controller("ctrlProtocoloFormValidation", function($scope, serviceForm, $filter) {
 
	$scope.listaComarcas = {};
	$scope.comarcaSelecionada;
	
	$scope.listaClassesProcessuais = {};
	$scope.classeSelecionada;	
	
	$scope.distribuicao;
	
	$scope.distribuir = function(){
		protocolarProcesso($scope.classeSelecionada, $scope.comarcaSelecionada);
	}
	
	$scope.closeAlert = function(){
		$scope.message = null;	
	}
	
	var atualizarComarcaSelecionada = function(){
		if( $scope.comarcaSelecionada == null )
			return;
		angular.forEach($scope.listaComarcas, function(comarca) {
			if( comarca.id ==  $scope.comarcaSelecionada.id)
				$scope.comarcaSelecionada = comarca;
		});	
	}
	
	var mostrarNotificacao = function(data){
		if(data.distribuicaoRealizada){
	    	$('#alerta').removeClass('alert-danger');
	    	$('#alerta').addClass('alert-success');
	    	$scope.message = "Processo distribuido para a vara: "+ data.nomeVara +", numero unico: " + data.numeroUnico;
		}else{
	    	$('#alerta').removeClass('alert-success');
	    	$('#alerta').addClass('alert-danger');
	    	$scope.message = "Processo não foi distribuido, erro: "+ data.msgErro;
		}
    	
	}

    
    /***
     * Métodos de chamada de WS Protocolo
     */
    
    //lista todas as comarcas
    var listarTodasComarcas = function() {
        serviceForm.listarTodasComarcas()
        		.success(
	                function(data, status, headers, config) {
	                    $scope.listaComarcas = data;
	                    atualizarComarcaSelecionada();
	                })
                .error(
	        		function(data, status, headers, config) {
			            switch (status) {
				            case 500: {
				                $scope.message = "Erro!";
				                break;
				            }
			            }
			            console.log(data, status);
			        }
                );
    };  
    
    
    //lista todas as classes processuais
    var listarTodasClassesProcessuais = function() {
        serviceForm.listarTodasClassesProcessuais()
        		.success(
	                function(data, status, headers, config) {
	                    $scope.listaClassesProcessuais = data;
	                })
                .error(
	        		function(data, status, headers, config) {
				        $scope.message = "Erro!";
			            console.log(data, status);
			        }
                );
    };  
    
    //distribui / protocola o processo
    var protocolarProcesso = function(classe, comarca) {
        serviceForm.protocolarProcesso(classe, comarca)
        		.success(
	                function(data, status, headers, config) {
	                	console.log(data);
	                	listarTodasComarcas();
	                	$scope.distribuicao = data;
	                	mostrarNotificacao(data);
	                })
                .error(
	        		function(data, status, headers, config) {
	        			mostrarNotificacao(data);
			            console.log(data, status);
			        }
                );
    }; 
    
    
    
    //Faz a consulta inicial 
    listarTodasComarcas();
    listarTodasClassesProcessuais();
 
 
});